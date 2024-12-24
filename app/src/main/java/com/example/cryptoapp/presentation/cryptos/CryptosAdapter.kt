package com.example.cryptoapp.presentation.cryptos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.databinding.CryptoItemBinding
import com.example.cryptoapp.domain.model.Crypto

class CryptosAdapter(private val cryptoList: List<Crypto>) :
    RecyclerView.Adapter<CryptosAdapter.ViewHolder>() {
    class ViewHolder(val binding: CryptoItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val binding = CryptoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val crypto = cryptoList[position]
        holder.binding.cryptoCode.text = crypto.code
        holder.binding.cryptoPrice.text = crypto.pricestr + "" + crypto.currency
    }

    override fun getItemCount(): Int {
        return cryptoList.size
    }
}