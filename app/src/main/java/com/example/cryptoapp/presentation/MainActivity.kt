package com.example.cryptoapp.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptoapp.databinding.ActivityMainBinding
import com.example.cryptoapp.presentation.cryptos.CryptoViewModel
import com.example.cryptoapp.presentation.cryptos.CryptosAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var adapter: CryptosAdapter
    private val cryptoViewModel: CryptoViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val rv = binding.rv
        val progressBar = binding.progressBar

        lifecycleScope.launch {
            cryptoViewModel.cryptoState.collect { cryptoState ->
                if (cryptoState.isLoading) {
                    progressBar.visibility = View.VISIBLE
                } else {
                    progressBar.visibility = View.GONE
                }
                if (cryptoState.error.isNotBlank()) {
                    Toast.makeText(this@MainActivity, cryptoState.error, Toast.LENGTH_LONG).show()
                }
                cryptoState.crypto.let {
                    adapter = CryptosAdapter(it)
                    rv.adapter = adapter
                    rv.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }
        }

    }
}