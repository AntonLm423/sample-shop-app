package ru.antonlm.product.di

import dagger.Component
import ru.antonlm.common.di.CommonProvider
import ru.antonlm.common.di.FeatureScoped
import ru.antonlm.data.DataProvider
import ru.antonlm.product.ProductProvider
import ru.antonlm.product.ui.ProductViewModel

@FeatureScoped
@Component(
    dependencies = [DataProvider::class, CommonProvider::class],
    modules = [ProductEntryModule::class]
)
interface ProductComponent : ProductProvider {

    val viewModel: ProductViewModel
}