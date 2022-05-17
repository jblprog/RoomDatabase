package com.jblprog.roomdatabase.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Dish (
    @PrimaryKey(autoGenerate = true)
    val idDish : Int = 0,
    val idMenu : Int,
    val nameDish : String,
    val dishType : String,
        )