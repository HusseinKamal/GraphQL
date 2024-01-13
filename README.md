GraphQL JetpackCompose app with Hilt Dependency injection

1-Gradle dependencies

plugins {
id 'com.android.application' version '8.0.2' apply false
id 'com.android.library' version '8.0.2' apply false
id 'org.jetbrains.kotlin.android' version '1.7.20' apply false
id ("com.google.dagger.hilt.android") version "2.42" apply false
id ("com.apollographql.apollo3").version("3.7.3") apply false
}


//GraphQL
implementation("com.apollographql.apollo3:apollo-runtime:3.7.3")
implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")
//Hilt
implementation 'com.google.dagger:hilt-android:2.42'
implementation 'androidx.hilt:hilt-navigation-compose:1.0.0'
kapt 'com.google.dagger:hilt-compiler:2.42'
kapt "androidx.hilt:hilt-compiler:1.0.0"

2- Add File GraphQl Country query

query Countries{
countries {
name
capital
code
emoji
}
}

3- Add File GraphQl Countries query
query Country($country_code : ID!){
country(code: $country_code) {
code
name
capital
currency
emoji
languages {
name
}
continent {
name
}
}
}

4-Get your schema here
https://studio.apollographql.com/public/countries/variant/current/schema/reference

5-Install Plugin GraphQl in Android Studio

6-Screenshots from app

![country1](https://github.com/HusseinKamal/GraphQL/assets/29864161/c681f08c-334e-4921-b155-dfc85f5c08e6)

![country2](https://github.com/HusseinKamal/GraphQL/assets/29864161/9b9131c5-2429-40ac-b5bc-c7fec138d179)
