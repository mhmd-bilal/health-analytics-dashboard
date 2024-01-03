package project;

import java.util.HashMap;
import java.util.Map;

public class FoodCaloriesParser {
    private Map<String, Integer> foodCaloriesMap;

    public FoodCaloriesParser(String foodText) {
        this.foodCaloriesMap = parseFoodText(foodText);
    }

    private Map<String, Integer> parseFoodText(String foodText) {
        Map<String, Integer> map = new HashMap<>();
        String[] lines = foodText.split("\n");

        for (String line : lines) {
            String[] parts = line.split("\t");

            if (parts.length == 2) {
                try {
                    String foodName = parts[0].trim().toLowerCase();
                    int calories = Integer.parseInt(parts[1].trim());
                    map.put(foodName, calories);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid calorie format for line: " + line);
                }
            } else {
                System.out.println("Invalid line format: " + line);
            }
        }

        return map;
    }

    public int getCaloriesForFood(String food) {
        return foodCaloriesMap.getOrDefault(food.toLowerCase(), 0);
    }

    public static void main(String[] args) {
        // Example usage
        String foodText = "artichoke\t60\narugula\t1\nasparagus\t2\n"; // Add the entire text here
        FoodCaloriesParser parser = new FoodCaloriesParser(foodText);

        // Example: Get calories for a specific food
        String foodToSearch = "asparagus";
        int calories = parser.getCaloriesForFood(foodToSearch);
        System.out.println("Calories for " + foodToSearch + ": " + calories);
    }
}
