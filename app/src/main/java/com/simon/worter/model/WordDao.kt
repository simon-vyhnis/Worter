package com.simon.worter.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WordDao {

    @Query("SELECT * FROM Word ORDER BY RANDOM() LIMIT 1")
    fun getRandomWord() : Word

    @Insert
    fun addWord(word : Word)
}