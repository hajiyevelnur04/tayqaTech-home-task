package com.eebros.myapplication

import dagger.android.support.DaggerFragment
import io.reactivex.disposables.CompositeDisposable

open class BaseFragment : DaggerFragment(){
    protected val subscriptions = CompositeDisposable()
}