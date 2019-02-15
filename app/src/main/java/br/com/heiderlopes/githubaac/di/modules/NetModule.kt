package br.com.heiderlopes.githubaac.di.modules

import br.com.heiderlopes.githubaac.BuildConfig
import br.com.heiderlopes.githubaac.data.remote.UserWebService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import javax.inject.Named


@Module
class NetModule {


    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    fun provideRetrofit(gson: Gson,
                        @Named("githubURL") githubURL: String,
                        okhttp: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(githubURL)
                .client(okhttp)
                .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient() : OkHttpClient {
        return OkHttpClient.Builder()
                .addNetworkInterceptor(StethoInterceptor())
                .build();
    }


    @Provides
    @Singleton
    fun provideApiWebservice(restAdapter: Retrofit): UserWebService {
        return restAdapter.create(UserWebService::class.java)
    }

    @Provides
    @Singleton
    @Named("githubURL")
    fun provideGithubURL(): String {
        return BuildConfig.GITHUB_URL
    }
    /*
    companion object {
        private val BASE_URL = "https://api.github.com/"
    }
    */
}