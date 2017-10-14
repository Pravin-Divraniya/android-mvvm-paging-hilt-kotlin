package com.pravin.mvvmdiexample.data.db

import com.pravin.mvvmdiexample.data.model.Person
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Pravin Divraniya on 10/6/2017.
 */
@Singleton
class DbHelper : IDbHelper {

    val appDatabase: AppDatabase

    @Inject
    constructor(appDatabase: AppDatabase) {
        this.appDatabase = appDatabase
    }
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