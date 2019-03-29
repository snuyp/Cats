package com.example.cats.db

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "favorite_cats")
class FavoriteCats {
    @PrimaryKey
    var id: String? = null

    var url: String? = null
}