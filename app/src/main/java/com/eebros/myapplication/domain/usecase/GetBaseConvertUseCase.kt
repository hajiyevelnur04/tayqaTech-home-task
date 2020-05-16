package com.eebros.myapplication.domain.usecase

import com.eebros.myapplication.domain.data.ExchangeRepositoryType
import javax.inject.Inject

class GetBaseConvertUseCase @Inject constructor(private val exchangeRepositoryType: ExchangeRepositoryType){
    fun execute(base: String) = exchangeRepositoryType.getBaseConvert(base)
}
