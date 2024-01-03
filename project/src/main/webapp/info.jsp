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
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">	
        <script>
          // Use fetch to trigger the SleepAnalyticsServlet on page load
          function fetchSleepAnalytics() {
            fetch('SleepAnalyticsServlet')
              .then(response => response.text())
              .then(data => {
                // Optional: You can add logic to update the UI based on the response from the servlet
                console.log(data);
              })
              .catch(error => {
                console.error('Error:', error);
              });
          }          
          function submitForm() {
            var inputValue = document.getElementById("inputValue").value;

            fetch('SaveToDatabaseServlet', {
              method: 'POST',
              headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
              },
              body: 'inputValue=' + encodeURIComponent(inputValue),
            })
              .then(response => response.json())
              .then(data => {
                alert(data.message);
                if (data.recordAdded) {
                  alert('Record added successfully!');
                }
              })
              .catch(error => {
                console.error('Error:', error);
              });
          }

          function redirectToAddRecordPage() {
            window.location.href = 'addrecord.jsp';
          }



        </script>

      </head>
      <body style="overflow:hidden">
      <div class="sidenav">
    <a href="#" style="padding-bottom: 100px;padding-left: 10px;"><img style="width: 95%;filter: brightness(1);" src="logo.png"></a>
    <a href="index2.jsp"><img src="dashboard.png"></a>
    <a href="add.jsp"><img src="add.png"></a>
    <a href="anal.jsp"><img src="anal.png"></a>
    <a class="active" href="info.jsp"><img src="info.png"></a>
  </div>
        <div style="font-spacing:1px;margin-top:100px;height: fit-content;" class="main">
              <img src="infograhic.png" class="infograhic" height="400px" ></p>  
        
                  <h2 style="font-weight: bolder;">Welcome to Vita+ - Your Personal Health Companion!</h2>
<p style="font-weight: bold;font-style:italic;font-size: 20px;;"><img src="help.png" style="margin-bottom:-5px;height:25px;filter: invert(100%)"> What is Vita+</p>
Vita+ isn't just an app; it's your 24/7 health companion, always ready to assist you on your wellness journey. Let's dive into the incredible features that make Vita+ the must-have app for a healthier, happier you!

<p style="font-weight: bold;font-style:italic;font-size: 20px;"><img src="health.png" style="margin-bottom:-5px;height:25px;filter: invert(100%)"> Health Tracking for Holistic Well-being!</p>
<p>Say goodbye to groggy mornings and hello to refreshing wake-ups! Vita+ intelligently tracks your sleep patterns, offering insights to help you optimize your bedtime routine. Eating well is a form of self-respect, and Vita+ is here to guide you with our Calorie Counter, keeping tabs on your nutrition and helping you make informed choices. Life happens, and so do occasional sniffles. Vita+ monitors your health history, making it easier to spot patterns and track your wellness journey. Get back on your feet faster than ever because a good day starts with a good night's sleep and a well-fed body is a happy body!</p>

<p style="font-weight: bold;font-style:italic;font-size: 20px;"><img src="hmeter.png" style="margin-bottom:-5px;height:25px;filter: invert(100%)"> Health Meter - Your Personal Wellness Scoreboard!</p>
Combine the power of good sleep, balanced nutrition, and timely health insights into your very own Health Meter. It's not just a number; it's a reflection of your commitment to a healthier lifestyle!

<p style="font-weight: bold;font-style:italic;font-size: 20px;"><img src="us.png" style="margin-bottom:-5px;height:25px;filter: invert(100%)"> Why Vita+?</p>
Vita+ isn't just an app; it's a lifestyle upgrade. We believe that small, consistent steps lead to significant transformations. Vita+ is here to empower you to make those steps with confidence, knowledge, and a touch of fun!

<p style="font-weight: bold;font-style:italic;font-size: 20px;">Your Journey to Better Health Starts Here!

      </div>

  <div class="main" style="text-align: center;margin-top: 5px;">
    <h2 style="font-weight: 400;">Team Members</h2>
    <div class="choose">
        <div class="choose-card" style="height: 80%;">
        <a class="choose-btn" href="https://www.linkedin.com/in/rithisnaha/" ><img src="1.png" style="margin-top:-20px;border-radius:50%"></a>
    </div>
        <div class="choose-card" style="height: 80%;">
        <a class="choose-btn" href="https://www.linkedin.com/in/mohammed-bilal-3640991a7/"><img src="2.png" style="border-radius:50%"></a>
    </div>
        <div class="choose-card" style="height: 80%;">
        <a class="choose-btn" href="https://www.linkedin.com/in/lalith-kumaresan-50a994272/")"><img src="3.png" style="border-radius:50%"></a>
        </div>
    </div>
    
</div>

      </body>

      </html>