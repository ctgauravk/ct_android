package com.clevertap.ctandroid

import android.annotation.SuppressLint
import android.app.NotificationManager
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.clevertap.android.sdk.CleverTapAPI
import com.clevertap.android.sdk.displayunits.DisplayUnitListener
import com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnit
import com.google.gson.Gson
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import android.webkit.WebSettings

import android.webkit.WebChromeClient
import com.clevertap.android.sdk.pushnotification.CTPushNotificationListener


class MainActivity : AppCompatActivity(), DisplayUnitListener/*, CTPushNotificationListener*/ {

    val LOCATION_REQUEST = 100
    var btn1: Button? =null
    var login1: Button? =null
    var login2: Button? =null
    var logout: Button? =null

    //    var myWebView: WebView? = null
    var cleverTapDefaultInstance: CleverTapAPI? = null
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cleverTapDefaultInstance = CleverTapAPI.getDefaultInstance(applicationContext)

//        Log.e("app",Gson().toJson(cleverTapDefaultInstance?.getCleverTapID()))

//        CleverTapAPI.getDefaultInstance(applicationContext)?.apply {
//            ctPushNotificationListener = this@MainActivity
//        }

        cleverTapDefaultInstance?.apply {
            setDisplayUnitListener(this@MainActivity)
        }
         //Set Log level to VERBOSE

        cleverTapDefaultInstance?.enableDeviceNetworkInfoReporting(true)

        // each of the below mentioned fields are optional
        val profileUpdate = HashMap<String, Any>()
//        profileUpdate["Name"] = "Rae" // String
        profileUpdate["Identity"] = "U#687" // String or number
//        profileUpdate["Email"] = "rae@gmail.com" // Email address of the user
//         profileUpdate["Gender"] = "Female" // Can be either M or F
        val calendar = Calendar.getInstance()
        calendar.time = Date() // Set your date object here
        calendar.set(Calendar.YEAR, 1992)
        calendar.set(Calendar.MONTH, Calendar.APRIL)
        calendar.set(Calendar.DAY_OF_MONTH, 10)
        calendar.time
        profileUpdate["DOB"] =
            calendar.time

         /*Date of Birth. Set the Date object to the appropriate value first
 optional fields. controls whether the user will be sent email, push etc.
 optional fields. controls whether the user will be sent email, push etc.
        profileUpdate["MSG-email"] = false // Disable email notifications
        profileUpdate["MSG-push"] = true // Enable push notifications
        profileUpdate["MSG-sms"] = false // Disable SMS notifications
        profileUpdate["MSG-whatsapp"] = true // Enable WhatsApp notifications
        val stuff = ArrayList<String>()
        stuff.add("Liverpool")
        stuff.add("Star Sports")
        stuff.add("India")
        profileUpdate["My Leagues"] = stuff;



        val stuff2 = ArrayList<String>()
        stuff2.add("bag")
        stuff2.add("shoes")
        profileUpdate["My"] = stuff2;


       Log.e("token",
           cleverTapDefaultInstance?.getDevicePushToken
               (com.clevertap.android.sdk.pushnotification.PushConstants.PushType.FCM)!!)
        ArrayList of Strings


        profileUpdate["MyStuff"] = stuff //ArrayList of Strings
        val otherStuff = arrayOf("Jeans", "Perfume")
        profileUpdate["MyStuff"] = otherStuff //String Array*/

        cleverTapDefaultInstance?.onUserLogin(profileUpdate)
        CleverTapAPI.getDefaultInstance(applicationContext)!!.incrementValue("totalgesture",10)

        CleverTapAPI.getDefaultInstance(applicationContext)!!.incrementValue("incvalue",10)

//        val pushprofile = HashMap<String, Any>()
//        profileUpdate["Name"] = "shrey" // String
//        profileUpdate["Identity"] = 150 // String or number
//        profileUpdate["Email"] = "shrey1@ct.com"

//        cleverTapDefaultInstance?.pushProfile(profileUpdate)

//        cleverTapDefaultInstance?.pushFcmRegistrationId(cleverTapDefaultInstance.getDevicePushToken
//            (com.clevertap.android.sdk.pushnotification.PushConstants.PushType.FCM)!!, true)

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

            CleverTapAPI.createNotificationChannel(applicationContext,"bpl",
                "Barclays Premier League","English top tier",
                4,true)
        }

