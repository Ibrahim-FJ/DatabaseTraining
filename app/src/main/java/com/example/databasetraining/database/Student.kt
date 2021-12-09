package com.example.databasetraining.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Student(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "name")
    val studentName: String,
    @ColumnInfo(name = "age")
    val studentAge: Int
)

