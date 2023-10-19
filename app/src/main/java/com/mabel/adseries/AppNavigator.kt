package com.mabel.adseries

interface AppNavigator {

    fun navigateToCurrentForecast(zipcode: String)
    fun navigateToLocationEntry()
    fun navigateToForecastDetails(forecast: DailyForecast)
}