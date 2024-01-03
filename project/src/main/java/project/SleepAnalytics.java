package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SleepAnalytics {

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "password");
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT SUM(minutesslept) AS totalMinutesSlept FROM sleepentry");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                int totalMinutesSlept = resultSet.getInt("totalMinutesSlept");
                int totalHoursSlept = totalMinutesSlept / 60;

                System.out.println("Total Hours Slept: " + totalHoursSlept);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
