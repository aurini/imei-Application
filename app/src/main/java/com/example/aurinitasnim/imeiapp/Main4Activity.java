package com.example.aurinitasnim.imeiapp;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.aurinitasnim.imeiapp.MainActivity.PERMISSION_READ_STATE;

public class Main4Activity extends AppCompatActivity {

    TelephonyManager telephonyManager;
    String ver;
    String phone;
    String TAG = "PhoneActivityTAG";
    Activity activity = Main4Activity.this;
    String wantPermission = Manifest.permission.READ_PHONE_STATE;
    private static final int PERMISSION_REQUEST_CODE = 1;

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        textView=findViewById(R.id.textView_4);
        version();

        textView.setText(ver+"\n"

                +phone +""
        );
    }




    private void version() {

        int checkpermission= ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);
        if(checkpermission== PackageManager.PERMISSION_GRANTED)
        {
            telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
            ver= telephonyManager.getNetworkOperatorName();
            phone =telephonyManager.getLine1Number();
        }
        else
        {
            ActivityCompat.requestPermissions(this,
                    new String [] {Manifest.permission.READ_PHONE_STATE},
                    PERMISSION_READ_STATE);

        }
    }
}
