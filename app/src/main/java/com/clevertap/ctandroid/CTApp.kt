package com.clevertap.ctandroid

import android.app.Application
import com.clevertap.android.sdk.ActivityLifecycleCallback
import com.clevertap.android.sdk.CleverTapAPI

class CTApp : Application()  {

    override fun onCreate() {
        ActivityLifecycleCallback.register(this)
        CleverTapAPI.setDebugLevel(3)
        super.onCreate()
    }
}

