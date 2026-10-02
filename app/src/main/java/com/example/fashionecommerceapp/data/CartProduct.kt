package com.example.fashionecommerceapp.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class CartProduct(
    val cartProduct : Product,
    val initialQuantity : Int
){
    var quantity by mutableStateOf(initialQuantity)
}
