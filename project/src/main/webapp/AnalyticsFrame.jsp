<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your Analytics</title>
</head>
<body>
    <!-- Fetch data using JavaScript and display it -->
<script>
    fetch('SleepAnalyticsServlet')
        .then(response => response.json())
        .then(data => {
            // Log data to console for debugging
            console.log(data);

            // Use the data to display in the iframe
            var totalHoursSlept = data.totalHoursSlept;
            var totalCalories = data.totalCalories;

            document.write('<p>Total Hours Slept: ' + (totalHoursSlept !== null ? totalHoursSlept + ' hours' : 'N/A') + '</p>');
            document.write('<p>Total Calories This Month: ' + (totalCalories !== null ? totalCalories + ' calories' : 'N/A') + '</p>');
        })
        .catch(error => {
            console.error('Error:', error);
        });
</script>
</body>
</html>
