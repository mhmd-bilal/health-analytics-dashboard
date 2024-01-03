<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="styles2.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script>

        // Function to fetch data and create the pie chart
        function createMoodChart() {
            fetch('MoodChartDataServlet') // Assuming you create a servlet to provide data
                .then(response => response.json())
                .then(data => {
                    var ctx = document.getElementById('moodChart').getContext('2d');

                    // Add title element with an ID
                    var title = document.createElement('div');
                    document.querySelector('.piechart').appendChild(title);

                    // Define solid colors
                    var color1 = '#62cd32'; // Replace with your desired color
                    var color2 = '#399f2e'; // Replace with your desired color
                    var color3 = '#d3d3d3'; // Replace with your desired color

                    new Chart(ctx, {
                        type: 'doughnut',
                        data: {
                            labels: data.labels,
                            datasets: [{
                                data: data.values,
                                backgroundColor: [color1, color2, color3], // Use solid colors
                                borderWidth: 0, // Remove border
                                fontColor: 'white',
                                }]
                        },
                        options: {
                            legend: {
                                display: true, // Hide the legend
                            },
                            responsive: true, // Make the chart responsive
                        },
                    });
                })
                .catch(error => {
                    console.error('Error:', error);
                });
        }

        // Call the function when the page loads
        window.onload = function() {
            createMoodChart();
        };

    </script>
</head>
<body>
    <div class="analytics">
        <div class="piechart">
            <canvas id="moodChart" style="width:100%;max-height:450px" width="400" height="400"></canvas>
        </div>
    </div>
</body>
</html>
