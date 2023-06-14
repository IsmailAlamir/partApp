package com.example.partapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Areas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areas);

        Spinner sp_shapes= findViewById(R.id.area_sp_shapes);
        EditText et_rectangle_width= findViewById(R.id.areas_et_rectangle_width);
        EditText et_rectangle_height= findViewById(R.id.areas_et_rectangle_height);
        EditText et_triangle_base= findViewById(R.id.areas_et_triangle_base);
        EditText et_triangle_height= findViewById(R.id.areas_et_triangle_height);
        EditText et_circle_radius= findViewById(R.id.areas_et_circle_radius);
        TextView tv_result = findViewById(R.id.areas_tv_result);
        Button btn_calculate = findViewById(R.id.areas_btn_calculate);

        sp_shapes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch(position){
                    case 0:
                        et_rectangle_width.setVisibility(View.VISIBLE);
                        et_rectangle_height.setVisibility(View.VISIBLE);
                        et_triangle_base.setVisibility(View.GONE);
                        et_triangle_height.setVisibility(View.GONE);
                        et_circle_radius.setVisibility(View.GONE);
                        break;
                    case 1:
                        et_rectangle_width.setVisibility(View.GONE);
                        et_rectangle_height.setVisibility(View.GONE);
                        et_triangle_base.setVisibility(View.VISIBLE);
                        et_triangle_height.setVisibility(View.VISIBLE);
                        et_circle_radius.setVisibility(View.GONE);
                        break;
                    case 2:
                        et_rectangle_width.setVisibility(View.GONE);
                        et_rectangle_height.setVisibility(View.GONE);
                        et_triangle_base.setVisibility(View.GONE);
                        et_triangle_height.setVisibility(View.GONE);
                        et_circle_radius.setVisibility(View.VISIBLE);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double area =0;
                switch (sp_shapes.getSelectedItemPosition()){
                    case 0 :
                        double rec_width= Double.parseDouble(et_rectangle_width.getText().toString());
                        double rec_height= Double.parseDouble(et_rectangle_height.getText().toString());
                        area = rec_width * rec_height;
                        break;
                    case 1 :
                        double triangle_base= Double.parseDouble(et_triangle_base.getText().toString());
                        double triangle_height= Double.parseDouble(et_triangle_height.getText().toString());
                        area = 0.5 * triangle_base *triangle_height;
                        break;

                    case 2 :
                        double radius= Double.parseDouble(et_circle_radius.getText().toString());
                        area =Math.PI * Math.pow(radius,2);
                        break;

                }
                tv_result.setText(area+"");
            }
        });

    }
}