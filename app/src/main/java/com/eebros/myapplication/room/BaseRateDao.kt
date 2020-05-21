package com.eebros.myapplication.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface BaseRateDao {
    @Query("SELECT * FROM baseRate")
    fun query(): LiveData<List<BaseRate>>
}