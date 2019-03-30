package com.example.cats.mvp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Breeds {
    @SerializedName("alt_names")
    @Expose
    var altNames: String? = null
    @SerializedName("experimental")
    @Expose
    var experimental: Int? = null
    @SerializedName("hairless")
    @Expose
    var hairless: Int? = null
    @SerializedName("hypoallergenic")
    @Expose
    var hypoallergenic: Int? = null
    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("life_span")
    @Expose
    var lifeSpan: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("natural")
    @Expose
    var natural: Int? = null
    @SerializedName("origin")
    @Expose
    var origin: String? = null
    @SerializedName("rare")
    @Expose
    var rare: Int? = null
    @SerializedName("reference_image_id")
    @Expose
    var referenceImageId: Any? = null
    @SerializedName("rex")
    @Expose
    var rex: Int? = null
    @SerializedName("short_legs")
    @Expose
    var shortLegs: Int? = null
    @SerializedName("suppressed_tail")
    @Expose
    var suppressedTail: Int? = null
    @SerializedName("temperament")
    @Expose
    var temperament: String? = null
    @SerializedName("weight_imperial")
    @Expose
    var weightImperial: String? = null
    @SerializedName("wikipedia_url")
    @Expose
    var wikipediaUrl: String? = null
}