//        Handler(Looper.myLooper()!!).postDelayed({
//            // code
//            Log.e("TAG", "delayed ")
//            cleverTapDefaultInstance?.pushEvent("native trigger")
//        }, 1000)
//        Handler(Looper.myLooper()!!).postDelayed({
//            // code
//            Log.e("TAG", "delayed 2")
//            cleverTapDefaultInstance?.pushEvent("product trigger") },
//            2000)


//          myWebView = findViewById(R.id.webview)
//        myWebView?.webChromeClient = WebChromeClient()
//        myWebView?.loadUrl("http://thebundlers.com/TEST/CT/")
//        val webSettings = myWebView?.settings
//        webSettings?.javaScriptEnabled = true
//        myWebView?.addJavascriptInterface(WebViewInterface(this), "Android")
//        myWebView?.addJavascriptInterface((),"Android")

        btn1 = findViewById(R.id.button)
        btn1?.text = getString(R.string.click)


        
//        myWebView?.addJavascriptInterface(   WebViewInterface.setContext(),"Android");



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
                Toast.makeText(applicationContext, "user $j", Toast.LENGTH_LONG).show()

                j++

//                prepareDisplayView(unit)
            }
        }
     }

    private fun isLocationPermissionGranted(): Boolean {
        return if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION,

                ),
                LOCATION_REQUEST
            )
            false
        } else {
            true
        }
    }

    fun buttonClick(view: View) {
        Log.e("TAG", "buttonClick: ")
        cleverTapDefaultInstance?.pushEvent("Button Click")
//        {"evtName":"Screen View","evtData":{"Screen Name":"Category Screen",
//            "Loyalty No":"6270012000001466496","Email":"an6@gmail.com","Customer Id":"350001",
//            "phone":"+96508220026",
//            "Wallet Id":"MTRDRDFCQ0JFQUQ3REU1QzUwQjFDMjdEMUY2NEY1ODlDQkM0NjdBMkUzQjQ2ODhCRjBERjZFRUVC\nNzVDRTk2RTE5NDI4QjhBNUFBNzU3MTRENUU5ODQyNTI3RTVBQTE1NUM1MUVDMDE4QjdBQzMwM0M5\nRDVBOUNGRjJFQjdBOTQ=",
//            "Substore Id":"35","Name":"ghh ftyhj"},
//            "s":1659960765,"pg":4,"type":"event","ep":1659960829,"f":false,"lsl":425,"dsync":false}
//                cleverTapDefaultInstance?.pushEvent("Screen View")
//
//        val prodViewedAction = mapOf(
////                        "l_number" to 6270012000001467594,
//            "l_number" to "6270012000001467594",
//            "Customer Id" to "M350001",
//            "phone" to "+96508220026",
//            "new_won" to "6270012000001467594",
//            "fghjkl" to "TSC-6270012000001467594",
//            "Name" to "ghh ftyhj")
//        cleverTapDefaultInstance?.pushEvent("Screen View", prodViewedAction)

    }


    fun login1Click(view: View) {
        val profileUpdate = HashMap<String, Any>()
        profileUpdate["Name"] = "darwin" // String
        profileUpdate["Identity"] = "dn9" // String or number
        profileUpdate["Email"] = "darwin@gmail.com" // Email address of the user
        profileUpdate["Gender"] = "M" // Can be either M or F
        val calendar = Calendar.getInstance()
        calendar.time = Date() // Set your date object here

        calendar.set(Calendar.YEAR, 1992)
        calendar.set(Calendar.MONTH, Calendar.APRIL)
        calendar.set(Calendar.DAY_OF_MONTH, 10)
        calendar.time
        profileUpdate["DOB"] =
            calendar.time
        cleverTapDefaultInstance?.onUserLogin(profileUpdate)

    }

    fun login2Click(view: View) {
        val profileUpdate = HashMap<String, Any>()
        profileUpdate["Name"] = "Fabio" // String
        profileUpdate["Identity"] = "FC19" // String or number
        profileUpdate["Email"] = "fabio@gmail.com" // Email address of the user
        profileUpdate["Gender"] = "M" // Can be either M or F
        val calendar = Calendar.getInstance()
        calendar.time = Date() // Set your date object here

        calendar.set(Calendar.YEAR, 1992)
        calendar.set(Calendar.MONTH, Calendar.APRIL)
        calendar.set(Calendar.DAY_OF_MONTH, 10)
        calendar.time
        profileUpdate["DOB"] =
            calendar.time
        cleverTapDefaultInstance?.onUserLogin(profileUpdate)
    }


    fun push_profile(view: View) {
        val profileUpdate = HashMap<String, Any>()
//          profileUpdate["Email"] = "andy@gmail.com" // Email address of the user
        profileUpdate["Gender"] = "F" // Can be either M or F
        val calendar = Calendar.getInstance()
        val calendar2 = Calendar.getInstance()

        calendar.time = Date() // Set your date object here
        calendar2.time = Date()
        calendar.set(Calendar.YEAR, 1992)
        calendar.set(Calendar.MONTH, Calendar.APRIL)
        calendar.set(Calendar.DAY_OF_MONTH, 10)
        calendar.time
        profileUpdate["DOB"] =
            calendar.time

        calendar2.set(Calendar.YEAR, 2022)
        calendar2.set(Calendar.MONTH, Calendar.OCTOBER)
        calendar2.set(Calendar.DAY_OF_MONTH, 31)
        calendar2.set(Calendar.HOUR, 12)
        calendar2.set(Calendar.MINUTE, 0)
        calendar2.set(Calendar.SECOND, 0)


        calendar2.time
        profileUpdate["Expiry Date of Subscription"] =
            calendar2.time

        profileUpdate["occupation"] = "racer"
        cleverTapDefaultInstance?.pushProfile(profileUpdate)
    }

    fun logout(view: View) {
        cleverTapDefaultInstance?.pushEvent("Button Click")
    }



