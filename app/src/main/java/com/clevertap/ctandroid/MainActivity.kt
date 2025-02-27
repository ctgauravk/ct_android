        package com.clevertap.ctandroid

        //import com.mparticle.MPEvent
        //import com.mparticle.MParticle
        //import com.mparticle.identity.BaseIdentityTask
        //import com.mparticle.identity.IdentityApiRequest
        import android.annotation.SuppressLint
        import android.content.Intent
        import android.os.Build
        import android.os.Bundle
        import android.util.Log
        import android.view.View
        import android.widget.Button
        import android.widget.EditText
        import androidx.appcompat.app.AppCompatActivity
        import androidx.lifecycle.MutableLiveData
        import com.clevertap.android.sdk.CleverTapAPI
        import com.clevertap.android.sdk.InAppNotificationListener
        import com.clevertap.android.sdk.inapp.CTInAppNotification
         import com.google.firebase.analytics.FirebaseAnalytics
        import com.google.gson.Gson
        import com.leanplum.Leanplum
        import com.leanplum.LeanplumInboxMessage
        import java.util.Calendar
        import java.util.Date
        import java.util.Objects


        class MainActivity : AppCompatActivity(), InAppNotificationListener  {



            private var mFirebaseAnalytics: FirebaseAnalytics? = null
            val LOCATION_REQUEST = 100
            var btn1: Button? =null
            var login1: Button? =null
            var login2: Button? =null
            var logout: Button? =null
            var email: EditText? = null
            var phone: EditText? = null
            var id: EditText? = null
            private val PERMISSION_NOTIFICATION = 101

            //    var myWebView: WebView? = null
//            var cleverTapDefaultInstance: CleverTapAPI? = null
            @SuppressLint("SetJavaScriptEnabled")
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)




//                cleverTapDefaultInstance = CleverTapAPI.getDefaultInstance(applicationContext)
//
//                cleverTapDefaultInstance?.inAppNotificationListener = this


                mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)

//                Log.e("app", Gson().toJson(cleverTapDefaultInstance?.getCleverTapID {
//                    Log.e("app", cleverTapDefaultInstance?.cleverTapID.toString())
//
//
//                }))

//                cleverTapDefaultInstance?.getCleverTapID {
//
//                    Log.e("===========id",  cleverTapDefaultInstance?.cleverTapID.toString())
//
//                    mFirebaseAnalytics?.setUserProperty("ct_objectId",
//                        Objects.requireNonNull(CleverTapAPI.getDefaultInstance(this))?.cleverTapID
//                    )
//                }

        //        cleverTapDefaultInstance?.rec

                //Set Log level to VERBOSE

