package com.jgeron.dynamicrecyclerviewmenu.di

import com.jgeron.dynamicrecyclerviewmenu.data.datagenerator.DataGenerator
import com.jgeron.dynamicrecyclerviewmenu.data.datagenerator.UserGenerator
import com.jgeron.dynamicrecyclerviewmenu.domain.model.User
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GeneratorModule {

    @Provides
    @Singleton
    fun provideDataGenerator(): DataGenerator<User> = UserGenerator()
}