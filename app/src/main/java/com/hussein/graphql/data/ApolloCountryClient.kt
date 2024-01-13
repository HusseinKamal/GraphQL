package com.hussein.graphql.data

import com.apollographql.apollo3.ApolloClient
import com.hussein.graphql.domain.CountryClient
import com.hussein.graphql.domain.DetailedCountry
import com.hussein.graphql.domain.SimpleCountry
import com.plcoding.CountriesQuery
import com.plcoding.CountryQuery

class ApolloCountryClient(
    private val apolloClient: ApolloClient //we can change this to retrofit client for our APIs
):CountryClient {
    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toSimpleCountry() }
            ?:emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailedCountry()
    }
}