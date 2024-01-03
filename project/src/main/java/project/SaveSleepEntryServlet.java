package project;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SaveSleepEntryServlet")
public class SaveSleepEntryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        try {
            Date sleepOnTime = sdf.parse(request.getParameter("sleepontime"));
            Date sleepOfTime = sdf.parse(request.getParameter("sleepoftime"));

            // Calculate minutes slept
            long minutesSlept = (sleepOfTime.getTime() - sleepOnTime.getTime()) / (60 * 1000);

            // Get the current timestamp
            String sleepEntryTime = sdf.format(new Date());

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "password");
                 PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO sleepentry (sleepontime, sleepoftime, minutesslept) VALUES (?, ?, ?)")) {

                preparedStatement.setString(1, sdf.format(sleepOnTime));
                preparedStatement.setString(2, sdf.format(sleepOfTime));
                preparedStatement.setLong(3, minutesSlept);

                preparedStatement.executeUpdate();

                response.getWriter().println("Sleep entry saved successfully!");

            } catch (SQLException e) {
                e.printStackTrace();
                response.getWriter().println("Error: " + e.getMessage());
            }
        } catch (ParseException e) {
            e.printStackTrace();
            response.getWriter().println("Error parsing date: " + e.getMessage());
        }
    }
}

