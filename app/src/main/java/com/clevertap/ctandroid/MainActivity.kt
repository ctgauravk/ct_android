package com.clevertap.ctandroid

import android.app.NotificationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.clevertap.android.sdk.CleverTapAPI
import com.clevertap.android.sdk.events.EventDetail
import com.clevertap.android.sdk.inbox.CTInboxMessage
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
//__gb17172eb7bba490b9530ef300aa87a3d
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         var cleverTapDefaultInstance: CleverTapAPI? = null
        cleverTapDefaultInstance = CleverTapAPI.getDefaultInstance(applicationContext)



        CleverTapAPI.getDefaultInstance(applicationContext)?.enableDeviceNetworkInfoReporting(true);

        // each of the below mentioned fields are optional
        val profileUpdate = HashMap<String, Any>()
        profileUpdate["Name"] = "Firmino" // String
//        profileUpdate["Identity"] = 30061965 // String or number
        profileUpdate["Email"] = "rf9@gmail.com" // Email address of the user
//        profileUpdate["Phone"] = "+14130061955" // Phone (with the country code, starting with +)
        profileUpdate["Gender"] = "M" // Can be either M or F
        val calendar = Calendar.getInstance()
        calendar.time = Date() // Set your date object here

        calendar.set(Calendar.YEAR, 1992)
        calendar.set(Calendar.MONTH, Calendar.APRIL)
        calendar.set(Calendar.DAY_OF_MONTH, 10)
        calendar.time
        profileUpdate["DOB"] = calendar.time // Date of Birth. Set the Date object to the appropriate value first
// optional fields. controls whether the user will be sent email, push etc.
// optional fields. controls whether the user will be sent email, push etc.
        profileUpdate["MSG-email"] = false // Disable email notifications
        profileUpdate["MSG-push"] = true // Enable push notifications
        profileUpdate["MSG-sms"] = false // Disable SMS notifications
        profileUpdate["MSG-whatsapp"] = true // Enable WhatsApp notifications
        val stuff = ArrayList<String>()
        stuff.add("Liverpool")
        stuff.add("Star Sports")
        stuff.add("India")
        profileUpdate["My Leagues"] = stuff;


//        cleverTapDefaultInstance?.pushEvent("in app call")

        val stuff2 = ArrayList<String>()
        stuff2.add("bag")
        stuff2.add("shoes")
        profileUpdate["My"] = stuff2;

//
//       Log.e("token",
//           cleverTapDefaultInstance?.getDevicePushToken
//               (com.clevertap.android.sdk.pushnotification.PushConstants.PushType.FCM)!!)
        //ArrayList of Strings


//        profileUpdate["MyStuff"] = stuff //ArrayList of Strings
//        val otherStuff = arrayOf("Jeans", "Perfume")
//        profileUpdate["MyStuff"] = otherStuff //String Array
        CleverTapAPI.getDefaultInstance(applicationContext)?.onUserLogin(profileUpdate)
//        CleverTapAPI.getDefaultInstance(applicationContext)?.pushEvent("multipleUser")
//        cleverTapDefaultInstance?.pushEvent("array property event", prodViewedAction)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            Log.e("Main", "onCreate: Called" )
            CleverTapAPI.createNotificationChannelGroup(applicationContext,
                "football", "ChampionsLeague")


            CleverTapAPI.createNotificationChannel(applicationContext,
                "euro", "Europe", "EuroCountry",
                NotificationManager.IMPORTANCE_MAX, "football", true)
//
//            CleverTapAPI.createNotificationChannel(applicationContext,"bpl",
//                "Barclays Premier League","English top tier",
//                NotificationManager.IMPORTANCE_MAX,true)

