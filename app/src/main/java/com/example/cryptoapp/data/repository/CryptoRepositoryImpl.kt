package com.example.cryptoapp.data.repository

import com.example.cryptoapp.CryptoApp
import com.example.cryptoapp.data.remote.CrytpoAPI
import com.example.cryptoapp.data.remote.dto.CryptoDto
import com.example.cryptoapp.domain.repository.CryptoRepository
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(private val cryptoAPI: CrytpoAPI) :
    CryptoRepository {
    override suspend fun getCrypto(): CryptoDto {
        return cryptoAPI.getCryptos()
    }

    //CryptoRepository interfacesini uygular ve gerçek iş mantığını içerir.
    // Bu yapı,API ile üst katman(domain) arasındaki arayüz olarak çalışır  ve getCrypto fonksiyonunun detaylarından uygulamayı soyutlar.

}
