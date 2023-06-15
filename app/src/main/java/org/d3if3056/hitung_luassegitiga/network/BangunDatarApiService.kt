package org.d3if3056.hitung_luassegitiga.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://raw.githubusercontent.com/chikalfch/Assesment-3/listbangundatar/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface BangunDatarApiService {
    @GET("static-api.json")
    suspend fun getListBangunDatar(): String
}
object BangunDatarApi {
    val service: BangunDatarApiService by lazy {
        retrofit.create(BangunDatarApiService::class.java)
    }
}
