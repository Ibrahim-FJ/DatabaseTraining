package com.example.databasetraining.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertStudent(student: Student)

    @Update
    suspend fun updateStudent(student: Student)



    @Query("SELECT * FROM student ORDER BY id Asc")
    fun getAllStudent(): Flow<List<Student>>


    @Query("SELECT * FROM student WHERE id = :id")
    fun getStudent(id: Int): Flow<Student>

    @Query("DELETE FROM student WHERE id = :id")
     fun deleteStudent(id: Int)

}