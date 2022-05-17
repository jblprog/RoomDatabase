package com.jblprog.roomdatabase.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.jblprog.roomdatabase.entities.Dish
import com.jblprog.roomdatabase.entities.Ingredient

data class IngredientWithDishes (
    @Embedded val ingredient: Ingredient,
    @Relation(
        parentColumn = "idIngredient",
        entityColumn = "idDish",
        associateBy = Junction(DishIngredientCrossRef::class)
    )
    val dishes : List<Dish>
        )