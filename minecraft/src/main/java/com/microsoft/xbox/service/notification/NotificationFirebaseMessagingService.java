package com.microsoft.xbox.service.notification;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class NotificationFirebaseMessagingService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
