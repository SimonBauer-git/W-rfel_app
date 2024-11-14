package com.example.wuerfel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import static android.view.HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING;
import static android.view.HapticFeedbackConstants.VIRTUAL_KEY;

public class SettingsActivity extends AppCompatActivity {
Switch switch7mode;
Switch switchvibrate;
boolean vibration;
boolean switchState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        switch7mode =(Switch)(findViewById(R.id.switch7mode));
        switchvibrate=(Switch) (findViewById(R.id.switchvibrate));
        Bundle bundle= getIntent().getExtras();
        if (bundle==null){
            vibration=false;
            switchState=false;
        }
        else
        {vibration =bundle.getBoolean("vibrate");
        switchState= bundle.getBoolean("mode");}

        switchvibrate.setChecked(vibration);
        switch7mode.setChecked(switchState);
     }
public void onbackclick(View v)
{vibration= switchvibrate.isChecked();
switchState= switch7mode.isChecked();
    if(vibration==true)
    {getWindow().getDecorView().performHapticFeedback(VIRTUAL_KEY, FLAG_IGNORE_GLOBAL_SETTING);}
    Intent intent= new Intent(SettingsActivity.this,(MainActivity.class));
    intent.putExtra("vibrate",vibration);
    intent.putExtra("mode",switchState);
    startActivity(intent);
    finish();
}}

