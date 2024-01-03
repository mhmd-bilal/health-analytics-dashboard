<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%
    String inputValue = request.getParameter("inputValue");

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/your_database";
        String username = "root";
        String password = "password";

        connection = DriverManager.getConnection(url, username, password);

        String sql = "INSERT INTO moodentry(entry) VALUES (?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, inputValue);

        preparedStatement.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception e) { /* ignored */ }
        try { if (connection != null) connection.close(); } catch (Exception e) { /* ignored */ }
    }
%>
