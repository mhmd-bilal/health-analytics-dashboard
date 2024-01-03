<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Kanit">
    <link rel="stylesheet" type="text/css" href="styles2.css">

    <meta charset="UTF-8">
    <title>Food Entry Form</title>
    <!-- Include your stylesheet link here -->
</head>
<body style="background-image:none;overflow: hidden">
<div class="main-entry">

<form action="SaveFoodEntryServlet" method="post">
        <label for="food">What did you eat?</label><br><br>
        <input class="date-pick" type="text" id="food" name="food" required><br><br>

        <input type="submit" class="subbtnentry" value="Submit">
    </form>

</div>
</body>
</html>
