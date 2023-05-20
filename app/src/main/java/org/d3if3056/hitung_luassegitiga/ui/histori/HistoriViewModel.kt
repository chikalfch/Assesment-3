package org.d3if3056.hitung_luassegitiga.ui.histori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3056.hitung_luassegitiga.db.bangundatar.BangunDatarDao

class HistoriViewModel  (private val db: BangunDatarDao) : ViewModel() {
    val dataSegitiga = db.getLastSegitiga()
    val dataPersegiPanjang = db.getLastPersegiPanjang()

    fun hapusData() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            db.clearData()
        }
    }

}