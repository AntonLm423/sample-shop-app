package ru.antonlm.product

import androidx.navigation.NavType
import androidx.navigation.navArgument
import ru.antonlm.common.di.ComposableFeatureEntry

abstract class ProductEntry: ComposableFeatureEntry {

    final override val featureRoute = "product/{$ARG_PRODUCT_ID}\""

    final override val arguments = listOf(
        navArgument(ARG_PRODUCT_ID) {
            type = NavType.IntType
        }
    )

    fun destination(productId: Int): String =
        "product/$productId"

    protected companion object {
        const val ARG_PRODUCT_ID = "product_id"
    }
}
