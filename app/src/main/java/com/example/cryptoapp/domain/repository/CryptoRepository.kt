package com.example.cryptoapp.domain.repository

import com.example.cryptoapp.data.remote.dto.CryptoDto

interface CryptoRepository {

    suspend fun getCrypto(): CryptoDto


    //Bu interface veriyi sağlayacak bir yapı sunar.
    // Gerçek işlem bu arayüzü implement eden class'da yapılır.(CryptoRepositoryImpl)


}