//app mit der man Würfeln können soll
package com.example.wuerfel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import static android.view.HapticFeedbackConstants.*;



public class MainActivity extends AppCompatActivity {
ImageView image;

ImageButton settings;
Button würfeln;
boolean vibration;
boolean switchState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image =(ImageView) findViewById(R.id.imageView);
        settings=(ImageButton)findViewById(R.id.imageButton3);
        würfeln=(Button) findViewById(R.id.button); }

    public void onbuttonClick (View V)                                                                 //checks if the "Würfeln" button is pressed and if it is pressed it
    {Bundle bundle= getIntent().getExtras();
    if (bundle==null){
        vibration=false;
        switchState=false;
    }
    else
    {vibration =bundle.getBoolean("vibrate");
    switchState= bundle.getBoolean("mode");}
    if(vibration==true)
    {getWindow().getDecorView().performHapticFeedback(VIRTUAL_KEY, FLAG_IGNORE_GLOBAL_SETTING);}
        boolean isDarkThemeOn = (getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK)  == Configuration.UI_MODE_NIGHT_YES;
                                                                     //checks if the switch is set to "7er Modus" or not and calculates the
    if(switchState==false)                                                                              //values accordingly
    {int random= (int)(Math.random()*6+1);
    switch (random)                                                                                     //the switch then decides which image to show in the imageView window
        { case 1:
        if(isDarkThemeOn==false)
        {image.setImageResource(R.drawable.wuerfelbild_1);}
        else
        {image.setImageResource(R.drawable.wuerfelbild_1_darkmode);}
        break;

        case 2:
        if(isDarkThemeOn==false)
        {image.setImageResource(R.drawable.wuerfelbild_2);}
        else
        {image.setImageResource(R.drawable.wuerfelbild_2_darkmode);}
        break;

        case 3:
        if(isDarkThemeOn==false)
        {image.setImageResource(R.drawable.wuerfelbild_3);}
        else
        {image.setImageResource(R.drawable.wuerfelbild_3_darkmode);}
        break;

        case 4:
        if(isDarkThemeOn==false)
        {image.setImageResource(R.drawable.wuerfelbild_4);}
        else
        {image.setImageResource(R.drawable.wuerfelbild_4_darkmode);}
        break;

        case 5:
        if(isDarkThemeOn==false)
        {image.setImageResource(R.drawable.wuerfelbild_5);}
        else
        {image.setImageResource(R.drawable.wuerfelbild_5_darkmode);}
        break;

        case 6:
        if (isDarkThemeOn==false)
        {image.setImageResource(R.drawable.wuerfelbild_6);}
        else
        {image.setImageResource(R.drawable.wuerfelbild_6_darkmode);}
        break;}}
    else
    {int random= (int)(Math.random()*7+1);
        switch (random)
        { case 1:
            if (isDarkThemeOn==false)
            {image.setImageResource(R.drawable.wuerfelbild_1);}
            else
            {image.setImageResource(R.drawable.wuerfelbild_1_darkmode);}
            break;

            case 2:
                if (isDarkThemeOn==false)
                {image.setImageResource(R.drawable.wuerfelbild_2);}
                else
                {image.setImageResource(R.drawable.wuerfelbild_2_darkmode);}
                break;

            case 3:
                if(isDarkThemeOn==false)
                {image.setImageResource(R.drawable.wuerfelbild_3);}
                break;

            case 4:
                if (isDarkThemeOn==false)
                {image.setImageResource(R.drawable.wuerfelbild_4);}
                else
                {image.setImageResource(R.drawable.wuerfelbild_4_darkmode);}
                break;

            case 5:
                if (isDarkThemeOn==false)
                {image.setImageResource(R.drawable.wuerfelbild_5);}
                else
                {image.setImageResource(R.drawable.wuerfelbild_5_darkmode);}
                break;

            case 6:
            if(isDarkThemeOn==false)
            {image.setImageResource(R.drawable.wuerfelbild_6);}
            else
            {image.setImageResource(R.drawable.wuerfelbild_6_darkmode);}
            break;

            case 7:
            if (isDarkThemeOn==false)
            {image.setImageResource(R.drawable.wuerfelbild_7);}
            else
            {image.setImageResource(R.drawable.wuerfelbild_7_darkmode);}
        break;}}}

    public void onsettingsclick(View v) {
    if(vibration==true)
    {getWindow().getDecorView().performHapticFeedback(VIRTUAL_KEY, FLAG_IGNORE_GLOBAL_SETTING);}

    Intent intent = new Intent(MainActivity.this,(SettingsActivity.class));
    intent.putExtra("vibrate",vibration);
    intent.putExtra("mode",switchState);
    startActivity(intent);
    finish();}}


