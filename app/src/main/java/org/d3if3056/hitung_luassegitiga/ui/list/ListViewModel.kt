package org.d3if3056.mobpro1.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3056.hitung_luassegitiga.R
import org.d3if3056.hitung_luassegitiga.model.BangunDatar
import org.d3if3056.hitung_luassegitiga.network.BangunDatarApi

class ListViewModel : ViewModel() {
    private val data = MutableLiveData<List<BangunDatar>>()
    init {
        data.value = initData()
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch (Dispatchers.IO) {
            try {
                val result = BangunDatarApi.service.getListBangunDatar()
                Log.d("ListViewModel", "Success: $result")
            } catch (e: Exception) {
                Log.d("ListViewModel", "Failure: ${e.message}")
            }
        }
    }
    // Data ini akan kita ambil dari server di langkah selanjutnya
    private fun initData(): List<BangunDatar> {
        return listOf(
            BangunDatar("Persegi Panjang", "Luas = panjang x lebar", R.drawable.persegipanjang),
            BangunDatar("Segitiga", "Luas = 1/2 x (alas x tinggi)", R.drawable.segitiga),
            BangunDatar("Lingkaran", "Luas = 22/7 x jari-jari x jari-jari", R.drawable.lingkaran),
            BangunDatar("Trapesium", "Luas = 1/2 x (a + b) x tinggi", R.drawable.trapesium),
            BangunDatar("Layang-layang", "Luas = 1/2 x d1 x d2", R.drawable.layanglayang),
        )
    }
    fun getData(): LiveData<List<BangunDatar>> = data
}