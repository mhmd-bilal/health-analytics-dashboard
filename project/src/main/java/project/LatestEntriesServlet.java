package project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LatestEntriesServlet")
public class LatestEntriesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Entry> latestEntries = getLatestEntries();
        request.setAttribute("latestEntries", latestEntries);

        // Forward the request to the JSP page
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private List<Entry> getLatestEntries() {
        List<Entry> entries = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/project";
            String username = "root";
            String password = "password";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                // Fetch latest entries from each table and add to the list
                //entries.addAll(fetchLatestEntriesFromTable(connection, "foodentry", "food"));
                //entries.addAll(fetchLatestEntriesFromTable(connection, "sleepentry", "sleep"));
                //entries.addAll(fetchLatestEntriesFromTable(connection, "illnessentry", "illness"));
                entries.addAll(fetchLatestEntriesFromTable(connection, "moodentry", "mood"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Sort entries by entry time in descending order
        Collections.sort(entries, Collections.reverseOrder());

        return entries;
    }

    private List<Entry> fetchLatestEntriesFromTable(Connection connection, String tableName, String type) throws SQLException {
        List<Entry> entries = new ArrayList<>();

        String sql = "SELECT * FROM " + tableName + " ORDER BY entrytime DESC LIMIT 1";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Entry entry = new Entry(type, resultSet.getTimestamp("entrytime"), resultSet.getString("entry"));
                entries.add(entry);
            }
        }

        return entries;
    }
}