//            {"evtName":"App Launched","evtData":{"Build":"2865","Version":"5.17.0","OS Version":"12","SDK Version":40400,"Make":"samsung","Model":"SM-G975F","Carrier":"Vi India","useIP":false,"OS":"Android","wdt":2.57,"hgt":4.8,"dpi":560,"dt":1,"abckt":"active","cc":"in"},"s":1643281067,"pg":1,"type":"event","ep":1643281067,"f":false,"lsl":1233,"pai":"com.seatech.bluebird","dsync":true}
//2022-01-27 16:27:47.109 25297-25375/? D/CleverTap:6K9-955-9K6Z: Network retry #0
//2022-01-27 16:27:47.109 25297-25375/? D/CleverTap:6K9-955-9K6Z: Failure count is 0. Setting delay frequency to 1s
//2022-01-27 16:27:47.122 25297-25375/? D/CleverTap:6K9-955-9K6Z: Queued event: {"evtName":"wzrk_fetch","evtData":{"t":1},"s":1643281067,"pg":1,"type":"event","ep":1643281067,"f":false,"lsl":1233,"dsync":false}
//2022-01-27 16:27:47.122 25297-25375/? D/CleverTap:6K9-955-9K6Z: Network retry #0
//2022-01-27 16:27:47.122 25297-25375/? D/CleverTap:6K9-955-9K6Z: Failure count is 0. Setting delay frequency to 1s
//2022-01-27 16:27:47.185 25297-25375/? D/CleverTap:6K9-955-9K6Z: Queued event: {"data":{"action":"register","id":"cb1HYzwQSEO1W0fGVvf6Dq:APA91bGjBc666N0t5wdHCULE-QIHFIAQmpRa0UJ5oshUybYgg0s1AS6Por1t_xUbJ5C-YfEXykEJEwFBs3z9hzVuSoDMIFCSzuDoiRGSe2PAk0Eb5HOPsWI5iEyricDnJMoqkq3vzIF_","type":"fcm"},"s":1643281067,"pg":1,"type":"data","ep":1643281067,"f":false,"lsl":1233,"dsync":false}
//2022-01-27 16:27:47.185 25297-25375/? D/CleverTap:6K9-955-9K6Z: Network retry #0
//2022-01-27 16:27:47.185 25297-25375/? D/CleverTap:6K9-955-9K6Z: Failure count is 0. Setting delay frequency to 1s
//2022-01-27 16:27:47.216 25297-25375/? D/CleverTap:6K9-955-9K6Z: Queued event: {"data":{"action":"register","id":"cb1HYzwQSEO1W0fGVvf6Dq:APA91bGjBc666N0t5wdHCULE-QIHFIAQmpRa0UJ5oshUybYgg0s1AS6Por1t_xUbJ5C-YfEXykEJEwFBs3z9hzVuSoDMIFCSzuDoiRGSe2PAk0Eb5HOPsWI5iEyricDnJMoqkq3vzIF_","type":"fcm"},"s":1643281067,"pg":1,"type":"data","ep":1643281067,"f":false,"lsl":1233,"dsync":false}
//2022-01-27 16:27:47.216 25297-25375/? D/CleverTap:6K9-955-9K6Z: Network retry #0
//2022-01-27 16:27:47.216 25297-25375/? D/CleverTap:6K9-955-9K6Z: Failure count is 0. Setting delay frequency to 1s
//2022-01-27 16:27:48.229 25297-25375/? D/CleverTap:6K9-955-9K6Z: Send queue contains 4 items: [{"g":"__6af93f48bb0648f887a9c461a3b0513c","type":"meta","af":{"Build":"2865","Version":"5.17.0","OS Version":"12","SDK Version":40400,"Make":"samsung","Model":"SM-G975F","Carrier":"Vi India","useIP":false,"OS":"Android","wdt":2.57,"hgt":4.8,"dpi":560,"dt":1,"abckt":"active","cc":"in"},"id":"6K9-955-9K6Z","tk":"55c-c36","l_ts":1643279828,"f_ts":1643279827,"ct_pi":"Email,Identity","ddnd":false,"rtl":[],"rct":0,"ait":0,"frs":true,"arp":{"sv":40400,"dh":1391137264,"wdt":2,"d_ts":1643279826,"hgt":4,"av":"5.17.0","v":1,"e_ts":0,"j_n":"Zw==","i_n":"bmtqfwU=","r_ts":1643279827,"id":"6K9-955-9K6Z","j_s":"{ }"},"imp":0,"tlc":[]}, {"evtName":"App Launched","evtData":{"Build":"2865","Version":"5.17.0","OS Version":"12","SDK Version":40400,"Make":"samsung","Model":"SM-G975F","Carrier":"Vi India","useIP":false,"OS":"Android","wdt":2.57,"hgt":4.8,"dpi":560,"dt":1,"abckt":"active","cc":"in"},"s":1643281067,"pg":1,"type":"event","ep":1643281067,"f":false,"lsl":1233,"pai":"com.seatech.bluebird","dsync":true},{"evtName":"wzrk_fetch","evtData":{"t":1},"s":1643281067,"pg":1,"type":"event","ep":1643281067,"f":false,"lsl":1233,"dsync":false},{"data":{"action":"register","id":"cb1HYzwQSEO1W0fGVvf6Dq:APA91bGjBc666N0t5wdHCULE-QIHFIAQmpRa0UJ5oshUybYgg0s1AS6Por1t_xUbJ5C-YfEXykEJEwFBs3z9hzVuSoDMIFCSzuDoiRGSe2PAk0Eb5HOPsWI5iEyricDnJMoqkq3vzIF_","type":"fcm"},"s":1643281067,"pg":1,"type":"data","ep":1643281067,"f":false,"lsl":1233,"dsync":false},{"data":{"action":"register","id":"cb1HYzwQSEO1W0fGVvf6Dq:APA91bGjBc666N0t5wdHCULE-QIHFIAQmpRa0UJ5oshUybYgg0s1AS6Por1t_xUbJ5C-YfEXykEJEwFBs3z9hzVuSoDMIFCSzuDoiRGSe2PAk0Eb5HOPsWI5iEyricDnJMoqkq3vzIF_","type":"fcm"},"s":1643281067,"pg":1,"type":"data","ep":1643281067,"f":false,"lsl":1233,"dsync":false}]
//2022-01-27 16:27:48.229 25297-25375/? D/CleverTap:6K9-955-9K6Z: Sending queue to: https://sg1.wzrkt.com/a1?os=Android&t=40400&z=6K9-955-9K6Z&ts=1643281068
//2022-01-27 16:27:48.603 25297-25375/? I/CleverTapResponse:

        }


