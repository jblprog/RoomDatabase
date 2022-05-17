package com.jblprog.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jblprog.roomdatabase.entities.Dish
import com.jblprog.roomdatabase.entities.Ingredient
import com.jblprog.roomdatabase.entities.MenuCard
import com.jblprog.roomdatabase.entities.Restaurant
import com.jblprog.roomdatabase.entities.relations.DishIngredientCrossRef

@Database(
    entities = [
        Dish::class,
        Ingredient::class,
        MenuCard::class,
        Restaurant::class,
        DishIngredientCrossRef::class
    ],
    version = 1
)
abstract class RestaurantDatabase : RoomDatabase() {

    abstract val restaurantDao: RestaurantDao

    companion object {
        @Volatile
        private var INSTANCE : RestaurantDatabase? = null

        fun getInstance(context : Context): RestaurantDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    RestaurantDatabase::class.java,
                    "restaurant_db"
                ).build().also{
                    INSTANCE = it
                }
            }
        }
    }
}