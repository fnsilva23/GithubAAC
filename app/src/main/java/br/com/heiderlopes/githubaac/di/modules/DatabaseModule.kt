package br.com.heiderlopes.githubaac.di.modules

import android.app.Application
import android.arch.persistence.room.Room
import br.com.heiderlopes.githubaac.data.local.MeuBancoDeDados
import br.com.heiderlopes.githubaac.data.local.dao.UserDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(application: Application): MeuBancoDeDados {
        return Room.databaseBuilder(
                application,
                MeuBancoDeDados::class.java, "MyDatabase.db"
        )
                .build()
    }

    @Provides
    @Singleton
    fun provideUserDao(database: MeuBancoDeDados): UserDAO {
        return database.userDao()
    }

}