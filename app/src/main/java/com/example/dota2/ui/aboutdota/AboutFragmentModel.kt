package com.example.dota2.ui.aboutdota
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.dota2.databinding.FragmentAboutBinding

class AboutFragmentModel : ViewModel() {
    private var binding: FragmentAboutBinding? = null
    private val _text = MutableLiveData<String>().apply {
         value = binding?.recyclerView.toString()
    }
    val text: LiveData<String> = _text
}