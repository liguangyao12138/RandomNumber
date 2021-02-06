package com.example.randomnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_left_digit;
    private EditText et_left_min;
    private EditText et_left_max;
    private TextView tv_left_randomNumber;

    private EditText et_mid_digit;
    private EditText et_mid_min;
    private EditText et_mid_max;
    private TextView tv_mid_randomNumber;

    private EditText et_right_digit;
    private EditText et_right_min;
    private EditText et_right_max;
    private TextView tv_right_randomNumber;

    private static String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindView();
    }

    private void bindView() {

        et_left_digit = findViewById(R.id.et_left_digit);
        et_left_min = findViewById(R.id.et_left_min);
        et_left_max = findViewById(R.id.et_left_max);
        tv_left_randomNumber = findViewById(R.id.tv_left_randomNumber);
        findViewById(R.id.btn_left_determine).setOnClickListener(this);

        et_mid_digit = findViewById(R.id.et_mid_digit);
        et_mid_min = findViewById(R.id.et_mid_min);
        et_mid_max = findViewById(R.id.et_mid_max);
        tv_mid_randomNumber = findViewById(R.id.tv_mid_randomNumber);
        findViewById(R.id.btn_mid_determine).setOnClickListener(this);

        et_right_digit = findViewById(R.id.et_right_digit);
        et_right_min = findViewById(R.id.et_right_min);
        et_right_max = findViewById(R.id.et_right_max);
        tv_right_randomNumber = findViewById(R.id.tv_right_randomNumber);
        findViewById(R.id.btn_right_determine).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btn_left_determine){
            String leftNumber  = createRandom(et_left_digit,et_left_min,et_left_max);
            tv_left_randomNumber.setText(leftNumber);
            Log.d(TAG, "leftNumber = "+leftNumber);

        }else if(v.getId() == R.id.btn_mid_determine){
            String midNumber  = createRandom(et_mid_digit,et_mid_min,et_mid_max);
            tv_mid_randomNumber.setText(midNumber);
            Log.d(TAG, "midNumber = "+midNumber);

        }else if(v.getId() == R.id.btn_right_determine){
            String rightNumber  = createRandom(et_right_digit,et_right_min,et_right_max);
            tv_right_randomNumber.setText(rightNumber);
            Log.d(TAG, "rightNumber = "+rightNumber);
        }
    }


    private  String createRandom(EditText et1, EditText et2, EditText et3){
        String number = "";

        //位数，最小值，最大值为空
        Boolean et1_null = et1.getText().toString().equals("");
        Boolean et2_null = et2.getText().toString().equals("");
        Boolean et3_null = et3.getText().toString().equals("");

        if( !et1_null && !et2_null && !et3_null){
            int digit = Integer.parseInt(et1.getText().toString());
            int min = Integer.parseInt(et2.getText().toString());
            int max = Integer.parseInt(et3.getText().toString());

            if (min<=max){
                for (int i=0;i<digit;i++){
                    Random random = new Random();
                    String s = String.valueOf(random.nextInt(max)%(max-min+1) + min);
                    number = number + s;
                    Log.d(TAG, "number---"+number);
                }
            }else {
                Toast.makeText(this, "最小值应大于最大值", Toast.LENGTH_SHORT).show();
            }

        }else if(et1_null && !et2_null && !et3_null){
            Toast.makeText(this, "位数为空", Toast.LENGTH_SHORT).show();
        }else if(!et1_null && et2_null && !et3_null){
            Toast.makeText(this, "最小值为空", Toast.LENGTH_SHORT).show();
        }else if(!et1_null && !et2_null && et3_null){
            Toast.makeText(this, "最大值为空", Toast.LENGTH_SHORT).show();
        }else if(et1_null && et2_null && !et3_null){
            Toast.makeText(this, "位数和最小值为空", Toast.LENGTH_SHORT).show();
        }else if(et1_null && !et2_null && et3_null){
            Toast.makeText(this, "位数和最大值为空", Toast.LENGTH_SHORT).show();
        }else if(!et1_null && et2_null && et3_null){
            Toast.makeText(this, "最小值和最大值为空", Toast.LENGTH_SHORT).show();
        }else if(et1_null && et2_null && et3_null){
            Toast.makeText(this, "位数和最小值和最大值为空", Toast.LENGTH_SHORT).show();
        }

        return number;
    }
}