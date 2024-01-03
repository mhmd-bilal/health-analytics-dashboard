package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SaveToDatabaseServlet")
public class saveToDatabase extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String inputValue = request.getParameter("inputValue");
        System.out.println(inputValue);
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/project";
            String username = "root";
            String password = "password";

            connection = DriverManager.getConnection(url, username, password);

            String sql = "INSERT INTO moodentry (entry) VALUES (?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, inputValue);

            preparedStatement.executeUpdate();

            // Close the database connection
            preparedStatement.close();
            connection.close();

            // Call the function to update mood in the database
            SentimentAnalyzer.updateMoodInDatabase();

            // Send HTML response with JavaScript for popup
            String htmlResponse = "Record added successfully";

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            System.out.println(htmlResponse);
            request.setAttribute("recordAdded", true);

        } catch (Exception e) {
            e.printStackTrace();
            // You can include an error message in the response if needed
            response.getWriter().println("Error: " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
