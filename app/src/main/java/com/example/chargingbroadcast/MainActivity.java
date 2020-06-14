package com.example.chargingbroadcast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    ExampleBroadcast broadcast = new ExampleBroadcast();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }

    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter();
        filter.addAction( Intent.ACTION_BATTERY_CHANGED );
//        filter.addAction( Intent.ACTION_BATTERY_CHANGED );
//        filter.addAction( Intent.ACTION_POWER_DISCONNECTED );
        registerReceiver( broadcast, filter );
    }

    protected void onStop() {
        super.onStop();
        unregisterReceiver( broadcast );
    }
}
