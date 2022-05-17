package com.jblprog.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.jblprog.roomdatabase.entities.Dish
import com.jblprog.roomdatabase.entities.Ingredient
import com.jblprog.roomdatabase.entities.MenuCard
import com.jblprog.roomdatabase.entities.Restaurant
import com.jblprog.roomdatabase.entities.relations.DishIngredientCrossRef
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dao: RestaurantDao = RestaurantDatabase.getInstance(this).restaurantDao
        val restaurants = listOf(
            Restaurant(nameRestaurant = "The true restaurant"),
            Restaurant(nameRestaurant = "Gastro coco"),
            Restaurant(nameRestaurant = "Blue moon"),
            Restaurant(nameRestaurant = "Woky wok"),
        )

        val menus = listOf(
            MenuCard(idRestaurant = 1, nameMenu = "True sausage"),
            MenuCard(idRestaurant = 2, nameMenu = "High five"),
            MenuCard(idRestaurant = 3, nameMenu = "Lovely dishes"),
            MenuCard(idRestaurant = 4, nameMenu = "Mix it all"),
        )

        val dishes = listOf(
            Dish(idMenu = 1, nameDish = "Sausage soup", dishType = "Starter"),
            Dish(idMenu = 1, nameDish = "Baked sausage", dishType = "Main"),
            Dish(idMenu = 1, nameDish = "Sausage cake", dishType = "Desert"),
            Dish(idMenu = 2, nameDish = "Carrot cake", dishType = "Starter"),
            Dish(idMenu = 2, nameDish = "Walking ravioli", dishType = "Main"),
            Dish(idMenu = 3, nameDish = "Heart salad", dishType = "Starter"),
            Dish(idMenu = 3, nameDish = "Tiramisu", dishType = "Desert"),
            Dish(idMenu = 4, nameDish = "Wok", dishType = "Main"),
            Dish(idMenu = 4, nameDish = "Fruits wok", dishType = "Desert"),
        )

        val ingredients = listOf(
            Ingredient(nameIngredient = "Sausage"),
            Ingredient(nameIngredient = "Garlic"),
            Ingredient(nameIngredient = "Pineapple"),
            Ingredient(nameIngredient = "Bread"),
            Ingredient(nameIngredient = "Flour"),
            Ingredient(nameIngredient = "Carrot"),
            Ingredient(nameIngredient = "Magic"),
            Ingredient(nameIngredient = "Cream"),
            Ingredient(nameIngredient = "Beef heart"),
            Ingredient(nameIngredient = "Biscuits"),
            Ingredient(nameIngredient = "Sprout"),
            Ingredient(nameIngredient = "Mushrooms"),
            Ingredient(nameIngredient = "Banana"),
            Ingredient(nameIngredient = "Strawberries"),
            Ingredient(nameIngredient = "Chocolate"),
            Ingredient(nameIngredient = "Lettuce"),
        )

        val dishIngredientRelation = listOf(
            DishIngredientCrossRef(idDish = 1, idIngredient = 1),
            DishIngredientCrossRef(idDish = 1, idIngredient = 2),
            DishIngredientCrossRef(idDish = 1, idIngredient = 6),
            DishIngredientCrossRef(idDish = 1, idIngredient = 8),
            DishIngredientCrossRef(idDish = 2, idIngredient = 1),
            DishIngredientCrossRef(idDish = 2, idIngredient = 11),
            DishIngredientCrossRef(idDish = 3, idIngredient = 1),
            DishIngredientCrossRef(idDish = 3, idIngredient = 5),
            DishIngredientCrossRef(idDish = 4, idIngredient = 6),
            DishIngredientCrossRef(idDish = 4, idIngredient = 5),
            DishIngredientCrossRef(idDish = 5, idIngredient = 5),
            DishIngredientCrossRef(idDish = 5, idIngredient = 12),
            DishIngredientCrossRef(idDish = 5, idIngredient = 7),
            DishIngredientCrossRef(idDish = 6, idIngredient = 9),
            DishIngredientCrossRef(idDish = 6, idIngredient = 16),
            DishIngredientCrossRef(idDish = 7, idIngredient = 15),
            DishIngredientCrossRef(idDish = 7, idIngredient = 8),
            DishIngredientCrossRef(idDish = 8, idIngredient = 6),
            DishIngredientCrossRef(idDish = 8, idIngredient = 11),
            DishIngredientCrossRef(idDish = 9, idIngredient = 14),
            DishIngredientCrossRef(idDish = 9, idIngredient = 13),
            DishIngredientCrossRef(idDish = 9, idIngredient = 3),
        )
        lifecycleScope.launch {
            restaurants.forEach{dao.insertRestaurant(it) }
            menus.forEach{dao.insertMenu(it)}
            dishes.forEach { dao.insertDish(it) }
            ingredients.forEach { dao.insertIngredient(it) }
            dishIngredientRelation.forEach { dao.insertDishIngredientCrossRef(it) }
        }
    }
}