package com.jblprog.roomdatabase.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Ingredient (
    @PrimaryKey(autoGenerate = true)
    val idIngredient: Int = 0,
    val nameIngredient : String

        )