package com.example.dota2

public class DataModel {

    private val userId = Int
    private val  id = Int
    private val title = String

    public fun getUserId(int: Int): Int.Companion {
        return userId
    }
    public fun getId(int: Int): Int.Companion {
        return id
    }
    public fun getTitle(string: String): String.Companion {
        return title
    }
}