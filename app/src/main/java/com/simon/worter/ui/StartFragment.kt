package com.simon.worter.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.simon.worter.R

class StartFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root =  inflater.inflate(R.layout.fragment_start, container, false)
        val buttonPractice = root.findViewById<Button>(R.id.practice)
        buttonPractice.setOnClickListener {
            it.findNavController().navigate(R.id.action_startFragment_to_practiceFragment)
        }
        val buttonAdd = root.findViewById<Button>(R.id.add)
        buttonAdd.setOnClickListener {
            it.findNavController().navigate(R.id.action_startFragment_to_addFragment)
        }
        return root
    }
}