package com.pravin.mvvmdiexample.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pravin.mvvmdiexample.utils.ConstantData
import com.pravin.mvvmdiexample.data.local.db.dao.PersonDAO
import com.pravin.mvvmdiexample.data.model.db.Person

/**
 * Created by Pravin Divraniya on 10/5/2017.
 */
@Database(entities = [Person::class],
            version = ConstantData.DB_VERSION)
abstract class AppDatabase : RoomDatabase() {
    abstract fun personDAO(): PersonDAO
}