package com.example.fashionecommerceapp.uiscreen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fashionecommerceapp.R
import com.example.fashionecommerceapp.data.CartProduct
import com.example.fashionecommerceapp.data.Product
import com.example.fashionecommerceapp.ui.theme.Violet
import com.example.fashionecommerceapp.viewmodel.CartViewModel
import com.example.fashionecommerceapp.data.ProductData
import kotlinx.coroutines.delay

@Composable
fun HomeScreen(
    navController: NavController,
    cartViewModel: CartViewModel,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        item {
            HomeHeader(navController)
        }
        item {
            OfferBanners()
        }
        item {
            SectionTitleText(title = "Category")
        }
        item {
            CategoryGridSection(navController)
        }
        item {
            SectionTitleText(title = "Best Selling")
        }
        item {
            BestSellingProducts(cartViewModel)
        }
    }
}

@Composable
fun HomeHeader(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Violet)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "NTTI010B1",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = null,
                tint = Color.White
            )
        }

        Spacer(Modifier.height(12.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { focusState ->
                    if (focusState.isFocused) {
                        navController.navigate("product/All")
                    }
                },
            readOnly = true,
            placeholder = { Text("Search Product", color = Color.LightGray) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "search",
                    tint = Color.LightGray
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
            shape = RoundedCornerShape(14.dp)
        )
    }
}

@Composable
fun OfferBanners() {
    val images = listOf(
        R.drawable.sale1,
        R.drawable.sale2,
        R.drawable.sale3
    )
    var index by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(3000)
            index = (index + 1) % images.size
        }
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Special Offer", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(6.dp)
        ) {
            Image(
                painter = painterResource(id = images[index]),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            images.forEachIndexed { i, _ ->
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(if (i == index) 12.dp else 8.dp)
                        .clip(CircleShape)
                        .background(if (i == index) Violet else Color.LightGray)
                )
            }
        }
    }
}

@Composable
fun SectionTitleText(title: String) {
    Text(
        text = title,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
    )
}

@Composable
fun CategoryGridSection(navController: NavController) {
    val categories = ProductData.categories

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.height(240.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(categories) { categoryItem ->
            CategoryGrid(productCategory = categoryItem) {
                navController.navigate("product/${categoryItem.categoryName}")
            }
        }
    }
}

@Composable
fun BestSellingItem(
    product: Product,
    onAddToCart: () -> Unit
) {
    val context = LocalContext.current
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Violet)
    ) {
        Column {
            Box {
                Image(
                    painter = painterResource(id = product.productImage),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp),
                    contentScale = ContentScale.Crop
                )
                IconButton(
                    onClick = {
                        onAddToCart()
                        Toast.makeText(context, "Added to Cart", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                        .background(Violet, CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
            Column(Modifier.padding(8.dp)) {
                Text(
                    text = product.productName,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
                Text(text = "$${product.productPrice}", color = Color.White)
            }
        }
    }
}

@Composable
fun BestSellingProducts(cartViewModel: CartViewModel) {
    val products = ProductData.products.take(4)
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        modifier = Modifier.height(420.dp)
    ) {
        items(products) { product ->
            BestSellingItem(product = product) {

                cartViewModel.addToCart(CartProduct(cartProduct = product, initialQuantity = 1))
            }
        }
    }
}