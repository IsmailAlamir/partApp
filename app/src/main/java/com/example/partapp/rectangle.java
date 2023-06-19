package com.example.partapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class rectangle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);

        EditText et_rectangle_width= findViewById(R.id.rectangle_et_width);
        EditText et_rectangle_height= findViewById(R.id.rectangle_et_height);
        Button rectangle_btn_calculate = findViewById(R.id.rectangle_btn_calculate_area);


        rectangle_btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double area =0;
                double rectangle_width= Double.parseDouble(et_rectangle_width.getText().toString());
                double rectangle_height= Double.parseDouble(et_rectangle_height.getText().toString());
                area = rectangle_width * rectangle_height;
                Intent intent = new Intent();
                intent.putExtra("rectangle_area", area);
                setResult(1, intent);
                finish();

                }

        });



    }
}