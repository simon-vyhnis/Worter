package com.simon.worter.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WordDao {

    @Query("SELECT * FROM Word ORDER BY RANDOM() LIMIT 1")
    fun getRandomWord() : LiveData<Word>
    @Insert
    suspend fun addWord(word : Word)
    @Delete
    suspend fun deleteWord(word: Word)
    @Update
    suspend fun updateWord(word: Word)
    @Query("SELECT COUNT(*) FROM Word ")
    fun getNumberOfWords() : LiveData<Int>
    @Query("SELECT EXISTS(SELECT * FROM Word WHERE value = :wordText)")
    fun isWordSaved(wordText : String) : LiveData<Boolean>
}