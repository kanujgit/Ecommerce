package com.kdroid.ecommerce.data.model

data class Product(
    var id: Int? = null,
    var title: String? = null,
    var price: Int? = null,
    var description: String? = null,
    var images: ArrayList<String> = arrayListOf(),
    var creationAt: String? = null,
    var updatedAt: String? = null,
    var category: Category? = Category())
