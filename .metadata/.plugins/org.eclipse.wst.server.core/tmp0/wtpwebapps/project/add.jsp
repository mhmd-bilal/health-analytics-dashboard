<!DOCTYPE html>
<html>

<head>
    <script>
    function goBack() {
        window.location.href = 'index.jsp';
    }
        function goBack() {
            window.location.href = 'index.jsp';
        }

        function showInputFields(selectedOption) {
            var iframeSrc = "";
            
            // Set the iframe source based on the selected option
            if (selectedOption === "food") {
                iframeSrc = "foodentry.jsp";
            } else if (selectedOption === "sleep") {
                iframeSrc = "sleepentry.jsp";
            } else if (selectedOption === "illness") {
                iframeSrc = "illnessentry.jsp";
            }

            // Set the iframe source
            document.getElementById("formFrame").src = iframeSrc;
        }
    </script>
    <title >Your Health Dashboard</title>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
  <link rel="stylesheet" href="styles2.css">
  <meta name="viewport" content="width=device-width, initial-scale=1">

</head>

<body>

      <div class="sidenav">
    <a href="#" style="padding-bottom: 100px;padding-left: 10px;"><img style="width: 95%;filter: brightness(1);" src="logo.png"></a>
    <a  href="index2.jsp"><img src="dashboard.png"></a>
    <a class="active" href="add.jsp"><img src="add.png"></a>
    <a href="anal.jsp"><img src="anal.png"></a>
    <a href="info.jsp"><img src="info.png"></a>
  </div>

  <div class="main" style="text-align: center;margin-top: 100px;">
    <h2 style="font-weight: 400;">Add Record</h2>
    <p style="font-weight: bold;font-style:italic;font-size: 20px;">Select the input type:</p>

    <div class="choose">
        <div class="choose-card">
        <a class="choose-btn" href="#" onclick="showInputFields('sleep')"><img src="sleep-green.png"></a>
    </div>
        <div class="choose-card">
        <a class="choose-btn" href="#" onclick="showInputFields('food')"><img src="food-green.png"></a>
    </div>
        <div class="choose-card">
        <a class="choose-btn" href="#" onclick="showInputFields('illness')"><img src="ill-green.png"></a>
        </div>
    </div>
    <iframe id="formFrame" name="formFrame" width="100%" height="300px" frameborder="0"></iframe>
    
</div>
</body>

</html>