package eu.tutorials.mywishlistapp

sealed class Screen(val route:String) {
    object LoginScreen: Screen("login_screen")
    object HomeScreen: Screen("home_screen")
    object AddScreen: Screen("add_screen")
}