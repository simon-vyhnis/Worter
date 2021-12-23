package com.simon.worter.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WordDao {

    @Query("SELECT * FROM Word ORDER BY RANDOM() LIMIT 1")
    public fun getRandomWord() : LiveData<Word>
    @Insert
    public suspend fun addWord(word : Word)
    @Delete
    public suspend fun deleteWord(word: Word)
    @Update
    public suspend fun updateWord(word: Word)
    @Query("SELECT COUNT(*) FROM Word ")
    public fun getNumberOfWords() : LiveData<Int>
    @Query("SELECT EXISTS(SELECT * FROM Word WHERE value = :wordText)")
    fun isWordSaved(wordText : String) : LiveData<Boolean>
}