package com.Hilal.CourseWork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;

public class SecondActivity extends AppCompatActivity  implements
        AdapterView.OnItemSelectedListener{

    private Spinner spinner;
    private ImageView imageview2;
    private Button btn2;
    int i=0;
    private TextView txtview_answer;
    private TextView txtCheck;
    private TextView label;
   private TextView timer;
    private CountDownTimer countDownTimer;
    private boolean TimerSwitchOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        imageview2=(ImageView)findViewById(R.id.Imageview1);
        btn2=(Button)findViewById(R.id.identify_btn);
        txtview_answer=(TextView)findViewById(R.id.textView2_answer);
        txtCheck=(TextView)findViewById(R.id.textView2_true);
        label=(TextView)findViewById(R.id.correct_answer_label);
        timer=findViewById(R.id.countdown1);
        spinner=findViewById(R.id.spinner1);

        Intent intent = getIntent();//to get message from main activity
        TimerSwitchOn = intent.getExtras().getBoolean("switchValue");
        if (TimerSwitchOn){    //Check weather switch is on or not
            switchTimer();//start timer
            showImages();//to get random image
        }else {
            showImages();
        }


//-----------------------------------------
       Spinner spinner = findViewById(R.id.spinner1);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cartype_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }


    //---------------------------------------

        btn2.setOnClickListener(v -> {
            if(i==0) {          //when the button click first time
                btn2.setText("Next");
                String selection = spinner.getSelectedItem().toString();
                String type = carTypesArray[0].getType();
                if (selection.equals(type)) {       //if answer is correct
                    txtCheck.setText("CORRECT!");
                    txtCheck.setTextColor(Color.rgb(0, 148, 50));
                    txtview_answer.setText("");

                    if (TimerSwitchOn) {
                        countDownTimer.cancel();                   //To pause the timer
                    }

                } else {
                    txtCheck.setText("WRONG!");//if answer is wrong
                    txtCheck.setTextColor(Color.RED);
                    txtview_answer.setText(type);

                    label.setText("Correct Answer:");
                    txtview_answer.setTextColor(Color.YELLOW);
                    if (TimerSwitchOn) {
                        countDownTimer.cancel();                   //To pause the timer
                    }
                }

                i++;
            }

            else if(i==1){
                showImages();
                btn2.setText("Identify");
                txtCheck.setText("");
                txtview_answer.setText("");
                label.setText("");
                if(TimerSwitchOn){
                    switchTimer();//start timer

                }

                i=0;//to change button to the next
            }

        });
    }
    public void showImages(){
        selectRandomly();
        imageview2.setImageResource(carTypesArray[0].getCarImage());



    }
    public void switchTimer(){
        countDownTimer = new CountDownTimer(21000,1000) {  //Create the countDownTimer
            @Override
            public void onTick(long millisUntilFinished) {
                String seconds = millisUntilFinished / 1000 + "";
                timer.setText(seconds);
            }
            @Override
            public void onFinish() {   //method for when the timer finished
                submitauto();
            }
        };
        countDownTimer.start();       //To Start the countdown
    }
    public void submitauto(){//to submit the answer automatically
        Log.d("xyz", "Here");
        btn2.setText("Next");
        String selection = spinner.getSelectedItem().toString();
        String type = carTypesArray[0].getType();
        if (selection.equals(type)) {
            txtCheck.setText("CORRECT!");
            txtCheck.setTextColor(Color.rgb(0, 148, 50));

            txtview_answer.setText("");
        } else {
            txtCheck.setText("WRONG!");
            txtCheck.setTextColor(Color.RED);
            txtview_answer.setText(type);

            label.setText("Correct Answer:");
            txtview_answer.setTextColor(Color.YELLOW);

        }

    }


    Types b1=new Types(R.drawable.bmw1,"BMW");//https://www.youtube.com/watch?v=HR-3fm1Pcxg
    Types b2=new Types(R.drawable.bmw2,"BMW");
    Types b3=new Types(R.drawable.bmw3,"BMW");
    Types b4=new Types(R.drawable.bmw4,"BMW");
    Types b5=new Types(R.drawable.bmw5,"BMW");
    Types f1=new Types(R.drawable.ford1,"Ford");
    Types f2=new Types(R.drawable.ford2,"Ford");
    Types f3=new Types(R.drawable.ford3,"Ford");
    Types f4=new Types(R.drawable.ford4,"Ford");
    Types f5=new Types(R.drawable.ford5,"Ford");
    Types ho1=new Types(R.drawable.honda1,"Honda");
    Types ho2=new Types(R.drawable.honda2,"Honda");
    Types ho3=new Types(R.drawable.honda3,"Honda");
    Types ho4=new Types(R.drawable.honda4,"Honda");
    Types ho5=new Types(R.drawable.honda5,"Honda");
    Types hy1=new Types(R.drawable.hyhundai1,"Hyhundai");
    Types hy2=new Types(R.drawable.hyhundai2,"Hyhundai");
    Types hy3=new Types(R.drawable.hyhundai3,"Hyhundai");
    Types hy4=new Types(R.drawable.hyhundai4,"Hyhundai");
    Types hy5=new Types(R.drawable.hyhundai5,"Hyhundai");
    Types te1=new Types(R.drawable.tesla1,"Tesla");
    Types te2=new Types(R.drawable.tesla2,"Tesla");
    Types te3=new Types(R.drawable.tesla3,"Tesla");
    Types te4=new Types(R.drawable.tesla4,"Tesla");
    Types te5=new Types(R.drawable.tesla5,"Tesla");
    Types to1=new Types(R.drawable.toyota1,"Toyota");
    Types to2=new Types(R.drawable.toyota2,"Toyota");
    Types to3=new Types(R.drawable.toyota3,"Toyota");
    Types to4=new Types(R.drawable.toyota4,"Toyota");
    Types to5=new Types(R.drawable.toyota5,"Toyota");
    Types []carTypesArray=new Types[]{
            b1,b2,b3,b4,b5,f1,f2,f3,f4,f5,ho1,ho2,ho3,ho4,ho5,hy1,hy2,hy3,hy4,hy5,te1,te2,te3,te4,te5,to1,to2,to3,to4,to5
    };

    public void selectRandomly(){//to shuffle the array list
        Collections.shuffle(Arrays.asList(carTypesArray));
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int
            i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        displayToast(spinnerLabel);
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}