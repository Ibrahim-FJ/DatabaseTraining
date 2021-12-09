package com.example.databasetraining.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(student: Student)


    @Query("SELECT * FROM student ORDER BY id Asc")
    fun getAllStudent(): Flow<List<Student>>

}