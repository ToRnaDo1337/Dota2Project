package com.example.dota2.ui.aboutdota
import android.content.Context
import android.provider.Settings.Global.getString
import android.view.View
import android.widget.TextView

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.dota2.R

import com.example.dota2.adapter.ListAdapter
import com.example.dota2.data.model.Responsibility
import java.lang.reflect.TypeVariable


class AboutFragmentModel : ViewModel() {

    private val _text = MutableLiveData<List<String>>().apply {

     /*   value = listOf(Responsibility(3).loadAffirmations().toString())*/
    }


    val text: LiveData<List<String>> = _text

}

