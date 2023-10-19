package com.mabel.adseries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mabel.adseries.forecast.CurrentForecastFragment
import com.mabel.adseries.location.LocationEntryFragment

class MainActivity : AppCompatActivity(), AppNavigator {


    private lateinit var tempDisplaySettingManager: TempDisplaySettingManager

    // region Setup Methods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tempDisplaySettingManager = TempDisplaySettingManager(this)

        val navController = findNavController(R.id.nav_host_fragment)
//        val appBarConfiguration = AppBarConfiguration(navController.graph)
        findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar).setTitle(R.string.app_name)
        findViewById<BottomNavigationView>(R.id.bottomNavigationView).setupWithNavController(navController)
    }


    override fun navigateToCurrentForecast(zipcode: String) {
        findNavController(R.id.nav_host_fragment).navigate(R.id.action_locationEntryFragment_to_currentForecastFragment)

    }

    override fun navigateToLocationEntry() {
        findNavController(R.id.nav_host_fragment).navigate(R.id.action_currentForecastFragment_to_locationEntryFragment)
    }

    override fun navigateToForecastDetails(forecast: DailyForecast) {
        val bundle = Bundle().apply {
            putFloat("temp", forecast.temp)
            putString("description",forecast.description)
        }
        findNavController(R.id.nav_host_fragment).navigate(R.id.action_currentForecastFragment_to_forecastDetailsFragment, bundle)
    }
}