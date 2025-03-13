package ru.antonlm.sampleshopapp.di

import androidx.compose.runtime.compositionLocalOf
import ru.antonlm.common.di.CommonProvider
import ru.antonlm.common.di.Destinations
import ru.antonlm.data.DataProvider

interface AppProvider: CommonProvider, DataProvider {

    val destinations: Destinations
}

val LocalAppProvider = compositionLocalOf<AppProvider> { error("No app provider found!") }