//    override fun onNotificationClickedPayloadReceived(payload: HashMap<String?, Any?>?) {
//        //Use your custom logic for  the payload
//        Log.e("Payload Main", "onNotificationClickedPayloadReceived = $payload")
//
//    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        Log.e("load", "called")
        // On Android 12, Raise notification clicked event when Activity is already running in activity backstack
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            cleverTapDefaultInstance?.pushNotificationClickedEvent(intent!!.extras)
        }
    }
}

//2022-01-28 11:19:02.082 26045-26045/? D/CleverTap: Referrer data: {
//        "us": "google-play",
//        "um": "organic"
//    }

//2022-01-28 11:26:52.773 29682-29682/? D/CleverTap: Referrer data: {
//        "us": "google-play",
//        "um": "organic"
//    }

//"https://eu1-sharedresources-platformstorages3bucket-np5wb2kjrbki.s3.eu-west-1.amazonaws.com/catalog/1517477760/1660026737.csv?X-Amz-Security-Token=IQoJb3JpZ2luX2VjEL7%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaCWV1LXdlc3QtMSJGMEQCIFZ%2BFSHElst7e%2BBGuzsN%2FRJC2NrrRUChCqu3aEGZeVs5AiA2AlIOhwgoLTsehWyCJ78rHCvMVjI%2BJzf4LYVNUIhZUCrSBAgnEAAaDDA2MjQ4NDI2MDA5MiIMldPbBElVzW5%2F4xuIKq8EY0oXH%2BkcNX3lWRvv9bomNTxJcVJNUcQtXdNoIWR4q9Vyq%2F%2FEkkohFJGFrcBhr%2BuCDRJ10%2FM%2FtlagBn3IHurzhrhD4OEz6Wqt3UH83ePKpbmxZpU8NY4gl1OkteGNMrQKyfzAIinpeRVK4gF%2FL4POLczP2w4YYN%2Fg2Mm19id89Bf3N%2FqtH1ev0FwYhe34%2FwjuynR%2FsQlWppJBogxZb4oqoI5tQ2P6KVA4gTm%2FRYETp9rlArJyuId9cPWmqyTD3Ew3c3Y3iiu5nunt2zzJZ7lule7khrNcXBMhj6EvfQ2j%2Bq1FbsjQH22dkGiYLAdgqKoKNzZWBqQTS7BP8bUp56j%2Fz%2B89Feq62tJAzCFC2EXfcp7vXfjCRpX3aVcpgatUxCwfL0MqFU9uTOTfF952Si4SkB1VnWEG6GP8q8DgGfkyWx51jl7%2Fld2kc0mFu1WRkLAtNRFAXXYldZakmkxR2i6uTt0KolAoOREcxgawEMpQVackIo4ZOyjzRQ%2FB2JKHmcChfgtozwaR9x8tJBoz3FZNNXR1JToe5DQJvd6uIfgQGK84LJFbt0c7ESdE%2BG7yNYnaOHeaoOaBkQVj0RwOMztADJGXW4rw7WkXTdeihYSkBOIuX73VuWxQARLZoM2fPwwO5AtsmPW7LmrON1wBCIxNKRj2o6xQojn0WxVMk7jf14Lbr7p57p9khcm3zjuk1iygC5jT7zSowPcFW3daoQf1vVsmrHi8lWbU6OiuPiMkVzDl5ceXBjqqAarXb9TaMKfv9iFGX3mOK3Mi0HwRQ7KT1VDa8wozFLcc5yeSQ2zQvFaIfW786qyRysnvSnfzJfvY1Z59JYHT8yYFGQqnQv9ae6rzx7uUdZO2ptJ6tAv3ogiGc85DkZRdrDrkJf1xYvzi6z3R%2FyprkYYzH7%2FKuG5%2BoHSEAgaJkCyNmKWOc8g7bmsOZez%2FKXLk6T15dVosNHC%2FPVtG5g%2Frs1JuLvrMuLfixIGL&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20220809T063217Z&X-Amz-SignedHeaders=content-type%3Bhost&X-Amz-Expires=172799&X-Amz-Credential=ASIAQ5DC2ET6FQM7NGEZ%2F20220809%2Feu-west-1%2Fs3%2Faws4_request&X-Amz-Signature=5d31bd812e213edf9ac77c4258245dbb377203386fb4968cd2ac98b2fb723e6e"

