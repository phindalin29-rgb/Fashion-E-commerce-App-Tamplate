package com.example.fashionecommerceapp.uiscreen

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fashionecommerceapp.data.CartProduct
import com.example.fashionecommerceapp.viewmodel.CartViewModel
import com.example.fashionecommerceapp.data.ProductData

@Composable
fun SearchScreen(cartViewModel: CartViewModel) {
    var query by remember { mutableStateOf("") }
    val result = ProductData.products.filter {
        it.productName.contains(query, true)
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shadowElevation = 6.dp,
            tonalElevation = 6.dp,
            shape = RoundedCornerShape(14.dp),
            color = Color.White
        ) {
            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Search Product") },
                leadingIcon = {
                    Icon(Icons.Default.Search, contentDescription = "Search")
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    focusedTrailingIconColor = Color.Transparent,
                    unfocusedTrailingIconColor = Color.Transparent,
                    focusedTextColor = Color.Black
                ),
                shape = RoundedCornerShape(14.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(result) { product ->
                ProductItem(product) {

                    cartViewModel.addToCart(
                        CartProduct(cartProduct = product, initialQuantity = 1)
                    )
                }
            }
        }
    }
}