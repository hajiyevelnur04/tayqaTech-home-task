package com.eebros.myapplication

import android.app.Application
import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class AppModule {
    @Provides
    fun providesContext(app: Application) = app.applicationContext

    @Provides
    fun provideResources(app: Application): Resources = app.resources

    @Provides
    fun provideActivity(): BaseActivity = BaseActivity()

    @Provides
    @Reusable
    fun provideSharedPreferences(context: Context)= context.getSharedPreferences("tayqa.az", Context.MODE_PRIVATE)
}