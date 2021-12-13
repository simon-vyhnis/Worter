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

    public fun addWord(word:String, translation:String) = viewModelScope.launch{
        db.wordDao().addWord(Word(word, translation))
    }

    public fun getRandomWord() : LiveData<Word> {
        return db.wordDao().getRandomWord()
    }
    public fun getNumberOfWords() : LiveData<Int> {
        return db.wordDao().getNumberOfWords()
    }

    public fun deleteWord(word: Word) = viewModelScope.launch{
        db.wordDao().deleteWord(word)
    }
    public fun updateWord(word: Word) = viewModelScope.launch{
        db.wordDao().updateWord(word)
    }

}