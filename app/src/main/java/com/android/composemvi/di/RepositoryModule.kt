package com.android.composemvi.di

import com.android.composemvi.data.remote.restaurantlist.repo.RestaurantListRepoImpl
import com.android.composemvi.domain.restaurantlist.RestaurantListRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideRestaurantRepo(restaurantListRepoImpl: RestaurantListRepoImpl):
            RestaurantListRepo

}