package com.clevertap.ctandroid

import android.app.NotificationManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.clevertap.android.sdk.CleverTapAPI
import com.clevertap.android.sdk.pushnotification.CTPushNotificationListener
import com.clevertap.android.sdk.pushnotification.fcm.CTFcmMessageHandler
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.gson.Gson
import java.util.HashMap

class FcmMessageListenerService: FirebaseMessagingService(), CTPushNotificationListener {

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
                        CleverTapAPI.getDefaultInstance(applicationContext)?.pushNotificationViewedEvent(extras)

                        CleverTapAPI.createNotification(applicationContext, extras)
//                        CleverTapAPI.getDefaultInstance(applicationContext).pa
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
//        CleverTapAPI.getDefaultInstance(this)?.r

    }

    override fun onNotificationClickedPayloadReceived(payload: HashMap<String, Any>?) {

            Log.e("Payload", "onNotificationClickedPayloadReceived = $payload")

    }
}
