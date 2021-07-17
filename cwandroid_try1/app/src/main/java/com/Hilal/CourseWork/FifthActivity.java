package com.Hilal.CourseWork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;


import java.util.Arrays;
import java.util.Collections;

public class FifthActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
        private ImageView img1_act5;
        private ImageView img2_act5;
        private EditText editText3;
        private TextView txt;
        private Button btn_acticity5;
        private TextView scorelabel;
        private TextView imgtxt1,imgtxt2,imgtxt3;
        private ImageView img3_act5;
        private EditText editText1;
        private EditText editText2;

        private TextView timer;
        private CountDownTimer countDownTimer;
        private boolean TimerSwitchOn = false;
        String firstImage,secondImage,thirdImage,cartype1,cartype2,cartype3;
        int score_fifth=0;
        int l=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        img1_act5 = (ImageView) findViewById(R.id.imageView1_act5);
        img2_act5 = (ImageView) findViewById(R.id.imageView2_act5);
        img3_act5 = (ImageView) findViewById(R.id.imageView3_act5);
        editText1 = (EditText) findViewById(R.id.editText_image1);
        editText2 = (EditText) findViewById(R.id.editText_image2);
        editText3 = (EditText) findViewById(R.id.editText_image3);
        txt = (TextView) findViewById(R.id.textView_true_activity5);
        btn_acticity5 = (Button) findViewById(R.id.button_activity5);
        scorelabel = (TextView) findViewById(R.id.textView_mark);

        imgtxt1 = (TextView) findViewById(R.id.img1_answer);
        imgtxt2 = (TextView) findViewById(R.id.img2_answer);
        imgtxt3 = (TextView) findViewById(R.id.img3_answer);
        timer = findViewById((R.id.countdown5));

        Intent intent = getIntent();
        TimerSwitchOn = intent.getExtras().getBoolean("switchValue", false);//get message from the main activity
        if (TimerSwitchOn) {    //Check weather switch is on or not
            switchTimer();
            showImagesForIdentify();
        } else {
            showImagesForIdentify();
        }

        btn_acticity5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                firstImage = editText1.getText().toString().toUpperCase();//to convert user inputs to uppercase
                secondImage = editText2.getText().toString().toUpperCase();
                thirdImage = editText3.getText().toString().toUpperCase();
                cartype1 = carTypesArray[0].getType();//to get actual car types of 3 images
                cartype2 = carTypesArray[1].getType();
                cartype3 = carTypesArray[2].getType();

                if (!btn_acticity5.getText().equals("NEXT")) {
                    if (firstImage.equals(cartype1) && secondImage.equals(cartype2) && thirdImage.equals(cartype3)) {

                        editText1.setTextColor(Color.rgb(0, 148, 50));
                        editText2.setTextColor(Color.rgb(0, 148, 50));
                        editText3.setTextColor(Color.rgb(0, 148, 50));
                        txt.setText("CORRECT");
                        if (TimerSwitchOn) {
                            countDownTimer.cancel();   //To pause the timer
                        }
                        txt.setTextColor(Color.rgb(0, 148, 50));
                        btn_acticity5.setText("NEXT");
                        scorelabel.setText(Integer.toString(3));

                    } else {
                        score_fifth = 0;
                        l++;
                        editText1.setTextColor(Color.RED);//check whether first answers is correct or wrong
                        editText2.setTextColor(Color.RED);
                        editText3.setTextColor(Color.RED);
                        if (firstImage.equals(cartype1)) {
                            editText1.setEnabled(false);
                            editText1.setTextColor(Color.rgb(0, 148, 50));
                            score_fifth = score_fifth + 1;

                        }

                        if (secondImage.equals(cartype2)) {//check whether second answers is correct or wrong
                            editText2.setEnabled(false);
                            editText2.setTextColor(Color.rgb(0, 148, 50));
                            score_fifth = score_fifth + 1;

                        }

                        if (thirdImage.equals(cartype3)) {//check whether third answers is correct or wrong
                            editText3.setEnabled(false);
                            editText3.setTextColor(Color.rgb(0, 148, 50));
                            score_fifth = score_fifth + 1;
                        }
                        scorelabel.setText(Integer.toString(score_fifth));
                    }

                    Log.d("xyz", "after while " + l);
                    if (l == 3) {//after 3 attempts
                        txt.setText("WRONG!");
                        if (TimerSwitchOn) {
                            countDownTimer.cancel();   //To pause the timer
                        }
                        txt.setTextColor(Color.RED);
                        btn_acticity5.setText("NEXT");
                        scorelabel.setText(Integer.toString(score_fifth));

                        if (editText1.isEnabled()) {
                            editText1.setEnabled(false);
                            imgtxt1.setText(cartype1);
                            imgtxt1.setTextColor(Color.YELLOW);
                        }
                        if (editText2.isEnabled()) {
                            editText2.setEnabled(false);
                            imgtxt2.setText(cartype2);
                            imgtxt2.setTextColor(Color.YELLOW);
                        }
                        if (editText3.isEnabled()) {
                            editText3.setEnabled(false);
                            imgtxt3.setText(cartype3);
                            imgtxt3.setTextColor(Color.YELLOW);
                        }

                    }

                    Toast.makeText(FifthActivity.this," You have  "+(3-l)+" more attempts",Toast.LENGTH_SHORT).show();

                } else {
                    Intent inte = new Intent(FifthActivity.this, FifthActivity.class);//to chnage the intent
                    inte.putExtra("switchValue", TimerSwitchOn);
                    startActivity(inte);
                    finish();
                }
            }

        });

    }



    private void switchTimer() {

        countDownTimer = new CountDownTimer(21000,1000) {  //Create the countDownTimer
            @Override
            public void onTick(long millisUntilFinished) {
                String sec = millisUntilFinished / 1000 + "";
                timer.setText(sec);
            }
            @Override
            public void onFinish() {   //method for when the timer finished
              submitauto();
            }
        };
        countDownTimer.start();

    }
    public void submitauto(){//auto submit
        firstImage=editText1.getText().toString().toUpperCase();
        secondImage=editText2.getText().toString().toUpperCase();
        thirdImage=editText3.getText().toString().toUpperCase();
        cartype1=carTypesArray[0].getType();
        cartype2=carTypesArray[1].getType();
        cartype3=carTypesArray[2].getType();

        if (firstImage.equals(cartype1) && secondImage.equals(cartype2) && thirdImage.equals(cartype3)) {
            if (!btn_acticity5.getText().equals("NEXT")) {
                editText1.setTextColor(Color.rgb(0, 148, 50));
                editText2.setTextColor(Color.rgb(0, 148, 50));
                editText3.setTextColor(Color.rgb(0, 148, 50));
                txt.setText("CORRECT");

                txt.setTextColor(Color.rgb(0, 148, 50));
                btn_acticity5.setText("NEXT");
                scorelabel.setText(Integer.toString(3));

            }


            btn_acticity5.setText("NEXT");
            Intent inte = new Intent(FifthActivity.this, FifthActivity.class);
            inte.putExtra("switchValue",TimerSwitchOn);
            startActivity(inte);
            finish();

        } else {
            l = 3;
            score_fifth = 0;

            editText1.setTextColor(Color.RED);
            editText2.setTextColor(Color.RED);
            editText3.setTextColor(Color.RED);
            if (firstImage.equals(cartype1)) {
                editText1.setEnabled(false);
                editText1.setTextColor(Color.rgb(0, 148, 50));
                score_fifth = score_fifth + 1;

            }

            if (secondImage.equals(cartype2)) {
                editText2.setEnabled(false);
                editText2.setTextColor(Color.rgb(0, 148, 50));
                score_fifth = score_fifth + 1;

            }

            if (thirdImage.equals(cartype3)) {
                editText3.setEnabled(false);
                editText3.setTextColor(Color.rgb(0, 148, 50));
                score_fifth = score_fifth + 1;
            }
            scorelabel.setText(Integer.toString(score_fifth));
        }

        Log.d("xyz","after while "+l);
        if(l==3){

            txt.setText("WRONG!");
            txt.setTextColor(Color.RED);
            btn_acticity5.setText("NEXT");
            scorelabel.setText(Integer.toString(score_fifth));

            if(editText1.isEnabled()){
                editText1.setEnabled(false);
                imgtxt1.setText(cartype1);
                imgtxt1.setTextColor(Color.YELLOW);
            }
            if(editText2.isEnabled()){
                editText2.setEnabled(false);
                imgtxt2.setText(cartype2);
                imgtxt2.setTextColor(Color.YELLOW);
            }
            if(editText3.isEnabled()){
                editText3.setEnabled(false);
                imgtxt3.setText(cartype3);
                imgtxt3.setTextColor(Color.YELLOW);
            }

        }

    }


    public void showImagesForIdentify(){//get 3 random images
        selectThreeImageswithText();
        int i=carTypesArray[0].getCarImage();
        img1_act5.setImageResource(i);
        int j=carTypesArray[1].getCarImage();
        img2_act5.setImageResource(j);
        int k=carTypesArray[2].getCarImage();
        img3_act5.setImageResource(k);


    }


    //array
    Types b1=new Types(R.drawable.bmw1,"BMW");//https://www.youtube.com/watch?v=HR-3fm1Pcxg
    Types b2=new Types(R.drawable.bmw2,"BMW");
    Types b3=new Types(R.drawable.bmw3,"BMW");
    Types b4=new Types(R.drawable.bmw4,"BMW");
    Types b5=new Types(R.drawable.bmw5,"BMW");
    Types f1=new Types(R.drawable.ford1,"FORD");
    Types f2=new Types(R.drawable.ford2,"FORD");
    Types f3=new Types(R.drawable.ford3,"FORD");
    Types f4=new Types(R.drawable.ford4,"FORD");
    Types f5=new Types(R.drawable.ford5,"FORD");
    Types ho1=new Types(R.drawable.honda1,"HONDA");
    Types ho2=new Types(R.drawable.honda2,"HONDA");
    Types ho3=new Types(R.drawable.honda3,"HONDA");
    Types ho4=new Types(R.drawable.honda4,"HONDA");
    Types ho5=new Types(R.drawable.honda5,"HONDA");
    Types hy1=new Types(R.drawable.hyhundai1,"HYHUNDAI");
    Types hy2=new Types(R.drawable.hyhundai2,"HYHUNDAI");
    Types hy3=new Types(R.drawable.hyhundai3,"HYHUNDAI");
    Types hy4=new Types(R.drawable.hyhundai4,"HYHUNDAI");
    Types hy5=new Types(R.drawable.hyhundai5,"HYHUNDAI");
    Types te1=new Types(R.drawable.tesla1,"TESLA");
    Types te2=new Types(R.drawable.tesla2,"TESLA");
    Types te3=new Types(R.drawable.tesla3,"TESLA");
    Types te4=new Types(R.drawable.tesla4,"TESLA");
    Types te5=new Types(R.drawable.tesla5,"TESLA");
    Types to1=new Types(R.drawable.toyota1,"TOYOTA");
    Types to2=new Types(R.drawable.toyota2,"TOYOTA");
    Types to3=new Types(R.drawable.toyota3,"TOYOTA");
    Types to4=new Types(R.drawable.toyota4,"TOYOTA");
    Types to5=new Types(R.drawable.toyota5,"TOYOTA");
    Types []carTypesArray=new Types[]{
            b1,b2,b3,b4,b5,f1,f2,f3,f4,f5,ho1,ho2,ho3,ho4,ho5,hy1,hy2,hy3,hy4,hy5,te1,te2,te3,te4,te5,to1,to2,to3,to4,to5
    };

    public void selectThreeImageswithText(){
        Collections.shuffle(Arrays.asList(carTypesArray));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}