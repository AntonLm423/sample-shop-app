package ru.antonlm.sampleshopapp

import android.app.Application
import ru.antonlm.common.di.DaggerCommonComponent
import ru.antonlm.data.di.DaggerDataComponent
import ru.antonlm.sampleshopapp.di.AppProvider
import ru.antonlm.sampleshopapp.di.DaggerAppComponent

class SampleShopApp : Application() {

    lateinit var appProvider: AppProvider
        private set

    override fun onCreate() {
        super.onCreate()

        val commonProvider = DaggerCommonComponent.factory().create(this)
        appProvider = DaggerAppComponent.builder()
            .commonProvider(commonProvider)
            .dataProvider(DaggerDataComponent.builder().commonProvider(commonProvider).build())
            .build()
    }
}

val Application.appProvider: AppProvider
    get() = (this as SampleShopApp).appProvider