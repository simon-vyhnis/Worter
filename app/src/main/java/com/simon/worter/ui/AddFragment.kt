package com.simon.worter.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.simon.worter.R
import kotlinx.coroutines.runBlocking

class AddFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root =  inflater.inflate(R.layout.fragment_add, container, false)
        val word = root.findViewById<EditText>(R.id.input_word)
        val translation = root.findViewById<EditText>(R.id.input_translation)
        val btn = root.findViewById<Button>(R.id.add)
        val viewModel : MainViewModel by viewModels()
        btn.setOnClickListener {
            val wordText = word.text.toString()
            val translationText = translation.text.toString()
            if(wordText.isBlank() || translationText.isBlank()) {
                Toast.makeText(context, "Enter word and translation", Toast.LENGTH_SHORT).show()
            }else {
                viewModel.addWord(wordText, translationText)
                root.findNavController().navigate(R.id.action_addFragment_to_startFragment)
            }
        }
        return root
    }
}