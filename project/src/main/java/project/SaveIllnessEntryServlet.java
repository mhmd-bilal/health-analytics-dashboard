package project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SaveIllnessEntryServlet")
public class SaveIllnessEntryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String illness = request.getParameter("illness");

        // Get the current timestamp
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String illnessEntryTime = sdf.format(new Date());

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "password");
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO illnessentry (illness, illnessentrytime) VALUES (?, ?)")) {

            preparedStatement.setString(1, illness);
            preparedStatement.setString(2, illnessEntryTime);

            preparedStatement.executeUpdate();

            response.getWriter().println("Illness entry saved successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
