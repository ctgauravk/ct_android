package com.clevertap.ctandroid

//import com.clevertap.android.sdk.CleverTapAPI
//import com.clevertap.android.pushtemplates.PTConstants
//import com.clevertap.android.pushtemplates.PushTemplateNotificationHandler
//import com.clevertap.android.sdk.ActivityLifecycleCallback
//import com.clevertap.android.sdk.CleverTapAPI
//import com.clevertap.android.sdk.interfaces.NotificationHandler
//import com.clevertap.android.sdk.pushnotification.CTPushNotificationListener
//import com.mparticle.MParticle
//import com.mparticle.MParticleOptions
//import com.segment.analytics.android.integrations.clevertap.CleverTapIntegration
import android.R
import android.app.Application
import android.app.NotificationManager
import android.content.Intent
import android.util.Log
import com.clevertap.android.sdk.ActivityLifecycleCallback
import com.clevertap.android.sdk.CleverTapAPI
import com.clevertap.android.sdk.pushnotification.CTPushNotificationListener
 import com.google.firebase.analytics.FirebaseAnalytics
import com.leanplum.Leanplum
import com.leanplum.LeanplumActivityHelper
import com.leanplum.annotations.Parser
import com.leanplum.callbacks.CleverTapInstanceCallback
import java.util.*


//import com..analytics.android.integrations.clevertap.CleverTapIntegration
class CTApp : Application()/*, CTPushNotificationListener, ActivityLifecycleCallbacks */{
    private var clevertap: CleverTapAPI? = null
    private var mFirebaseAnalytics: FirebaseAnalytics? = null
    override fun onCreate() {
//        CleverTapAPI.setNotificationHandler(PushTemplateNotificationHandler() as NotificationHandler);

//        Leanplum.setApplicationContext(this)
//        Parser.parseVariables(this)
//
//        //  For session lifecyle tracking. Must be called if you do not extend LeanplumApplication Class
//        LeanplumActivityHelper.enableLifecycleCallbacks(this)
//
//        // Insert your API keys here.
//        if (BuildConfig.DEBUG) {
//            Leanplum.setAppIdForProductionMode("app_u6X10hGhMG5qJ2bqffPnP5FsNV1cD5JiEDVBQuqAD6w",
//                "prod_fUKTczwzADi3LN2lO2LTwg2QwldCDZcIl8Y07CMm49c")
//        } else {
//            Leanplum.setAppIdForDevelopmentMode(
//                "app_u6X10hGhMG5qJ2bqffPnP5FsNV1cD5JiEDVBQuqAD6w",
//                "prod_fUKTczwzADi3LN2lO2LTwg2QwldCDZcIl8Y07CMm49c"
//            )
//        }
//
//        // This will only run once per session, even if the activity is restarted.
//        Leanplum.start(this);
//
//        setCleverTapMethods()
//        ActivityLifecycleCallback.register(this)


        super.onCreate()


        Leanplum.setApplicationContext(this);
        Parser.parseVariables(this);

        //  For session lifecyle tracking. Must be called if you do not extend LeanplumApplication Class
        LeanplumActivityHelper.enableLifecycleCallbacks(this);
        val ctCallback = CleverTapInstanceCallback { it: CleverTapAPI ->
            it.enableDeviceNetworkInfoReporting(true)


            CleverTapAPI.createNotificationChannel(
                this,
                "activity",
                "Activity",
                "desc",
                5,
                true)


        }






        Leanplum.addCleverTapInstanceCallback(ctCallback)

        if (BuildConfig.DEBUG) {
            Leanplum.setAppIdForDevelopmentMode("app_u6X10hGhMG5qJ2bqffPnP5FsNV1cD5JiEDVBQuqAD6w", "dev_I9QfkPt72NZdd0HaZsp0LdVAy2MHS2HYtThIgBOHJ7w");
        } else {
            Leanplum.setAppIdForProductionMode("app_u6X10hGhMG5qJ2bqffPnP5FsNV1cD5JiEDVBQuqAD6w", "prod_fUKTczwzADi3LN2lO2LTwg2QwldCDZcIl8Y07CMm49c");
        }

        // This will only run once per session, even if the activity is restarted.
        Leanplum.start(this)
        Leanplum.setLogLevel(3)
//        val options = MParticleOptions.builder(this)
//            .credentials("us1-3e81cd679eda1148a8f99262f4ae06cf", "8I7aVDndQNUSMSuLYVyGUDCOWApyVIRp8xHhiSwm0Ay0_eqTgTF58iYJpLZrh2mS")
//            .environment(MParticle.Environment.Development)
//
//            .build()
//        MParticle.start(options)

//        12the June uncomment
//        val analytics: Analytics = Analytics.Builder(applicationContext, "LB3BaAT7D1y0uFboloCsRHLKEpsASUfU")
//            .logLevel(Analytics.LogLevel.VERBOSE)
//            .use(CleverTapIntegration.FACTORY)
//            .build()
// ends

//
//        val analytics = Analytics.Builder(applicationContext, WRITE_KEY)
//            .logLevel(Analytics.LogLevel.VERBOSE)
//            .use(CleverTapIntegration.FACTORY)
//            .build()
//
//starts
//        analytics.onIntegrationReady<CleverTapAPI>("CleverTap") { instance ->
//            Log.i("TAG", "analytics.onIntegrationReady() called")
//            cleverTapIntegrationReady(instance)
//        }
//        Analytics.setSingletonInstance(analytics)



//        clevertap?.getCleverTapID {
//
//
//
//            mFirebaseAnalytics?.setUserProperty("ct_objectId",
//                Objects.requireNonNull(CleverTapAPI.getDefaultInstance(this))?.cleverTapID
//            )
//        }
    }

