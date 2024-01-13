package com.hussein.graphql.domain

interface CountryClient {
    suspend fun getCountries() : List<SimpleCountry>
    suspend fun getCountry(code:String) : DetailedCountry?

}