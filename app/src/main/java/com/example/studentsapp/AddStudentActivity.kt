package com.example.studentsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AddStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_student)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val saveButton: Button = findViewById(R.id.add_student_activity_save_button)
        val cancelButton: Button = findViewById(R.id.add_student_activity_cancel_button)

        val name: EditText = findViewById(R.id.add_student_activity_name_edit_text)
        val id: EditText = findViewById(R.id.add_student_activity_id_edit_text)
        val phone: EditText = findViewById(R.id.add_student_activity_phone_edit_text)
        val address: EditText = findViewById(R.id.add_student_activity_address_edit_text)
        val checkbox = findViewById<CheckBox>(R.id.edit_student_checkbox)

        checkbox.isChecked = false

        cancelButton.setOnClickListener {
            val intent = Intent(this, StudentsRecyclerViewActivity::class.java)
            startActivity(intent)
        }


        saveButton.setOnClickListener {
            val student: Student = Student(name.text.toString(), id.text.toString(), "", phone.text.toString(), address.text.toString(), checkbox.isChecked)
            Model.shared.students.add(student)
            val intent = Intent(this, StudentsRecyclerViewActivity::class.java)
            startActivity(intent)
        }
    }
}