package com.jblprog.roomdatabase.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MenuCard (
    @PrimaryKey(autoGenerate = true)
    val idMenu : Int = 0,
    val idRestaurant : Int,
    val nameMenu : String
        )