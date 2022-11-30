package com.example.dota2.ui.aboutdota
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AboutFragmentModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "1";
        value = "2";


    }
    val text: LiveData<String> = _text
}