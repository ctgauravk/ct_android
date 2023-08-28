package com.clevertap.ctandroid

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.clevertap.android.sdk.CleverTapAPI
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.gson.Gson
import com.segment.analytics.Analytics
import com.segment.analytics.Properties
import com.segment.analytics.Traits
import java.util.*


class MainActivity : AppCompatActivity()  {


    private var mFirebaseAnalytics: FirebaseAnalytics? = null
    val LOCATION_REQUEST = 100
    var btn1: Button? =null
    var login1: Button? =null
    var login2: Button? =null
    var logout: Button? =null
    private val PERMISSION_NOTIFICATION = 101

    //    var myWebView: WebView? = null
    var cleverTapDefaultInstance: CleverTapAPI? = null
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        cleverTapDefaultInstance = CleverTapAPI.getDefaultInstance(applicationContext)
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)

        Log.e("app", Gson().toJson(cleverTapDefaultInstance?.getCleverTapID {
            Log.e("app", cleverTapDefaultInstance?.cleverTapID.toString())


        }))

        cleverTapDefaultInstance?.getCleverTapID {


            mFirebaseAnalytics?.setUserProperty("ct_objectId",
                Objects.requireNonNull(CleverTapAPI.getDefaultInstance(this))?.cleverTapID)
        }

        //Set Log level to VERBOSE

        cleverTapDefaultInstance?.enableDeviceNetworkInfoReporting(true)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            CleverTapAPI.createNotificationChannelGroup(
                applicationContext,
                "football", "ChampionsLeague"
            )


            CleverTapAPI.createNotificationChannel(
                applicationContext,
                "euro", "Europe", "EuroCountry",
                4, "football", false
            )

            CleverTapAPI.createNotificationChannel(
                applicationContext, "bpl",
                "Barclays Premier League", "English top tier",
                4, true
            )
        }

        btn1 = findViewById(R.id.button)
        btn1?.text = getString(R.string.click)

        Analytics.with(applicationContext).track(
            "SegmentEvent",
            Properties().putValue("value", "testValue").putValue("testDate", Date(System.currentTimeMillis()))
        )


    }


    fun buttonClick(view: View) {
        Analytics.with(applicationContext).track(
            "push event",
            Properties().putValue("prop1", "value1").putValue("testDate", Date(System.currentTimeMillis()))
        )
    }



    fun login1Click(view: View) {

        val traits = Traits()
        traits.putEmail("foo2@foo.com")
        traits.putName("FooName")
        traits.putPhone("+141555512342")
        traits.putGender("M")
        traits["occupation"] = "racer"
        Analytics.with(applicationContext).identify("foo2@foo.com", traits, null)



    }

    fun login2Click(view: View) {

        val traits = Traits()
        traits.putEmail("foo1@foo.com")
        traits.putName("FooName")
        traits.putPhone("+141555512234")
        traits.putGender("M")
        traits["occupation"] = "Teacher"
        Analytics.with(applicationContext).identify("foo1@foo.com", traits, null)

    }


    fun push_profile(view: View) {

        //          profileUpdate["Email"] = "andy@gmail.com" // Email address of the user

        val calendar = Calendar.getInstance()


        calendar.time = Date() // Set your date object here

        calendar.set(Calendar.YEAR, 1992)
        calendar.set(Calendar.MONTH, Calendar.APRIL)
        calendar.set(Calendar.DAY_OF_MONTH, 10)
        calendar.time


        val traits = Traits()
        traits.putEmail("foo@foo.com")
        traits.putName("FooName")
        traits.putPhone("+14155551234")
        traits.putGender("M")
        traits.putBirthday(calendar.time)
        traits["occupation"] = "racer"
        Analytics.with(applicationContext).identify("foo@foo.com", traits, null)

    }
    fun logout(view: View) {

        val stuff = ArrayList<String>()
        stuff.add("bag")
        stuff.add("shoes")
        cleverTapDefaultInstance?.addMultiValueForKey("mystuff", "tie")

    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        Log.e("load", "called")
        // On Android 12, Raise notification clicked event when Activity is already running in activity backstack
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            cleverTapDefaultInstance?.pushNotificationClickedEvent(intent!!.extras)
        }
    }

}
