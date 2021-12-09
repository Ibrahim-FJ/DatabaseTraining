package com.example.databasetraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.databasetraining.databinding.ActivityMainBinding
import com.example.databasetraining.viewmodel.StudentViewModel
import com.example.databasetraining.viewmodel.StudentViewModelFactory

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private val studentViewModel: StudentViewModel by viewModels {
        StudentViewModelFactory((application as StudentApplication).database.studentDao())
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.button?.setOnClickListener {
            studentViewModel.addNewStudent(binding?.name?.text.toString(), Integer.parseInt(binding?.age?.text.toString()))
        }

    }


}