//        Activity Lifecycle Callback successfully registered
//2022-01-28 11:19:01.616 26045-26117/? D/CleverTap: ExoPlayer library files are missing!!!
//2022-01-28 11:19:01.616 26045-26117/? D/CleverTap: Please add ExoPlayer dependencies to render InApp or Inbox messages playing video. For more information checkout CleverTap documentation.
//2022-01-28 11:19:01.616 26045-26117/? D/CleverTap: ExoPlayer classes not found
//2022-01-28 11:19:01.617 26045-26045/? I/CleverTap: CleverTap SDK initialized with accountId: 6K9-955-9K6Z accountToken: 55c-c36 accountRegion: sg1
//2022-01-28 11:19:01.617 26045-26117/? D/CleverTap: READ_PHONE_STATE permission not asked by the app or not granted by the user
//2022-01-28 11:19:01.617 26045-26123/? D/CleverTap: READ_PHONE_STATE permission not asked by the app or not granted by the user
//2022-01-28 11:19:01.624 26045-26123/? I/CleverTap: SDK Version Code is 40400
//2022-01-28 11:19:01.627 26045-26123/? I/CleverTap: sdk.pushnotification.CTPushNotificationReceiver is present
//2022-01-28 11:19:01.630 26045-26123/? I/CleverTap: pushnotification.CTNotificationIntentService not present
//2022-01-28 11:19:01.632 26045-26123/? I/CleverTap: InAppNotificationActivity is present
//2022-01-28 11:19:01.633 26045-26123/? I/CleverTap: inbox.CTInboxActivity is present
//2022-01-28 11:19:01.633 26045-26123/? I/CleverTap: geofence.CTGeofenceReceiver not present
//2022-01-28 11:19:01.634 26045-26123/? I/CleverTap: geofence.CTLocationUpdateReceiver not present
//2022-01-28 11:19:01.634 26045-26123/? I/CleverTap: geofence.CTGeofenceBootReceiver not present
//2022-01-28 11:19:01.634 26045-26123/? I/CleverTap: pushnotification.amp.CTBackgroundJobService is present
//2022-01-28 11:19:01.634 26045-26123/? I/CleverTap: pushnotification.amp.CTBackgroundIntentService is present
//2022-01-28 11:19:01.634 26045-26123/? I/CleverTap: pushnotification.fcm.FcmMessageListenerService not present
//2022-01-28 11:19:01.650 26045-26123/? I/CleverTap:6K9-955-9K6Z: Notification channel MyBluebird Notification has been created
//2022-01-28 11:19:01.913 26045-26045/? D/CleverTap:6K9-955-9K6Z: In-app notifications will not be shown on []
//2022-01-28 11:19:01.935 26045-26123/? D/CleverTap:6K9-955-9K6Z: Queued event: {"evtName":"App Launched","evtData":{"Build":"2865","Version":"5.17.0","OS Version":"12","SDK Version":40400,"Make":"samsung","Model":"SM-G975F","Carrier":"Vi India","useIP":false,"OS":"Android","wdt":2.57,"hgt":4.8,"dpi":560,"dt":1,"abckt":"active","cc":"in"},"s":1643348941,"pg":1,"type":"event","ep":1643348941,"f":true,"lsl":0,"pai":"com.seatech.bluebird","dsync":true}
//2022-01-28 11:19:01.935 26045-26123/? D/CleverTap:6K9-955-9K6Z: Network retry #0
//2022-01-28 11:19:01.935 26045-26123/? D/CleverTap:6K9-955-9K6Z: Failure count is 0. Setting delay frequency to 1s
//2022-01-28 11:19:01.960 26045-26123/? D/CleverTap:6K9-955-9K6Z: Queued event: {"evtName":"wzrk_fetch","evtData":{"t":1},"s":1643348941,"pg":1,"type":"event","ep":1643348941,"f":true,"lsl":0,"dsync":false}
//2022-01-28 11:19:01.960 26045-26123/? D/CleverTap:6K9-955-9K6Z: Network retry #0
//2022-01-28 11:19:01.960 26045-26123/? D/CleverTap:6K9-955-9K6Z: Failure count is 0. Setting delay frequency to 1s
//2022-01-28 11:19:02.082 26045-26045/? D/CleverTap: Referrer data: {
//        "us": "google-play",
//        "um": "organic"
//    }
//2022-01-28 11:19:02.082 26045-26045/? D/CleverTap:6K9-955-9K6Z: Install Referrer data set [Referrer URL-utm_source=google-play&utm_medium=organic]
//2022-01-28 11:19:02.092 26045-26123/? D/CleverTap:6K9-955-9K6Z: Queued event: {"us":"google-play","um":"organic","referrer":"wzrk:\/\/track?install=true&utm_source=google-play&utm_medium=organic","install":"true","s":1643348941,"pg":1,"type":"page","ep":1643348942,"f":true,"lsl":0,"dsync":false}
//2022-01-28 11:19:02.092 26045-26123/? D/CleverTap:6K9-955-9K6Z: Network retry #0
//2022-01-28 11:19:02.092 26045-26123/? D/CleverTap:6K9-955-9K6Z: Failure count is 0. Setting delay frequency to 1s
//2022-01-28 11:19:02.451 26045-26123/? D/CleverTap:6K9-955-9K6Z: Queued event: {"data":{"action":"register","id":"dDTx9H5kReGIKQMSmEdUoE:APA91bFZizrghyIV9jZIW-_CTKDONJoLGdQJLlIg501GHWZR5ocD1cDLXeLQjg6x1kZbj5-dSsfme0yrjprKtuviftZqGs4IC5BFObQl6M03sE-q9gf_G86eYCqc5Xh9qrTOJJq6_Dzi","type":"fcm"},"s":1643348941,"pg":1,"type":"data","ep":1643348942,"f":true,"lsl":0,"dsync":false}
//2022-01-28 11:19:02.451 26045-26123/? D/CleverTap:6K9-955-9K6Z: Network retry #0
//2022-01-28 11:19:02.451 26045-26123/? D/CleverTap:6K9-955-9K6Z: Failure count is 0. Setting delay frequency to 1s
//2022-01-28 11:19:02.463 26045-26123/? D/CleverTap:6K9-955-9K6Z: Queued event: {"data":{"action":"register","id":"dDTx9H5kReGIKQMSmEdUoE:APA91bFZizrghyIV9jZIW-_CTKDONJoLGdQJLlIg501GHWZR5ocD1cDLXeLQjg6x1kZbj5-dSsfme0yrjprKtuviftZqGs4IC5BFObQl6M03sE-q9gf_G86eYCqc5Xh9qrTOJJq6_Dzi","type":"fcm"},"s":1643348941,"pg":1,"type":"data","ep":1643348942,"f":true,"lsl":0,"dsync":false}
//2022-01-28 11:19:02.463 26045-26123/? D/CleverTap:6K9-955-9K6Z: Network retry #0
//2022-01-28 11:19:02.463 26045-26123/? D/CleverTap:6K9-955-9K6Z: Failure count is 0. Setting delay frequency to 1s
//2022-01-28 11:19:03.487 26045-26123/? D/CleverTap:6K9-955-9K6Z: Send queue contains 5 items: [{"g":"__883d792b3a9b4f8ab73eb3e1cea33b85","type":"meta","af":{"Build":"2865","Version":"5.17.0","OS Version":"12","SDK Version":40400,"Make":"samsung","Model":"SM-G975F","Carrier":"Vi India","useIP":false,"OS":"Android","wdt":2.57,"hgt":4.8,"dpi":560,"dt":1,"abckt":"active","cc":"in"},"id":"6K9-955-9K6Z","tk":"55c-c36","l_ts":0,"f_ts":0,"ct_pi":"Email,Identity","ddnd":false,"rtl":[],"frs":true,"ref":{"us":"google-play","um":"organic"},"imp":0,"tlc":[]}, {"evtName":"App Launched","evtData":{"Build":"2865","Version":"5.17.0","OS Version":"12","SDK Version":40400,"Make":"samsung","Model":"SM-G975F","Carrier":"Vi India","useIP":false,"OS":"Android","wdt":2.57,"hgt":4.8,"dpi":560,"dt":1,"abckt":"active","cc":"in"},"s":1643348941,"pg":1,"type":"event","ep":1643348941,"f":true,"lsl":0,"pai":"com.seatech.bluebird","dsync":true},{"evtName":"wzrk_fetch","evtData":{"t":1},"s":1643348941,"pg":1,"type":"event","ep":1643348941,"f":true,"lsl":0,"dsync":false},{"us":"google-play","um":"organic","referrer":"wzrk:\/\/track?install=true&utm_source=google-play&utm_medium=organic","install":"true","s":1643348941,"pg":1,"type":"page","ep":1643348942,"f":true,"lsl":0,"dsync":false},{"data":{"action":"register","id":"dDTx9H5kReGIKQMSmEdUoE:APA91bFZizrghyIV9jZIW-_CTKDONJoLGdQJLlIg501GHWZR5ocD1cDLXeLQjg6x1kZbj5-dSsfme0yrjprKtuviftZqGs4IC5BFObQl6M03sE-q9gf_G86eYCqc5Xh9qrTOJJq6_Dzi","type":"fcm"},"s":1643348941,"pg":1,"type":"data","ep":1643348942,"f":true,"lsl":0,"dsync":false},{"data":{"action":"register","id":"dDTx9H5kReGIKQMSmEdUoE:APA91bFZizrghyIV9jZIW-_CTKDONJoLGdQJLlIg501GHWZR5ocD1cDLXeLQjg6x1kZbj5-dSsfme0yrjprKtuviftZqGs4IC5BFObQl6M03sE-q9gf_G86eYCqc5Xh9qrTOJJq6_Dzi","type":"fcm"},"s":1643348941,"pg":1,"type":"data","ep":1643348942,"f":true,"lsl":0,"dsync":false}]
//2022-01-28 11:19:03.487 26045-26123/? D/CleverTap:6K9-955-9K6Z: Sending queue to: https://sg1.wzrkt.com/a1?os=Android&t=40400&z=6K9-955-9K6Z&ts=1643348943
//2022-01-28 11:19:03.747 26045-26123/? I/CleverTapResponse: Done processing response!
//2022-01-28 11:19:03.748 26045-26123/? D/CleverTap:6K9-955-9K6Z: Queue sent successfully


