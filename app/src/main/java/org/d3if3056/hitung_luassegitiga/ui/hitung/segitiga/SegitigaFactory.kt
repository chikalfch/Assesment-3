package org.d3if3056.hitung_luassegitiga.ui.hitung.segitiga

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if3056.hitung_luassegitiga.db.bangundatar.BangunDatarDao


class SegitigaFactory (
    private val db: BangunDatarDao
    ) : ViewModelProvider.Factory {
        @Suppress("unchecked_cast")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(SegitigaViewModel::class.java)) {
                return SegitigaViewModel(db) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
}