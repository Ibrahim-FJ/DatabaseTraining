package com.example.databasetraining.viewmodels

import androidx.lifecycle.*
import com.example.databasetraining.data.StudentRepository
import com.example.databasetraining.data.StudentUiState
import com.example.databasetraining.database.Student
import com.example.databasetraining.database.StudentDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StudentViewModel @Inject constructor(private val repository: StudentRepository) : ViewModel() {
    val allStudents: LiveData<List<Student>> = repository.getAllItems().asLiveData()


    private fun insertStudent(newStudent: Student) {
        viewModelScope.launch {
           repository.insertItem(newStudent)
        }
    }


    // from activity
    fun addNewStudent(studentNamed: String, studentAged: Int) {
        insertStudent(Student(studentName = studentNamed, studentAge = studentAged))
    }


    fun delete(id: Int){
        viewModelScope.launch {
            repository.delete(id)

        }
    }


    fun retrieve(id: Int): LiveData<Student>{

       return repository.retrieve(id)
    }






}
