package com.example.cryptoapp.di

import com.example.cryptoapp.data.remote.CrytpoAPI
import com.example.cryptoapp.data.repository.CryptoRepositoryImpl
import com.example.cryptoapp.domain.repository.CryptoRepository
import com.example.cryptoapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/** Annotationlar Ve Anlamları
 * @Module
 * Bu sınıfın bir Hilt modülü olduğunu belirtir.
 * Modüller,bağımlılıkların sağlanacağı(provide edileceği yerdir)
 * Bu sayede,Hilt uygulamayı çalıştırırken bağımlılıkları oluşturabilir ve gerektiği yerde sağlayabilir.
 *
 * @InstallIn(SingletonComponent::class)
 * SingletonComponent uygulama yaşam döngüsünü temsil eder,yani bu modül tarafından sağlanan bağımlılıklar,uygulama boyunca tek bir örnek(singleton) olarak
 * oluşturulur ve kullanılır.
 *
 * @Provides
 * Bir bağımlılığın nasıl sağlanacağını belirtir.
 * Bu,Hilt'in belirtilen bağımlılığı nasıl oluşturacağını söylemek için kullanılır

@Singleton
 * Sağlanan bağımlılığın uygulama boyunca tek bir örneğinin kullanılacağını belirtir.
 * Retrofit gibi ağ istemcileri,gereksiz yere tekrar oluşturulursa performans sorunlarına yol açar.
 * Mesela bu örnek için,her CrytpoAPI'nin Inject edildiği yerde bu değer tek bir defa oluşturulucak ve Inject edilen yere verilecektir.
 */
@Module
@InstallIn(SingletonComponent::class)
object CryptoModule {

    @Provides
    @Singleton
     fun provideApi(): CrytpoAPI {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(CrytpoAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(cryptoAPI: CrytpoAPI): CryptoRepository {
        return CryptoRepositoryImpl(cryptoAPI)
    }
}