//2022-01-28 11:23:17.801 27981-27981/? I/CleverTap: Activity Lifecycle Callback successfully registered
//2022-01-28 11:23:17.809 27981-28056/? D/CleverTap: ExoPlayer library files are missing!!!
//2022-01-28 11:23:17.809 27981-28056/? D/CleverTap: Please add ExoPlayer dependencies to render InApp or Inbox messages playing video. For more information checkout CleverTap documentation.
//2022-01-28 11:23:17.809 27981-28056/? D/CleverTap: ExoPlayer classes not found
//2022-01-28 11:23:17.810 27981-28056/? D/CleverTap: READ_PHONE_STATE permission not asked by the app or not granted by the user
//2022-01-28 11:23:17.813 27981-27981/? I/CleverTap: CleverTap SDK initialized with accountId: 6K9-955-9K6Z accountToken: 55c-c36 accountRegion: sg1
//2022-01-28 11:23:17.816 27981-28062/? D/CleverTap: READ_PHONE_STATE permission not asked by the app or not granted by the user
//2022-01-28 11:23:17.819 27981-28062/? I/CleverTap: SDK Version Code is 40400
//2022-01-28 11:23:17.821 27981-28062/? I/CleverTap: sdk.pushnotification.CTPushNotificationReceiver is present
//2022-01-28 11:23:17.822 27981-28062/? I/CleverTap: pushnotification.CTNotificationIntentService not present
//2022-01-28 11:23:17.825 27981-28062/? I/CleverTap: InAppNotificationActivity is present
//2022-01-28 11:23:17.827 27981-28062/? I/CleverTap: inbox.CTInboxActivity is present
//2022-01-28 11:23:17.827 27981-28062/? I/CleverTap: geofence.CTGeofenceReceiver not present
//2022-01-28 11:23:17.827 27981-28062/? I/CleverTap: geofence.CTLocationUpdateReceiver not present
//2022-01-28 11:23:17.827 27981-28062/? I/CleverTap: geofence.CTGeofenceBootReceiver not present
//2022-01-28 11:23:17.828 27981-28062/? I/CleverTap: pushnotification.amp.CTBackgroundJobService is present
//2022-01-28 11:23:17.829 27981-28062/? I/CleverTap: pushnotification.amp.CTBackgroundIntentService is present
//2022-01-28 11:23:17.829 27981-28062/? I/CleverTap: pushnotification.fcm.FcmMessageListenerService not present
//2022-01-28 11:23:17.846 27981-28062/? I/CleverTap:6K9-955-9K6Z: Notification channel MyBluebird Notification has been created
//2022-01-28 11:23:18.030 27981-27981/? D/CleverTap:6K9-955-9K6Z: In-app notifications will not be shown on []
//2022-01-28 11:23:18.051 27981-28062/? D/CleverTap:6K9-955-9K6Z: Queued event: {"evtName":"App Launched","evtData":{"Build":"2865","Version":"5.17.0","OS Version":"12","SDK Version":40400,"Make":"samsung","Model":"SM-G975F","Carrier":"Vi India","useIP":false,"OS":"Android","wdt":2.57,"hgt":4.8,"dpi":560,"dt":1,"abckt":"active","cc":"in"},"s":1643349198,"pg":1,"type":"event","ep":1643349198,"f":false,"lsl":2,"pai":"com.seatech.bluebird","dsync":true}
//2022-01-28 11:23:18.052 27981-28062/? D/CleverTap:6K9-955-9K6Z: Network retry #0
//2022-01-28 11:23:18.052 27981-28062/? D/CleverTap:6K9-955-9K6Z: Failure count is 0. Setting delay frequency to 1s
//2022-01-28 11:23:18.075 27981-28062/? D/CleverTap:6K9-955-9K6Z: Queued event: {"evtName":"wzrk_fetch","evtData":{"t":1},"s":1643349198,"pg":1,"type":"event","ep":1643349198,"f":false,"lsl":2,"dsync":false}
//2022-01-28 11:23:18.075 27981-28062/? D/CleverTap:6K9-955-9K6Z: Network retry #0
//2022-01-28 11:23:18.075 27981-28062/? D/CleverTap:6K9-955-9K6Z: Failure count is 0. Setting delay frequency to 1s
//2022-01-28 11:23:18.092 27981-28062/? D/CleverTap:6K9-955-9K6Z: Queued event: {"profile":{"Carrier":"Vi India","cc":"in","tz":"Asia\/Kolkata"},"s":1643349198,"pg":1,"type":"profile","ep":1643349198,"f":false,"lsl":2,"dsync":true}
//2022-01-28 11:23:18.092 27981-28062/? D/CleverTap:6K9-955-9K6Z: Network retry #0
//2022-01-28 11:23:18.092 27981-28062/? D/CleverTap:6K9-955-9K6Z: Failure count is 0. Setting delay frequency to 1s
//2022-01-28 11:23:18.138 27981-28062/? D/CleverTap:6K9-955-9K6Z: Queued event: {"data":{"action":"register","id":"dDTx9H5kReGIKQMSmEdUoE:APA91bFZizrghyIV9jZIW-_CTKDONJoLGdQJLlIg501GHWZR5ocD1cDLXeLQjg6x1kZbj5-dSsfme0yrjprKtuviftZqGs4IC5BFObQl6M03sE-q9gf_G86eYCqc5Xh9qrTOJJq6_Dzi","type":"fcm"},"s":1643349198,"pg":1,"type":"data","ep":1643349198,"f":false,"lsl":2,"dsync":false}
//2022-01-28 11:23:18.138 27981-28062/? D/CleverTap:6K9-955-9K6Z: Network retry #0
//2022-01-28 11:23:18.139 27981-28062/? D/CleverTap:6K9-955-9K6Z: Failure count is 0. Setting delay frequency to 1s
//2022-01-28 11:23:18.150 27981-28062/? D/CleverTap:6K9-955-9K6Z: Queued event: {"data":{"action":"register","id":"dDTx9H5kReGIKQMSmEdUoE:APA91bFZizrghyIV9jZIW-_CTKDONJoLGdQJLlIg501GHWZR5ocD1cDLXeLQjg6x1kZbj5-dSsfme0yrjprKtuviftZqGs4IC5BFObQl6M03sE-q9gf_G86eYCqc5Xh9qrTOJJq6_Dzi","type":"fcm"},"s":1643349198,"pg":1,"type":"data","ep":1643349198,"f":false,"lsl":2,"dsync":false}
//2022-01-28 11:23:18.150 27981-28062/? D/CleverTap:6K9-955-9K6Z: Network retry #0
//2022-01-28 11:23:18.150 27981-28062/? D/CleverTap:6K9-955-9K6Z: Failure count is 0. Setting delay frequency to 1s
//2022-01-28 11:23:19.164 27981-28062/? D/CleverTap:6K9-955-9K6Z: Send queue contains 4 items: [{"g":"__883d792b3a9b4f8ab73eb3e1cea33b85","type":"meta","af":{"Build":"2865","Version":"5.17.0","OS Version":"12","SDK Version":40400,"Make":"samsung","Model":"SM-G975F","Carrier":"Vi India","useIP":false,"OS":"Android","wdt":2.57,"hgt":4.8,"dpi":560,"dt":1,"abckt":"active","cc":"in"},"id":"6K9-955-9K6Z","tk":"55c-c36","l_ts":1643348943,"f_ts":1643348943,"ct_pi":"Email,Identity","ddnd":false,"rtl":[],"rct":0,"ait":0,"frs":true,"arp":{"sv":40400,"dh":-1920428336,"wdt":2,"d_ts":1643348942,"hgt":4,"av":"5.17.0","v":1,"e_ts":0,"j_n":"Zw==","i_n":"bmhqeAc=","r_ts":1643348942,"id":"6K9-955-9K6Z","j_s":"{ }"},"imp":0,"tlc":[]}, {"evtName":"App Launched","evtData":{"Build":"2865","Version":"5.17.0","OS Version":"12","SDK Version":40400,"Make":"samsung","Model":"SM-G975F","Carrier":"Vi India","useIP":false,"OS":"Android","wdt":2.57,"hgt":4.8,"dpi":560,"dt":1,"abckt":"active","cc":"in"},"s":1643349198,"pg":1,"type":"event","ep":1643349198,"f":false,"lsl":2,"pai":"com.seatech.bluebird","dsync":true},{"evtName":"wzrk_fetch","evtData":{"t":1},"s":1643349198,"pg":1,"type":"event","ep":1643349198,"f":false,"lsl":2,"dsync":false},{"data":{"action":"register","id":"dDTx9H5kReGIKQMSmEdUoE:APA91bFZizrghyIV9jZIW-_CTKDONJoLGdQJLlIg501GHWZR5ocD1cDLXeLQjg6x1kZbj5-dSsfme0yrjprKtuviftZqGs4IC5BFObQl6M03sE-q9gf_G86eYCqc5Xh9qrTOJJq6_Dzi","type":"fcm"},"s":1643349198,"pg":1,"type":"data","ep":1643349198,"f":false,"lsl":2,"dsync":false},{"data":{"action":"register","id":"dDTx9H5kReGIKQMSmEdUoE:APA91bFZizrghyIV9jZIW-_CTKDONJoLGdQJLlIg501GHWZR5ocD1cDLXeLQjg6x1kZbj5-dSsfme0yrjprKtuviftZqGs4IC5BFObQl6M03sE-q9gf_G86eYCqc5Xh9qrTOJJq6_Dzi","type":"fcm"},"s":1643349198,"pg":1,"type":"data","ep":1643349198,"f":false,"lsl":2,"dsync":false}]
//2022-01-28 11:23:19.164 27981-28062/? D/CleverTap:6K9-955-9K6Z: Sending queue to: https://sg1.wzrkt.com/a1?os=Android&t=40400&z=6K9-955-9K6Z&ts=1643349199
//2022-01-28 11:23:19.547 27981-28062/? I/CleverTapResponse: Done processing response!
//2022-01-28 11:23:19.547 27981-28062/? D/CleverTap:6K9-955-9K6Z: Queue sent successfully
//2022-01-28 11:23:19.566 27981-28062/? D/CleverTap:6K9-955-9K6Z: Send queue contains 1 items: [{"g":"__883d792b3a9b4f8ab73eb3e1cea33b85","type":"meta","af":{"Build":"2865","Version":"5.17.0","OS Version":"12","SDK Version":40400,"Make":"samsung","Model":"SM-G975F","Carrier":"Vi India","useIP":false,"OS":"Android","wdt":2.57,"hgt":4.8,"dpi":560,"dt":1,"abckt":"active","cc":"in"},"id":"6K9-955-9K6Z","tk":"55c-c36","l_ts":1643349199,"f_ts":1643348943,"ct_pi":"Email,Identity","ddnd":false,"rtl":[],"rct":0,"ait":0,"frs":false,"arp":{"sv":40400,"dh":-1920428336,"wdt":2,"d_ts":1643348942,"hgt":4,"av":"5.17.0","v":1,"e_ts":0,"j_n":"Zw==","i_n":"bmhqeAc=","r_ts":1643349197,"id":"6K9-955-9K6Z","j_s":"{ }"},"imp":0,"tlc":[]}, {"profile":{"Carrier":"Vi India","cc":"in","tz":"Asia\/Kolkata"},"s":1643349198,"pg":1,"type":"profile","ep":1643349198,"f":false,"lsl":2,"dsync":true}]
//2022-01-28 11:23:19.566 27981-28062/? D/CleverTap:6K9-955-9K6Z: Sending queue to: https://sg1.wzrkt.com/a1?os=Android&t=40400&z=6K9-955-9K6Z&ts=1643349199
//2022-01-28 11:23:19.679 27981-28062/? I/CleverTapResponse: Done processing response!
//2022-01-28 11:23:19.679 27981-28062/? D/CleverTap:6K9-955-9K6Z: Queue sent successfully






