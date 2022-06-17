package com.clevertap.ctandroid

import android.os.Bundle
import android.util.Log
import com.clevertap.android.sdk.CleverTapAPI
import com.clevertap.android.sdk.pushnotification.fcm.CTFcmMessageHandler
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.gson.Gson

class FcmMessageListenerService: FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        Log.e("FCM", "onMessageReceived: " + Gson().toJson(message))
//        Your discount is {% if Profile["Plan Type"== 'Gold'%} 30% {% else %}10% {% endif %}
        message.data.apply {
            try {
                if (size > 0) {
                    val extras = Bundle()
                    for ((key, value) in this) {
                        extras.putString(key, value)
                    }
                    val info = CleverTapAPI.getNotificationInfo(extras)
//                    wzrk_cid=clevertap
                    if (info.fromCleverTap) {
                        CleverTapAPI.createNotification(applicationContext, extras)
                    } else {
                        // not from CleverTap handle yourself or pass to another provider
                    }
                }
            } catch (t: Throwable) {
                Log.e("FCM", "Error parsing FCM message", t.fillInStackTrace())
            }
        }

    }

//    override fun onMessageReceived(message: RemoteMessage) {
//        CTFcmMessageHandler()
//            .createNotification(applicationContext, message)
//    }

    override fun onNewToken(token: String) {
        Log.e("FCM", "onNewToken: $token")
        CleverTapAPI.getDefaultInstance(this)?.pushFcmRegistrationId(token, true)
    }
}

