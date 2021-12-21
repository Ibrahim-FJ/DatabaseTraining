package com.example.databasetraining.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.databasetraining.R
import com.example.databasetraining.databinding.FragmentAddStudentBinding
import com.example.databasetraining.viewmodels.StudentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddStudentFragment : Fragment() {
    private var binding: FragmentAddStudentBinding? = null
    private val studentViewModel: StudentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddStudentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.saveActionFragmentAddStudent?.setOnClickListener {
            studentViewModel.addNewStudent(
                binding?.studentNameFragmentAddStudent?.text.toString(),
                Integer.parseInt(binding?.studentAgeFragmentAddStudent?.text.toString())
            )

    //        studentViewModel.updateStudent(1,  "Heldddlo", 32)

            findNavController().navigate(R.id.action_addStudentFragment_to_listStudentFragment)

        }


    }
}