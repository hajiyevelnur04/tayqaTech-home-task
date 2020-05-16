package com.eebros.myapplication.ui.fragment

import com.eebros.myapplication.base.BaseViewModel
import com.eebros.myapplication.base.BaseViewModelInputs
import com.eebros.myapplication.base.BaseViewModelOutputs
import com.eebros.myapplication.data.remote.GetBaseConvertResponse
import com.eebros.myapplication.domain.usecase.GetBaseConvertUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

interface CashConvertFragmentInputs: BaseViewModelInputs{
    fun getBaseConvert(base: String)
}

interface CashConvertFragmentOutputs: BaseViewModelOutputs{
    fun onBaseConvertSuccess(): PublishSubject<ArrayList<GetBaseConvertResponse>>
}

class CashConvertFragmentViewModel @Inject constructor(
    private val getBaseConvertUseCase: GetBaseConvertUseCase
): BaseViewModel(), CashConvertFragmentInputs,CashConvertFragmentOutputs{

    override val inputs: CashConvertFragmentInputs = this
    override val outputs: CashConvertFragmentOutputs = this

    private val getBaseConvert = PublishSubject.create<ArrayList<GetBaseConvertResponse>>()
    override fun getBaseConvert(base: String) {
        getBaseConvertUseCase.execute(base)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (it.size > 0) {
                    getBaseConvert.onNext(it)
                } else {
                    //some server error code
                    error.onNext(1)
                }
            },{
                error.onNext(1992)
                it.printStackTrace()
            })
    }

    override fun onBaseConvertSuccess() = getBaseConvert

}
