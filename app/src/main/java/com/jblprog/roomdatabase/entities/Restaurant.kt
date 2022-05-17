package com.jblprog.roomdatabase.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Restaurant (
        @PrimaryKey(autoGenerate = true)
        val idRestaurant : Int = 0,
        val nameRestaurant : String
        )