package org.d3if3056.hitung_luassegitiga.db.bangundatar

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SegitigaEntity::class, PersegiPanjangEntity ::class], version = 2, exportSchema = false)
abstract class BangunDatarDb : RoomDatabase() {
    abstract val dao: BangunDatarDao

    companion object {
        @Volatile
        private var INSTANCE: BangunDatarDb? = null
        fun getInstance(context: Context): BangunDatarDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BangunDatarDb::class.java,
                        "bangundatar.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
