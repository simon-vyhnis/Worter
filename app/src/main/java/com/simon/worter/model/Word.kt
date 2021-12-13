package com.simon.worter.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Word (
    @ColumnInfo(name = "value") var value : String,
    @ColumnInfo(name = "translation") var translation : String
    ){
    @PrimaryKey(autoGenerate = true) var uid: Int = 0
}