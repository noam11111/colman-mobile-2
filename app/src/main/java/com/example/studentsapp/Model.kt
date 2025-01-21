package com.example.studentsapp

class Model private constructor() {

    val students: MutableList<Student> = ArrayList()

    companion object {
        val shared = Model()
    }

    init {
        for (i in 0..10) {
            val student = Student(
                name = "noam$i",
                id = "$i",
                avatarUrl = "",
                address = "Maanit Maanit",
                phoneNumber = "0532668951",
                isChecked = false
            )
            students.add(student)
        }
    }
}