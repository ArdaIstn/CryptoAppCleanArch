package com.example.cryptoapp.data.remote

import com.example.cryptoapp.data.remote.dto.CryptoDto
import com.example.cryptoapp.util.Constants.API_KEY
import com.example.cryptoapp.util.Constants.CONTENT_TYPE
import retrofit2.http.GET
import retrofit2.http.Header

interface CrytpoAPI {

    @GET("economy/cripto")
    suspend fun getCryptos(
        @Header("content-type") contentType: String = CONTENT_TYPE,
        @Header("authorization") key: String = API_KEY
    ): CryptoDto

    // GET isteği api'ye istek gönderir ve cevapları almak istiyorum deriz.
    // POST isteği'nde ise api'ye parametre göndeririz ve onun karşılığında bize bir cevap döner.
    // Burda ise sadece Doğrulama için parametre göndeririz,onun dışında GET isteğinde parametre göndermeyiz.

}