//curl -X POST "https://eu1.api.clevertap.com/upload_catalog_completed" -H 'Cache-Control:no-
//cache' -H 'Content-Type:application/json' -H "X-CleverTap-Account-Id:W67-774-7Z5Z" -H "X-
//CleverTap-Passcode: 93bfd52844a7458484986b3ffde7fcea" -H'cache-control:no-cache' -d'{"name":"gaurav_test_catalog","email":"gaurav.singh@clevertap.com","creator":"Gaurav","URL":""https://eu1-sharedresources-platformstorages3bucket-np5wb2kjrbki.s3.eu-west-1.amazonaws.com/catalog/1517477760/1660026737.csv?X-Amz-Security-Token=IQoJb3JpZ2luX2VjEL7%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaCWV1LXdlc3QtMSJGMEQCIFZ%2BFSHElst7e%2BBGuzsN%2FRJC2NrrRUChCqu3aEGZeVs5AiA2AlIOhwgoLTsehWyCJ78rHCvMVjI%2BJzf4LYVNUIhZUCrSBAgnEAAaDDA2MjQ4NDI2MDA5MiIMldPbBElVzW5%2F4xuIKq8EY0oXH%2BkcNX3lWRvv9bomNTxJcVJNUcQtXdNoIWR4q9Vyq%2F%2FEkkohFJGFrcBhr%2BuCDRJ10%2FM%2FtlagBn3IHurzhrhD4OEz6Wqt3UH83ePKpbmxZpU8NY4gl1OkteGNMrQKyfzAIinpeRVK4gF%2FL4POLczP2w4YYN%2Fg2Mm19id89Bf3N%2FqtH1ev0FwYhe34%2FwjuynR%2FsQlWppJBogxZb4oqoI5tQ2P6KVA4gTm%2FRYETp9rlArJyuId9cPWmqyTD3Ew3c3Y3iiu5nunt2zzJZ7lule7khrNcXBMhj6EvfQ2j%2Bq1FbsjQH22dkGiYLAdgqKoKNzZWBqQTS7BP8bUp56j%2Fz%2B89Feq62tJAzCFC2EXfcp7vXfjCRpX3aVcpgatUxCwfL0MqFU9uTOTfF952Si4SkB1VnWEG6GP8q8DgGfkyWx51jl7%2Fld2kc0mFu1WRkLAtNRFAXXYldZakmkxR2i6uTt0KolAoOREcxgawEMpQVackIo4ZOyjzRQ%2FB2JKHmcChfgtozwaR9x8tJBoz3FZNNXR1JToe5DQJvd6uIfgQGK84LJFbt0c7ESdE%2BG7yNYnaOHeaoOaBkQVj0RwOMztADJGXW4rw7WkXTdeihYSkBOIuX73VuWxQARLZoM2fPwwO5AtsmPW7LmrON1wBCIxNKRj2o6xQojn0WxVMk7jf14Lbr7p57p9khcm3zjuk1iygC5jT7zSowPcFW3daoQf1vVsmrHi8lWbU6OiuPiMkVzDl5ceXBjqqAarXb9TaMKfv9iFGX3mOK3Mi0HwRQ7KT1VDa8wozFLcc5yeSQ2zQvFaIfW786qyRysnvSnfzJfvY1Z59JYHT8yYFGQqnQv9ae6rzx7uUdZO2ptJ6tAv3ogiGc85DkZRdrDrkJf1xYvzi6z3R%2FyprkYYzH7%2FKuG5%2BoHSEAgaJkCyNmKWOc8g7bmsOZez%2FKXLk6T15dVosNHC%2FPVtG5g%2Frs1JuLvrMuLfixIGL&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20220809T063217Z&X-Amz-SignedHeaders=content-type%3Bhost&X-Amz-Expires=172799&X-Amz-Credential=ASIAQ5DC2ET6FQM7NGEZ%2F20220809%2Feu-west-1%2Fs3%2Faws4_request&X-Amz-Signature=5d31bd812e213edf9ac77c4258245dbb377203386fb4968cd2ac98b2fb723e6e","replace":false}'

