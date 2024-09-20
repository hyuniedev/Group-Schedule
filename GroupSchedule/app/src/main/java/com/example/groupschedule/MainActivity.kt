package com.example.groupschedule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.groupschedule.ui.scene.LoginScene
import com.example.groupschedule.ui.theme.GroupScheduleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GroupScheduleTheme {
                Surface {
                    MainLayout()
                }
            }
        }
    }
}

@Composable
fun MainLayout(){
    LoginScene().LoginScreen("Login","Please enter your phone, we will send OTP to your phone by SMS.")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GroupScheduleTheme {
        MainLayout()
    }
}