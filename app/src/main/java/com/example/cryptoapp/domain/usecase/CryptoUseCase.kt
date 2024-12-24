package com.example.cryptoapp.domain.usecase


import com.example.cryptoapp.data.mapper.toCrypto
import com.example.cryptoapp.domain.model.Crypto
import com.example.cryptoapp.domain.repository.CryptoRepository
import com.example.cryptoapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class CryptoUseCase @Inject constructor(
    private val repository: CryptoRepository
) {
    fun getCrypto(): Flow<Resource<List<Crypto>>> = flow {
        try {
            val crypto = repository.getCrypto()
            if (crypto.success) {
                emit(Resource.Success(crypto.toCrypto()))
            } else {
                emit(Resource.Error("No Crypto Found"))
            }

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Error"))
        } catch (e: IOException) {
            emit(Resource.Error("Check Internet Connection"))
        }
    }
}