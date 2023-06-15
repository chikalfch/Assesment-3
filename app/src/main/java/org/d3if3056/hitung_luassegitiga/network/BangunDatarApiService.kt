package org.d3if3056.hitung_luassegitiga.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if3056.hitung_luassegitiga.model.BangunDatar
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

import retrofit2.http.GET


private const val BASE_URL = "https://raw.githubusercontent.com/chikalfch/Assesment-3/listbangundatar/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface BangunDatarApiService {
    @GET("listBangunDatar.json")
    suspend fun getListBangunDatar(): List<BangunDatar>
}
object BangunDatarApi {
    val service: BangunDatarApiService by lazy {
        retrofit.create(BangunDatarApiService::class.java)
    }

    fun getBangunDatarUrl(imageId: String): String {
        return "$BASE_URL$imageId.jpg"
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }

