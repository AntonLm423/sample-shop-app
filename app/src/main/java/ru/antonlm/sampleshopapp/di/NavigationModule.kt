package ru.antonlm.sampleshopapp.di

import dagger.Module
import ru.antonlm.catalog.di.CatalogEntryModule
import ru.antonlm.product.di.ProductEntryModule

@Module(
    includes = [
        CatalogEntryModule::class,
        ProductEntryModule::class
    ]
)
interface NavigationModule
