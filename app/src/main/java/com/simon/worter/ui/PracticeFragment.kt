package com.simon.worter.ui

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.simon.worter.R

class PracticeFragment : Fragment() {
    lateinit var word:TextView
    private lateinit var check:TextView
    private lateinit var btn: Button
    private var statusCheck = false
    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_practice, container, false)
        val viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
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
        viewModel.getRandomWord().observe(viewLifecycleOwner) {
            it?.let {
                viewModel.lastWord = it
                word.text = it.value
                check.text = it.translation
                btn.text = "check"
            }
            it?: run{word.text = "You don't have words"}
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_word, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.delete){
            viewModel.lastWord?.let {viewModel.deleteWord(it)}
            Toast.makeText(context, "Word deleted", Toast.LENGTH_LONG).show()
        }else if(item.itemId == R.id.edit){
            findNavController().navigate(R.id.action_practiceFragment_to_editFragment)
        }
        return super.onOptionsItemSelected(item)
    }

}