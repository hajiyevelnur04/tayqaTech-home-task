package com.eebros.myapplication.ui.fragment

import com.eebros.myapplication.base.BaseViewModel
import com.eebros.myapplication.base.BaseViewModelInputs
import com.eebros.myapplication.base.BaseViewModelOutputs
import com.eebros.myapplication.data.remote.GetBaseConvertResponse
import com.eebros.myapplication.domain.usecase.GetBaseConvertUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit
import javax.inject.Inject

interface ConvertFragmentInputs : BaseViewModelInputs {
    fun getBaseConvert(base: String)

}

interface ConvertFragmentOutputs : BaseViewModelOutputs {
    fun onBaseConvertSuccess(): PublishSubject<ArrayList<GetBaseConvertResponse>>

}

class ConvertFragmentViewModel @Inject constructor(
    private val getBaseConvertUseCase: GetBaseConvertUseCase
) : BaseViewModel(), ConvertFragmentInputs, ConvertFragmentOutputs {

    override val inputs: ConvertFragmentInputs = this
    override val outputs: ConvertFragmentOutputs = this

    private val getBaseConvert = PublishSubject.create<ArrayList<GetBaseConvertResponse>>()
    override fun getBaseConvert(base: String) {
        //repeat every second
        getBaseConvertUseCase.execute(base)
            .repeatWhen {
                it.delay(1, TimeUnit.SECONDS)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                //best way is to add some server status code and check
                if (it.size > 0) {
                    getBaseConvert.onNext(it)
                } else {
                    //some server error code
                    error.onNext(1)
                }
            }, {
                error.onNext(1992)
                it.printStackTrace()
            })
    }

    override fun onBaseConvertSuccess() = getBaseConvert

}
