package org.d3if3056.hitung_luassegitiga.db.bangundatar

import org.d3if3056.hitung_luassegitiga.model.HasilPersegiPanjang
import org.d3if3056.hitung_luassegitiga.model.HasilSegitiga

fun PersegiPanjangEntity.hitungBangunDatar(): HasilPersegiPanjang {
    val luas = panjang * lebar
    return HasilPersegiPanjang(luas)
}

fun SegitigaEntity.hitungBangunDatar(): HasilSegitiga {
    val luas = (alas * tinggi) /2
    return HasilSegitiga(luas)
}