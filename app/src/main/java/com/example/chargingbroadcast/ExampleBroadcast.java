package com.example.chargingbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.BatteryManager;
import android.widget.Toast;

public class ExampleBroadcast extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {
//        if (Intent.ACTION_POWER_CONNECTED.equals( intent.getAction() )) {
//            Toast.makeText( context, "Charging", Toast.LENGTH_SHORT ).show();
//        } else if (Intent.ACTION_POWER_DISCONNECTED.equals( intent.getAction() )) {
//            Toast.makeText( context, "Not Charging", Toast.LENGTH_SHORT ).show();
//        }
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        int percent = level * 100 / scale;
        if (percent == 100) {
            playSound(context);
            Toast.makeText(context, String.valueOf(percent), Toast.LENGTH_SHORT).show();
        } else if (percent == 15) {
            playSound(context);
            Toast.makeText(context, String.valueOf(percent), Toast.LENGTH_SHORT).show();
        }
    }

    public void playSound(Context context) {
        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        Ringtone r = RingtoneManager.getRingtone(context, notification);
        r.play();
    }
}
