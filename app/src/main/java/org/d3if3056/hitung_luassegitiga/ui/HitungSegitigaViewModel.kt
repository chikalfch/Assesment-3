package org.d3if3056.hitung_luassegitiga.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.d3if3056.hitung_luassegitiga.model.HasilPersegiPanjang
import org.d3if3056.hitung_luassegitiga.model.HasilSegitiga

class HitungSegitigaViewModel : ViewModel() {
    private val hasilSegitiga = MutableLiveData<HasilSegitiga?>()

    fun hitungSegitiga(alas: Float, tinggi: Float) {
        val hasil = (alas * tinggi) / 2
        hasilSegitiga.value = HasilSegitiga(hasil)
    }

    fun getHasilSegitiga(): LiveData<HasilSegitiga?> = hasilSegitiga
}