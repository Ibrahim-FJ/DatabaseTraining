package com.example.databasetraining

import android.app.Application
import com.example.databasetraining.database.StudentRoomDatabase

class StudentApplication: Application() {
    val database: StudentRoomDatabase by lazy { StudentRoomDatabase.getDatabase(this) }

}