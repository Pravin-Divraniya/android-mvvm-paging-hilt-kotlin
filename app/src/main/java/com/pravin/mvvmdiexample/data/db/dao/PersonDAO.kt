package com.pravin.mvvmdiexample.data.db.dao

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.pravin.mvvmdiexample.data.model.Person

/**
 * Created by Pravin Divraniya on 10/5/2017.
 */
@Dao
interface PersonDAO {

    @Query("select * from person")
    fun getAllPerson():List<Person>

    @Insert(onConflict = REPLACE)
    fun insertPerson(person:Person)

    @Update(onConflict = REPLACE)
    fun updatePerson(person:Person)

    @Delete
    fun deletePerson(person:Person)

    @Query("select * from person where id = :id")
    fun getPerson(id:Long):Person
}