package com.example.databasetraining.di

import android.content.Context
import com.example.databasetraining.database.StudentDao
import com.example.databasetraining.database.StudentRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): StudentRoomDatabase {
        return StudentRoomDatabase.getDatabase(context)
    }

    @Provides
    fun provideStudentDao(appDatabase: StudentRoomDatabase): StudentDao {
        return appDatabase.studentDao()
    }
}