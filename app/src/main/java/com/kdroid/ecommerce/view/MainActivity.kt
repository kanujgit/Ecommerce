package com.kdroid.ecommerce.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kdroid.ecommerce.databinding.ActivityMainBinding
import com.kdroid.ecommerce.view.adapter.ProductListAdapter
import com.kdroid.ecommerce.view.viewmodel.MainViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    private lateinit var prdAdapter: ProductListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setupRecyclerview()

        lifecycleScope.launch {
            viewModel.productListing().collectLatest {
                prdAdapter.submitData(lifecycle, it)
            }
        }

    }

    private fun setupRecyclerview() {
        prdAdapter = ProductListAdapter()
        binding.recItemList.apply {
            adapter = prdAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        }
    }
}