package com.example.databasetraining.viewmodels

import androidx.lifecycle.*
import com.example.databasetraining.database.Student
import com.example.databasetraining.database.StudentDao
import kotlinx.coroutines.launch

class StudentViewModel(private val studentDao: StudentDao) : ViewModel() {
    val allStudents: LiveData<List<Student>> = studentDao.getAllStudent().asLiveData()


    private fun insertStudent(newStudent: Student) {
        viewModelScope.launch {
            studentDao.insertStudent(newStudent)
        }
    }


    private fun updateStudent(student: Student) {
        viewModelScope.launch {
            studentDao.updateStudent(student)
        }
    }


    // from activity
    fun addNewStudent(studentNamed: String, studentAged: Int) {
        insertStudent(Student(studentName = studentNamed, studentAge = studentAged))
    }

    fun updateStudent(id: Int, studentName: String, studentAge: Int) {
        updateStudent(Student(id = id, studentName = studentName, studentAge = studentAge))
    }

    fun retrieveStudent(id: Int): LiveData<Student> {
        return studentDao.getStudent(id).asLiveData()
    }

    private fun deleteStudent(){
        viewModelScope.launch {

        }
    }

    fun deleteStudent(id: Int){
        studentDao.deleteStudent(id)
//        viewModelScope.launch {
//
//        }
    }

}


class StudentViewModelFactory(private val studentDao: StudentDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StudentViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return StudentViewModel(studentDao) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }


}