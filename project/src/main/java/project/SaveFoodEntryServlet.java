package project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SaveFoodEntryServlet")
public class SaveFoodEntryServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Integer> foodCaloriesMap;

    @Override
    public void init() throws ServletException {
        super.init();
        // Initialize the foodCaloriesMap with food items and their corresponding calories
        foodCaloriesMap = new HashMap<>();
        // Add all your food items and calories here
        foodCaloriesMap.put("artichoke", 60);
        foodCaloriesMap.put("arugula", 1);
        foodCaloriesMap.put("asparagus", 2);
        foodCaloriesMap.put("aubergine", 115);
        foodCaloriesMap.put("beetroot", 35);
        foodCaloriesMap.put("bell pepper", 15);
        foodCaloriesMap.put("black olives", 2);
        foodCaloriesMap.put("broccoli", 207);
        foodCaloriesMap.put("brussels sprouts", 8);
        foodCaloriesMap.put("cabbage", 227);
        foodCaloriesMap.put("capsicum", 12);
        foodCaloriesMap.put("carrot", 25);
        foodCaloriesMap.put("cauliflower", 3);
        foodCaloriesMap.put("celery", 6);
        foodCaloriesMap.put("chard", 9);
        foodCaloriesMap.put("cherry tomato", 20);
        foodCaloriesMap.put("chicory", 38);
        foodCaloriesMap.put("chinese cabbage", 134);
        foodCaloriesMap.put("chives", 1);
        foodCaloriesMap.put("collard greens", 12);
        foodCaloriesMap.put("corn", 562);
        foodCaloriesMap.put("courgette", 33);
        foodCaloriesMap.put("creamed spinach", 148);
        foodCaloriesMap.put("cucumber", 66);
        foodCaloriesMap.put("eggplant", 115);
        foodCaloriesMap.put("endive", 87);
        foodCaloriesMap.put("fennel", 73);
        foodCaloriesMap.put("garlic", 4);
        foodCaloriesMap.put("gherkin", 9);
        foodCaloriesMap.put("gourd", 108);
        foodCaloriesMap.put("green beans", 34);
        foodCaloriesMap.put("green olives", 2);
        foodCaloriesMap.put("green onion", 5);
        foodCaloriesMap.put("horseradish", 7);
        foodCaloriesMap.put("kale", 33);
        foodCaloriesMap.put("kohlrabi", 108);
        foodCaloriesMap.put("kumara", 112);
        foodCaloriesMap.put("leek", 54);
        foodCaloriesMap.put("lettuce", 90);
        foodCaloriesMap.put("mushrooms", 1);
        foodCaloriesMap.put("mustard greens", 15);
        foodCaloriesMap.put("nori", 1);
        foodCaloriesMap.put("okra", 4);
        foodCaloriesMap.put("olives", 2);
        foodCaloriesMap.put("onion", 34);
        foodCaloriesMap.put("parsnips", 128);
        foodCaloriesMap.put("peas", 79);
        foodCaloriesMap.put("pepper", 20);
        foodCaloriesMap.put("potato", 164);
        foodCaloriesMap.put("pumpkin", 51);
        foodCaloriesMap.put("radishes", 1);
        foodCaloriesMap.put("red cabbage", 7);
        foodCaloriesMap.put("rutabaga", 147);
        foodCaloriesMap.put("shallots", 18);
        foodCaloriesMap.put("spinach", 78);
        foodCaloriesMap.put("squash", 88);
        foodCaloriesMap.put("sweet potato", 112);
        foodCaloriesMap.put("tomato", 20);
        foodCaloriesMap.put("turnip greens", 34);
        foodCaloriesMap.put("turnips", 34);
        foodCaloriesMap.put("wasabi", 184);
        foodCaloriesMap.put("winter squash", 147);
        foodCaloriesMap.put("zucchini", 33);
        foodCaloriesMap.put("acai", 20);
        foodCaloriesMap.put("apple", 95);
        foodCaloriesMap.put("applesauce", 167);
        foodCaloriesMap.put("apricot", 17);
        foodCaloriesMap.put("avocado", 320);
        foodCaloriesMap.put("banana", 111);
        foodCaloriesMap.put("blackberries", 62);
        foodCaloriesMap.put("blood oranges", 70);
        foodCaloriesMap.put("blueberries", 84);
        foodCaloriesMap.put("cantaloupe", 23);
        foodCaloriesMap.put("cherries", 4);
        foodCaloriesMap.put("clementine", 35);
        foodCaloriesMap.put("cranberries", 46);
        foodCaloriesMap.put("currants", 63);
        foodCaloriesMap.put("custard apple", 136);
        foodCaloriesMap.put("dates", 20);
        foodCaloriesMap.put("figs", 37);
        foodCaloriesMap.put("fruit salad", 125);
        foodCaloriesMap.put("grapes", 104);
        foodCaloriesMap.put("greengage", 2);
        foodCaloriesMap.put("guava", 37);
        foodCaloriesMap.put("jackfruit", 143);
        foodCaloriesMap.put("jujube", 22);
        foodCaloriesMap.put("kiwi", 112);
        foodCaloriesMap.put("lemon", 17);
        foodCaloriesMap.put("lime", 20);
        foodCaloriesMap.put("lychees", 7);
        foodCaloriesMap.put("mandarin oranges", 47);
        foodCaloriesMap.put("mango", 202);
        foodCaloriesMap.put("minneola", 70);
        foodCaloriesMap.put("mulberries", 60);
        foodCaloriesMap.put("nectarine", 66);
        foodCaloriesMap.put("olives", 2);
        foodCaloriesMap.put("orange", 62);
        foodCaloriesMap.put("papaya", 215);
        foodCaloriesMap.put("passion fruit", 17);
        foodCaloriesMap.put("peach", 59);
        foodCaloriesMap.put("pear", 101);
        foodCaloriesMap.put("persimmon", 32);
        foodCaloriesMap.put("physalis", 2);
        foodCaloriesMap.put("pineapple", 453);
        foodCaloriesMap.put("plantains", 218);
        foodCaloriesMap.put("plum", 30);
        foodCaloriesMap.put("pomegranate", 234);
        foodCaloriesMap.put("quince", 52);
        foodCaloriesMap.put("raisins", 434);
        foodCaloriesMap.put("rambutan", 7);
        foodCaloriesMap.put("raspberries", 64);
        foodCaloriesMap.put("rhubarb", 11);
        foodCaloriesMap.put("starfruit", 28);
        foodCaloriesMap.put("strawberries", 49);
        foodCaloriesMap.put("tamarind", 5);
        foodCaloriesMap.put("tangerine", 47);
        foodCaloriesMap.put("watermelon", 86);
        foodCaloriesMap.put("baby back ribs", 360);
        foodCaloriesMap.put("bacon and eggs", 539);
        foodCaloriesMap.put("baked beans", 244);
        foodCaloriesMap.put("bbq ribs", 360);
        foodCaloriesMap.put("beef stew", 186);
        foodCaloriesMap.put("biryani", 484);
        foodCaloriesMap.put("black pudding", 101);
        foodCaloriesMap.put("black rice", 323);
        foodCaloriesMap.put("blt", 593);
        foodCaloriesMap.put("brown rice", 670);
        foodCaloriesMap.put("burrito", 326);
        foodCaloriesMap.put("butter chicken", 490);
        foodCaloriesMap.put("california roll", 33);
        foodCaloriesMap.put("chicken caesar salad", 392);
        foodCaloriesMap.put("chicken fried steak", 423);
        foodCaloriesMap.put("chicken marsala", 2209);
        foodCaloriesMap.put("chicken parmesan", 250);
        foodCaloriesMap.put("chicken pot pie", 673);
        foodCaloriesMap.put("chicken tikka masala", 195);
        foodCaloriesMap.put("chili con carne", 266);
        foodCaloriesMap.put("chimichanga", 418);
        foodCaloriesMap.put("cobb salad", 632);
        foodCaloriesMap.put("collard greens", 13);
        foodCaloriesMap.put("corn dog", 438);
        foodCaloriesMap.put("corned beef hash", 349);
        foodCaloriesMap.put("cottage pie", 523);
        foodCaloriesMap.put("dal", 304);
        foodCaloriesMap.put("deviled eggs", 62);
        foodCaloriesMap.put("dim sum", 37);
        foodCaloriesMap.put("dosa", 287);
        foodCaloriesMap.put("enchiladas", 323);
        foodCaloriesMap.put("fajita", 290);
        foodCaloriesMap.put("fish and chips", 585);
        foodCaloriesMap.put("fried rice", 662);
        foodCaloriesMap.put("fried shrimp", 75);
        foodCaloriesMap.put("grilled cheese sandwich", 392);
        foodCaloriesMap.put("ham and cheese sandwich", 352);
        foodCaloriesMap.put("hummus", 435);
        foodCaloriesMap.put("jambalaya", 250);
        foodCaloriesMap.put("kebab", 774);
        foodCaloriesMap.put("lasagne", 284);
        foodCaloriesMap.put("mac and cheese", 699);
        foodCaloriesMap.put("macaroni and cheese", 699);
        foodCaloriesMap.put("mashed potatoes", 174);
        foodCaloriesMap.put("meat pie", 290);
        foodCaloriesMap.put("meatloaf", 721);
        foodCaloriesMap.put("naan", 260);
        foodCaloriesMap.put("orange chicken", 420);
        foodCaloriesMap.put("pad thai", 375);
        foodCaloriesMap.put("paella", 200);
        foodCaloriesMap.put("paratha", 260);
        foodCaloriesMap.put("pea soup", 190);
        foodCaloriesMap.put("peanut butter sandwich", 200);
        foodCaloriesMap.put("peking duck", 401);
        foodCaloriesMap.put("philly cheese steak", 300);
        foodCaloriesMap.put("pizza", 272);
        foodCaloriesMap.put("pork chop", 295);
        foodCaloriesMap.put("potato salad", 136);
        foodCaloriesMap.put("pulled pork sandwich", 551);
        foodCaloriesMap.put("ramen", 380);
        foodCaloriesMap.put("ravioli", 134);
        foodCaloriesMap.put("reuben sandwich", 641);
        foodCaloriesMap.put("roast beef", 23);
        foodCaloriesMap.put("roast dinner", 240);
        foodCaloriesMap.put("samosa", 107);
        foodCaloriesMap.put("sausage roll", 361);
        foodCaloriesMap.put("sausage rolls", 101);
        foodCaloriesMap.put("shepherds pie", 159);
        foodCaloriesMap.put("shrimp cocktail", 130);
        foodCaloriesMap.put("sloppy joe", 101);
        foodCaloriesMap.put("sloppy joes", 397);
        foodCaloriesMap.put("spaghetti bolognese", 374);
        foodCaloriesMap.put("spring roll", 350);
        foodCaloriesMap.put("taco", 213);
        foodCaloriesMap.put("tandoori chicken", 198);
        foodCaloriesMap.put("yorkshire pudding", 83);
        foodCaloriesMap.put("amaranth", 716);
        foodCaloriesMap.put("barley", 556);
        foodCaloriesMap.put("barley groats", 31);
        foodCaloriesMap.put("brown rice", 757);
        foodCaloriesMap.put("buckwheat", 583);
        foodCaloriesMap.put("buckwheat groats", 567);
        foodCaloriesMap.put("corn waffles", 110);
        foodCaloriesMap.put("cornmeal", 442);
        foodCaloriesMap.put("cornstarch", 488);
        foodCaloriesMap.put("couscous", 650);
        foodCaloriesMap.put("cracker", 35);
        foodCaloriesMap.put("durum wheat semolina", 119);
        foodCaloriesMap.put("flaxseed", 897);
        foodCaloriesMap.put("freekeh", 832);
        foodCaloriesMap.put("gluten", 104);
        foodCaloriesMap.put("grissini", 20);
        foodCaloriesMap.put("kamut", 627);
        foodCaloriesMap.put("millet", 484);
        foodCaloriesMap.put("millet flour", 521);
        foodCaloriesMap.put("millet gruel", 80);
        foodCaloriesMap.put("oat bran", 231);
        foodCaloriesMap.put("pearl barley", 553);
        foodCaloriesMap.put("polenta", 549);
        foodCaloriesMap.put("prawn crackers", 16);
        foodCaloriesMap.put("pretzel sticks", 46);
        foodCaloriesMap.put("quinoa", 626);
        foodCaloriesMap.put("rusk", 41);
        foodCaloriesMap.put("rye bran", 422);
        foodCaloriesMap.put("sago", 99);
        foodCaloriesMap.put("savoury biscuits", 139);
        foodCaloriesMap.put("shortbread", 95);
        foodCaloriesMap.put("spelt", 588);
        foodCaloriesMap.put("spelt bran", 283);
        foodCaloriesMap.put("spelt semolina", 601);
        foodCaloriesMap.put("sunflower seeds", 818);
        foodCaloriesMap.put("tortilla", 467);
        foodCaloriesMap.put("tortilla chips", 160);
        foodCaloriesMap.put("wheat bran", 125);
        foodCaloriesMap.put("wheat germ", 432);
        foodCaloriesMap.put("wheat gluten", 10);
        foodCaloriesMap.put("wheat semolina", 601);
        foodCaloriesMap.put("wheat starch", 386);
        foodCaloriesMap.put("whole grain wheat", 407);
        foodCaloriesMap.put("wholegrain oat", 300);
        foodCaloriesMap.put("almond oil", 123);
        foodCaloriesMap.put("apricot kernel oil", 124);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String food = request.getParameter("food");
        int calories = getCaloriesForFood(food);

        if (calories >= 0) {
            // Get the current timestamp
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String foodEntryTime = sdf.format(new Date());

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "password");
                 PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO foodentry (food, foodentrytime, calories) VALUES (?, ?, ?)")) {

                preparedStatement.setString(1, food);
                preparedStatement.setString(2, foodEntryTime);
                preparedStatement.setInt(3, calories);

                preparedStatement.executeUpdate();

                response.getWriter().println("Food entry saved successfully!");

            } catch (SQLException e) {
                e.printStackTrace();
                response.getWriter().println("Error: " + e.getMessage());
            }
        } else {
            response.getWriter().println("Error: Food not found or calories information not available.");
        }
    }
    private int getCaloriesForFood(String food) {
        // Convert the food parameter to lowercase
        String lowercaseFood = food.toLowerCase();

        // Check if the lowercase food is present in the map
        if (foodCaloriesMap.containsKey(lowercaseFood)) {
            return foodCaloriesMap.get(lowercaseFood);
        } else {
            return -1; // Return -1 or handle this case as per your requirement
        }
    }
}
