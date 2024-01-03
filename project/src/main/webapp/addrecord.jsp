<!DOCTYPE html>
<html lang="en">
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
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Kanit">
    <link rel="stylesheet" type="text/css" href="styles.css">
    <title >Your Health Dashboard</title>
    <!-- Include your stylesheet link here -->
</head>
<body>
    <br>
    <header>
        <h1 style="font-size:25px">YOUR HEALTH DASHBOARD</h1>
		<button class="tb back" onclick="goBack()">Back</button>
    </header>
    <br>
    <main>
        <div class="container">
            <button class="bm" onclick="showInputFields('food')">Food</button>
            <button class="bm" onclick="showInputFields('sleep')">Sleep</button>
            <button class="bm" onclick="showInputFields('illness')">Illness</button>
        </div>
        <div>
            <br>
            <!-- Iframe to display the form -->
            <iframe id="formFrame" name="formFrame" width="100%" height="600px" frameborder="0"></iframe>
        </div>
    </main>
</body>
</html>
