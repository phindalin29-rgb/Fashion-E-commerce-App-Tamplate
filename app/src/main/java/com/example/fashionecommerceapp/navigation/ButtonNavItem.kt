package com.example.fashionecommerceapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ButtonNavItem(
    val route: String,
    val icon: ImageVector
) {
    object Home : ButtonNavItem("home", Icons.Default.Home)
    object Search : ButtonNavItem("search", Icons.Default.Search)
    object Cart : ButtonNavItem("cart", Icons.Default.ShoppingCart)
    object Profile : ButtonNavItem("profile", Icons.Default.Person)
}