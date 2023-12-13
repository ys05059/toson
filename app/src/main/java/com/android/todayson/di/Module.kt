package com.android.todayson.di

import android.content.Context
import com.android.todayson.VoiceToTextParser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {
    @Provides
    @Singleton
    fun provideVoiceToTextParser(
        @ApplicationContext context : Context
    ): VoiceToTextParser {
        return VoiceToTextParser(context)
    }
}