package org.d3if3056.hitung_luassegitiga.ui.hitung.persegipanjang

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if3056.hitung_luassegitiga.db.bangundatar.BangunDatarDao

class PersegiPanjangFactory (
    private val db: BangunDatarDao
    ) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PersegiPanjangViewModel::class.java)) {
            return PersegiPanjangViewModel(db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}