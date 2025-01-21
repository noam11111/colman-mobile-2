package com.example.studentsapp

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class StudentsActivity : AppCompatActivity() {

    var students: MutableList<Student>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_students)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        students = Model.shared.students
        val listView: ListView = findViewById(R.id.students)
        listView.adapter = StudentsAdapter()
    }

    inner class StudentsAdapter(): BaseAdapter() {
        override fun getCount(): Int = students?.size ?: 0

        override fun getItem(position: Int) {}

        override fun getItemId(position: Int): Long {
            throw Error("Not implemented")
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val inflation = LayoutInflater.from(parent?.context)
            val view = convertView ?: inflation.inflate(
                R.layout.student_item,
                parent,
                false
            ).apply {
                findViewById<CheckBox>(R.id.student_item_check_box).apply {
                    setOnClickListener { view ->
                        (tag as? Int)?.let { tag ->
                            val student = students?.get(tag)
                            student?.isChecked = (view as? CheckBox)?.isChecked ?: false
                        }
                    }
                }
            }

            val student = students?.get(position)

            val nameTextView: TextView? = view?.findViewById(R.id.student_item_name)
            val idTextView: TextView? = view?.findViewById(R.id.student_item_id)
            val checkBox: CheckBox? = view?.findViewById(R.id.student_item_check_box)

            nameTextView?.text = student?.name
            idTextView?.text = student?.id

            checkBox?.apply {
                isChecked = student?.isChecked ?: false
                tag = position
            }
            return view!!
        }
    }
}