package ru.antonlm.catalog.di

import dagger.Component
import ru.antonlm.catalog.CatalogProvider
import ru.antonlm.catalog.ui.CatalogViewModel
import ru.antonlm.common.di.CommonProvider
import ru.antonlm.common.di.FeatureScoped
import ru.antonlm.data.DataProvider

@FeatureScoped
@Component(
    dependencies = [DataProvider::class, CommonProvider::class],
    modules = [CatalogEntryModule::class]
)
interface CatalogComponent : CatalogProvider {

    val viewModel: CatalogViewModel
}
