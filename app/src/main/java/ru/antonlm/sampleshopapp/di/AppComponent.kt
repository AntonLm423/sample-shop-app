package ru.antonlm.sampleshopapp.di

import dagger.Component
import ru.antonlm.common.di.CommonProvider
import ru.antonlm.data.DataProvider
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        CommonProvider::class,
        DataProvider::class,
    ],
    modules = [NavigationModule::class]
)
interface AppComponent : AppProvider