package com.simon.worter.ui

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.simon.worter.R

class StartFragment : Fragment() {
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.statistics){
            viewModel.getNumberOfWords().observe(this) {
                Toast.makeText(context, "Total words: $it", Toast.LENGTH_LONG).show()
            }
        }else if(item.itemId == R.id.about){
            findNavController().navigate(R.id.action_startFragment_to_aboutFragment)
        }
        return super.onOptionsItemSelected(item)
    }
}