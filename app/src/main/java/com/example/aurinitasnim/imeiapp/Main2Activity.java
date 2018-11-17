package com.example.aurinitasnim.imeiapp;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    String imei;
    TextView textView1, textView;
    Button button;
    ClipboardManager clipboardManager;
    ClipData clipData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView=(TextView)findViewById(R.id.textView1);
        textView1=(TextView)findViewById(R.id.textView2);
        button=(Button)findViewById(R.id.button22);
       getValues();
       clipboardManager=(ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
    }
     public void getValues()
     {
         Intent intent=getIntent();
         Bundle bundle=intent.getExtras();
         if(bundle!=null)
         {
             imei=bundle.getString("imei",imei);
         }
         textView1.setText(
                 imei
         );
     }

     public void onClickm2(View v)
     {
         clipData=ClipData.newPlainText("imei",imei);
         clipboardManager.setPrimaryClip(clipData);
         Toast.makeText(getApplicationContext(),"Coppied", Toast.LENGTH_SHORT).show();
     }
}
