package br.com.heiderlopes.githubaac.di.modules

import br.com.heiderlopes.githubaac.data.UserRepository
import br.com.heiderlopes.githubaac.data.local.dao.UserDAO
import br.com.heiderlopes.githubaac.data.remote.UserWebService
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module(includes = [
    NetModule::class,
    DatabaseModule::class,
    AppModule::class
]

)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(
            webservice: UserWebService,
            userDao: UserDAO,
            executor: Executor
    ): UserRepository {
        return UserRepository(webservice, userDao, executor)
    }

}