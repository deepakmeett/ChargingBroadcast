package com.example.chargingbroadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ExampleBroadcast broadcast = new ExampleBroadcast();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);
//        filter.addAction( Intent.ACTION_BATTERY_CHANGED );
//        filter.addAction( Intent.ACTION_POWER_DISCONNECTED );
        registerReceiver(broadcast, filter);
    }

    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcast);
    }
}
