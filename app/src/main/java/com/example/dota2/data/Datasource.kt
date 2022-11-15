package com.example.dota2.data

import com.example.dota2.R
import com.example.dota2.data.model.Responsibility

class Datasource {

    fun loadAffirmations(): List<Responsibility> {
        return listOf<Responsibility>(
            Responsibility(R.string.affirmation1),
            Responsibility(R.string.affirmation2),
            Responsibility(R.string.affirmation3),
            Responsibility(R.string.affirmation4),
        )
    }
}