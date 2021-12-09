package com.simon.worter.ui

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.room.Room
import androidx.room.RoomDatabase
import com.simon.worter.model.AppDatabase
import com.simon.worter.model.Word

class MainViewModel(context: Application) : AndroidViewModel(context) {
    private var db:AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "Word"
    ).build()

    public fun addWord(word:String, translation:String){
        db.wordDao().addWord(Word(word, translation))
    }

    public fun getRandomWord() : Word{
        return db.wordDao().getRandomWord()
    }
}