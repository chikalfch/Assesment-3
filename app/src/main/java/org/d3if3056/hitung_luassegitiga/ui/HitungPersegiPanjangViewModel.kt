package org.d3if3056.hitung_luassegitiga.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.d3if3056.hitung_luassegitiga.model.HasilPersegiPanjang
import org.d3if3056.hitung_luassegitiga.model.HasilSegitiga

class HitungPersegiPanjangViewModel : ViewModel() {
    private val hasilPersegiPanjang = MutableLiveData<HasilPersegiPanjang?>()

    fun hitungPersegiPanjang(panjang: Float, lebar: Float) {
        val hasil = (panjang * lebar)
        hasilPersegiPanjang.value = HasilPersegiPanjang(hasil)
    }

    fun getHasilPersegiPanjang(): LiveData<HasilPersegiPanjang?> = hasilPersegiPanjang




}