package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SleepCalculator {
    public static int calculateSleepHoursForWeek() {
        int totalHoursSlept = 0;

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "password")) {

            // Calculate the start date of the week
            LocalDate currentDate = LocalDate.now();
            LocalDateTime startDateTimeOfWeek = LocalDateTime.of(currentDate.minusDays(currentDate.getDayOfWeek().getValue() - 1), LocalDateTime.MIN.toLocalTime());

            String sqlQuery = "SELECT SUM(minutesslept) AS totalMinutesSlept FROM sleepentry WHERE sleepontime >= ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setString(1, startDateTimeOfWeek.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int totalMinutesSlept = resultSet.getInt("totalMinutesSlept");
                        totalHoursSlept = totalMinutesSlept / 60;

                        System.out.println("Total Hours Slept for the Week: " + totalHoursSlept);
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalHoursSlept;
    }
}
