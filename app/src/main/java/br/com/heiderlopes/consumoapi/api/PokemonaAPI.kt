package br.com.heiderlopes.consumoapi.api

import br.com.heiderlopes.consumoapi.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonaAPI {

    @GET("/api/v2/pokemon/{number}")
    fun search(@Path("number") number: String): Call<Pokemon>

}