    private fun cleverTapIntegrationReady(instance: CleverTapAPI) {
//        instance.enablePersonalization()
//        sCleverTapSegmentEnabled = true
//        clevertap = instance
    }

    public fun setCleverTapMethods() {
        Log.e("called","123456789")
        ActivityLifecycleCallback.register(this)
        CleverTapAPI.setDebugLevel(3)
//        CleverTapAPI.getDefaultInstance(applicationContext)?.apply {
//            ctPushNotificationListener = this@CTApp
//        }

//        CleverTapAPI.setNotificationHandler(PushTemplateNotificationHandler() as NotificationHandler);



    }



//    override fun onNotificationClickedPayloadReceived(payload: HashMap<String, Any>?) {
//
//        Log.e("MyApplication", "onNotificationClickedPayloadReceived = $payload")
//        var intent: Intent = Intent(applicationContext, HomeActivity::class.java)
//        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//        startActivity( intent)
//    }

    fun intializeKuwait(){


    }

    fun initializeOman(){

    }

    fun getInstance(): CleverTapAPI{
        return CleverTapAPI.getDefaultInstance(this)!!
    }

//    override fun onActivityCreated(p0: Activity, p1: Bundle?) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
//            NotificationUtils.dismissNotification(p0.intent, applicationContext)
//        }
//    }
//
//    override fun onActivityStarted(p0: Activity) {
//     }
//
//    override fun onActivityResumed(p0: Activity) {
//     }
//
//    override fun onActivityPaused(p0: Activity) {
//     }
//
//    override fun onActivityStopped(p0: Activity) {
//     }
//
//    override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
//
//    }
//
//    override fun onActivityDestroyed(p0: Activity) {
//
//    }


//    object NotificationUtils {
//
//            //Require to close notification on action button click
//            fun dismissNotification(intent: Intent?, applicationContext: Context){
//                intent?.extras?.apply {
//                    var autoCancel = true
//                    var notificationId = -1
//
//                    getString("actionId")?.let {
//                        Log.d("ACTION_ID", it)
//                        autoCancel = getBoolean("autoCancel", true)
//                        notificationId = getInt("notificationId", -1)
//                    }
//                    /**
//                     * If using InputBox template, add ptDismissOnClick flag to not dismiss notification
//                     * if pt_dismiss_on_click is false in InputBox template payload. Alternatively if normal
//                     * notification is raised then we dismiss notification.
//                     */
//                    val ptDismissOnClick = intent.extras!!.getString(PTConstants.PT_DISMISS_ON_CLICK,"")
//
//                    if (autoCancel && notificationId > -1 && ptDismissOnClick.isNullOrEmpty()) {
//                        val notifyMgr: NotificationManager =
//                            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//                        notifyMgr.cancel(notificationId)
//                    }
//                }
//            }
//
//    }

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

