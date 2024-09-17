package com.example.groupschedule.entity

import java.util.Calendar

class User (var name: String, var numberPhone: String, var dob: Calendar, var password: String){
    lateinit var id: String
}