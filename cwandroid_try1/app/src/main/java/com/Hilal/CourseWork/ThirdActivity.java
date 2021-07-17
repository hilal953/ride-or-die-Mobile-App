package com.Hilal.CourseWork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class ThirdActivity extends AppCompatActivity {
    private ImageView imageView3;
    private Button submit;
    private CountDownTimer countDownTimer;
    private boolean Timer = false;
    private TextView dashes,correctOrWrong,correctAnswer;
    private EditText guesses;
    String type;
    int wroungAttempt =0;
    String hidingWord = "";
    private TextView timer1;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        imageView3=(ImageView)findViewById(R.id.Imageview2);
        submit=(Button)findViewById(R.id.button_thirdact);
        dashes=(TextView)findViewById(R.id.guessing_dashes);
        guesses=(EditText) findViewById(R.id.guessing_try);
        correctOrWrong=(TextView) findViewById(R.id.true_false);
        correctAnswer=(TextView)findViewById(R.id.answer);
        timer1=findViewById(R.id.countdown2);

        Intent intent = getIntent();//get the message from the main activity
        Timer = intent.getExtras().getBoolean("switchValue");
        if (Timer){    //Check weather switch is on or not
            switchTimer();
            showImages();
        }else {
            showImages();
        }

        Random r=new Random();//to get the random image
        int random=r.nextInt(carTypesArray.length);
        type=carTypesArray[random].getType();
        for(int i=0;i<type.length();i++){
            hidingWord = hidingWord + "_  ";
        }
        dashes.setText(hidingWord);//to set the dashes

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!submit.getText().equals("NEXT")) {
                    if (guesses.getText().length() <= 0) {
                        Toast.makeText(ThirdActivity.this, "Try a letter!", Toast.LENGTH_SHORT).show();//if textfield empty
                    } else {
                        String ch = guesses.getText().toString().toUpperCase();//to change the character to the uppercase

                        if (type.contains(ch)) {//check weather car type contains the letter
                            for (int i = 0; i < type.length(); i++) {
                                if ((type.charAt(i)) == ch.charAt(0)) {//check indexes of two words

                                    char[] name = hidingWord.toCharArray();
                                    name[i * 3] = ch.charAt(0);
                                    hidingWord = String.valueOf(name);
                                }
                            }

                            dashes.setText(hidingWord);//if car type contains the letter set that character to the dashes


                            if (!hidingWord.contains("_")) {//if all dashes are filled
                                correctOrWrong.setText("CORRECT!");
                                correctOrWrong.setTextColor(Color.rgb(0, 148, 50));
                                guesses.setEnabled(false);
                                if (Timer) {
                                    countDownTimer.cancel();            //To pause the timer
                                }
                                submit.setText("NEXT");//change button to next
                            }


                        } else {
                            wroungAttempt++;//if attept is wrong that adds to the bad attempts
                            if (wroungAttempt >= 3) {//check bad attempts count
                                correctOrWrong.setText("WRONG!");//if there are 3 bad attepmts
                                correctOrWrong.setTextColor(Color.RED);
                                guesses.setEnabled(false);
                                correctAnswer.setText(type);
                                correctAnswer.setTextColor(Color.YELLOW);
                                if (Timer) {
                                    countDownTimer.cancel();                   //To pause the timer
                                }
                                submit.setText("NEXT");
                            }else {
                                Toast.makeText(ThirdActivity.this, "Incorrect.You have more " + (3 - wroungAttempt) + " Guesses", Toast.LENGTH_SHORT).show();
                            }
                        }

                    }
                    guesses.setText("");

                } else {
                    Intent inte = new Intent(ThirdActivity.this, ThirdActivity.class);
                    inte.putExtra("switchValue", Timer);
                    startActivity(inte);
                    finish();

                }
            }
        });
    }
    public void switchTimer(){
        countDownTimer = new CountDownTimer(21000,1000) {  //Create the countDownTimer
            @Override
            public void onTick(long millisUntilFinished) {
                String seconds = millisUntilFinished / 1000 + "";
                timer1.setText(seconds);
            }
            @Override
            public void onFinish() {   //method for when the timer finished
               submitauto();

            }
        };
        countDownTimer.start();       //To Start the countdown
    }

    public void submitauto(){//code for auto submit

        if (!hidingWord.contains("_")) {
            correctOrWrong.setText("CORRECT!!!");
            correctOrWrong.setTextColor(Color.rgb(0, 148, 50));
            guesses.setEnabled(false);
            submit.setText("NEXT");
        }

        else {
            correctOrWrong.setText("WRONG!");
            correctOrWrong.setTextColor(Color.RED);
            guesses.setEnabled(false);
            correctAnswer.setText(type);
            correctAnswer.setTextColor(Color.YELLOW);
            submit.setText("NEXT");

        }

    }

    public void showImages(){//get random image
        selectRandomly();
        imageView3.setImageResource(carTypesArray[0].getCarImage());

    }

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

    public void selectRandomly(){//shuffle the array
        Collections.shuffle(Arrays.asList(carTypesArray));
    }


}