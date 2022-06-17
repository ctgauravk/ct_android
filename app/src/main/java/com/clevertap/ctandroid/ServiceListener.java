package com.clevertap.ctandroid;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;

import com.clevertap.android.sdk.ActivityLifecycleCallback;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.pushnotification.NotificationInfo;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class ServiceListener extends FirebaseMessagingService {
    public void onMessageReceived(@NonNull RemoteMessage message) {
       try{ if (message.getData().size() > 0) {
            Bundle extras = new Bundle();
            for (Map.Entry<String, String> entry : message.getData().entrySet()) {
                extras.putString(entry.getKey(), entry.getValue());
            }
            NotificationInfo info = CleverTapAPI.getNotificationInfo(extras);
            if (info.fromCleverTap) {
                CleverTapAPI.createNotification(getApplicationContext(), extras);
            } else {
// not from CleverTap handle yourself or pass to another provider
            }
        }
    } catch (Throwable t) {
        Log.d("MYFCMLIST", "Error parsing FCM message", t);
    }

}

    @Override
    public void onNewToken(@NonNull String s) {
        CleverTapAPI.getDefaultInstance(getApplicationContext()).pushFcmRegistrationId(s,true);
    }
}
