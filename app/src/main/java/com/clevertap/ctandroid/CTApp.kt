package com.clevertap.ctandroid

import android.app.Application
import android.util.Log
import com.clevertap.android.pushtemplates.PushTemplateNotificationHandler
import com.clevertap.android.sdk.ActivityLifecycleCallback
import com.clevertap.android.sdk.CleverTapAPI
import com.clevertap.android.sdk.interfaces.NotificationHandler
import com.clevertap.android.sdk.pushnotification.CTPushNotificationListener

class CTApp : Application(), CTPushNotificationListener {

    override fun onCreate() {
        ActivityLifecycleCallback.register(this)
//        CleverTapAPI.setNotificationHandler(PushTemplateNotificationHandler() as NotificationHandler);

        CleverTapAPI.setDebugLevel(3)
        CleverTapAPI.getDefaultInstance(applicationContext)?.apply {
            ctPushNotificationListener = this@CTApp
        }

        CleverTapAPI.setNotificationHandler(PushTemplateNotificationHandler() as NotificationHandler);

        super.onCreate()
    }

    override fun onNotificationClickedPayloadReceived(payload: HashMap<String, Any>?) {

        Log.e("MyApplication", "onNotificationClickedPayloadReceived = $payload")
    }

    //    override fun onNewIntent(intent: Intent?) {
//        super.onNewIntent(intent)
//
//        Log.e("load", "called")
//        // On Android 12, Raise notification clicked event when Activity is already running in activity backstack
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
//            cleverTapDefaultInstance?.pushNotificationClickedEvent(intent!!.extras)
//        }
//    }
}

