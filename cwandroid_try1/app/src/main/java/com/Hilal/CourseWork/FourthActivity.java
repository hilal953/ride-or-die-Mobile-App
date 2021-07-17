package com.Hilal.CourseWork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;


import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class FourthActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
        private ImageView img1;
        private ImageView img2;
        private ImageView img3;
        private TextView txt_label_type;//show the car image type
        private TextView txt_answer;
        private Button btn_activity4;
        private TextView timer4;
        private CountDownTimer countDownTimer;
        private boolean TimerSwitchOn = false;
        private boolean isClicked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        img1=(ImageView)findViewById(R.id.Imageview4);
        img2=(ImageView)findViewById(R.id.ImageView5);
        img3=(ImageView)findViewById(R.id.ImageView6);
        txt_label_type=(TextView)findViewById(R.id.car_type_label);
        txt_answer=(TextView) findViewById(R.id.car_type_true);
        btn_activity4=(Button)findViewById(R.id.button_activity4);
        timer4=findViewById(R.id.countdown4);


        Intent intent = getIntent();
        TimerSwitchOn = intent.getExtras().getBoolean("switchValue");
        if (TimerSwitchOn){    //Check weather switch is on or not
            switchTimer();
            showThreeimages();
        }else {
            showThreeimages();
        }





        btn_activity4.setOnClickListener(v -> {

            if (TimerSwitchOn){    //Check weather switch is on or not
                switchTimer();//start the timer
                showThreeimages();//show 3 images
            }else {

                if(!isClicked){
                    Toast.makeText(FourthActivity.this,"Select one image!",Toast.LENGTH_SHORT).show();
                }else{
                    showThreeimages();
                }
            }

            txt_answer.setText("");
            img1.setEnabled(true);
            img2.setEnabled(true);
            img3.setEnabled(true);
        });

    //----------------------------------------------------------

    }

    public void showThreeimages(){
        isClicked = false;
        selectThreeImagesRandomly();
        int i=carTypesArray[0].getCarImage();
        img1.setImageResource(i);
        boolean same=true;
        while(same){//to get 3 types of car images

           int j=carTypesArray[1].getCarImage();
           int k=carTypesArray[2].getCarImage();
           if(carTypesArray[0].getType().equals(carTypesArray[1])&&carTypesArray[1].getType().equals(carTypesArray[2])&&carTypesArray[0].getType().equals(carTypesArray[2])){
            same=true;
           }else {
               same=false;
               img1.setImageResource(i);//to set images
               img2.setImageResource(j);
               img3.setImageResource(k);
           }

       }
       Random r=new Random();
       int random=r.nextInt(2);//generate a random number
       String type=carTypesArray[random].getType();
       txt_label_type.setText(type);
}
    public void switchTimer(){
        countDownTimer = new CountDownTimer(21000,1000) {  //Create the countDownTimer
            @Override
            public void onTick(long millisUntilFinished) {
                String seconds = millisUntilFinished / 1000 + "";
                timer4.setText(seconds);
            }
            @Override
            public void onFinish() {   //method for when the timer finished
                submitauto();
            }
        };
        countDownTimer.start();       //To Start the countdown
    }
    public void submitauto(){
        txt_answer.setText("WRONG!");
        txt_answer.setTextColor(Color.RED);

    }


    public void clickFirstImage(View view){
        isClicked = true;
        String value1=carTypesArray[0].getType();//to get the first image type
        String value1_txt=txt_label_type.getText().toString();//to get random image type
        if(value1.equals(value1_txt)){//check weather selected image and random image type are equals

            txt_answer.setText("CORRECT!");
            txt_answer.setTextColor(Color.rgb(0, 148, 50));
            if (TimerSwitchOn) {
                countDownTimer.cancel();   //To pause the timer
            }
        }else{
            txt_answer.setText("WRONG!");//if both of names are not similar
            txt_answer.setTextColor(Color.RED);
            if (TimerSwitchOn) {
                countDownTimer.cancel();   //To pause the timer
            }
        }

        img2.setEnabled(false);//disable the img2 and img3
        img3.setEnabled(false);

        }
    public void clickSecondImage(View view) {
        isClicked = true;
            String value2 = carTypesArray[1].getType();//to get the second image type
            String value2_txt = txt_label_type.getText().toString();//to get the car type
            if (value2.equals(value2_txt)) {//check weather selected image and random image car are equals
                txt_answer.setText("CORRECT!");
                txt_answer.setTextColor(Color.rgb(0, 148, 50));
            } else {
                txt_answer.setText("WRONG!");//if both of names are not similar
                txt_answer.setTextColor(Color.RED);
            }
        if (TimerSwitchOn) {
            countDownTimer.cancel();                   //To pause the timer
        }
        img3.setEnabled(false);//disable the img1 and img3
        img1.setEnabled(false);

    }
    public void clickThirdImage(View view){
        isClicked = true;
        String value3=carTypesArray[2].getType();//to get the third car type
        String value3_txt=txt_label_type.getText().toString();//to get the car type in the label
        if(value3.equals(value3_txt)){//check weather selected image and random image car are equals
            txt_answer.setText("CORRECT!");
            txt_answer.setTextColor(Color.rgb(0, 148, 50));
        }else{
            txt_answer.setText("WRONG!");
            txt_answer.setTextColor(Color.RED);
        }
        if (TimerSwitchOn) {
            countDownTimer.cancel();                   //To pause the timer
        }
        img1.setEnabled(false);//disable the img1,img2
        img2.setEnabled(false);
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

    public void selectThreeImagesRandomly(){
        Collections.shuffle(Arrays.asList(carTypesArray));
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}