//$(curl --request PUT --upload-file "/Users/gaurav.singh/Downloads/ProductSameRow.csv"
// "//https://eu1-sharedresources-platformstorages3bucket-np5wb2kjrbki.s3.eu-west-1.amazonaws.com/catalog/1517477760/1660024692.csv?X-Amz-Security-Token=IQoJb3JpZ2luX2VjEL3%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaCWV1LXdlc3QtMSJHMEUCIQC3HKdCMl9Gfr8rzw5ky37kECkanywoS%2B2592Vbgr%2F0SAIgP8ulH%2FRYOGHiqUyHqXLf7QtSsxVEfohgPcswEMz1F5Qq0gQIJhAAGgwwNjI0ODQyNjAwOTIiDFXPU%2Bsrj98FuxVjMyqvBHikhVJA8Xt05CCPpgCIFxESFnNNXUltCeXLWhqAID%2FxanGFmlWqAu9MQ%2F4IzD%2FYZtmggVltVmXzmF0J06BcnDGtsYZiW08BataCclGAbbRqqMdDHabbQvNEhBxfNwG%2BWJjTgEDfSMyPK67zJIzKkjGmziWNehFKsmjK9O9aC0iOpc6lGXhb3UsjoAH%2FsriUUKbIdx5vug1xNWup0iINYQEC6qSXFh9XouD75cyiVCVSKhB%2FAHyCtS1V%2BaarLorPijguehMApIIA4yT76mhszxmb8baMHSFJSvs1pQpC7WcMCW2zYoZdPh%2Fsr7CwyV24tKE5lHelNBjj93do9%2B76wETjCkYhxykxIirvJynH0sjQ8aarxkfVnyNQOb4%2BAYVjVP2MSV44ObSClP5Ffe3uK6E7f3EGZDyuFdass4cMqKJpHDahB9TuClpGJ3zQw%2FB8wXmfOke8uHxdkcNdZCgZraB32fqCizf9QfZHUNHhyNawGxHQfY3BHYw%2Fs71ZRPn1dlq%2BUxWo%2B9OYEJa0WtWslYO0KjYpbwMTlYKAvglOFWfQBgqrQYm%2FA2%2Bk4YTSxrHAI4GY2z07KPpXL%2FXvpjyRB7hdrXMgz8xRr6VwVnNRUIw5Osg9lu%2BL8jeQv1QtzBmO2E%2FvXZkUTKJpMAE%2FKI0DQ62EFeasLUqe7MlzTLIzyxGczIiVQg8AOQM49NEiVk%2FU2DnGq9kDqIunOUlvQVYtm1iiw1dIr55IBbtmNLr%2Fo0gw88nHlwY6qQFE6ozi%2Bn069TJGiKitf%2F0tHI1D6%2BAYIuSzo2dgZOevY2zvMhGlS%2FBNmfgZQ4hegMbFub%2BeuK6A%2F7t%2BsSAl7Dyfg3Jeh6VxTgpF7OPHOo1HURNNZvROexPijIb0JJttgp%2BZDq1NQ1qKLvsmm4WtM1JrDSMcB5yZpC4I1052eCLvBclMp%2BGiTYxKSw%2F5PRS4yOqRoiSXVch7eZgCTgbWyfzfREdrroXB7tgf&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20220809T055812Z&X-Amz-SignedHeaders=content-type%3Bhost&X-Amz-Expires=172799&X-Amz-Credential=ASIAQ5DC2ET6MKZMFUH7%2F20220809%2Feu-west-1%2Fs3%2Faws4_request&X-Amz-Signature=09e835be2174d6b3ba27a6fbc2195a51ff5e2d3a282eea87f131fff5678dc895
//")

