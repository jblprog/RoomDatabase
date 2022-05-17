package com.jblprog.roomdatabase.entities.relations

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation
import com.jblprog.roomdatabase.entities.Dish
import com.jblprog.roomdatabase.entities.MenuCard

@Entity
data class MenuWithDishes (
    @Embedded val menu : MenuCard,
    @Relation(
        parentColumn = "idMenu",
        entityColumn = "idMenu"
    )
    val dish : List<Dish>
        )