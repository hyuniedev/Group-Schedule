package com.example.groupschedule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.groupschedule.ui.scene.LoginScreen
import com.example.groupschedule.ui.scene.MainScene
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
fun MainLayout() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login/1") {
        composable("login/{step}") { backStackEntry ->
            val step = backStackEntry.arguments?.getString("step")!!.toInt()
            LoginScreen(
                step,
                navController
            )
        }
        composable("mainScene") {
            MainScene()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GroupScheduleTheme {
        MainLayout()
    }
}