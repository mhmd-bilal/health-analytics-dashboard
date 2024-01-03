package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.util.CoreMap;

public class SentimentAnalyzer {

    private static StanfordCoreNLP pipeline;

    static {
        // Initialize Stanford CoreNLP pipeline
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, parse, sentiment");
        pipeline = new StanfordCoreNLP(props);
    }

    public static String analyzeSentiment(String text) {
        // Create an annotation with the given text
        Annotation annotation = new Annotation(text);

        // Run all the selected Annotators on the text
        pipeline.annotate(annotation);

        // Extract sentiment information
        for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
            return sentence.get(SentimentCoreAnnotations.SentimentClass.class);
        }

        return "Neutral"; // Default to neutral if sentiment cannot be determined
    }

    public static void updateMoodInDatabase() {
        Connection connection = null;
        PreparedStatement selectStatement = null;
        PreparedStatement updateStatement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/project";
            String username = "root";
            String password = "password";

            connection = DriverManager.getConnection(url, username, password);

            // Select all entries from moodentry table
            String selectSql = "SELECT id, entry FROM moodentry";
            selectStatement = connection.prepareStatement(selectSql);
            ResultSet resultSet = selectStatement.executeQuery();

            // Update mood for each entry
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String entry = resultSet.getString("entry");

                // Analyze sentiment of the entry
                String mood = analyzeSentiment(entry);

                // Update the mood in the database
                String updateSql = "UPDATE moodentry SET mood = ? WHERE id = ?";
                updateStatement = connection.prepareStatement(updateSql);
                updateStatement.setString(1, mood);
                updateStatement.setInt(2, id);

                updateStatement.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (selectStatement != null)
                    selectStatement.close();
                if (updateStatement != null)
                    updateStatement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Call the function to update mood in the database
        updateMoodInDatabase();
    }
}
