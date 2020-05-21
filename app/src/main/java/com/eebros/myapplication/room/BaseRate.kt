package com.eebros.myapplication.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity
data class BaseRate(
    @PrimaryKey
    val code: String,
    val alphaCode: String,
    val numericCode: String,
    val name: String,
    val rate: BigDecimal,
    val date: String,
    var inverseRate: BigDecimal
)