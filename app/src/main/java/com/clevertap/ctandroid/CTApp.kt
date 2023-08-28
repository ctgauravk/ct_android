package com.clevertap.ctandroid

import android.app.Application
import android.util.Log
import com.clevertap.android.pushtemplates.PushTemplateNotificationHandler
import com.clevertap.android.sdk.ActivityLifecycleCallback
import com.clevertap.android.sdk.CleverTapAPI
import com.clevertap.android.sdk.interfaces.NotificationHandler
import com.clevertap.android.sdk.pushnotification.CTPushNotificationListener
import com.segment.analytics.Analytics
import com.segment.analytics.android.integrations.clevertap.CleverTapIntegration

//import com..analytics.android.integrations.clevertap.CleverTapIntegration
class CTApp : Application(), CTPushNotificationListener {
    private var clevertap: CleverTapAPI? = null

    override fun onCreate() {
//        CleverTapAPI.setNotificationHandler(PushTemplateNotificationHandler() as NotificationHandler);


        setCleverTapMethods()
        super.onCreate()


        val analytics: Analytics = Analytics.Builder(applicationContext, "LB3BaAT7D1y0uFboloCsRHLKEpsASUfU")
            .logLevel(Analytics.LogLevel.VERBOSE)
            .use(CleverTapIntegration.FACTORY)
            .build()
//
//        val analytics = Analytics.Builder(applicationContext, WRITE_KEY)
//            .logLevel(Analytics.LogLevel.VERBOSE)
//            .use(CleverTapIntegration.FACTORY)
//            .build()
//
//
        analytics.onIntegrationReady<CleverTapAPI>("CleverTap") { instance ->
            Log.i("TAG", "analytics.onIntegrationReady() called")
            cleverTapIntegrationReady(instance)
        }
        Analytics.setSingletonInstance(analytics)
    }

    private fun cleverTapIntegrationReady(instance: CleverTapAPI) {
//        instance.enablePersonalization()
//        sCleverTapSegmentEnabled = true
        clevertap = instance
    }

    public fun setCleverTapMethods() {
//        Log.e("called","")
        ActivityLifecycleCallback.register(this)
        CleverTapAPI.setDebugLevel(3)
        CleverTapAPI.getDefaultInstance(applicationContext)?.apply {
            ctPushNotificationListener = this@CTApp
        }

        CleverTapAPI.setNotificationHandler(PushTemplateNotificationHandler() as NotificationHandler);

    }

    override fun onNotificationClickedPayloadReceived(payload: HashMap<String, Any>?) {

        Log.e("MyApplication", "onNotificationClickedPayloadReceived = $payload")
    }

    fun intializeKuwait(){


    }

    fun initializeOman(){

    }

    fun getInstance(): CleverTapAPI{
        return CleverTapAPI.getDefaultInstance(this)!!
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

