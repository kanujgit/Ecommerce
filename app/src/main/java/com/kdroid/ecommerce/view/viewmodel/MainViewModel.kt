package com.kdroid.ecommerce.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.kdroid.ecommerce.data.model.Product
import com.kdroid.ecommerce.data.repo.ProductRepo
import kotlinx.coroutines.flow.Flow

class MainViewModel : ViewModel() {

    val repo = ProductRepo()

    fun productListing():Flow<PagingData<Product>> {
        return repo.getProductList().cachedIn(viewModelScope)
    }
}