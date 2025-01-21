package com.example.studentsapp

data class Student(
    val name: String,
    val id: String,
    val avatarUrl: String,
    val phoneNumber: String,
    val address: String,
    var isChecked: Boolean
)
