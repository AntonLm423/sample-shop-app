package ru.antonlm.catalog

import ru.antonlm.common.di.ComposableFeatureEntry

abstract class CatalogEntry: ComposableFeatureEntry {

    final override val featureRoute = "catalog"
}
