package com.example.databasetraining

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.databasetraining.adapter.StudentListAdapter
import com.example.databasetraining.databinding.FragmentListStudentBinding
import com.example.databasetraining.viewmodel.StudentViewModel
import com.example.databasetraining.viewmodel.StudentViewModelFactory


class ListStudentFragment : Fragment() {
    private var binding: FragmentListStudentBinding? = null
    private val studentViewModel: StudentViewModel by activityViewModels {
        StudentViewModelFactory((activity?.application as StudentApplication).database.studentDao())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListStudentBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = StudentListAdapter()
        binding?.studentRecyclerView?.adapter = adapter
        studentViewModel.allStudents.observe(viewLifecycleOwner){
            it.let {
                adapter.submitList(it)
            }
        }

    }

}