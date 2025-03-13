package ru.antonlm.data

import androidx.compose.runtime.compositionLocalOf
import ru.antonlm.common.domain.ProductsRepository

interface DataProvider {

    val productsRepository: ProductsRepository
}

val LocalDataProvider = compositionLocalOf<DataProvider> { error("No data provider found!") }