package com.app.trendingrepositorykmm.domain.use_case

import com.app.trendingrepositorykmm.domain.model.VyaparEmployee
import com.app.trendingrepositorykmm.domain.repository.EmployeeRepository
import com.app.trendingrepositorykmm.ktx.CommonFlow
import com.app.trendingrepositorykmm.ktx.asCommonFlow
import com.app.trendingrepositorykmm.util.Resource

class GetVyaparEmployees(
    private val repository: EmployeeRepository,
) {

    operator fun invoke(): CommonFlow<Resource<List<VyaparEmployee>>> {
        return repository.getVyaparEmployee().asCommonFlow()
    }

}