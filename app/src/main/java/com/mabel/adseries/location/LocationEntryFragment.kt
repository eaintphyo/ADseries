package com.mabel.adseries.location

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mabel.adseries.AppNavigator
import com.mabel.adseries.R


class LocationEntryFragment : Fragment() {

    private lateinit var appNavigator: AppNavigator

    override fun onAttach(context: Context) {
        super.onAttach(context)
        appNavigator = context as AppNavigator
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_location_entry, container, false)
        // Inflate the layout for this fragment

        val zipcodeEditText: EditText = view.findViewById(R.id.edZipcode)
        val enterButton: Button = view.findViewById(R.id.enterButton)

        enterButton.setOnClickListener {
            val zipcode: String = zipcodeEditText.text.toString()
            Toast.makeText(requireContext(), zipcode, Toast.LENGTH_SHORT).show()

            if (zipcode.length != 5) {
                Toast.makeText(requireContext(), getString(R.string.zipcode_entry_error), Toast.LENGTH_SHORT).show()
            }else {
                appNavigator.navigateToCurrentForecast(zipcode)
            }
        }


        return view
    }
}