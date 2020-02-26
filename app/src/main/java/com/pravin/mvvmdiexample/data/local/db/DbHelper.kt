package com.pravin.mvvmdiexample.data.local.db

import com.pravin.mvvmdiexample.data.model.db.Person
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Pravin Divraniya on 10/6/2017.
 */
@Singleton
class DbHelper @Inject constructor(private val appDatabase: AppDatabase) : IDbHelper {
    
    override fun getAllPerson(): List<Person> = appDatabase.personDAO().getAllPerson()

    override fun insertPerson(person: Person) {
        appDatabase.personDAO().insertPerson(person)
    }

    override fun updatePerson(person: Person) {
        appDatabase.personDAO().updatePerson(person)
    }

    override fun deletePerson(person: Person) {
        appDatabase.personDAO().deletePerson(person)
    }

    override fun getPerson(id: Long): Person = appDatabase.personDAO().getPerson(id)

}