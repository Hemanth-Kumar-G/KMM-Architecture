package com.app.trendingrepositorykmm.data.repository

import com.app.trendingrepositorykmm.data.remote.ApiClient
import com.app.trendingrepositorykmm.domain.model.VyaparEmployee
import com.app.trendingrepositorykmm.domain.repository.EmployeeRepository
import com.app.trendingrepositorykmm.util.Resource
import io.ktor.client.call.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class EmployeeRepositoryImpl : EmployeeRepository {


    override fun getVyaparEmployee(): Flow<Resource<List<VyaparEmployee>>> {
        return flow {
            emit(Resource.Loading())

            val response = ApiClient.getVyaparEmployee()

            if (response.status.value in 200..209) {
                emit(Resource.Success(data = response.body()))
                return@flow
            } else {
                emit(Resource.Error("Something went wrong"))
                return@flow
            }

        }
    }
}