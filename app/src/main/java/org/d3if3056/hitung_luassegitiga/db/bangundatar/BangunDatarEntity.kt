package org.d3if3056.hitung_luassegitiga.db.bangundatar

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "persegipanjang")
data class PersegiPanjangEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var tanggal: Long = System.currentTimeMillis(),
    var panjang: Float,
    var lebar: Float
)

@Entity(tableName = "segitiga")
data class SegitigaEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var tanggal: Long = System.currentTimeMillis(),
    var alas: Float,
    var tinggi: Float
)
