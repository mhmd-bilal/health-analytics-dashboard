package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IllnessCalculator {
    public static int calculateIllnessHoursForMonth() {
        int totalHoursIll = 0;

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "password")) {

            // Calculate the start date of the month
            LocalDate currentDate = LocalDate.now();
            LocalDateTime startDateTimeOfMonth = LocalDateTime.of(currentDate.minusDays(currentDate.getDayOfMonth() - 1), LocalDateTime.MIN.toLocalTime());

            String sqlQuery = "SELECT count(illnesseid) AS totalIllnessHours FROM illnessentry WHERE illnessentrytime >= ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setString(1, startDateTimeOfMonth.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        totalHoursIll = resultSet.getInt("totalIllnessHours");

                        System.out.println("Total Hours Ill for the Month: " + totalHoursIll);
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalHoursIll;
    }
}
