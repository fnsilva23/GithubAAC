package br.com.heiderlopes.githubaac.di.modules

import android.app.Application
import retrofit2.Retrofit
import javax.inject.Singleton
import dagger.Provides
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import android.arch.persistence.room.Room
import br.com.heiderlopes.githubaac.data.UserRepository
import br.com.heiderlopes.githubaac.data.local.MeuBancoDeDados
import br.com.heiderlopes.githubaac.data.local.dao.UserDAO
import br.com.heiderlopes.githubaac.data.remote.UserWebService

import dagger.Module
import java.util.concurrent.Executor
import java.util.concurrent.Executors


@Module//(includes = [ViewModelModule::class])
class AppModule {

    @Provides
    fun provideExecutor(): Executor {
        return Executors.newSingleThreadExecutor()
    }

}
