package com.example.cryptoapp.domain.model

data class Crypto(
    val name: String,
    val code: String,
    val currency: String,
    val pricestr: String,
)

/**
 * Api'den çektiğimiz verilerin hepsini kullanmıyoruz.
 * Kullanacağımız parametreleri domain'deki modelde tanımlayıp burdan kullanırız.
 * Mapper yazarak dönüşüm işlemi gerçekleştireceğiz.
 */