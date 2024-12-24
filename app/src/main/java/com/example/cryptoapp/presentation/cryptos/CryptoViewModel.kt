package com.example.cryptoapp.presentation.cryptos

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.domain.usecase.CryptoUseCase
import com.example.cryptoapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class CryptoViewModel @Inject constructor(
    private val cryptoUseCase: CryptoUseCase
) : ViewModel() {

    private val _cryptoState = MutableStateFlow(CryptoState(isLoading = true))
    val cryptoState: StateFlow<CryptoState> = _cryptoState

    init {
        getCrypto()
        //ViewModel oluşturulduğunda bu fonksiyon otomatik olarak çağrılacaktır.
    }

    private var job: Job? = null
    private fun getCrypto() {
        job?.cancel()
        cryptoUseCase.getCrypto().onStart {
            Log.e("Flow", "onStart'a girdi")
        }.onCompletion {
            Log.e("Flow", "onCompletion'a girdi")
        }
            .onEach { result -> //onEach değeri getCrypto'nun döndürdüğü değer her değiştiğinde tetiklenir.
                Log.e("Flow", "onEach'e girdi")
                when (result) {
                    is Resource.Error -> {
                        _cryptoState.value = _cryptoState.value.copy(
                            error = result.message ?: "Error", isLoading = false
                        )
                    }

                    is Resource.Success -> {
                        _cryptoState.value = _cryptoState.value.copy(
                            crypto = result.data ?: emptyList(), isLoading = false
                        )
                    }

                }
            }.launchIn(viewModelScope)
    }

}
