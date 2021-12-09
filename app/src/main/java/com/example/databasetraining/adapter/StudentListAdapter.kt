package com.example.databasetraining.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.databasetraining.database.Student
import com.example.databasetraining.databinding.ListStudentItemBinding

class StudentListAdapter: ListAdapter<Student, StudentListAdapter.StudentListViewHolder>(DiffCallback) {


    class StudentListViewHolder(private var binding: ListStudentItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(student: Student){
            binding.apply {
                name.text = student.studentName
                age.text = student.studentAge.toString()

            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentListViewHolder {
        return StudentListViewHolder(ListStudentItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: StudentListViewHolder, position: Int) {
        val currentStudent = getItem(position)
        holder.bind(currentStudent)
    }


    companion object{
        private val DiffCallback = object : DiffUtil.ItemCallback<Student>(){
            override fun areItemsTheSame(oldItem: Student, newItem: Student): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Student, newItem: Student): Boolean {
                return oldItem.studentName == newItem.studentName
            }


        }
    }


}