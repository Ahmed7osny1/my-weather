package com.example.myweather.di

import org.koin.androidx.viewmodel.dsl.viewModel
import com.example.myweather.data.mapper.WeatherMapperImpl
import com.example.myweather.data.repository.LocationProviderImpl
import com.example.myweather.data.repository.WeatherRepositoryImpl
import com.example.myweather.data.service.LocationProvider
import com.example.myweather.domain.repository.WeatherRepository
import com.example.myweather.domain.usecase.GetWeatherUseCase
import com.example.myweather.presentation.viewmodel.WeatherViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single {
        HttpClient(OkHttp) {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
        }
    }
    single<LocationProvider> { LocationProviderImpl(androidContext()) }

    single { WeatherMapperImpl() }

    single<WeatherRepository> { WeatherRepositoryImpl(get(), get(), get()) }

    single { GetWeatherUseCase(get()) }

    viewModel {
        WeatherViewModel(get())
    }

}
