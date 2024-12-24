package com.example.cryptoapp.presentation.cryptos

import com.example.cryptoapp.domain.model.Crypto

data class CryptoState(
    val isLoading: Boolean = false, val crypto: List<Crypto> = emptyList(), val error: String = ""
)
