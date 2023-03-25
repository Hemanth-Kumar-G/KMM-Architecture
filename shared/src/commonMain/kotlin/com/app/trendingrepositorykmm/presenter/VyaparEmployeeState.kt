package com.app.trendingrepositorykmm.presenter

import com.app.trendingrepositorykmm.domain.model.VyaparEmployee

data class VyaparEmployeeState(
    val vyaparEmployees: List<VyaparEmployee> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
)