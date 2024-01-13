package com.hussein.graphql.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hussein.graphql.domain.DetailedCountry
import com.hussein.graphql.domain.GetCountriesUseCase
import com.hussein.graphql.domain.GetCountryUseCase
import com.hussein.graphql.domain.SimpleCountry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase,
    private val getCountryUseCase: GetCountryUseCase
) : ViewModel() {


    private val _state =  MutableStateFlow(CountriesStates())

    val state =_state.asStateFlow()

    init {
        viewModelScope.launch {
            //Show Loading
            _state.update {
                it.copy(
                    isLoading = true,
                )
            }
            //Load data and hide loading
            _state.update {
                it.copy(
                    countries = getCountriesUseCase.execute(),
                    isLoading = false
                )
            }
        }
    }

    fun selectedCountry(code :String){
        viewModelScope.launch {
            _state.update { it.copy(
                selectedCountry = getCountryUseCase.execute(code = code)
            ) }
        }
    }

    fun dismissCountryDialog(){
        _state.update {
            it.copy(
                selectedCountry = null
            )
        }
    }
    data class CountriesStates(
     val countries : List<SimpleCountry> = emptyList(),
     val isLoading : Boolean = false,
     val selectedCountry : DetailedCountry? = null
    )
}