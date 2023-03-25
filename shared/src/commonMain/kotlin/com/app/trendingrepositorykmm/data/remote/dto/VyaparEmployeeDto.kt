package com.app.trendingrepositorykmm.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VyaparEmployeeDto(
    @SerialName("department")
    val department: String,
    @SerialName("email")
    val email: String,
    @SerialName("id")
    val id: Int,
    @SerialName("location")
    val location: String,
    @SerialName("name")
    val name: String,
    @SerialName("phone")
    val phone: String,
)
