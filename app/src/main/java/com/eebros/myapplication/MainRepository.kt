package com.eebros.myapplication

import io.reactivex.Single
import javax.inject.Inject

interface MainRepositoryType {
    fun getCampaignById(campaignId: Long): Single<Test>
    }

class MainRepository @Inject constructor(
    private val serviceProvider: MainApiServiceProvider
) : MainRepositoryType {

    override fun getCampaignById(campaignId: Long)=
        serviceProvider.getInstance().getCampaignById(campaignId)

}
