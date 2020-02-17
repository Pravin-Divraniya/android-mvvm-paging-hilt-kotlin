package com.pravin.mvvmdiexample.data.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pravin.mvvmdiexample.data.model.BaseModel
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