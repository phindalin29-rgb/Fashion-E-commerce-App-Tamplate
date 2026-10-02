package com.example.fashionecommerceapp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.fashionecommerceapp.data.CartProduct

class CartViewModel : ViewModel() {

    val cartProduct = mutableStateListOf<CartProduct>()

    fun addToCart(product : CartProduct) {

        val item = cartProduct.find { it.cartProduct.productID == product.cartProduct.productID }
        if (item != null) {

            item.quantity++
        } else {

            cartProduct.add(product)
        }
    }

    fun increase(item: CartProduct) {
        item.quantity++
    }

    fun decrease(item: CartProduct) {
        if (item.quantity > 1) {
            item.quantity--
        } else {
            cartProduct.remove(item)
        }
    }

    fun clearCart() {
        cartProduct.clear()
    }
}