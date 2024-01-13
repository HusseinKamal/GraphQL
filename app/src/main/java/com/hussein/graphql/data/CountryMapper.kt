package com.hussein.graphql.data

import com.hussein.graphql.domain.DetailedCountry
import com.hussein.graphql.domain.SimpleCountry
import com.plcoding.CountriesQuery
import com.plcoding.CountryQuery

fun CountryQuery.Country.toDetailedCountry() : DetailedCountry{
    return DetailedCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No Capital View",
        currency = currency ?: "No Currency",
        languages = languages.mapNotNull { it.name },
        continent = continent.name

    )
}

fun CountriesQuery.Country.toSimpleCountry() : SimpleCountry{
    return SimpleCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No Capital View",
    )
}