package com.clevertap.ctandroid

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.clevertap.android.sdk.CleverTapAPI
import com.clevertap.android.sdk.displayunits.DisplayUnitListener
import com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnit
import com.google.gson.Gson
import java.util.ArrayList


class HomeFragment : Fragment() , DisplayUnitListener {
    var cleverTapDefaultInstance: CleverTapAPI? = null
    val btn: Button? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        cleverTapDefaultInstance = CleverTapAPI.getDefaultInstance(activity)

        if (cleverTapDefaultInstance == null){
            Log.e("home","null instance")
        }

        cleverTapDefaultInstance?.pushEvent("product trigger")
        cleverTapDefaultInstance?.apply {
            setDisplayUnitListener(this@HomeFragment)
        }
        return view;
    }


    override fun onDisplayUnitsLoaded(units:  ArrayList<CleverTapDisplayUnit>?) {
        if (units != null) {
            Log.e("Unit", "onDisplayUnitsLoaded: " + units.size )
            var j = 1
            for (i in 0 until units.size)
            {
                val unit = units[i]
                Log.e("TAG", "onDisplayUnitsLoaded: " + Gson().toJson(unit) )
//                Toast.makeText(applicationContext,unit.customExtras.get("user"+i), Toast.LENGTH_SHORT).show()
                Toast.makeText(activity, "user $j", Toast.LENGTH_LONG).show()

                j++

//                prepareDisplayView(unit)
            }
        }
    }

}