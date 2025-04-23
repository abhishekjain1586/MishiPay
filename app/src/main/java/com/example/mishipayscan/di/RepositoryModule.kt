package com.example.mishipayscan.di

import com.example.mishipayscan.data.repository.CartRepositoryImpl
import com.example.mishipayscan.domain.repository.ICartRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindsCartRepository(
        cartRepositoryImpl: CartRepositoryImpl
    ): ICartRepository
}