package ru.antonlm.sampleshopapp.di

import dagger.Module
import ru.antonlm.catalog.di.CatalogEntryModule

@Module(
    includes = [
        CatalogEntryModule::class
    ]
)
interface NavigationModule
