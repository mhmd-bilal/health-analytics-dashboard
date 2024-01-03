<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
    <link rel="stylesheet" type="text/css" href="styles2.css">

    <meta charset="UTF-8">
    <title>Sleep Entry Form</title>
    <!-- Include your stylesheet link here -->
</head>
<body style="background-image:none;overflow: hidden">
    <div class="main-entry">
    <form action="SaveSleepEntryServlet" method="post">
        <label class="label-text" for="sleepontime">Enter the time you slept</label><br><br>
        <input class="date-pick" type="datetime-local" id="sleepontime" name="sleepontime" required><br><br>

        <label for="sleepoftime">Enter the time you woke up</label><br><br>
        <input class="date-pick" type="datetime-local" id="sleepoftime" name="sleepoftime" required><br><br>

        <input type="submit" class="subbtnentry" value="Submit">
    </form>
</body>
</html>
