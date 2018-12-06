package com.clarion.mvvmdiexample.data.model.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.clarion.mvvmdiexample.data.model.BaseModel
import java.io.Serializable

/**
 * Created by Pravin Divraniya on 10/3/2017.
 */
@Entity(tableName = "mPerson")
data class Person(@ColumnInfo(name="person_name") var name:String,
                  @ColumnInfo(name="age") var age:Int): BaseModel(),Serializable{
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0
}