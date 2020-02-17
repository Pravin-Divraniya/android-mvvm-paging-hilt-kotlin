package com.pravin.mvvmdiexample.data.local.db

import com.pravin.mvvmdiexample.data.model.db.Person

/**
 * Created by Pravin Divraniya on 10/6/2017.
 */
interface IDbHelper {
    fun getAllPerson(): List<Person>

    fun insertPerson(person: Person)

    fun updatePerson(person: Person)

    fun deletePerson(person: Person)

    fun getPerson(id:Long): Person
}