package com.app.trendingrepositorykmm.domain.repository

import com.app.trendingrepositorykmm.domain.model.VyaparEmployee
import com.app.trendingrepositorykmm.util.Resource
import kotlinx.coroutines.flow.Flow

interface EmployeeRepository {

    fun getVyaparEmployee(): Flow<Resource<List<VyaparEmployee>>>

}