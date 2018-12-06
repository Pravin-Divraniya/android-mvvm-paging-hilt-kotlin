package com.clarion.mvvmdiexample.data.local.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.clarion.mvvmdiexample.utils.ConstantData
import com.clarion.mvvmdiexample.data.local.db.dao.PersonDAO
import com.clarion.mvvmdiexample.data.model.db.Person

/**
 * Created by Pravin Divraniya on 10/5/2017.
 */
@Database(entities = arrayOf(Person::class),
            version = ConstantData.DB_VERSION)
abstract class AppDatabase : RoomDatabase() {
    abstract fun personDAO(): PersonDAO
}