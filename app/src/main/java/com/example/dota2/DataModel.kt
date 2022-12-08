package com.example.dota2

public class DataModel {

    private val  id = Int
        get() { return field }
    private val name = String
        get() { return field }
    private val localized_name = String
        get() { return field }
    private val primary_attr = String
        get() { return field }
    private var attack_type = String
        get() { return field }
    private val roles = listOf<String>()
        get() { return field }
    private val title = String
        get() { return field }



    public fun getId(int: Int): Int.Companion {
        return id
    }
    public fun getName(string: String): String.Companion {
        return name
    }
    public fun getLocalizedName(string: String): String.Companion {
        return localized_name
    }
    public fun getRoles(list: List<String>): List<String> {
        return roles
    }
    public fun getAttackType(string: String): String.Companion {
        return attack_type
    }

    public fun getPrimaryAtt(string: String): String.Companion {
        return primary_attr
    }

    public fun getTitle(string: String): String.Companion {
        return title
    }

}