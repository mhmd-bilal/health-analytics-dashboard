package project;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/MoodChartDataServlet")
public class MoodChartDataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // Fetch data from the database
        int positiveCount = fetchCountFromDatabase("positive");
        int negativeCount = fetchCountFromDatabase("negative");
        int neutralCount = fetchCountFromDatabase("neutral");

        // Create a JSON object with labels and values
        JsonObject jsonObject = new JsonObject();
        JsonArray labels = new JsonArray();
        JsonArray values = new JsonArray();

        labels.add("Positive");
        labels.add("Negative");
        labels.add("Neutral");

        values.add(positiveCount);
        values.add(negativeCount);
        values.add(neutralCount);

        jsonObject.add("labels", labels);
        jsonObject.add("values", values);

        // Set the content type and write the JSON response
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            out.println(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getMostFrequentMood() {
        String mostFrequentMood = "Neutral"; // Default to neutral if there's a tie

        int positiveCount = fetchCountFromDatabase("positive");
        int negativeCount = fetchCountFromDatabase("negative");
        int neutralCount = fetchCountFromDatabase("neutral");

        if (positiveCount > negativeCount && positiveCount > neutralCount) {
            mostFrequentMood = "Positive";
        } else if (negativeCount > positiveCount && negativeCount > neutralCount) {
            mostFrequentMood = "Negative";
        }

        return mostFrequentMood;
    }

    private static int fetchCountFromDatabase(String mood) {
        int count = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/project";
            String username = "root";
            String password = "password";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                String sql = "SELECT COUNT(*) AS count FROM moodentry WHERE mood = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, mood);
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            count = resultSet.getInt("count");
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return count;
    }
}
