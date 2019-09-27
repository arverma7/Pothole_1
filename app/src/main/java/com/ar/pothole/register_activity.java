package com.ar.pothole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class register_activity extends AppCompatActivity {
 private TextView login_txtView;
 private Button male_btn , female_btn;
 private  String gender;
 private  String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_activity);


        login_txtView = findViewById(R.id.login_txtView);
        login_txtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i  = new Intent(register_activity.this , MainActivity.class);
                startActivity(i);


            }
        });

        male_btn = findViewById(R.id.male_btn);
        female_btn = findViewById(R.id.female_btn);
        genderSelcetor(male_btn , female_btn);
    }

    void genderSelcetor(final Button male_btn , final Button female_btn){

        male_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                male_btn.setBackgroundResource(R.drawable.male_selected);
                male_btn.setTextColor(getResources().getColor(R.color.white));
                female_btn.setBackgroundResource(R.drawable.female_btn);
                female_btn.setTextColor(getResources().getColor(R.color.female));
                s = "m";
            }
        });

        female_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                male_btn.setBackgroundResource(R.drawable.male_btn);
                male_btn.setTextColor(getResources().getColor(R.color.male));
                female_btn.setBackgroundResource(R.drawable.remale_selected);
                female_btn.setTextColor(getResources().getColor(R.color.white));
                s = "f";
            }
        });



    }
}
