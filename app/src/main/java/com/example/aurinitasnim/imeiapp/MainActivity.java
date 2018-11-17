package com.example.aurinitasnim.imeiapp;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.acl.Permission;

public class MainActivity extends AppCompatActivity {

    private  Button b1, b2, b3, b4;
    TelephonyManager telephonyManager;
    String imei;
    static final int PERMISSION_READ_STATE = 123;
    ClipboardManager clipboardManager;
    ClipData clipData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button3);
        b3=(Button)findViewById(R.id.button4);
        b4=(Button)findViewById(R.id.button5);
        telephonyManager=(TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
    }

    public void onClick1 (View V)
    {
        int checkpermission= ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);
        if(checkpermission== PackageManager.PERMISSION_GRANTED)
        {
            telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
            imei=telephonyManager.getDeviceId();
        }
        else
        {
            ActivityCompat.requestPermissions(this,
                    new String [] {Manifest.permission.READ_PHONE_STATE},
                    PERMISSION_READ_STATE);

        }
        /*Intent intent= new Intent (this,Main2Activity.class);
        Bundle bundle=new Bundle();
        bundle.putString("imei",imei);
        intent.putExtras(bundle);
        startActivity(intent);*/
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        mBuilder.setTitle("IMEI");
        View mview=getLayoutInflater().inflate(R.layout.dialogimei,null);
        TextView txv=(TextView)mview.findViewById(R.id.textview_dia);
        Button bt= (Button)mview.findViewById(R.id.button_dia);
        clipboardManager=(ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        mBuilder.setView(mview);
        txv.setText(imei);
        mBuilder.setCancelable(false).setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog dialog=mBuilder.create();
        dialog.show();
        dialog.getWindow().setLayout(700, 800);

    }



    public void onclickdialog (View v1)
    {
        clipData=ClipData.newPlainText("imei",imei);
        clipboardManager.setPrimaryClip(clipData);
        Toast.makeText(getApplicationContext(),"Coppied", Toast.LENGTH_SHORT).show();

    }
    public void onClick2(View v)
    {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        mBuilder.setTitle("IMEI");
        View mview=getLayoutInflater().inflate(R.layout.dialoghard,null);
        TextView txv=(TextView)mview.findViewById(R.id.textViewhard);
        txv.setMovementMethod(new ScrollingMovementMethod());
        mBuilder.setView(mview);
        txv.setText(

                        "Hardware : "+Build.HARDWARE + "\n"
                        + "Display : "+Build.DISPLAY + "\n"
                        + "Fingure Print : " +Build.FINGERPRINT + "\n"
                        + "Bootloader : "+ Build.BOOTLOADER + "\n"

        );
        mBuilder.setCancelable(false).setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog dialog=mBuilder.create();
        dialog.show();
        dialog.getWindow().setLayout(700, 800);
    }

    public void onClick3 (View v)
    {
        Intent intent= new Intent (this,Main4Activity.class);
        startActivity(intent);
    }
}
