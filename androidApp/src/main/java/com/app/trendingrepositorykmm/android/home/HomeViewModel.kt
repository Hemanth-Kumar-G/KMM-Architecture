package com.app.trendingrepositorykmm.android.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.trendingrepositorykmm.data.repository.EmployeeRepositoryImpl
import com.app.trendingrepositorykmm.domain.use_case.GetVyaparEmployees
import com.app.trendingrepositorykmm.presenter.VyaparEmployeeState
import com.app.trendingrepositorykmm.util.Resource
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _state = mutableStateOf(VyaparEmployeeState())
    val state: State<VyaparEmployeeState> = _state


    private val getVyaparEmployee
        get() = GetVyaparEmployees(repository = EmployeeRepositoryImpl())


    fun fetchData() {
        viewModelScope.launch {
            getVyaparEmployee().watch {

                when (val result = it) {
                    is Resource.Loading -> {
                        _state.value = state.value.copy(
                            vyaparEmployees = result.data ?: emptyList(),
                            isLoading = true,
                            isError = false
                        )
                    }

                    is Resource.Success -> {
                        _state.value = state.value.copy(
                            vyaparEmployees = result.data ?: emptyList(),
                            isLoading = false,
                            isError = false
                        )
                    }

                    is Resource.Error -> {
                        _state.value = state.value.copy(
                            vyaparEmployees = emptyList(),
                            isError = true,
                            isLoading = false
                        )
                    }
                }
            }
        }
    }
}