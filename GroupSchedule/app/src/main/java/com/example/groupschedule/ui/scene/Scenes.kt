package com.example.groupschedule.ui.scene

sealed class Scenes(var title: String) {
    data object Home : Scenes("Home")
    data object MySchedule : Scenes("My Schedule")
    data object Search : Scenes("Search")
    data object Setting : Scenes("Setting")
}