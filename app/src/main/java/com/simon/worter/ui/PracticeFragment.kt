package com.simon.worter.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.simon.worter.R

class PracticeFragment : Fragment() {
    lateinit var word:TextView
    lateinit var check:TextView
    lateinit var btn: Button
    var statusCheck = false


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_practice, container, false)
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
        word.text = "loaded text"
        check.text = "loaded translation"
        btn.text = "check"
    }
}