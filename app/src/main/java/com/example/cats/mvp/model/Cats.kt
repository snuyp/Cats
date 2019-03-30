package com.example.cats.mvp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Cats {
    @SerializedName("breeds")
    @Expose
    var breeds: List<Breeds>? = null

    @SerializedName("categories")
    @Expose
    var categories: List<Category>? = null

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null
}