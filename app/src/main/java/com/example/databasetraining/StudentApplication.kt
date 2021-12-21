package com.example.databasetraining

import android.app.Application
import com.example.databasetraining.database.StudentRoomDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp

class StudentApplication: Application(){
    val database: StudentRoomDatabase by lazy { StudentRoomDatabase.getDatabase(this) }

}