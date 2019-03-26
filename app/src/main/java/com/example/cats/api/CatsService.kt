package com.example.cats.api

import com.example.cats.mvp.model.Cats
import retrofit2.http.GET
import retrofit2.http.Query
import io.reactivex.Observable
import retrofit2.http.Header

interface CatsService {

    companion object {
        const val KEY = "19989e85-1530-4d07-8455-d27e8314ce9f"
    }

    @GET("search?")
    fun getCats(@Query("limit") limit : Int,
                @Query("page") page : Int,
                @Header("x-api-key") key : String) : Observable<List<Cats>>
}