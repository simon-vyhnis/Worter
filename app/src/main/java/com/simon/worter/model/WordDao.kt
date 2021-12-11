package com.simon.worter.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WordDao {

    @Query("SELECT * FROM Word ORDER BY RANDOM() LIMIT 1")
    public fun getRandomWord() : LiveData<Word>

    @Insert
    public suspend fun addWord(word : Word)
    @Query("SELECT COUNT(*) FROM Word ")
    public fun getNumberOfWords() : LiveData<Int>
}