//                cleverTapDefaultInstance?.enableDeviceNetworkInfoReporting(true)

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
                email = findViewById(R.id.email)
                id = findViewById(R.id.identity)
                phone =findViewById(R.id.phone)

                btn1?.text = getString(R.string.click)

        //        Analytics.with(applicationContext).track(
        //            "SegmentEvent",
        //            Properties().putValue("value", "testValue").putValue("testDate", Date(System.currentTimeMillis()))
        //        )

        //        val customAttributes: MutableMap<String, String> = HashMap()



        //        customAttributes["destination"] = "test from"
        //        val event = MPEvent.Builder("Navbar Clicked", MParticle.EventType.Navigation)
        //            .customAttributes(customAttributes)
        //            .build()
        //        MParticle.getInstance()?.logEvent(event)
            }


            fun buttonClick(view: View) {

//                cleverTapDefaultInstance?.pushEvent("Custom event")
                val customAttributes = mapOf(
                    "category" to "Destination Intro",
                    "title" to "Paris"
                )

                val inbox = Leanplum.getInbox() // instantiate new Inbox object

                var all = inbox.allMessages();

                val messages = all as List<LeanplumInboxMessage>


        //        val event = MPEvent.Builder("React Web Event", MParticle.EventType.Other)
        //            .customAttributes(customAttributes)
        //            .build()
        //
        //        MParticle.getInstance()?.logEvent(event)
        //        Analytics.with(applicationContext).track(
        //            "push event",
        //            Properties().putValue("prop1", "value1").putValue("testDate", Date(System.currentTimeMillis()))
        //        )
            }



            fun login1Click(view: View) {
//
//        //        val traits = Traits()
//        //        traits.putEmail("foo2@foo.com")
//        //        traits.putName("FooName")
//        //        traits.putPhone("+141555512342")
//        //        traits.putGender("M")
//        //        traits["occupation"] = "racer"
//        //        Analytics.with(applicationContext).identify("foo2@foo.com", traits, null)
//
//
//                val customAttributes = mapOf(
//                    "category" to "Destination Intro",
//                    "title" to "Paris"
//                )
//
//        //        val event = MPEvent.Builder("mParticle Event", MParticle.EventType.Other)
//        ////            .customAttributes(customAttributes)
//        //            .build()
//        //
//        //        MParticle.getInstance()?.logEvent(event)

                val profileUpdate = HashMap<String, Any>()

                Log.e("TAG", email?.text.toString() + " " + phone?.text.toString() + "   " + id?.text.toString())

                if (email?.text.toString().trim().isNotEmpty()){
                    profileUpdate["Email"] = email?.text.toString()
                }
                if (id?.text.toString().trim().isNotEmpty()){
                    profileUpdate["Identity"] = id?.text.toString()
                }
                if (phone?.text.toString().trim().isNotEmpty()){
                    profileUpdate["Phone"] = phone?.text.toString()
                }
                val calendar = Calendar.getInstance()
                calendar.time = Date()

                calendar.set(Calendar.YEAR, 1992)
                calendar.set(Calendar.MONTH, Calendar.APRIL)
                calendar.set(Calendar.DAY_OF_MONTH, 10)
                calendar.time
                profileUpdate["DOB"] =
                    calendar.time

//                cleverTapDefaultInstance?.onUserLogin(profileUpdate)
            }

            fun push_profile(view: View) {
                val profileUpdate = HashMap<String, Any>()
                //          profileUpdate["Email"] = "andy@gmail.com" // Email address of the user
                if (email?.text.toString().trim().isNotEmpty()){
                    profileUpdate["Email"] = email?.text.toString()
                }
                if (id?.text.toString().trim().isNotEmpty()){
                    profileUpdate["Identity"] = id?.text.toString()
                }
                if (phone?.text.toString().trim().isNotEmpty()){
                    profileUpdate["Phone"] = phone?.text.toString()
                }

//                cleverTapDefaultInstance?.pushProfile(profileUpdate)
            }

            fun login2Click(view: View) {
        //        val identityRequest = IdentityApiRequest.withEmptyUser()
        //            .email("foo@example.com")
        //            .customerId("123456")
        //            .build()
        //        MParticle.getInstance()?.Identity()?.login(identityRequest)
        //
        //        val traits = Traits()
        //        traits.putEmail("foo1@foo.com")
        //        traits.putName("FooName")
        //        traits.putPhone("+141555512234")
        //        traits.putGender("M")
        //        traits["occupation"] = "Teacher"
        //        Analytics.with(applicationContext).identify("foo1@foo.com", traits, null)


//                cleverTapDefaultInstance?.pushEvent("InApp Event")

            }


            fun push_profilprofile(view: View) {

                //          profileUpdate["Email"] = "andy@gmail.com" // Email address of the user

                val calendar = Calendar.getInstance()


                calendar.time = Date() // Set your date object here

                calendar.set(Calendar.YEAR, 1992)
                calendar.set(Calendar.MONTH, Calendar.APRIL)
                calendar.set(Calendar.DAY_OF_MONTH, 10)
                calendar.time


        //        val traits = Traits()
        //        traits.putEmail("foo@foo.com")
        //        traits.putName("FooName")
        //        traits.putPhone("+14155551234")
        //        traits.putGender("M")
        //        traits.putBirthday(calendar.time)
        //        traits["occupation"] = "racer"
        //        Analytics.with(applicationContext).identify("foo@foo.com", traits, null)

        //        val identifyTask = BaseIdentityTask()
        //            .addFailureListener { identityHttpResponse ->
        //                //handle failure - see below
        //            }.addSuccessListener { identityApiResult ->
        //                val user = identityApiResult.user
        //                user.setUserAttribute("dob", calendar.time)
        //                user.setUserAttribute("custom", "data")
        //            }


        //        val current = MParticle.getInstance()?.Identity()?.currentUser
        //        if (current != null) {
        //            current.setUserAttribute("Name", "Gaurav")
        //            current.setUserAttribute("gender", "M")
        //            //String dob = "1990-01-01"; // Use the format YYYY-MM-DD
//                    current.setUserAttribute("dob", calendar.time)
        //            current.setUserAttribute("Phone",+919234567801  )
        //        }



            }
            fun logout(view: View) {

                val stuff = ArrayList<String>()
                stuff.add("bag")
                stuff.add("shoes")
//                cleverTapDefaultInstance?.addMultiValueForKey("mystuff", "tie")

            }

            override fun onNewIntent(intent: Intent?) {
                super.onNewIntent(intent)

                Log.e("load", "called")
                // On Android 12, Raise notification clicked event when Activity is already running in activity backstack
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
//                    cleverTapDefaultInstance?.pushNotificationClickedEvent(intent!!.extras)
                }


            }



            override fun onResume() {


                Log.e("TAG", "onResume: called" )
                if (!dismissDialog) {
                    Log.e("TAG", "inside if: " )
//                    cleverTapDefaultInstance?.pushEvent("InApp Event")
                }

                dismissDialog=false

                super.onResume()



            }

            override fun beforeShow(p0: MutableMap<String, Any>?): Boolean {

                return true
            }

            override fun onShow(@SuppressLint("RestrictedApi") p0: CTInAppNotification?) {
            }

            private var dismissDialog = false
            override fun onDismissed(p0: MutableMap<String, Any>?, p1: MutableMap<String, Any>?) {
                dismissDialog = true

            }
        }
