package com.example.groupschedule.ui.scene

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.compose.foundation.layout.Box as Box

@Composable
fun LoginScreen(onStep: Int, navController: NavController) {
    val phone = remember { mutableStateOf("") }
    val isLoading = remember {
        mutableStateOf(false)
    }
    val coroutineScope = rememberCoroutineScope()
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 30.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.8f)
                    .padding(top = 30.dp)
            ) {
                NumberStep(1, onStep==1)
                NumberStep(2, onStep==2)
                NumberStep(3, onStep==3)
            }
            Spacer(modifier = Modifier.weight(0.5f))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = when(onStep){
                        1 -> "Login"
                        2 -> "OTP Verification"
                        else -> ""
                    },
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = when(onStep){
                        1 -> "Please enter your phone, we will send OTP to your phone by SMS."
                        2 -> "Please enter the OTP sent to your phone."
                        else -> ""
                    },
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(25.dp))
                Box {
                    OutlinedTextField(
                        value = phone.value,
                        onValueChange = { newText -> phone.value = newText },
                        label = {
                            Text(
                                text = when(onStep){
                                    1 -> "Number phone"
                                    2 -> "OTP Code"
                                    else -> ""
                                }
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
                Spacer(modifier = Modifier.height(25.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth(fraction = 0.18f)
                        .aspectRatio(1f)
                        .clip(shape = RoundedCornerShape(10.dp))
                        .border(
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .clickable(enabled = true) {
                            coroutineScope.launch {
                                isLoading.value = true
                                delay(3000)
                                navController.navigate("login/${onStep + 1}")
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.PlayArrow,
                        contentDescription = "Next Step",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(6.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
            Spacer(modifier = Modifier.weight(0.5f))
            if (isLoading.value)
                Progress()
            else
                Text(text = "")
        }
    }
}

@Composable
fun Progress(){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircularProgressIndicator(modifier = Modifier
            .width(22.dp)
            .aspectRatio(1f), color = MaterialTheme.colorScheme.secondary)
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = "Loading", fontSize = 18.sp, color = MaterialTheme.colorScheme.secondary)
    }
}

@Composable
private fun NumberStep(num: Int, onStep: Boolean) {
    Box(
        modifier = Modifier
            .size(28.dp)
            .clip(shape = CircleShape)
            .border(2.dp, color = MaterialTheme.colorScheme.primary, shape = CircleShape)
            .background(color = if (onStep) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onPrimary),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = num.toString(),
            fontWeight = FontWeight.Bold,
            color = if (onStep) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.secondary
        )
    }
}