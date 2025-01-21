package com.example.studentsapp

class Model private constructor() {

    val students: MutableList<Student> = ArrayList()

    companion object {
        val shared = Model()
    }

    init {
        for (i in 0..20) {
            val student = Student(
                name = "Name $i",
                id = "Student ID: $i",
                avatarUrl = "",
                address = "Simtat Sahaf",
                phoneNumber = "0525124",
                isChecked = false
            )
            students.add(student)
        }
    }
}