package com.Hilal.CourseWork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    Switch timer;
    boolean TimerSwitchOn = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer=findViewById(R.id.switch_timer);



      timer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {//to on off timer
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    TimerSwitchOn = true;
                }else{
                    TimerSwitchOn = false;
                }
            }
        });
    }

    public void launchSecondActivity(View view) {//to launch identify the car make activity
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("switchValue", TimerSwitchOn);
        startActivity(intent);
    }
    public void launchThirdActivity3(View view) {// to lauch hint activity
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this,ThirdActivity.class);
        intent.putExtra("switchValue", TimerSwitchOn);
        startActivity(intent);
    }

    public void launchFourthActivity(View view) {//to launch identify the car image activity
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this,FourthActivity.class);
        intent.putExtra("switchValue", TimerSwitchOn);
        startActivity(intent);
    }

    public void launchFifthActivity(View view) {//to launch advance level activity
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this,FifthActivity.class);
        intent.putExtra("switchValue", TimerSwitchOn);
        startActivity(intent);
    }
}