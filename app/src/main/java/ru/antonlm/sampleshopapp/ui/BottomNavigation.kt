package ru.antonlm.sampleshopapp.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.antonlm.catalog.CatalogEntry
import ru.antonlm.common.di.Destinations
import ru.antonlm.common.di.find
import ru.antonlm.sampleshopapp.R

@Composable
fun BottomNavigation(navController: NavController, destinations: Destinations) {
    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.padding(vertical = 4.dp)) {
        BottomNavItem(
            isSelected = true,
            icon = Icons.Outlined.Home,
            titleResId = R.string.menu_catalog,
            onClick = {
                val route = destinations.find<CatalogEntry>().featureRoute
                navController.popBackStack(route, inclusive = false)
            },
            modifier = Modifier.weight(1f)
        )
        BottomNavItem(
            isSelected = false,
            icon = Icons.Outlined.FavoriteBorder,
            titleResId = R.string.menu_favorite,
            onClick = {

            },
            modifier = Modifier.weight(1f)
        )
        BottomNavItem(
            isSelected = false,
            icon = Icons.Outlined.Person,
            titleResId = R.string.menu_profile,
            onClick = {

            },
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun BottomNavItem(
    isSelected: Boolean,
    icon: ImageVector,
    @StringRes titleResId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val title = stringResource(titleResId)
    val color = if (isSelected) Color.Black else Color.Gray

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                indication = ripple(bounded = false),
                interactionSource = remember { MutableInteractionSource() },
                onClick = { onClick.invoke() })
    ) {
        Icon(imageVector = icon, contentDescription = title, tint = color)
        Text(text = title, color = color)
    }
}
