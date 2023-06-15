package org.d3if3056.hitung_luassegitiga.ui.hitung.persegipanjang

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3056.hitung_luassegitiga.db.bangundatar.BangunDatarDao
import org.d3if3056.hitung_luassegitiga.db.bangundatar.PersegiPanjangEntity
import org.d3if3056.hitung_luassegitiga.model.hitungBangunDatar
import org.d3if3056.hitung_luassegitiga.model.HasilPersegiPanjang

class PersegiPanjangViewModel (private val db: BangunDatarDao ) : ViewModel() {
    private val hasilPersegiPanjang = MutableLiveData<HasilPersegiPanjang?>()


    fun hitungPersegiPanjang(panjang: Float, lebar: Float) {
    val dataPersegiPanjang = PersegiPanjangEntity(
        panjang = panjang,
        lebar = lebar
    )
    hasilPersegiPanjang.value = dataPersegiPanjang.hitungBangunDatar()
         viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataPersegiPanjang)
            }
        }
    }fun getHasilPersegiPanjang(): LiveData<HasilPersegiPanjang?> = hasilPersegiPanjang
}