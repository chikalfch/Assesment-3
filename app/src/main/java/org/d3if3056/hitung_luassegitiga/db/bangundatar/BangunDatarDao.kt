package org.d3if3056.hitung_luassegitiga.db.bangundatar

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BangunDatarDao {

    @Insert
    fun insert(bangundatar: PersegiPanjangEntity)

    @Insert
    fun insert(bangundatar: SegitigaEntity)

    @Query("SELECT * FROM persegipanjang ORDER BY id DESC")
    fun getLastPersegiPanjang(): LiveData<List<PersegiPanjangEntity?>>

    @Query("SELECT * FROM segitiga ORDER BY id DESC")
    fun getLastSegitiga(): LiveData<List<SegitigaEntity?>>

    @Query("DELETE FROM persegipanjang")
    fun clearData()
}