//
//2022-01-28 11:26:18.516 27609-29041/? W/ProcStatsManager: No process com.coinswitch.kuber/10464 for service com.clevertap.android.sdk.pushnotification.fcm.FcmMessageListenerService
//2022-01-28 11:26:18.516 27609-29041/? W/ProcStatsManager: No process com.tul.tatacliq/10550 for service com.clevertap.android.sdk.pushnotification.amp.CTBackgroundJobService
//2022-01-28 11:26:18.695 27609-29041/? W/ProcStatsManager: No process com.coinswitch.kuber/10464 for service com.clevertap.android.sdk.pushnotification.fcm.FcmMessageListenerService
//2022-01-28 11:26:18.695 27609-29041/? W/ProcStatsManager: No process com.tul.tatacliq/10550 for service com.clevertap.android.sdk.pushnotification.amp.CTBackgroundJobService
//2022-01-28 11:26:39.528 27609-29152/? W/ProcStatsManager: No process com.coinswitch.kuber/10464 for service com.clevertap.android.sdk.pushnotification.fcm.FcmMessageListenerService
//2022-01-28 11:26:39.528 27609-29152/? W/ProcStatsManager: No process com.tul.tatacliq/10550 for service com.clevertap.android.sdk.pushnotification.amp.CTBackgroundJobService
//2022-01-28 11:26:49.272 27609-29343/? W/ProcStatsManager: No process com.coinswitch.kuber/10464 for service com.clevertap.android.sdk.pushnotification.fcm.FcmMessageListenerService
//2022-01-28 11:26:49.272 27609-29343/? W/ProcStatsManager: No process com.tul.tatacliq/10550 for service com.clevertap.android.sdk.pushnotification.amp.CTBackgroundJobService
//2022-01-28 11:26:51.308 29682-29682/? I/CleverTap: Activity Lifecycle Callback successfully registered
//2022-01-28 11:26:51.326 29682-29771/? D/CleverTap: ExoPlayer library files are missing!!!
//2022-01-28 11:26:51.326 29682-29771/? D/CleverTap: Please add ExoPlayer dependencies to render InApp or Inbox messages playing video. For more information checkout CleverTap documentation.
//2022-01-28 11:26:51.326 29682-29771/? D/CleverTap: ExoPlayer classes not found
//2022-01-28 11:26:51.326 29682-29771/? D/CleverTap: READ_PHONE_STATE permission not asked by the app or not granted by the user
//2022-01-28 11:26:51.327 29682-29682/? I/CleverTap: CleverTap SDK initialized with accountId: 6K9-955-9K6Z accountToken: 55c-c36 accountRegion: sg1
//2022-01-28 11:26:51.332 29682-29777/? D/CleverTap: READ_PHONE_STATE permission not asked by the app or not granted by the user
//2022-01-28 11:26:51.342 29682-29777/? I/CleverTap: SDK Version Code is 40400
//2022-01-28 11:26:51.342 29682-29777/? I/CleverTap: sdk.pushnotification.CTPushNotificationReceiver is present
//2022-01-28 11:26:51.343 29682-29777/? I/CleverTap: pushnotification.CTNotificationIntentService not present
//2022-01-28 11:26:51.352 29682-29777/? I/CleverTap: InAppNotificationActivity is present
//2022-01-28 11:26:51.353 29682-29777/? I/CleverTap: inbox.CTInboxActivity is present
//2022-01-28 11:26:51.353 29682-29777/? I/CleverTap: geofence.CTGeofenceReceiver not present
//2022-01-28 11:26:51.353 29682-29777/? I/CleverTap: geofence.CTLocationUpdateReceiver not present
//2022-01-28 11:26:51.353 29682-29777/? I/CleverTap: geofence.CTGeofenceBootReceiver not present
//2022-01-28 11:26:51.353 29682-29777/? I/CleverTap: pushnotification.amp.CTBackgroundJobService is present
//2022-01-28 11:26:51.353 29682-29777/? I/CleverTap: pushnotification.amp.CTBackgroundIntentService is present
//2022-01-28 11:26:51.353 29682-29777/? I/CleverTap: pushnotification.fcm.FcmMessageListenerService not present
//2022-01-28 11:26:51.439 29682-29777/? I/CleverTap:6K9-955-9K6Z: Notification channel MyBluebird Notification has been created
//2022-01-28 11:26:51.719 29682-29682/? D/CleverTap:6K9-955-9K6Z: In-app notifications will not be shown on []
//2022-01-28 11:26:51.742 29682-29777/? D/CleverTap:6K9-955-9K6Z: Queued event: {"evtName":"App Launched","evtData":{"Build":"2865","Version":"5.17.0","OS Version":"12","SDK Version":40400,"Make":"samsung","Model":"SM-G975F","Carrier":"Vi India","useIP":false,"OS":"Android","wdt":2.57,"hgt":4.8,"dpi":560,"dt":1,"abckt":"active","cc":"in"},"s":1643349411,"pg":1,"type":"event","ep":1643349411,"f":true,"lsl":0,"pai":"com.seatech.bluebird","dsync":true}
//2022-01-28 11:26:51.743 29682-29777/? D/CleverTap:6K9-955-9K6Z: Network retry #0
//2022-01-28 11:26:51.743 29682-29777/? D/CleverTap:6K9-955-9K6Z: Failure count is 0. Setting delay frequency to 1s
//2022-01-28 11:26:51.762 29682-29777/? D/CleverTap:6K9-955-9K6Z: Queued event: {"evtName":"wzrk_fetch","evtData":{"t":1},"s":1643349411,"pg":1,"type":"event","ep":1643349411,"f":true,"lsl":0,"dsync":false}
//2022-01-28 11:26:51.762 29682-29777/? D/CleverTap:6K9-955-9K6Z: Network retry #0
//2022-01-28 11:26:51.762 29682-29777/? D/CleverTap:6K9-955-9K6Z: Failure count is 0. Setting delay frequency to 1s
//2022-01-28 11:26:52.307 29682-29777/? D/CleverTap:6K9-955-9K6Z: Queued event: {"data":{"action":"register","id":"cv-N8ZKFQ2iosvzhQjz0UD:APA91bHwyFmNfXYtJkx0X2TOydVpJouhOuyS15U61CmxcBt56R-JVEp7XBZsMs7q2XR-ogFwbXPt2e4Nl_HpNv5_YwsTBnk4EYfuvoTHus7OvDhXUxuuyJaqQd0HNTZiJjbLRMfwcPag","type":"fcm"},"s":1643349411,"pg":1,"type":"data","ep":1643349412,"f":true,"lsl":0,"dsync":false}
//2022-01-28 11:26:52.307 29682-29777/? D/CleverTap:6K9-955-9K6Z: Network retry #0
//2022-01-28 11:26:52.307 29682-29777/? D/CleverTap:6K9-955-9K6Z: Failure count is 0. Setting delay frequency to 1s
//2022-01-28 11:26:52.319 29682-29777/? D/CleverTap:6K9-955-9K6Z: Queued event: {"data":{"action":"register","id":"cv-N8ZKFQ2iosvzhQjz0UD:APA91bHwyFmNfXYtJkx0X2TOydVpJouhOuyS15U61CmxcBt56R-JVEp7XBZsMs7q2XR-ogFwbXPt2e4Nl_HpNv5_YwsTBnk4EYfuvoTHus7OvDhXUxuuyJaqQd0HNTZiJjbLRMfwcPag","type":"fcm"},"s":1643349411,"pg":1,"type":"data","ep":1643349412,"f":true,"lsl":0,"dsync":false}
//2022-01-28 11:26:52.319 29682-29777/? D/CleverTap:6K9-955-9K6Z: Network retry #0
//2022-01-28 11:26:52.319 29682-29777/? D/CleverTap:6K9-955-9K6Z: Failure count is 0. Setting delay frequency to 1s
//2022-01-28 11:26:52.773 29682-29682/? D/CleverTap: Referrer data: {
//        "us": "google-play",
//        "um": "organic"
//    }
//2022-01-28 11:26:52.774 29682-29682/? D/CleverTap:6K9-955-9K6Z: Install Referrer data set [Referrer URL-utm_source=google-play&utm_medium=organic]
//2022-01-28 11:26:52.802 29682-29777/? D/CleverTap:6K9-955-9K6Z: Queued event: {"us":"google-play","um":"organic","referrer":"wzrk:\/\/track?install=true&utm_source=google-play&utm_medium=organic","install":"true","s":1643349411,"pg":1,"type":"page","ep":1643349412,"f":true,"lsl":0,"dsync":false}
//2022-01-28 11:26:52.803 29682-29777/? D/CleverTap:6K9-955-9K6Z: Network retry #0
//2022-01-28 11:26:52.803 29682-29777/? D/CleverTap:6K9-955-9K6Z: Failure count is 0. Setting delay frequency to 1s
//2022-01-28 11:26:53.905 29682-29777/? D/CleverTap:6K9-955-9K6Z: Send queue contains 5 items: [{"g":"__fd1656d925e94e88a3771e490e2fc7d5","type":"meta","af":{"Build":"2865","Version":"5.17.0","OS Version":"12","SDK Version":40400,"Make":"samsung","Model":"SM-G975F","Carrier":"Vi India","useIP":false,"OS":"Android","wdt":2.57,"hgt":4.8,"dpi":560,"dt":1,"abckt":"active","cc":"in"},"id":"6K9-955-9K6Z","tk":"55c-c36","l_ts":0,"f_ts":0,"ct_pi":"Email,Identity","ddnd":false,"rtl":[],"frs":true,"ref":{"us":"google-play","um":"organic"},"imp":0,"tlc":[]}, {"evtName":"App Launched","evtData":{"Build":"2865","Version":"5.17.0","OS Version":"12","SDK Version":40400,"Make":"samsung","Model":"SM-G975F","Carrier":"Vi India","useIP":false,"OS":"Android","wdt":2.57,"hgt":4.8,"dpi":560,"dt":1,"abckt":"active","cc":"in"},"s":1643349411,"pg":1,"type":"event","ep":1643349411,"f":true,"lsl":0,"pai":"com.seatech.bluebird","dsync":true},{"evtName":"wzrk_fetch","evtData":{"t":1},"s":1643349411,"pg":1,"type":"event","ep":1643349411,"f":true,"lsl":0,"dsync":false},{"data":{"action":"register","id":"cv-N8ZKFQ2iosvzhQjz0UD:APA91bHwyFmNfXYtJkx0X2TOydVpJouhOuyS15U61CmxcBt56R-JVEp7XBZsMs7q2XR-ogFwbXPt2e4Nl_HpNv5_YwsTBnk4EYfuvoTHus7OvDhXUxuuyJaqQd0HNTZiJjbLRMfwcPag","type":"fcm"},"s":1643349411,"pg":1,"type":"data","ep":1643349412,"f":true,"lsl":0,"dsync":false},{"data":{"action":"register","id":"cv-N8ZKFQ2iosvzhQjz0UD:APA91bHwyFmNfXYtJkx0X2TOydVpJouhOuyS15U61CmxcBt56R-JVEp7XBZsMs7q2XR-ogFwbXPt2e4Nl_HpNv5_YwsTBnk4EYfuvoTHus7OvDhXUxuuyJaqQd0HNTZiJjbLRMfwcPag","type":"fcm"},"s":1643349411,"pg":1,"type":"data","ep":1643349412,"f":true,"lsl":0,"dsync":false},{"us":"google-play","um":"organic","referrer":"wzrk:\/\/track?install=true&utm_source=google-play&utm_medium=organic","install":"true","s":1643349411,"pg":1,"type":"page","ep":1643349412,"f":true,"lsl":0,"dsync":false}]
//2022-01-28 11:26:53.905 29682-29777/? D/CleverTap:6K9-955-9K6Z: Sending queue to: https://sg1.wzrkt.com/a1?os=Android&t=40400&z=6K9-955-9K6Z&ts=1643349413
//2022-01-28 11:26:54.178 29682-29777/? I/CleverTapResponse: Done processing response!
//2022-01-28 11:26:54.178 29682-29777/? D/CleverTap:6K9-955-9K6Z: Queue sent successfully
//2022-01-28 11:27:30.642 31056-31056/? I/CleverTap: Activity Lifecycle Callback successfully registered
//2022-01-28 11:27:30.857 31056-31056/? I/CleverTap: Account Region not specified in the AndroidManifest - using default region
//2022-01-28 11:27:30.895 31056-31056/? I/CleverTap: CleverTap SDK initialized with accountId: R74-5R4-6W5Z accountToken: 425-4a2 accountRegion: null
//2022-01-28 11:27:30.897 31056-31136/? I/CleverTap: SDK Version Code is 40300
//2022-01-28 11:27:30.900 31056-31136/? I/CleverTap: sdk.pushnotification.CTPushNotificationReceiver is present
//2022-01-28 11:27:30.911 31056-31136/? I/CleverTap: pushnotification.CTNotificationIntentService is present
//2022-01-28 11:27:30.917 31056-31136/? I/CleverTap: InAppNotificationActivity is present
//2022-01-28 11:27:30.918 31056-31136/? I/CleverTap: inbox.CTInboxActivity is present
//2022-01-28 11:27:30.918 31056-31136/? I/CleverTap: geofence.CTGeofenceReceiver not present
//2022-01-28 11:27:30.919 31056-31136/? I/CleverTap: geofence.CTLocationUpdateReceiver not present
//2022-01-28 11:27:30.919 31056-31136/? I/CleverTap: geofence.CTGeofenceBootReceiver not present
//2022-01-28 11:27:30.919 31056-31136/? I/CleverTap: pushnotification.amp.CTBackgroundJobService is present
//2022-01-28 11:27:30.920 31056-31136/? I/CleverTap: pushnotification.amp.CTBackgroundIntentService is present
//2022-01-28 11:27:30.920 31056-31136/? I/CleverTap: pushnotification.fcm.FcmMessageListenerService not present


