package com.example.partapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Calculate extends AppCompatActivity {
    TextView tv_all_results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        Button btn_triangle = findViewById(R.id.triangle_btn);
        Button btn_rectangle = findViewById(R.id.rectangle_btn);
        tv_all_results = findViewById(R.id.all_areas_tv_result);

        btn_triangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), triangle.class);
                startActivityForResult(intent, 1);
            }
        });

        btn_rectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), rectangle.class);
                startActivityForResult(intent, 2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (tv_all_results != null) {
            if (requestCode == 1) {
                String oldText = tv_all_results.getText().toString();
                double newArea = data.getDoubleExtra("triangle_area", 0);
                tv_all_results.setText(oldText + "triangle : " + newArea);
            } else if (requestCode == 2) {
                String oldText = tv_all_results.getText().toString();
                double newArea = data.getDoubleExtra("rectangle_area", 0);
                tv_all_results.setText(oldText + "\nrectangle : " + newArea);
            }
        }
    }
}
