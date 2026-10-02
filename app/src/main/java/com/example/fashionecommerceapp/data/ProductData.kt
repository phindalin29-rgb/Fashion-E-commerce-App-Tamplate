package com.example.fashionecommerceapp.data

import com.example.fashionecommerceapp.R


object ProductData {
    val categories = listOf(
        ProductCategory(1, "Clothing", R.drawable.clothcategory),
        ProductCategory(2, "Electronics", R.drawable.elecategory),
        ProductCategory(3, "Food", R.drawable.foodcategory),
        ProductCategory(4, "Home", R.drawable.homecategory),
        ProductCategory(5, "Beauty", R.drawable.beautycategory),
        ProductCategory(6, "Jewellery", R.drawable.jewelcategory)
    )
    val products = listOf(
        // ====== Clothing ======
        Product(1, "Sweatshirt", 100, R.drawable.cloth1, "Clothing"),
        Product(2, "Jeans", 25, R.drawable.cloth2, "Clothing"),
        Product(3, "Dress", 75, R.drawable.cloth3, "Clothing"),
        Product(4, "Jacket", 45, R.drawable.cloth4, "Clothing"),
        Product(5, "T-Shirt", 35, R.drawable.cloth5, "Clothing"),
        Product(6, "Gown", 60, R.drawable.cloth6, "Clothing"),

        // ====== Electronics ======
        Product(7, "Air Conditioner", 150, R.drawable.elec1, "Electronics"),
        Product(8, "Television", 120, R.drawable.elec2, "Electronics"),
        Product(9, "Laptop", 45, R.drawable.elec3, "Electronics"),
        Product(10, "Speakers", 35, R.drawable.elec4, "Electronics"),
        Product(11, "Headphones", 80, R.drawable.elec5, "Electronics"),
        Product(12, "Juicer", 25, R.drawable.elec6, "Electronics"),

        // ====== Food ======
        Product(13, "Burger", 12, R.drawable.food1, "Food"),
        Product(14, "Pizza", 15, R.drawable.food2, "Food"),
        Product(15, "French Fries", 10, R.drawable.food3, "Food"),
        Product(16, "Matcha Latte", 5, R.drawable.food4, "Food"),
        Product(17, "Noodles", 8, R.drawable.food5, "Food"),

        // ====== Home ======
        Product(18, "Bedsheet", 20, R.drawable.home1, "Home"),
        Product(19, "Clock", 15, R.drawable.home2, "Home"),
        Product(20, "Curtains", 30, R.drawable.home3, "Home"),
        Product(21, "Table", 12, R.drawable.home4, "Home"),

        // ====== Beauty ======
        Product(22, "Lipstick", 25, R.drawable.beau1, "Beauty"),
        Product(23, "Sunscreen", 18, R.drawable.beau2, "Beauty"),
        Product(24, "Hair Brush", 18, R.drawable.beau3, "Beauty"),
        Product(25, "Nail Polish", 45, R.drawable.beau4, "Beauty"),
        Product(26, "Compact Powder", 22, R.drawable.beau5, "Beauty"),


        // ====== Jewellery ======
        Product(27, "Ring", 8, R.drawable.jewl1, "Jewellery"),
        Product(28, "Necklace", 85, R.drawable.jewl2, "Jewellery"),
        Product(29, "Bracelet", 250, R.drawable.jewl3, "Jewellery"),
        Product(30, "Earrings", 120, R.drawable.jewl4, "Jewellery"),
        Product(31, "Watch", 499, R.drawable.jewl5, "Jewellery"),
        Product(32, "Bangles", 75, R.drawable.jewl6, "Jewellery")
    )
}