//fPn7VfV9SB--g48rh2FQiO:APA91bFYCZfs3lGC4qFmZQDrKAu5xJwYHN8DYBTte56yAzdzXb76fNvV2UhmcgmKx6J7wE5W4NHZTMOwS_nlVXTAvvjh__OMDJYK7wqZ4ystzgezyB62nd41y9i0lUxEl0G_yBOCXMeT

        //export PATH="/Users/gaurav.singh/Library/Android/sdk/tools:/Users/gaurav.singh/Library/Android/sdk/build-tools:${PATH}"
    }
}

//{"data":{"action":"register","id":"eqo47WqmRLy0HvN_PWIr1Q:APA91bENliczzBYRfXz4KARmXOjj9VyFzfceM6CXuOoAKo0w_VUYOcVx8uncBoXfbCZgfozw_XSyXLrPMf-PMFJg_z-uV71y_lyuopSmIaBS5_e22j0-r-gPYs7OjWcqsV0AyhtjD-nN","type":"fcm"},"s":1643350956,"pg":2,"type":"data","ep":1643351317,"f":false,"lsl":572,"dsync":false}
//2022-01-28 11:58:37.159 14801-14916/? D/CleverTap:6K9-955-9K6Z: Network retry #0
//2022-01-28 11:58:37.159 14801-14916/? D/CleverTap:6K9-955-9K6Z: Failure count is 0. Setting delay frequency to 1s
//2022-01-28 11:58:38.129 14801-14801/? D/CleverTap:6K9-955-9K6Z: onUserLogin: {MSG-push=true, Email=gaurav.singh@clevertap.com, Phone=+919619314745, Identity=BB02479463, Name=Gaurav } maps to current device id __e1f3a1434c0c4df2ac85d6848b5f4988 pushing on current profile
//2022-01-28 11:58:38.153 14801-14916/? D/CleverTap:6K9-955-9K6Z: Queued event: {"profile":{"MSG-push":true,"Email":"gaurav.singh@clevertap.com","Phone":"+919619314745","Identity":"BB02479463","Name":"Gaurav","Carrier":"Vi India","cc":"in","tz":"Asia\/Kolkata"},"s":1643350956,"pg":3,"type":"profile","ep":1643351318,"f":false,"lsl":572,"dsync":true}
//2022-01-28 11:58:38.156 14801-14916/? D/CleverTap:6K9-955-9K6Z: Network retry #0
//2022-01-28 11:58:38.156 14801-14916/? D/CleverTap:6K9-955-9K6Z: Failure count is 0. Setting delay frequency to 1s
//2022-01-28 11:58:38.165 14801-14916/? D/CleverTap:6K9-955-9K6Z: Queued event: {"mc":21484392,"nt":"WiFi","s":1643350956,"pg":3,"type":"ping","ep":1643351318,"f":false,"lsl":572,"dsync":false}
//2022-01-28 11:58:38.165 14801-14916/? D/CleverTap:6K9-955-9K6Z: Network retry #0
//2022-01-28 11:58:38.165 14801-14916/? D/CleverTap:6K9-955-9K6Z: Failure count is 0. Setting delay frequency to 1s
//2022-01-28 11:58:39.191 14801-14916/? D/CleverTap:6K9-955-9K6Z: Send queue contains 4 items: [{"g":"__e1f3a1434c0c4df2ac85d6848b5f4988","type":"meta","af":{"Build":"2865","Version":"5.17.0","OS Version":"12","SDK Version":40400,"Latitude":19.1886221,"Longitude":73.0396217,"Make":"samsung","Model":"SM-G975F","Carrier":"Vi India","useIP":true,"OS":"Android","wdt":2.57,"hgt":4.8,"dpi":560,"dt":1,"abckt":"active","cc":"in","wifi":true,"BluetoothVersion":"ble","Radio":"4G"},"id":"6K9-955-9K6Z","tk":"55c-c36","l_ts":1643350969,"f_ts":1643350114,"ct_pi":"Email,Identity","ddnd":false,"rtl":[],"rct":0,"ait":0,"frs":false,"arp":{"sv":40400,"dh":805876337,"wdt":2,"d_ts":1643350113,"hgt":4,"av":"5.17.0","v":1,"e_ts":0,"j_n":"bmtqfwU=","i_n":"YG1reQs=","r_ts":1643350955,"id":"6K9-955-9K6Z","k_n":"[ \"gaurav.singh@clevertap.com\" , \"BB02479463\"]","j_s":"{ }"},"imp":0,"tlc":[]}, {"evtName":"App Launched","evtData":{"Build":"2865","Version":"5.17.0","OS Version":"12","SDK Version":40400,"Make":"samsung","Model":"SM-G975F","Carrier":"Vi India","useIP":true,"OS":"Android","wdt":2.57,"hgt":4.8,"dpi":560,"dt":1,"abckt":"active","cc":"in","wifi":true,"BluetoothVersion":"ble","Radio":"4G"},"s":1643350956,"pg":2,"type":"event","ep":1643351317,"f":false,"lsl":572,"pai":"com.seatech.bluebird","dsync":true},{"evtName":"wzrk_fetch","evtData":{"t":1},"s":1643350956,"pg":2,"type":"event","ep":1643351317,"f":false,"lsl":572,"dsync":false},{"data":{"action":"register","id":"eqo47WqmRLy0HvN_PWIr1Q:APA91bENliczzBYRfXz4KARmXOjj9VyFzfceM6CXuOoAKo0w_VUYOcVx8uncBoXfbCZgfozw_XSyXLrPMf-PMFJg_z-uV71y_lyuopSmIaBS5_e22j0-r-gPYs7OjWcqsV0AyhtjD-nN","type":"fcm"},"s":1643350956,"pg":2,"type":"data","ep":1643351317,"f":false,"lsl":572,"dsync":false},{"mc":21484392,"nt":"WiFi","s":1643350956,"pg":3,"type":"ping","ep":1643351318,"f":false,"lsl":572,"dsync":false}]
//2022-01-28 11:58:39.191 14801-14916/? D/CleverTap:6K9-955-9K6Z: Sending queue to: https://sg1.wzrkt.com/a1?os=Android&t=40400&z=6K9-955-9K6Z&ts=1643351319
//2022-01-28 11:58:39.450 14801-14916/? I/CleverTapResponse: Done processing response!
//2022-01-28 11:58:39.450 14801-14916/? D/CleverTap:6K9-955-9K6Z: Queue sent successfully
//2022-01-28 11:58:39.483 14801-14916/? D/CleverTap:6K9-955-9K6Z: Send queue contains 1 items: [{"g":"__e1f3a1434c0c4df2ac85d6848b5f4988","type":"meta","af":{"Build":"2865","Version":"5.17.0","OS Version":"12","SDK Version":40400,"Latitude":19.1886221,"Longitude":73.0396217,"Make":"samsung","Model":"SM-G975F","Carrier":"Vi India","useIP":true,"OS":"Android","wdt":2.57,"hgt":4.8,"dpi":560,"dt":1,"abckt":"active","cc":"in","wifi":true,"BluetoothVersion":"ble","Radio":"4G"},"id":"6K9-955-9K6Z","tk":"55c-c36","l_ts":1643351319,"f_ts":1643350114,"ct_pi":"Email,Identity","ddnd":false,"rtl":[],"rct":0,"ait":0,"frs":false,"arp":{"sv":40400,"dh":805876337,"wdt":2,"d_ts":1643350113,"hgt":4,"av":"5.17.0","v":1,"e_ts":0,"j_n":"bmtqfwU=","i_n":"YG1reQs=","r_ts":1643351317,"id":"6K9-955-9K6Z","k_n":"[ \"gaurav.singh@clevertap.com\" , \"BB02479463\"]","j_s":"{ }"},"imp":0,"tlc":[]}, {"profile":{"MSG-push":true,"Email":"gaurav.singh@clevertap.com","Phone":"+919619314745","Identity":"BB02479463","Name":"Gaurav","Carrier":"Vi India","cc":"in","tz":"Asia\/Kolkata"},"s":1643350956,"pg":3,"type":"profile","ep":1643351318,"f":false,"lsl":572,"dsync":true}]
//2022-01-28 11:58:39.483 14801-14916/? D/CleverTap:6K9-955-9K6Z: Sending queue to: https://sg1.wzrkt.com/a1?os=Android&t=40400&z=6K9-955-9K6Z&ts=1643351319
//2022-01-28 11:58:39.600 14801-14916/? I/CleverTapResponse: Done processing response!
//2022-01-28 11:58:39.601 14801-14916/? D/CleverTap:6K9-955-9K6Z: Queue sent successfully