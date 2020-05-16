package com.eebros.myapplication.di

import android.app.Application
import com.eebros.myapplication.base.BaseApplication
import com.eebros.myapplication.di.module.*
import com.eebros.myapplication.di.module.sub.ExchangeModule
import com.eebros.myapplication.domain.TayqaSessionManager
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityOrFragmentBuildersModule::class,
        AppModule::class,
        ViewModelFactoryModule::class,
        NetworkModule::class,
        ExchangeModule::class
    ]
)
interface AppComponent : AndroidInjector<BaseApplication> {

    //session plays middle role between client and server
    fun sessionManager() : TayqaSessionManager

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}