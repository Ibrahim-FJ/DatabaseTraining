package com.example.databasetraining.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.databasetraining.R
import com.example.databasetraining.StudentApplication
import com.example.databasetraining.databinding.FragmentDetailsBinding
import com.example.databasetraining.viewmodels.StudentViewModel
import com.example.databasetraining.viewmodels.StudentViewModelFactory


class DetailsFragment : Fragment() {
    private var binding: FragmentDetailsBinding? = null
    private val studentViewModel: StudentViewModel by activityViewModels{
        StudentViewModelFactory((activity?.application as StudentApplication).database.studentDao())
    }
    private val navigationArguments: DetailsFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        studentViewModel.retrieveStudent(navigationArguments.studentId).observe(viewLifecycleOwner,{
           bind(it.studentName, it.studentAge)
        })

        binding?.deleteActionFragmentDetails?.setOnClickListener {
            deleteStudent(navigationArguments.studentId)
        }

    }

    private fun bind(studentName: String, studentAge: Int){
        binding?.apply {
            studentNameFragmentDetails.text = studentName
            studentAgeFragmentDetails.text = studentAge.toString()
            deleteActionFragmentDetails.setOnClickListener {
                deleteStudent(navigationArguments.studentId)
                findNavController().navigateUp()
            }

            editActionFragmentDetails.setOnClickListener {
                findNavController().navigate(R.id.action_detailsFragment_to_addStudentFragment)
            }

        }

    }

    private fun deleteStudent(id: Int){
        studentViewModel.deleteStudent(id)
    }


}