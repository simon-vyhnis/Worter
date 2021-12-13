package com.simon.worter.ui

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.simon.worter.R

class StartFragment : Fragment() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root =  inflater.inflate(R.layout.fragment_start, container, false)
        val buttonForeignToOwn = root.findViewById<Button>(R.id.foreign_to_own)
        val buttonOwnToForeign = root.findViewById<Button>(R.id.own_to_foreign)
        buttonForeignToOwn.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_foreignToOwnFragment)
        }
        buttonOwnToForeign.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_ownToForeignFragment)
        }
        val buttonAdd = root.findViewById<Button>(R.id.add)
        buttonAdd.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_addFragment)
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