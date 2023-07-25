package com.kdroid.ecommerce.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kdroid.ecommerce.data.model.Product
import com.kdroid.ecommerce.databinding.PrdItemViewBinding

class ProductListAdapter :
    PagingDataAdapter<Product, ProductListAdapter.ItemViewHolder>(ProductComparator) {

    class ItemViewHolder(val itemViewBind: PrdItemViewBinding) :
        RecyclerView.ViewHolder(itemViewBind.root) {

        fun bind(data: Product) {
            itemViewBind.tvPrdName.text = data.title
            itemViewBind.tvDesc.text = data.description
            itemViewBind.tvCat.text = data.category?.name
            Glide.with(itemView.context).load(data.images[0]).into(itemViewBind.imgPrd)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val bind: PrdItemViewBinding =
            PrdItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(bind)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }


    object ProductComparator : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(
            oldItem: Product,
            newItem: Product,
        ) = (oldItem.id == newItem.id)


        override fun areContentsTheSame(
            oldItem: Product,
            newItem: Product,
        ) = (oldItem == newItem)


    }
}