// Activity Lifecycle Callback successfully registered
//2022-01-28 12:59:28.937 20086-20176/? D/CleverTap: ExoPlayer library files are missing!!!
//2022-01-28 12:59:28.937 20086-20176/? D/CleverTap: Please add ExoPlayer dependencies to render InApp or Inbox messages playing video. For more information checkout CleverTap documentation.
//2022-01-28 12:59:28.937 20086-20176/? D/CleverTap: ExoPlayer classes not found
//2022-01-28 12:59:28.938 20086-20176/? D/CleverTap: READ_PHONE_STATE permission not asked by the app or not granted by the user
//2022-01-28 12:59:28.940 20086-20086/? I/CleverTap: CleverTap SDK initialized with accountId: 6K9-955-9K6Z accountToken: 55c-c36 accountRegion: sg1
//2022-01-28 12:59:28.940 20086-20181/? D/CleverTap: READ_PHONE_STATE permission not asked by the app or not granted by the user
//2022-01-28 12:59:28.943 20086-20181/? I/CleverTap: SDK Version Code is 40400
//2022-01-28 12:59:28.944 20086-20181/? I/CleverTap: sdk.pushnotification.CTPushNotificationReceiver is present
//2022-01-28 12:59:28.946 20086-20181/? I/CleverTap: pushnotification.CTNotificationIntentService not present
//2022-01-28 12:59:28.948 20086-20181/? I/CleverTap: InAppNotificationActivity is present
//2022-01-28 12:59:28.949 20086-20181/? I/CleverTap: inbox.CTInboxActivity is present
//2022-01-28 12:59:28.949 20086-20181/? I/CleverTap: geofence.CTGeofenceReceiver not present
//2022-01-28 12:59:28.949 20086-20181/? I/CleverTap: geofence.CTLocationUpdateReceiver not present
//2022-01-28 12:59:28.949 20086-20181/? I/CleverTap: geofence.CTGeofenceBootReceiver not present
//2022-01-28 12:59:28.949 20086-20181/? I/CleverTap: pushnotification.amp.CTBackgroundJobService is present
//2022-01-28 12:59:28.949 20086-20181/? I/CleverTap: pushnotification.amp.CTBackgroundIntentService is present
//2022-01-28 12:59:28.949 20086-20181/? I/CleverTap: pushnotification.fcm.FcmMessageListenerService not present
//2022-01-28 12:59:29.021 20086-20181/? I/CleverTap:6K9-955-9K6Z: Notification channel MyBluebird Notification has been created
//2022-01-28 12:59:29.218 20086-20086/? D/CleverTap:6K9-955-9K6Z: In-app notifications will not be shown on []
//2022-01-28 12:59:29.245 20086-20181/? D/CleverTap:6K9-955-9K6Z: Queued event: {"evtName":"App Launched","evtData":{"Build":"2865","Version":"5.17.0","OS Version":"12","SDK Version":40400,"Make":"samsung","Model":"SM-G975F","Carrier":"Vi India","useIP":false,"OS":"Android","wdt":2.57,"hgt":4.8,"dpi":560,"dt":1,"abckt":"active","cc":"in"},"s":1643354969,"pg":1,"type":"event","ep":1643354969,"f":true,"lsl":0,"pai":"com.seatech.bluebird","dsync":true}
//2022-01-28 12:59:29.245 20086-20181/? D/CleverTap:6K9-955-9K6Z: Network retry #0
//2022-01-28 12:59:29.247 20086-20181/? D/CleverTap:6K9-955-9K6Z: Failure count is 0. Setting delay frequency to 1s
//2022-01-28 12:59:29.263 20086-20181/? D/CleverTap:6K9-955-9K6Z: Queued event: {"evtName":"wzrk_fetch","evtData":{"t":1},"s":1643354969,"pg":1,"type":"event","ep":1643354969,"f":true,"lsl":0,"dsync":false}
//2022-01-28 12:59:29.263 20086-20181/? D/CleverTap:6K9-955-9K6Z: Network retry #0
//2022-01-28 12:59:29.263 20086-20181/? D/CleverTap:6K9-955-9K6Z: Failure count is 0. Setting delay frequency to 1s
//2022-01-28 12:59:29.290 20086-20181/? D/CleverTap:6K9-955-9K6Z: Queued event: {"profile":{"Carrier":"Vi India","cc":"in","tz":"Asia\/Kolkata"},"s":1643354969,"pg":1,"type":"profile","ep":1643354969,"f":true,"lsl":0,"dsync":true}
//2022-01-28 12:59:29.290 20086-20181/? D/CleverTap:6K9-955-9K6Z: Network retry #0
//2022-01-28 12:59:29.290 20086-20181/? D/CleverTap:6K9-955-9K6Z: Failure count is 0. Setting delay frequency to 1s
//2022-01-28 12:59:29.652 20086-20086/? D/CleverTap: Referrer data: {
//        "us": "google-play",
//        "um": "organic"
//    }
//2022-01-28 12:59:29.652 20086-20086/? D/CleverTap:6K9-955-9K6Z: Install Referrer data set [Referrer URL-utm_source=google-play&utm_medium=organic]
//2022-01-28 12:59:29.672 20086-20181/? D/CleverTap:6K9-955-9K6Z: Queued event: {"us":"google-play","um":"organic","referrer":"wzrk:\/\/track?install=true&utm_source=google-play&utm_medium=organic","install":"true","s":1643354969,"pg":1,"type":"page","ep":1643354969,"f":true,"lsl":0,"dsync":false}
//2022-01-28 12:59:29.672 20086-20181/? D/CleverTap:6K9-955-9K6Z: Network retry #0
//2022-01-28 12:59:29.672 20086-20181/? D/CleverTap:6K9-955-9K6Z: Failure count is 0. Setting delay frequency to 1s
//2022-01-28 12:59:29.847 20086-20181/? D/CleverTap:6K9-955-9K6Z: Queued event: {"data":{"action":"register","id":"fHwvyP-_SfSfZGfUAyvwTd:APA91bEE_xsGBb2qJxXFUrIt7H-0IFywED94m5pH4CNUf2d4yKAwrOLHPAyHUkcopOXPA0qE3ng3F3FWBwtnsUFuoTFAPHSEAFAZdqBrfQtx2EnBuePdBiFrf7DKqbgLj5WObHrs_THp","type":"fcm"},"s":1643354969,"pg":1,"type":"data","ep":1643354969,"f":true,"lsl":0,"dsync":false}
//2022-01-28 12:59:29.847 20086-20181/? D/CleverTap:6K9-955-9K6Z: Network retry #0
//2022-01-28 12:59:29.847 20086-20181/? D/CleverTap:6K9-955-9K6Z: Failure count is 0. Setting delay frequency to 1s
//2022-01-28 12:59:29.857 20086-20181/? D/CleverTap:6K9-955-9K6Z: Queued event: {"data":{"action":"register","id":"fHwvyP-_SfSfZGfUAyvwTd:APA91bEE_xsGBb2qJxXFUrIt7H-0IFywED94m5pH4CNUf2d4yKAwrOLHPAyHUkcopOXPA0qE3ng3F3FWBwtnsUFuoTFAPHSEAFAZdqBrfQtx2EnBuePdBiFrf7DKqbgLj5WObHrs_THp","type":"fcm"},"s":1643354969,"pg":1,"type":"data","ep":1643354969,"f":true,"lsl":0,"dsync":false}
//2022-01-28 12:59:29.857 20086-20181/? D/CleverTap:6K9-955-9K6Z: Network retry #0
//2022-01-28 12:59:29.857 20086-20181/? D/CleverTap:6K9-955-9K6Z: Failure count is 0. Setting delay frequency to 1s
//2022-01-28 12:59:30.884 20086-20181/? D/CleverTap:6K9-955-9K6Z: Send queue contains 5 items: [{"g":"__95dce23778be4621a720b4f9d44628e9","type":"meta","af":{"Build":"2865","Version":"5.17.0","OS Version":"12","SDK Version":40400,"Make":"samsung","Model":"SM-G975F","Carrier":"Vi India","useIP":false,"OS":"Android","wdt":2.57,"hgt":4.8,"dpi":560,"dt":1,"abckt":"active","cc":"in"},"id":"6K9-955-9K6Z","tk":"55c-c36","l_ts":0,"f_ts":0,"ct_pi":"Email,Identity","ddnd":false,"rtl":[],"frs":true,"ref":{"us":"google-play","um":"organic"},"imp":0,"tlc":[]}, {"evtName":"App Launched","evtData":{"Build":"2865","Version":"5.17.0","OS Version":"12","SDK Version":40400,"Make":"samsung","Model":"SM-G975F","Carrier":"Vi India","useIP":false,"OS":"Android","wdt":2.57,"hgt":4.8,"dpi":560,"dt":1,"abckt":"active","cc":"in"},"s":1643354969,"pg":1,"type":"event","ep":1643354969,"f":true,"lsl":0,"pai":"com.seatech.bluebird","dsync":true},{"evtName":"wzrk_fetch","evtData":{"t":1},"s":1643354969,"pg":1,"type":"event","ep":1643354969,"f":true,"lsl":0,"dsync":false},{"us":"google-play","um":"organic","referrer":"wzrk:\/\/track?install=true&utm_source=google-play&utm_medium=organic","install":"true","s":1643354969,"pg":1,"type":"page","ep":1643354969,"f":true,"lsl":0,"dsync":false},{"data":{"action":"register","id":"fHwvyP-_SfSfZGfUAyvwTd:APA91bEE_xsGBb2qJxXFUrIt7H-0IFywED94m5pH4CNUf2d4yKAwrOLHPAyHUkcopOXPA0qE3ng3F3FWBwtnsUFuoTFAPHSEAFAZdqBrfQtx2EnBuePdBiFrf7DKqbgLj5WObHrs_THp","type":"fcm"},"s":1643354969,"pg":1,"type":"data","ep":1643354969,"f":true,"lsl":0,"dsync":false},{"data":{"action":"register","id":"fHwvyP-_SfSfZGfUAyvwTd:APA91bEE_xsGBb2qJxXFUrIt7H-0IFywED94m5pH4CNUf2d4yKAwrOLHPAyHUkcopOXPA0qE3ng3F3FWBwtnsUFuoTFAPHSEAFAZdqBrfQtx2EnBuePdBiFrf7DKqbgLj5WObHrs_THp","type":"fcm"},"s":1643354969,"pg":1,"type":"data","ep":1643354969,"f":true,"lsl":0,"dsync":false}]
//2022-01-28 12:59:30.884 20086-20181/? D/CleverTap:6K9-955-9K6Z: Sending queue to: https://sg1.wzrkt.com/a1?os=Android&t=40400&z=6K9-955-9K6Z&ts=1643354970
//2022-01-28 12:59:31.147 20086-20181/? I/CleverTapResponse: Done processing response!
//2022-01-28 12:59:31.148 20086-20181/? D/CleverTap:6K9-955-9K6Z: Queue sent successfully
//2022-01-28 12:59:31.172 20086-20181/? D/CleverTap:6K9-955-9K6Z: Send queue contains 1 items: [{"g":"__95dce23778be4621a720b4f9d44628e9","type":"meta","af":{"Build":"2865","Version":"5.17.0","OS Version":"12","SDK Version":40400,"Make":"samsung","Model":"SM-G975F","Carrier":"Vi India","useIP":false,"OS":"Android","wdt":2.57,"hgt":4.8,"dpi":560,"dt":1,"abckt":"active","cc":"in"},"id":"6K9-955-9K6Z","tk":"55c-c36","l_ts":1643354970,"f_ts":1643354970,"ct_pi":"Email,Identity","ddnd":false,"rtl":[],"frs":false,"arp":{"sv":40400,"dh":-565529647,"wdt":2,"d_ts":1643354969,"hgt":4,"av":"5.17.0","v":1,"e_ts":0,"j_n":"Zw==","i_n":"ZWNifQ==","r_ts":1643354969,"id":"6K9-955-9K6Z","j_s":"{ }"},"ref":{"us":"google-play","um":"organic"},"imp":0,"tlc":[]}, {"profile":{"Carrier":"Vi India","cc":"in","tz":"Asia\/Kolkata"},"s":1643354969,"pg":1,"type":"profile","ep":1643354969,"f":true,"lsl":0,"dsync":true}]
//2022-01-28 12:59:31.172 20086-20181/? D/CleverTap:6K9-955-9K6Z: Sending queue to: https://sg1.wzrkt.com/a1?os=Android&t=40400&z=6K9-955-9K6Z&ts=1643354971
//2022-01-28 12:59:31.284 20086-20181/? I/CleverTapResponse: Done processing response!
//2022-01-28 12:59:31.284 20086-20181/? D/CleverTap:6K9-955-9K6Z: Queue sent successfully





