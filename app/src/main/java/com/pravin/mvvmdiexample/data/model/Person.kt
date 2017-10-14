package com.pravin.mvvmdiexample.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Pravin Divraniya on 10/3/2017.
 */
@Entity(tableName = "person")
data class Person(@ColumnInfo(name="person_name") var name:String,
                  @ColumnInfo(name="Age") var age:Int):BaseModel(){
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0
}