package com.example.databasetraining.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.databasetraining.database.Student
import com.example.databasetraining.database.StudentDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StudentRepository @Inject constructor (private val studentDao: StudentDao) {


    suspend fun insertItem(student: Student) {
        studentDao.insertStudent(student)
    }


    fun getAllItems(): Flow<List<Student>> {
        return studentDao.getAllStudent()
    }


   suspend fun delete(id: Int){

        studentDao.deleteStudent(id)

    }

    fun retrieve(id: Int): LiveData<Student>{
        return studentDao.getStudent(id).asLiveData()
    }

}