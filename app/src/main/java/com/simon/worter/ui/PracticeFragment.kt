package com.simon.worter.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.simon.worter.R
import com.simon.worter.model.Word

class PracticeFragment : Fragment() {
    lateinit var word:TextView
    lateinit var check:TextView
    lateinit var btn: Button
    var statusCheck = false
    lateinit var viewModel : MainViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_practice, container, false)
        val viewModel : MainViewModel by viewModels()
        this.viewModel = viewModel
        word = root.findViewById(R.id.word)
        check = root.findViewById(R.id.check)
        btn = root.findViewById(R.id.btn)
        btn.setOnClickListener {
            if(statusCheck){
                loadWord()
                statusCheck = false
            }else{
                check.visibility = View.VISIBLE
                btn.text = "next"
                statusCheck = true
            }
        }
        loadWord()
        return root
    }

    private fun loadWord(){
        check.visibility = View.INVISIBLE
        val w = viewModel.getRandomWord()
        word.text = w.value
        check.text = w.translation
        btn.text = "check"
    }
}