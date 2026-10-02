package com.example.fashionecommerceapp.uiscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.fashionecommerceapp.data.CartProduct
import com.example.fashionecommerceapp.ui.theme.Violet
import com.example.fashionecommerceapp.viewmodel.CartViewModel

import com.example.fashionecommerceapp.data.ProductData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(category: String, cartViewModel: CartViewModel, navController: NavController) {

    val products = if (category == "All") {
        ProductData.products
    } else {
        ProductData.products.filter { it.productCategory == category }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(text = if (category == "All") "All Products" else category) },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Violet,
                titleContentColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
        )

        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(products) { productItem ->

                ProductItem(product = productItem) {

                    cartViewModel.addToCart(
                        CartProduct(cartProduct = productItem, initialQuantity = 1)
                    )
                }
            }
        }
    }
}