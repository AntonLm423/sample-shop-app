package ru.antonlm.catalog.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.antonlm.common.domain.Product
import ru.antonlm.common.ui.ProductCard

@Composable
internal fun SuccessState(products: List<Product>, onProductClick: (productId: Int) -> Unit) {
    val productRows = remember(products) {
        products.chunked(2).map { chunk ->
            ProductRowData(firstItem = chunk.first(), secondItem = chunk.getOrNull(1))
        }
    }

    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(
            items = productRows,
            key = { it.id },
            contentType = { "product_row" }
        ) { productRowData ->
            ProductRow(data = productRowData, onProductClick = onProductClick)
        }
    }
}

@Composable
private fun ProductRow(data: ProductRowData, onProductClick: (productId: Int) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
    ) {
        ProductCard(
            product = data.firstItem,
            onProductClick = onProductClick,
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        )

        Spacer(modifier = Modifier.width(4.dp))

        if (data.secondItem != null) {
            ProductCard(
                product = data.secondItem,
                onProductClick = onProductClick,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            )
        }
    }
}


@Immutable
private class ProductRowData(val firstItem: Product, val secondItem: Product?) {
    val id: Int = firstItem.id + (secondItem?.id ?: 0)
}