// curl -X POST "https://eu1.api.clevertap.com/upload_catalog_completed" -H 'Cache-Control: no-cache' -H 'Content-Type:application/json' -H "X-CleverTap-Account-Id: TEST-RZ7-Z94-K95Z" -H "X-CleverTap-Passcode: EVQ-ZUA-GXKL" -H 'cache-control:no-cache' -d '{"name":"same","email":"gaurav.singh@clevertap.com","creator":"Gaurav","url": "https://eu1-sharedresources-platformstorages3bucket-np5wb2kjrbki.s3.eu-west-1.amazonaws.com/catalog/1593491712/1660046677.csv?X-Amz-Security-Token=IQoJb3JpZ2luX2VjEMP%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaCWV1LXdlc3QtMSJIMEYCIQDmsOAAoHLi%2Bs8n%2FhOYZgpZGMgZOetsQARh3E5p4rb1igIhAL64SBUGdNrhSTMuRB2s8CJz2DNlwjwk91iRkpZF6xJRKtIECCwQABoMMDYyNDg0MjYwMDkyIgxdsbtyRwTZ5O4kj0MqrwTnKQe6vxJJjjyjo%2F%2FjUwBRq2AcsM1CnhCvJshiOwitKyF7hcuB8VICZ11qSwSI7BfSkN%2BatPu82jOYbdcTzyMPLbvWS9a7k%2FLqlH7w%2F8BxrhfnzGkeX%2Fvahq5FiUGsCQa1UWNL7PhOU5g3i89CdGTsG4mG5P3KBLdgn4QTFSRf9a110fAkM5V%2FTAVlp%2FPF02VhRMtBtZEK%2Fmsl9B2A1ypzZqLD4VVnI%2B6nrDPBx4Lapm8JRrx4LwTRy944z5gQKScQnU4WFYJMFlO0tdyfleRxsguou%2FI7Lm3Wiill0B52WkgZToz2f7fYU2n82b7uqm8xEmYwngJXmLDhnYjETQGFxjPTvKnTqvHNE4%2B2vYzXouKoQEXLbuJjKeFnYj5jO3BOaqM1ax9ZtFf9COwzxbMqnFk%2Fn%2BpSNSGyn7otDF2WZ3Oc%2FJYa9PdeGO2FMo6r%2FWJZNrhlv3Luy%2B3V7wEsH7MSPFxM%2F9eBWH9gBpw9IZ7P%2FoB4oIcCmPXe%2F%2F59J%2B1SWjMviJj41BQ93bsHX6d6Vk%2BTKE9jjvrTGs8FpcPMmg%2FPJo67sHZ6pt0VZbKGxczNW0jrtUcWVHyMRIkCK%2BGBVP9pF8cY1ncIzKaOLgTBc43hztV3fvwJjlpptoRPUQgV9KjQnjumKaOJHPtA6nRO5VuojuerX2fWAxWRqewS3Fh372Sf2dFmXsMQQol4ZUO20oC0MalHIg8zH5JHzTU7fkruwi%2B2LQwGuAE3CSd4CDxJMJzxyJcGOqgB4iGQloxJn9D%2BHB2DZBuKUB74cI%2FZ5j6SPCEDACyv0%2BvszQcgBW0yer6%2Fg%2BI%2FCm%2F2vxA8k3JboMCKPpXshY1yo3qoN19cHfR4%2B9YjpfgDJY%2Bn0xpDVO5oFnVJh9KHF2KtZU2clefF07KuWYFgaqNRhiXfZkbFOgljimq1CJ7p3mrQ1Mz80sEbFavr944Feg2if5%2B5HYkzgZOZauHPGPFUWpUFaMLnNLNU&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20220809T120437Z&X-Amz-SignedHeaders=content-type%3Bhost&X-Amz-Expires=172799&X-Amz-Credential=ASIAQ5DC2ET6MRBL2KXB%2F20220809%2Feu-west-1%2Fs3%2Faws4_request&X-Amz-Signature=547b5222258004c005a8062fc7e8dd003174c453329d2c578667788abf39b7f1","replace":false}'
