package com.jblprog.roomdatabase

import androidx.room.*
import com.jblprog.roomdatabase.entities.Dish
import com.jblprog.roomdatabase.entities.Ingredient
import com.jblprog.roomdatabase.entities.MenuCard
import com.jblprog.roomdatabase.entities.Restaurant
import com.jblprog.roomdatabase.entities.relations.*

@Dao
interface RestaurantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRestaurant (restaurant : Restaurant)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMenu (menu : MenuCard)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDish (dish: Dish)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIngredient (ingredient: Ingredient)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDishIngredientCrossRef (crossRef: DishIngredientCrossRef)

    @Transaction //To avoid multithreading issues
    @Query("SELECT * FROM restaurant WHERE idRestaurant = :idRestaurant")
    suspend fun getRestaurantAndMenuWithRestaurantId(idRestaurant: Int): List<RestaurantAndMenu>

    @Transaction
    @Query("SELECT * FROM menucard WHERE idMenu = :idMenu")
    suspend fun getDishesOfMenu(idMenu: Int): List<MenuWithDishes>

    @Transaction
    @Query("SELECT * FROM dish WHERE idDish = :idDish")
    suspend fun getIngredientsForDish(idDish: Int): List<DishWithIngredients>

    @Transaction
    @Query("SELECT * FROM ingredient WHERE idIngredient = :idIngredient")
    suspend fun getDishesWithIngredient(idIngredient: Int): List<IngredientWithDishes>
}