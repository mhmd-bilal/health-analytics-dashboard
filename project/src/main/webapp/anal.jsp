<%@ page import="project.SleepCalculator" %>
  <%@ page import="project.CaloriesCalculator" %>
    <%@ page import="project.IllnessCalculator " %>

      <html>

      <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Your Health Dashboard</title>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
        <link rel="stylesheet" type="text/css" href="styles2.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
	
        <script>
        // Use fetch to trigger the AnalyticsServlet on page load
        function fetchAnalyticsData() {
            fetch('AnalyticsServlet')
                .then(response => response.json())
                .then(data => {
                    // Update the UI based on the analytics data
                    document.getElementById('predominantEmotion').innerText = data.predominantEmotion;
                    document.getElementById('undersleptDate').innerText = data.undersleptDate;
                    document.getElementById('highCaloriesDate').innerText = data.highCaloriesDate;
                    document.getElementById('mostIllDate').innerText = data.mostIllDate;
                    document.getElementById('predictedWeightIncrease').innerText = data.predictedWeightIncrease + "%";
                })
                .catch(error => {
                    console.error('Error:', error);
                });
        }

        // Fetch analytics data on page load
        fetchAnalyticsData();

        </script>

      </head>

      <body>
  <div class="sidenav">
    <a href="#" style="padding-bottom: 100px;padding-left: 10px;"><img style="width: 95%;filter: brightness(1);" src="logo.png"></a>
    <a href="index2.jsp"><img src="dashboard.png"></a>
    <a href="add.jsp"><img src="add.png"></a>
    <a class="active" href="anal.jsp"><img src="anal.png"></a>
    <a href="info.jsp"><img src="info.png"></a>
  </div>
        <div class="main">
        
<div class="analytics_container">
        <!-- Your existing content -->


        <div class="analytics-card" style="width:30%">
            <p class="analytics-text">According to your text inputs,  this month you have been mostly feeling
                <span style="font-size:100px" id="predominantEmotion">[Emotion].</span></p>
        </div>

        <div class="analytics-card" style="width:13%">
            <p class="analytics-text">You underslept on <span style="font-size:50px" id="undersleptDate">[Date].</span></p>
        </div>

        <div class="analytics-card" style="width:13%">
            <p class="analytics-text">You had most calories on <span style="font-size:50px" id="highCaloriesDate">[Date].</span></p>
        </div>

        <div class="analytics-card" style="width:13%">
            <p class="analytics-text">You were most ill on <span style="font-size:50px" id="mostIllDate">[Date].</span></p>
        </div>

        <div class="analytics-card" style="width:30%">
            <p class="analytics-text">With respect to your past data, your predicted increase in weight percentage is
                <span style="font-size:100px" id="predictedWeightIncrease">[Percent].</span></p>
        </div>
    </div>
        </div>

      </body>

      </html>