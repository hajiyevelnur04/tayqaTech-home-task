package com.eebros.myapplication.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BaseRate::class], version = 1, exportSchema = false)
abstract class BaseRateDatabase: RoomDatabase(){
    abstract  fun baseRateDao(): BaseRateDao

    companion object {
        // Singleton prevents multiple instances of database opening at the same time.
        @Volatile
        private var INSTANCE: BaseRateDatabase? = null

        fun getDatabase(context: Context): BaseRateDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BaseRateDatabase::class.java,
                    "baseRate_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}