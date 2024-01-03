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
        alert('Record added successfully!');
        document.getElementById("inputValue").value = "";
        location.reload();
      })	
      .catch(error => {
        console.error('Error:', error);
      });
  }

  function redirectToAddRecordPage() {
    window.location.href = 'addrecord.jsp';
  }

  // Fetch analytics data on page load
  fetchSleepAnalytics();

</script>

      </head>

      <body>
  <div class="sidenav">
    <a href="#" style="padding-bottom: 100px;padding-left: 10px;"><img style="width: 95%;filter: brightness(1);" src="logo.png"></a>
    <a class="active" href="index2.jsp"><img src="dashboard.png"></a>
    <a href="add.jsp"><img src="add.png"></a>
    <a href="anal.jsp"><img src="anal.png"></a>
    <a href="info.jsp"><img src="info.png"></a>
  </div>
        <div class="main">
        
          <h2 style="font-weight: 400;">Hi! This is <b>Vita+</b></h2>
          <p style="font-weight: bold;font-style:italic;font-size: 20px;">How are you feeling right now? I am all ears!
          </p>
          <form class="container" onsubmit="submitForm(); return false;" method="post">
            <input id="inputValue" name="inputValue" class="moodenter" type="text" required>
            <button type="submit" class="subbtn">SUBMIT</button>
          </form><br><br>
          <div class="analytics_container">
<div class="pie">
	  <iframe src="chart.jsp" class="chartFrame" frameborder="0" width="100%" height="100%"></iframe>
	  <p class="md">Mood<br>Distribution</p>
	  
</div>
            <div class="count">
              <div class="counts">
                <div class="card">
                  <img class="count-icon" src="sleep.png">
                  <p class="count-text">You've Slept</p><br>
                  <p class="count-count">
                    <% 
                    int totalHoursSlept=SleepCalculator.calculateSleepHoursForWeek(); out.print(totalHoursSlept+ " hours" ); 
                    int sleeppercent=(totalHoursSlept*100)/50; %>
                      <p style="font-size:11px;margin-bottom:-15px">out 50 hours this week.</p></p>	
                  <br>
                  <div class="pbbg">
                    <div class="pb" style="width: <%=sleeppercent %>%;max-width:100%;min-width:0%"></div>
                  </div>
                </div>
                <div class="card">
                  <img class="count-icon" src="food.png">
                  <p class="count-text">You've Eaten</p><br>
                  <p class="count-count">
                    <% 
                    int totalCalories=CaloriesCalculator.calculateTotalCalories(); out.print(totalCalories + " calories"
                      ); int caloriepercent=(totalCalories*100)/2000; %>
                      <p style="font-size:11px;margin-bottom:-15px">out 2000 calories today.</p>
                  </p><br>
                  <div class="pbbg">
                    <div class="pb" style="width: <%=caloriepercent %>%;max-width:100%"></div>
                  </div>
                </div>
                <div class="card">
                  <img class="count-icon" src="ill.png">
                  <p class="count-text">You got ill</p><br>
                  <p class="count-count">
                    <% int totalHoursIll=IllnessCalculator.calculateIllnessHoursForMonth(); out.print(totalHoursIll
                      + " times" ); int illnessPercent=(totalHoursIll * 100) / 10;  %>
                      <p style="font-size:11px;margin-bottom:-15px">in this month.</p>
                  </p><br>
                  <div class="pbbg">
                    <div class="pb" style="width: <%=illnessPercent %>%;max-width:100%;min-width:0%"></div>
                  </div>
                </div>
              </div>
              <% int healthmeter=(3*sleeppercent+5*caloriepercent+2*illnessPercent)/10; %>

                <div class="health-meter">
                  <p class="count-text">Health Meter</p><br>
                  <p class="count-count" style="font-size:11px;margin-top:-20px">
                    <%out.print(healthmeter + "%" );%> - This is your cumulative health percent.
                  </p>
                  </p>
                  <div class="pbbg" style="height: 5%;">
                    <div class="pb" style="width: <%=healthmeter %>%;max-width:100%;min-width:0%"></div>
                  </div>
                </div>
            </div>
          </div>
        </div>

      </body>

      </html>