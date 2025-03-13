package ru.antonlm.data

import androidx.compose.runtime.compositionLocalOf

interface DataProvider {
}

val LocalDataProvider = compositionLocalOf<DataProvider> { error("No data provider found!") }