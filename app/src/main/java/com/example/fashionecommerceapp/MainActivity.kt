package com.example.fashionecommerceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fashionecommerceapp.navigation.AppNavGraph
import com.example.fashionecommerceapp.ui.theme.FashionEcommerceAppTheme
import com.example.fashionecommerceapp.viewmodel.CartViewModel





class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FashionEcommerceAppTheme {
                val cartViewModel: CartViewModel = viewModel()
                AppNavGraph(cartViewModel)
            }
        }
    }
}

