package com.example.fashionecommerceapp.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel // ត្រូវប្រាកដថាមាន Import មួយនេះ
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState // ប្តូរការ Import មកកាន់ទីនេះវិញ
import androidx.navigation.compose.rememberNavController
import com.example.fashionecommerceapp.uiscreen.CartScreen
import com.example.fashionecommerceapp.uiscreen.HomeScreen
import com.example.fashionecommerceapp.uiscreen.LoginScreen
import com.example.fashionecommerceapp.uiscreen.OrderSuccessScreen
import com.example.fashionecommerceapp.uiscreen.PaymentScreen
import com.example.fashionecommerceapp.uiscreen.ProductListScreen
import com.example.fashionecommerceapp.uiscreen.ProfileScreen
import com.example.fashionecommerceapp.uiscreen.SearchScreen
import com.example.fashionecommerceapp.viewmodel.CartViewModel // Import CartViewModel

@Composable
fun AppNavGraph(cartViewModel : CartViewModel) {
    val navController = rememberNavController()


    val cartViewModel: CartViewModel = viewModel()

    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute != "login") {
                ButtonBarNavigation(navController)
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            NavHost(
                navController, startDestination = "login"
            ) {
                composable("login") {
                    LoginScreen(navController = navController)
                }
                composable("home") {

                    HomeScreen(navController=navController,
                        cartViewModel=cartViewModel)
                }
                composable ("product/{category}"){
                    ProductListScreen(
                        category = it.arguments?.getString("category")!!,
                        cartViewModel = cartViewModel,
                        navController = navController
                    )
                }
                composable("search") {
                    SearchScreen(cartViewModel=cartViewModel)
                }
                composable("payment") {
                    PaymentScreen(navController)
                }
                composable("success") {
                    OrderSuccessScreen(navController, cartViewModel)
                }
                composable("cart") {

                    CartScreen(
                        navController = navController,
                        cartViewModel = cartViewModel
                    )
                }
                composable("profile") {
                    ProfileScreen(navController = navController)
                }
            }
        }
    }
}

@Composable
fun ButtonBarNavigation(navController: NavController) {
    val items = listOf(
        ButtonNavItem.Home,
        ButtonNavItem.Search,
        ButtonNavItem.Cart,
        ButtonNavItem.Profile,
    )

    NavigationBar(
        modifier = Modifier.background(
            Brush.verticalGradient(
                colors = listOf(
                    Color(0xff6a1b9a),
                    Color(0xff8e24aa),
                )
            )
        ),
        containerColor = Color.Transparent,
        tonalElevation = 6.dp
    ) {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

        items.forEach { item ->
            val selected = currentRoute == item.route

            NavigationBarItem(
                selected = selected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = "Icon",
                        tint = Color.White
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.White.copy(alpha = 0.18f)
                )
            )
        }
    }
}