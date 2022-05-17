package com.jblprog.roomdatabase.entities.relations

import androidx.room.Entity

@Entity(primaryKeys = ["idDish", "idIngredient"])
data class DishIngredientCrossRef (
    val idDish : Int,
    val idIngredient : Int
        )