package br.com.heiderlopes.githubaac.di.modules

import br.com.heiderlopes.githubaac.data.remote.UserWebService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule {


    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    fun provideRetrofit(gson: Gson): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build()
    }

    @Provides
    @Singleton
    fun provideApiWebservice(restAdapter: Retrofit): UserWebService {
        return restAdapter.create(UserWebService::class.java)
    }

    companion object {
        private val BASE_URL = "https://api.github.com/"
    }
}