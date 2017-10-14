package com.pravin.mvvmdiexample.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.pravin.mvvmdiexample.utils.ConstantData
import com.pravin.mvvmdiexample.data.db.dao.PersonDAO
import com.pravin.mvvmdiexample.data.model.Person

/**
 * Created by Pravin Divraniya on 10/5/2017.
 */
@Database(entities = arrayOf(Person::class),
            version = ConstantData.DB_VERSION)
abstract class AppDatabase : RoomDatabase() {
    abstract fun personDAO():PersonDAO
}