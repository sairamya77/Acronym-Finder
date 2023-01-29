package com.example.acronymfinder.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.acronymfinder.R
import com.example.acronymfinder.viewmodel.AcronymViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var acronymEditText: EditText
    private lateinit var meaningTextView: TextView
    private lateinit var searchButton: Button
    private lateinit var viewModel: AcronymViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        acronymEditText = findViewById(R.id.acronym_edit_text)
        meaningTextView = findViewById(R.id.meaning_text_view)
        searchButton = findViewById(R.id.search_button)

        viewModel = ViewModelProviders.of(this).get(AcronymViewModel::class.java)
        viewModel.acronym.observe(this, Observer { acronym ->
            meaningTextView.text = acronym.meaning
        })
        searchButton.setOnClickListener {
            val acronym = acronymEditText.text.toString()
            viewModel.getMeaning(acronym)
        }
    }
}