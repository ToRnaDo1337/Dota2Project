package com.example.dota2

import com.squareup.moshi.Json

data class DataModel (
    @field:Json(name = "id") var id: Int ,
    @field:Json(name = "name") var name: String,
    @field:Json(name = "localized_name") var localized_name: String,
    @field:Json(name = "primary_attr") var primary_attr: String,
    @field:Json(name = "attack_type") var attack_type: String,
    @field:Json(name = "roles") var roles: List<String>,


)