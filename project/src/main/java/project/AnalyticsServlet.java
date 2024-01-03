package project;

import com.google.gson.JsonObject;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AnalyticsServlet")
public class AnalyticsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Fetch data from the database
        String predominantEmotion = fetchPredominantEmotion();
        String undersleptDate = fetchUndersleptDate();
        String highCaloriesDate = fetchHighCaloriesDate();
        String mostIllDate = fetchMostIllDate();
        double predictedWeightIncrease = fetchPredictedWeightIncrease();

        // Create a JSON object with the data
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("predominantEmotion", predominantEmotion);
        jsonObject.addProperty("undersleptDate", undersleptDate);
        jsonObject.addProperty("highCaloriesDate", highCaloriesDate);
        jsonObject.addProperty("mostIllDate", mostIllDate);
        jsonObject.addProperty("predictedWeightIncrease", predictedWeightIncrease);

        // Set the content type and write the JSON response
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String fetchPredominantEmotion() {
        // Implement logic to fetch predominant emotion from the database
        // ...

        // For now, returning a sample value
        return "Happy";
    }

    private String fetchUndersleptDate() {
        // Implement logic to fetch underslept date from the database
        // ...

        // For now, returning a sample value
        return "2023-01-15";
    }

    private String fetchHighCaloriesDate() {
        // Implement logic to fetch date with high calories from the database
        // ...

        // For now, returning a sample value
        return "2023-01-20";
    }

    private String fetchMostIllDate() {
        // Implement logic to fetch date with most illness from the database
        // ...

        // For now, returning a sample value
        return "2023-02-05";
    }

    private double fetchPredictedWeightIncrease() {
        // Implement logic to fetch predicted weight increase percentage from the database
        // ...

        // For now, returning a sample value
        return 5.2;
    }
}
