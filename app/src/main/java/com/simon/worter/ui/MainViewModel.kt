package com.simon.worter.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.simon.worter.model.AppDatabase
import com.simon.worter.model.Word
import kotlinx.coroutines.launch

class MainViewModel(context: Application) : AndroidViewModel(context) {
    var lastWord: Word? = null
    private var db:AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "Word"
    ).build()

    fun addWord(word:String, translation:String) = viewModelScope.launch{
        db.wordDao().addWord(Word(word, translation))
    }

    fun getRandomWord() : LiveData<Word> {
        return db.wordDao().getRandomWord()
    }
    fun getNumberOfWords() : LiveData<Int> {
        return db.wordDao().getNumberOfWords()
    }

    fun deleteWord(word: Word) = viewModelScope.launch{
        db.wordDao().deleteWord(word)
    }
    fun updateWord(word: Word) = viewModelScope.launch{
        db.wordDao().updateWord(word)
    }
    fun isWordSaved(wordText: String) : LiveData<Boolean> {
        return db.wordDao().isWordSaved(wordText)
    }

}