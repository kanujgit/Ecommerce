package com.kdroid.ecommerce.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.kdroid.ecommerce.api.RetrofitBuilder
import com.kdroid.ecommerce.data.model.Product

class ProductPagingSource : PagingSource<Int, Product>() {


    override fun getRefreshKey(state: PagingState<Int, Product>): Int? {
        return state.anchorPosition?.let { it ->
            state.closestPageToPosition(it)?.prevKey?.plus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {

        val pos = params.key ?: 1
        val res = RetrofitBuilder.apiService?.getProductList(pos,10)
           return LoadResult.Page(
                data = res!!.body()!!.toMutableList(),
                prevKey = if (pos == 1) pos else -1,
                nextKey = pos + 1
            )
    }
}