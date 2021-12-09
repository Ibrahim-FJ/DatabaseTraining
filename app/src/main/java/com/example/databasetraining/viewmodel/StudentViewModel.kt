package com.example.databasetraining.viewmodel

import androidx.lifecycle.*
import com.example.databasetraining.database.Student
import com.example.databasetraining.database.StudentDao
import kotlinx.coroutines.launch

class StudentViewModel(private val studentDao: StudentDao): ViewModel() {



   private fun insertStudent(newStudent: Student){
            viewModelScope.launch {
                studentDao.insert(newStudent)
            }
    }


    // from activity
    fun addNewStudent(studentNamed: String, studentAged: Int){
        insertStudent(Student(studentName = studentNamed, studentAge = studentAged))
    }



}




class StudentViewModelFactory(private val studentDao: StudentDao): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(StudentViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return StudentViewModel(studentDao) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }


}