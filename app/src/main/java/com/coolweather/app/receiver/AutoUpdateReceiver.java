package com.coolweather.app.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.coolweather.app.service.AutoUpdateService;

/**
 * Created by Administrator on 2016/7/6 0006.
 */
public class AutoUpdateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent2 = new Intent(context, AutoUpdateService.class);
        context.startService(intent2);
    }
}
