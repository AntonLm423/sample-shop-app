package ru.antonlm.catalog.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.antonlm.catalog.CatalogEntry
import ru.antonlm.catalog.CatalogEntryImpl
import ru.antonlm.common.di.FeatureEntry
import ru.antonlm.common.di.FeatureEntryKey
import javax.inject.Singleton

@Module
interface CatalogEntryModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(CatalogEntry::class)
    fun catalogEntry(entry: CatalogEntryImpl): FeatureEntry
}