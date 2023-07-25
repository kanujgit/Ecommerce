package com.kdroid.ecommerce.data.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.kdroid.ecommerce.data.model.Product
import com.kdroid.ecommerce.paging.ProductPagingSource
import kotlinx.coroutines.flow.Flow

class ProductRepo {

    val pagingSource: ProductPagingSource = ProductPagingSource()

    fun getProductList(): Flow<PagingData<Product>> {
        return Pager(
            config = PagingConfig(
                10, enablePlaceholders = false, initialLoadSize = 2
            ), pagingSourceFactory = {
                pagingSource
            }, initialKey = 1
        ).flow
    }
}
