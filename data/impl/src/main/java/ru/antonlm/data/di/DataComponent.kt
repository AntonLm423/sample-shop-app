package ru.antonlm.data.di

import dagger.Component
import ru.antonlm.common.di.CommonProvider
import ru.antonlm.data.DataProvider
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [CommonProvider::class],
    modules = [DataModule::class]
)
interface DataComponent: DataProvider