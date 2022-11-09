package com.example.dota2.ui.aboutdota
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AboutFragmentModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Dota 2 is a 2013 multiplayer online battle arena (MOBA) video game developed and published by Valve. The game is a sequel to Defense of the Ancients (DotA), which was a community-created mod for Blizzard Entertainments Warcraft III: Reign of Chaos. Dota 2 is played in matches between two teams of five players, with each team occupying and defending their own separate base on the map. Each of the ten players independently controls a powerful character known as a \"hero\" that all have unique abilities and differing styles of play. During a match players collect experience points and items for their heroes to successfully defeat the opposing teams heroes in player versus player combat. A team wins by being the first to destroy the other teams \"Ancient\", a large structure located within their base.Development of Dota 2 began in 2009 when IceFrog, lead designer of Defense of the Ancients, was hired by Valve to create a modernized remake for them in the Source game engine. It was released for Windows, OS X, and Linux via the digital distribution platform Steam in July 2013, following a Windows-only open beta phase that began two years prior. The game is fully free-to-play with no heroes or any other gameplay element needing to be bought or otherwise unlocked. To maintain it, Valve supports the game as a service, selling loot boxes and a battle pass subscription system called Dota Plus that offer non-gameplay altering virtual goods in return, such as hero cosmetics and audio replacement packs. The game was ported to the Source 2 engine in 2015, making it the first game to use it."
    }
    val text: LiveData<String> = _text
}