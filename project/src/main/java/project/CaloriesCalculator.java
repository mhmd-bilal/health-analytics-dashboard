// CaloriesCalculator.java

package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CaloriesCalculator {
    public static int calculateTotalCalories() {
        int totalCalories = 0;

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "password")) {
            // Calculate the start and end date of the current month
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
            String startDate = dateFormat.format(calendar.getTime());
            calendar.add(java.util.Calendar.MONTH, 1);
            calendar.set(java.util.Calendar.DAY_OF_MONTH, 1);
            calendar.add(java.util.Calendar.DATE, -1);
            String endDate = dateFormat.format(calendar.getTime());

            // Prepare and execute the SQL query
            String sql = "SELECT SUM(calories) AS totalCalories FROM foodentry WHERE foodentrytime BETWEEN ? AND ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, startDate);
                preparedStatement.setString(2, endDate);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        totalCalories = resultSet.getInt("totalCalories");
                        System.out.println("Total Calories This Month: " + totalCalories);
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalCalories;
    }
}
