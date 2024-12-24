package com.example.cryptoapp.data.mapper

import com.example.cryptoapp.data.remote.dto.CryptoDto
import com.example.cryptoapp.domain.model.Crypto


fun CryptoDto.toCrypto(): List<Crypto> {
    return result.map {   //Map fonksiyonu result listesindeki bütün indexleri dolaşarak,içine yazdığımız işlemi bütün indexler için gerçekleştirir.
        Crypto( //Sonunda ise bu listenin uygulanmış halini bize geri döndürür.

            name = it.name, code = it.code, currency = it.currency, pricestr = it.pricestr
        )

    }
}

// Burdaki asıl amaç CryptoDto içerisindeki ham veriyi(CryptoDto) temizleyip dönüştürerek kullanıma uygun hale getirmektir.
// Domain katmanındaki model classımız tipinde nesneler oluşturup o nesneleri bir liste halinda döneriz.
// Bunu yapmamızdaki amaç api'den dönen CryptoDto içerisindeki field'ların hepsine ihtiyacımız olmamasıdır
// İhtiyacımız olan kadar'ki kısmı mapleyip projemizde kullanırız.
