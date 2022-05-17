package com.jblprog.roomdatabase.entities.relations

import androidx.room.Embedded
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.jblprog.roomdatabase.entities.MenuCard
import com.jblprog.roomdatabase.entities.Restaurant

data class RestaurantAndMenu (
    @Embedded val restaurant : Restaurant,
    @Relation(
        parentColumn = "idRestaurant",
        entityColumn = "idRestaurant"
    )
    val menuCard : List<MenuCard>
        )