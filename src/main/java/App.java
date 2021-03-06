import com.google.gson.Gson;
import dao.Sql2oFoodtypeDao;
import dao.Sql2oRestaurantDao;
import dao.Sql2oReviewDao;
import models.Foodtype;
import models.Restaurant;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        Sql2oReviewDao reviewDao;
        Sql2oRestaurantDao restaurantDao;
        Sql2oFoodtypeDao foodtypeDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/jadle.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        reviewDao = new Sql2oReviewDao(sql2o);
        restaurantDao = new Sql2oRestaurantDao(sql2o);
        foodtypeDao =new Sql2oFoodtypeDao(sql2o);
        conn = sql2o.open();

        post("/restaurants/new", "application/json", (req, res) -> {
            Restaurant restaurant = gson.fromJson(req.body(), Restaurant.class);
            restaurantDao.add(restaurant);
            res.status(201);
            return gson.toJson(restaurant);
        });

        post("/foodtypes/new", "application/json", (req, res) -> {
            Foodtype foodtype = gson.fromJson(req.body(), Foodtype.class);
            foodtypeDao.add(foodtype);
            res.status(201);
            return gson.toJson(foodtype);
        });

        get("/restaurants", "application/json", (req, res) -> { //accept a request in format JSON from an app
            return gson.toJson(restaurantDao.getAll());//send it back to be displayed
        });

        get("/restaurants/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            int restaurantId = Integer.parseInt(req.params("id"));
            return gson.toJson(restaurantDao.findById(restaurantId));
        });



        get("/foodtypes", "application/json", (req, res) -> { //accept a request in format JSON from an app
            return gson.toJson(foodtypeDao.getAll());//send it back to be displayed
        });

        get("/foodtypes/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            int foodtypeId = Integer.parseInt(req.params("id"));
            return gson.toJson(foodtypeDao.findById(foodtypeId));
        });

        //FILTERS
        after((req, res) ->{
            res.type("application/json");
        });



    }

}
