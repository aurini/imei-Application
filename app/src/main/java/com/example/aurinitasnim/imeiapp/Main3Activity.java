package com.example.aurinitasnim.imeiapp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import static com.example.aurinitasnim.imeiapp.MainActivity.PERMISSION_READ_STATE;

public class Main3Activity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        textView=findViewById(R.id.textview_3);
        textView.setMovementMethod(new ScrollingMovementMethod());


        textView.setText(

                "Model Name : "+ Build.MODEL + "\n"
                + "Manufacturer : "+ Build.MANUFACTURER + "\n"
                + "Hardware : "+Build.HARDWARE + "\n"
                + "Display : "+Build.DISPLAY + "\n"
                + "Device : "+ Build.DEVICE + "\n"
                + "Fingure Print : " +Build.FINGERPRINT + "\n"
                + "Bootloader : "+ Build.BOOTLOADER + "\n"
                + "Version : " + Build.VERSION.RELEASE + "\n"
                + "Version Base : " + Build.VERSION_CODES.BASE + "\n"
                + "HOST : " + Build.HOST + "\n"


        );
    }



}
