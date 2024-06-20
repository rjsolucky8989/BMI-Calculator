package com.example.bmicalculator;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editWeight, editHeight;
    Button btnCalculate;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editWeight = findViewById(R.id.editWeight);
        editHeight = findViewById(R.id.editHeight);
        btnCalculate = findViewById(R.id.btnCalculate);
        textViewResult = findViewById(R.id.textViewResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }
    public void calculateBMI(){
        String weightStr = editWeight.getText().toString();
        String heightStr = editHeight.getText().toString();

        if (!weightStr.isEmpty() && !heightStr.isEmpty()){
            float weight = Float.parseFloat(weightStr);
            float height = Float.parseFloat(heightStr) / 100 ;

            float bmi = weight/(height*height) ;
            displayResult(bmi);
        }
        else {
            textViewResult.setText("Please enter valid weight and height");
            textViewResult.setTextColor(Color.GRAY);
        }
    }
    public void displayResult(float bmi){
        String bmiLabel;
        int color;

        if(bmi<18.5){
            bmiLabel = "Underweight";
            color = Color.parseColor("#FF8F00");
        }
        else if(bmi<25){
            bmiLabel = "Normal";
            color = Color.parseColor("#2E7D32");
        }
        else{
            bmiLabel = "OverWeight";
            color = Color.parseColor("#db3131");
        }
        textViewResult.setText(String.format("BMI: %.2f\n%s", bmi, bmiLabel));
        textViewResult.setTextColor(color);
    }
}