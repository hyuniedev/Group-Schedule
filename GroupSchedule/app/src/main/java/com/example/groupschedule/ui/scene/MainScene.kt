package com.example.groupschedule.ui.scene

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

data class ItemNav(
    val title: String,
    val iconSelected: ImageVector,
    val iconUnselected: ImageVector
)

private val itemsNav = listOf(
    ItemNav(Scenes.Home.title, Icons.Filled.Home, Icons.Outlined.Home),
    ItemNav(Scenes.MySchedule.title, Icons.Filled.DateRange, Icons.Outlined.DateRange),
    ItemNav(Scenes.Search.title, Icons.Filled.Search, Icons.Outlined.Search),
    ItemNav(Scenes.Setting.title, Icons.Filled.Settings, Icons.Outlined.Settings),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScene() {
    val itemSelected = rememberSaveable {
        mutableIntStateOf(0)
    }
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Group Scheme") }) },
        bottomBar = {
            NavigationBar(containerColor = MaterialTheme.colorScheme.primary) {
                itemsNav.forEachIndexed { index, itemNav ->
                    NavigationBarItem(
                        selected = itemSelected.intValue == index,
                        onClick = { itemSelected.intValue = index },
                        icon = {
                            Icon(
                                imageVector = if (itemSelected.intValue == index) itemNav.iconSelected else itemNav.iconUnselected,
                                contentDescription = itemNav.title,
                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        },
                        label = {
                            Text(
                                text = itemNav.title,
                                style = TextStyle(color = MaterialTheme.colorScheme.onPrimary)
                            )
                        },
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Scenes.Home.title,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Scenes.Home.title) {

            }
            composable(Scenes.MySchedule.title) {

            }
            composable(Scenes.Search.title) {

            }
            composable(Scenes.Setting.title) {

            }
        }
    }
}
