package ru.antonlm.common.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import ru.antonlm.common.R
import ru.antonlm.common.domain.Product


@Composable
fun ProductCard(product: Product, onProductClick: (productId: Int) -> Unit, modifier: Modifier = Modifier) {

    val price = product.price?.toString()?.let { notNullPrice -> stringResource(R.string.common_price_in_rubbles, notNullPrice) }
    val shape = RoundedCornerShape(8.dp)
    val placeholderPainter = painterResource(R.drawable.ic_placeholder_default)

    Column(
        modifier = modifier
            .shadow(elevation = 4.dp, shape = shape)
            .clickable(
                indication = ripple(bounded = true),
                interactionSource = remember { MutableInteractionSource() },
                onClick = { onProductClick.invoke(product.id) })
            .background(color = Color.White)
            .clip(shape)
            .padding(16.dp),
    ) {
        if (!product.category.isNullOrBlank()) {
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.tertiary, RoundedCornerShape(8.dp))
                    .padding(vertical = 2.dp, horizontal = 6.dp)
            ) {
                Text(
                    text = product.category,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onTertiary
                )
            }
        }

        AsyncImage(
            model = product.image,
            contentDescription = stringResource(R.string.common_product_image_cont_desc),
            placeholder = placeholderPainter,
            error = placeholderPainter,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(shape),
        )

        if (!product.title.isNullOrBlank()) {
            Text(
                text = product.title,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        if (!product.description.isNullOrBlank()) {
            Text(
                text = product.description,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        if (!price.isNullOrBlank()) {
            Text(text = price, style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(top = 8.dp))
        }
    }
}

@Preview
@Composable
private fun ProductCardPreview() {
    ProductCard(product = Product.createStub(), onProductClick = {})
}
