package org.d3if3056.hitung_luassegitiga.model

import org.d3if3056.hitung_luassegitiga.db.bangundatar.PersegiPanjangEntity
import org.d3if3056.hitung_luassegitiga.db.bangundatar.SegitigaEntity

fun PersegiPanjangEntity.hitungBangunDatar(): HasilPersegiPanjang {
    val luas = panjang * lebar
    return HasilPersegiPanjang(luas)
}

fun SegitigaEntity.hitungBangunDatar(): HasilSegitiga {
    val luas = (alas * tinggi) / 2
    return HasilSegitiga(luas)
}