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
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.simon.worter.R

class EditFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root =  inflater.inflate(R.layout.fragment_add, container, false)
        val viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        val word = viewModel.lastWord

        val wordView = root.findViewById<EditText>(R.id.input_word)
        wordView.setText(word?.value)
        println(word?.value)
        val translation = root.findViewById<EditText>(R.id.input_translation)
        translation.setText(word?.translation)
        val btn = root.findViewById<Button>(R.id.add)
        btn.text = "Update"

        btn.setOnClickListener {
            word?.value = wordView.text.toString()
            word?.translation = translation.text.toString()
            if(wordView.text.toString().isBlank() || wordView.text.toString().isBlank()) {
                Toast.makeText(context, "Enter word and translation", Toast.LENGTH_SHORT).show()
            }else {
                word?.let {
                    viewModel.updateWord(it)
                }
                Toast.makeText(context, "Word updated", Toast.LENGTH_LONG).show()
                root.findNavController().navigate(R.id.action_editFragment_to_practiceFragment)
            }
        }
        return root
    }
}