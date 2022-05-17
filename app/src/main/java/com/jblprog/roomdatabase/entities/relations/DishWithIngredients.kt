package com.jblprog.roomdatabase.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.jblprog.roomdatabase.entities.Dish
import com.jblprog.roomdatabase.entities.Ingredient

data class DishWithIngredients (
    @Embedded val dish: Dish,
    @Relation(
        parentColumn = "idDish",
        entityColumn = "idIngredient",
        associateBy = Junction(DishIngredientCrossRef::class)
    )
    val ingredients: List<Ingredient>
        )