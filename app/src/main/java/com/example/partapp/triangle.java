package com.example.partapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class triangle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);

        EditText et_triangle_base= findViewById(R.id.triangle_et_base);
        EditText et_triangle_height= findViewById(R.id.triangle_et_height);
        Button rectangle_btn_calculate = findViewById(R.id.triangle_areas_btn_calculate);




        rectangle_btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double area =0;
                double triangle_base= Double.parseDouble(et_triangle_base.getText().toString());
                double triangle_height= Double.parseDouble(et_triangle_height.getText().toString());
                area = 0.5* triangle_height *triangle_base;
                Intent intent = new Intent();
                intent.putExtra("triangle_area", area);
                setResult(1, intent);
                finish();

            }

        });


    }
}