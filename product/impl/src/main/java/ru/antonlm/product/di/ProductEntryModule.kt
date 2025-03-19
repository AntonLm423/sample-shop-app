package ru.antonlm.product.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.antonlm.common.di.FeatureEntry
import ru.antonlm.common.di.FeatureEntryKey
import ru.antonlm.product.ProductEntry
import ru.antonlm.product.ProductEntryImpl
import javax.inject.Singleton

@Module
interface ProductEntryModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(ProductEntry::class)
    fun productEntry(entry: ProductEntryImpl): FeatureEntry
}