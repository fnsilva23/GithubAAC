package br.com.heiderlopes.githubaac.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import br.com.heiderlopes.githubaac.data.local.converter.DateConverter
import br.com.heiderlopes.githubaac.data.local.dao.UserDAO
import br.com.heiderlopes.githubaac.data.local.entity.User

@Database(entities = [User::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class MeuBancoDeDados : RoomDatabase() {

    abstract fun userDao(): UserDAO

    companion object {
        val INSTANCE: MeuBancoDeDados? = null
    }

}