//Activity Lifecycle Callback successfully registered
//2022-02-03 13:27:56.324 10189-10189/co.carefer I/CleverTap: Account ID or Account token is missing from AndroidManifest.xml, unable to create default instance
//2022-02-03 13:27:56.355 10189-10189/co.carefer I/CleverTap: Account ID or Account token is missing from AndroidManifest.xml, unable to create default instance
//2022-02-03 13:27:56.485 10189-10189/co.carefer I/CleverTap: Account ID or Account token is missing from AndroidManifest.xml, unable to create default instance
//2022-02-03 13:27:56.678 10189-10189/co.carefer I/CleverTap: Account ID or Account token is missing from AndroidManifest.xml, unable to create default instance
//2022-02-03 13:27:56.764 10189-10309/co.carefer D/CleverTap: ExoPlayer is present
//2022-02-03 13:27:56.765 10189-10309/co.carefer D/CleverTap: READ_PHONE_STATE permission not asked by the app or not granted by the user
//2022-02-03 13:27:56.773 10189-10189/co.carefer I/CleverTap: CleverTap SDK initialized with accountId: R7R-RWK-Z46Z accountToken: 302-2a2 accountRegion:
//2022-02-03 13:27:56.773 10189-10189/co.carefer I/Analytics-CleverTap: Configured CleverTap+Segment integration and initialized CleverTap.
//2022-02-03 13:27:56.773 10189-10189/co.carefer I/CLEVERTAP.co.carefer.App.AppController: analytics.onIntegrationReady() called
//2022-02-03 13:27:56.774 10189-10189/co.carefer D/CleverTap:R7R-RWK-Z46Z: Push notification: NULL not from CleverTap - will not process Notification Clicked event.
//2022-02-03 13:27:56.774 10189-10189/co.carefer D/Analytics: Ran Activity Created on integration CleverTap in 119792 ns.
//2022-02-03 13:27:56.779 10189-10314/co.carefer D/CleverTap:R7R-RWK-Z46Z: Job scheduled - -2037060283
//2022-02-03 13:27:56.779 10189-10314/co.carefer D/CleverTap: READ_PHONE_STATE permission not asked by the app or not granted by the user
//2022-02-03 13:27:56.785 10189-10314/co.carefer I/CleverTap: SDK Version Code is 40400
//2022-02-03 13:27:56.786 10189-10314/co.carefer I/CleverTap: sdk.pushnotification.CTPushNotificationReceiver is present
//2022-02-03 13:27:56.786 10189-10314/co.carefer I/CleverTap: pushnotification.CTNotificationIntentService not present
//2022-02-03 13:27:56.787 10189-10314/co.carefer I/CleverTap: InAppNotificationActivity is present
//2022-02-03 13:27:56.787 10189-10314/co.carefer I/CleverTap: inbox.CTInboxActivity is present
//2022-02-03 13:27:56.787 10189-10314/co.carefer I/CleverTap: geofence.CTGeofenceReceiver not present
//2022-02-03 13:27:56.788 10189-10314/co.carefer I/CleverTap: geofence.CTLocationUpdateReceiver not present
//2022-02-03 13:27:56.788 10189-10314/co.carefer I/CleverTap: geofence.CTGeofenceBootReceiver not present
//2022-02-03 13:27:56.788 10189-10314/co.carefer I/CleverTap: pushnotification.amp.CTBackgroundJobService is present
//2022-02-03 13:27:56.788 10189-10314/co.carefer I/CleverTap: pushnotification.amp.CTBackgroundIntentService is present
//2022-02-03 13:27:56.788 10189-10314/co.carefer I/CleverTap: pushnotification.fcm.FcmMessageListenerService is present
//2022-02-03 13:27:56.805 10189-10189/co.carefer D/Analytics: Ran Activity Started on integration CleverTap in 709 ns.
//2022-02-03 13:27:56.806 10189-10189/co.carefer D/CleverTap:R7R-RWK-Z46Z: In-app notifications will not be shown on [.Activities.SplashActivity]
//2022-02-03 13:27:56.807 10189-10189/co.carefer D/Analytics: Ran Activity Resumed on integration CleverTap in 1098875 ns.
//2022-02-03 13:27:56.863 10189-10314/co.carefer D/CleverTap:R7R-RWK-Z46Z: Queued event: {"evtName":"App Launched","evtData":{"Build":"246","Version":"4.11.0","OS Version":"12","SDK Version":40400,"Make":"Google","Model":"sdk_gphone64_arm64","Carrier":"T-Mobile","useIP":false,"OS":"Android","wdt":2.45,"hgt":4.73,"dpi":440,"dt":1,"abckt":"active","lib":"Segment-Android","cc":"us"},"s":1643875076,"pg":1,"type":"event","ep":1643875076,"f":true,"lsl":0,"pai":"co.carefer","dsync":true}
//2022-02-03 13:27:56.864 10189-10314/co.carefer D/CleverTap:R7R-RWK-Z46Z: Network retry #0
//2022-02-03 13:27:56.864 10189-10314/co.carefer D/CleverTap:R7R-RWK-Z46Z: Failure count is 0. Setting delay frequency to 1s
//2022-02-03 13:27:56.871 10189-10314/co.carefer D/CleverTap:R7R-RWK-Z46Z: Queued event: {"evtName":"wzrk_fetch","evtData":{"t":1},"s":1643875076,"pg":1,"type":"event","ep":1643875076,"f":true,"lsl":0,"dsync":false}
//2022-02-03 13:27:56.871 10189-10314/co.carefer D/CleverTap:R7R-RWK-Z46Z: Network retry #0
//2022-02-03 13:27:56.871 10189-10314/co.carefer D/CleverTap:R7R-RWK-Z46Z: Failure count is 0. Setting delay frequency to 1s
//2022-02-03 13:27:56.883 10189-10314/co.carefer D/CleverTap:R7R-RWK-Z46Z: Queued event: {"profile":{"Carrier":"T-Mobile","cc":"us","tz":"Asia\/Kolkata"},"s":1643875076,"pg":1,"type":"profile","ep":1643875076,"f":true,"lsl":0,"dsync":true}
//2022-02-03 13:27:56.883 10189-10314/co.carefer D/CleverTap:R7R-RWK-Z46Z: Network retry #0
//2022-02-03 13:27:56.883 10189-10314/co.carefer D/CleverTap:R7R-RWK-Z46Z: Failure count is 0. Setting delay frequency to 1s
//2022-02-03 13:27:57.115 10189-10189/co.carefer D/CleverTap: Referrer data: {
//        "us": "google-play",
//        "um": "organic"
//    }
//2022-02-03 13:27:57.115 10189-10189/co.carefer D/CleverTap:R7R-RWK-Z46Z: Install Referrer data set [Referrer URL-utm_source=google-play&utm_medium=organic]
//2022-02-03 13:27:57.157 10189-10314/co.carefer D/CleverTap:R7R-RWK-Z46Z: Queued event: {"us":"google-play","um":"organic","referrer":"wzrk:\/\/track?install=true&utm_source=google-play&utm_medium=organic","install":"true","s":1643875076,"pg":1,"type":"page","ep":1643875077,"f":true,"lsl":0,"dsync":false}
//2022-02-03 13:27:57.158 10189-10314/co.carefer D/CleverTap:R7R-RWK-Z46Z: Network retry #0
//2022-02-03 13:27:57.158 10189-10314/co.carefer D/CleverTap:R7R-RWK-Z46Z: Failure count is 0. Setting delay frequency to 1s
//2022-02-03 13:27:57.456 10189-10314/co.carefer D/CleverTap:R7R-RWK-Z46Z: Queued event: {"data":{"action":"register","id":"eOKtye61Sxq4Myx8Figw6U:APA91bFxllj7XAEO9LfTaQ_TG0iWflUwkZP_iOE08486y5uTDfzqR3-nhIs82pna-QKf54H3PnBun0F6-0y3M1vJAaOqYyli8KoW7kboc1KKPJ_l4E6UyBWt2wiEs2qzFT09ZnnF7NTj","type":"fcm"},"s":1643875076,"pg":1,"type":"data","ep":1643875077,"f":true,"lsl":0,"dsync":false}
//2022-02-03 13:27:57.456 10189-10314/co.carefer D/CleverTap:R7R-RWK-Z46Z: Network retry #0
//2022-02-03 13:27:57.456 10189-10314/co.carefer D/CleverTap:R7R-RWK-Z46Z: Failure count is 0. Setting delay frequency to 1s
//2022-02-03 13:27:58.431 10189-10189/co.carefer D/CleverTap:R7R-RWK-Z46Z: For event "Install Attributed": Property value for property campaign wasn't a primitive ({source=Organic, name=null, content=null, adCreative=null, adGroup=null})
//2022-02-03 13:27:58.431 10189-10189/co.carefer D/Analytics: Ran TrackPayload{event="Install Attributed"} on integration CleverTap in 847125 ns.
//2022-02-03 13:27:58.441 10189-10314/co.carefer D/CleverTap:R7R-RWK-Z46Z: Queued event: {"evtName":"Install Attributed","evtData":{"provider":"Adjust","trackerToken":"48nai84","trackerName":"Organic"},"s":1643875076,"pg":1,"type":"event","ep":1643875078,"f":true,"lsl":0,"wzrk_error":{"c":512,"d":"For event \"Install Attributed\": Property value for property campaign wasn't a primitive ({source=Organic, name=null, content=null, adCreative=null, adGroup=null})"},"dsync":false}
//2022-02-03 13:27:58.441 10189-10314/co.carefer D/CleverTap:R7R-RWK-Z46Z: Network retry #0
//2022-02-03 13:27:58.442 10189-10314/co.carefer D/CleverTap:R7R-RWK-Z46Z: Failure count is 0. Setting delay frequency to 1s
//2022-02-03 13:27:59.865 10189-10314/co.carefer D/CleverTap:R7R-RWK-Z46Z: Send queue contains 5 items: [{"g":"__gbdd15850db924f6caf3a46af6b39d8ed","type":"meta","af":{"Build":"246","Version":"4.11.0","OS Version":"12","SDK Version":40400,"GoogleAdID":"bdd15850db924f6caf3a46af6b39d8ed","GoogleAdIDLimit":false,"Make":"Google","Model":"sdk_gphone64_arm64","Carrier":"T-Mobile","useIP":false,"OS":"Android","wdt":2.45,"hgt":4.73,"dpi":440,"dt":1,"abckt":"active","lib":"Segment-Android","cc":"us"},"id":"R7R-RWK-Z46Z","tk":"302-2a2","l_ts":0,"f_ts":0,"ct_pi":"Email,Identity","ddnd":false,"rtl":[],"frs":true,"ref":{"us":"google-play","um":"organic"},"imp":0,"tlc":[]}, {"evtName":"App Launched","evtData":{"Build":"246","Version":"4.11.0","OS Version":"12","SDK Version":40400,"Make":"Google","Model":"sdk_gphone64_arm64","Carrier":"T-Mobile","useIP":false,"OS":"Android","wdt":2.45,"hgt":4.73,"dpi":440,"dt":1,"abckt":"active","lib":"Segment-Android","cc":"us"},"s":1643875076,"pg":1,"type":"event","ep":1643875076,"f":true,"lsl":0,"pai":"co.carefer","dsync":true},{"evtName":"wzrk_fetch","evtData":{"t":1},"s":1643875076,"pg":1,"type":"event","ep":1643875076,"f":true,"lsl":0,"dsync":false},{"us":"google-play","um":"organic","referrer":"wzrk:\/\/track?install=true&utm_source=google-play&utm_medium=organic","install":"true","s":1643875076,"pg":1,"type":"page","ep":1643875077,"f":true,"lsl":0,"dsync":false},{"data":{"action":"register","id":"eOKtye61Sxq4Myx8Figw6U:APA91bFxllj7XAEO9LfTaQ_TG0iWflUwkZP_iOE08486y5uTDfzqR3-nhIs82pna-QKf54H3PnBun0F6-0y3M1vJAaOqYyli8KoW7kboc1KKPJ_l4E6UyBWt2wiEs2qzFT09ZnnF7NTj","type":"fcm"},"s":1643875076,"pg":1,"type":"data","ep":1643875077,"f":true,"lsl":0,"dsync":false},{"evtName":"Install Attributed","evtData":{"provider":"Adjust","trackerToken":"48nai84","trackerName":"Organic"},"s":1643875076,"pg":1,"type":"event","ep":1643875078,"f":true,"lsl":0,"wzrk_error":{"c":512,"d":"For event \"Install Attributed\": Property value for property campaign wasn't a primitive ({source=Organic, name=null, content=null, adCreative=null, adGroup=null})"},"dsync":false}]
//2022-02-03 13:27:59.865 10189-10314/co.carefer D/CleverTap:R7R-RWK-Z46Z: Sending queue to: https://eu1.clevertap-prod.com/a1?os=Android&t=40400&z=R7R-RWK-Z46Z&ts=1643875079
//2022-02-03 13:28:00.166 10189-10314/co.carefer I/CleverTapResponse: Done processing response!
//2022-02-03 13:28:00.167 10189-10314/co.carefer D/CleverTap:R7R-RWK-Z46Z: Queue sent successfully
//2022-02-03 13:28:00.173 10189-10314/co.carefer D/CleverTap:R7R-RWK-Z46Z: Send queue contains 1 items: [{"g":"__gbdd15850db924f6caf3a46af6b39d8ed","type":"meta","af":{"Build":"246","Version":"4.11.0","OS Version":"12","SDK Version":40400,"GoogleAdID":"bdd15850db924f6caf3a46af6b39d8ed","GoogleAdIDLimit":false,"Make":"Google","Model":"sdk_gphone64_arm64","Carrier":"T-Mobile","useIP":false,"OS":"Android","wdt":2.45,"hgt":4.73,"dpi":440,"dt":1,"abckt":"active","lib":"Segment-Android","cc":"us"},"id":"R7R-RWK-Z46Z","tk":"302-2a2","l_ts":1643875079,"f_ts":1643875079,"ct_pi":"Email,Identity","ddnd":false,"rtl":[],"frs":false,"arp":{"sv":40400,"dh":-839050337,"wdt":2,"d_ts":1643875077,"hgt":4,"av":"4.11.0","v":1,"e_ts":0,"j_n":"Zw==","i_n":"Ymhqfg==","r_ts":1643877037,"id":"R7R-RWK-Z46Z","j_s":"{ }"},"ref":{"us":"google-play","um":"organic"},"imp":0,"tlc":[]}, {"profile":{"Carrier":"T-Mobile","cc":"us","tz":"Asia\/Kolkata"},"s":1643875076,"pg":1,"type":"profile","ep":1643875076,"f":true,"lsl":0,"dsync":true}]
//2022-02-03 13:28:00.173 10189-10314/co.carefer D/CleverTap:R7R-RWK-Z46Z: Sending queue to: https://eu1.clevertap-prod.com/a1?os=Android&t=40400&z=R7R-RWK-Z46Z&ts=1643875080
//2022-02-03 13:28:00.388 10189-10314/co.carefer I/CleverTapResponse: Done processing response!
//2022-02-03 13:28:00.388 10189-10314/co.carefer D/CleverTap:R7R-RWK-Z46Z: Queue sent successfully