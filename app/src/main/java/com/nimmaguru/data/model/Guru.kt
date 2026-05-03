package com.nimmaguru.data.model

data class Guru(
    val id: String = "",
    val name: String = "",
    val skills: List<String> = emptyList(),
    val availability: String = "",
    val location: String = "",
    val bio: String = ""
)
