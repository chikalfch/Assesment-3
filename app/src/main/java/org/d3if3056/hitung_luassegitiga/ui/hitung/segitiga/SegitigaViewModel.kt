package org.d3if3056.hitung_luassegitiga.ui.hitung.segitiga

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3056.hitung_luassegitiga.db.bangundatar.BangunDatarDao
import org.d3if3056.hitung_luassegitiga.db.bangundatar.SegitigaEntity
import org.d3if3056.hitung_luassegitiga.model.hitungBangunDatar
import org.d3if3056.hitung_luassegitiga.model.HasilSegitiga

class SegitigaViewModel  (private val db: BangunDatarDao)  : ViewModel() {
    private val hasilSegitiga = MutableLiveData<HasilSegitiga?>()


    fun hitungSegitiga(alas: Float, tinggi: Float) {
        val dataSegitiga = SegitigaEntity(
            alas = alas,
            tinggi = tinggi
        )
        hasilSegitiga.value = dataSegitiga.hitungBangunDatar()
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataSegitiga)
            }
        }
    }

    fun getHasilSegitiga(): LiveData<HasilSegitiga?> = hasilSegitiga
}