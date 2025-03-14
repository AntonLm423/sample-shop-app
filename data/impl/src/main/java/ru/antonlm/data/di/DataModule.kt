package ru.antonlm.data.di

import dagger.Binds
import dagger.Module
import ru.antonlm.common.domain.ProductsRepository
import ru.antonlm.data.repository.ProductsRepositoryImpl
import javax.inject.Singleton

@Module(
    includes = [NetworkModule::class]
)
interface DataModule {

    @Binds
    @Singleton
    fun catalogRepository(impl: ProductsRepositoryImpl): ProductsRepository
}