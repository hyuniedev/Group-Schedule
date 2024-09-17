package com.example.groupschedule.ui.scene

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class LoginScene {
    @Composable
    fun LoginScreen1(){
        var phone = remember {mutableStateOf("")}
        Box(modifier = Modifier.fillMaxSize()){
            OutlinedTextField(value = phone.value, onValueChange = {newText -> phone.value = newText}, label = { Text(
                text = "Number phone"
            )}, modifier = Modifier.align(alignment = Alignment.Center))
        }
    }
}