package com.mabel.adseries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mabel.adseries.forecast.CurrentForecastFragment
import com.mabel.adseries.location.LocationEntryFragment

class MainActivity : AppCompatActivity(), AppNavigator {


    private lateinit var tempDisplaySettingManager: TempDisplaySettingManager

    // region Setup Methods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tempDisplaySettingManager = TempDisplaySettingManager(this)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainer, LocationEntryFragment())
            .commit()
    }


    override fun navigateToCurrentForecast(zipcode: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, CurrentForecastFragment.newInstance(zipcode))
            .commit()

    }

    override fun navigateToLocationEntry() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, LocationEntryFragment())
            .commit()
    }
}