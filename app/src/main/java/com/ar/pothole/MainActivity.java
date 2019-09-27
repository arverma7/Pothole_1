package com.ar.pothole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;

public class MainActivity extends AppCompatActivity {

 private CircularProgressButton cbtn;
 private Button signin_btn;
 private Button signup;
 private EditText number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
number  = findViewById(R.id.number_edittext);
        signin_btn = findViewById(R.id.signin_btn);
        signin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phoneNumber = "+91" + number;
                Intent i  = new Intent(MainActivity.this , verify_phone_activity.class);
                i.putExtra("phonenumber", phoneNumber);
                startActivity(i);
            }
        });

      signup = findViewById(R.id.singup_btn);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k = new Intent(MainActivity.this , register_activity.class);
                startActivity(k);
            }
        });


    cbtn = findViewById(R.id.btn_loading);
    cbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AsyncTask<String,String,String> demo = new AsyncTask<String, String, String>() {
                @Override
                protected String doInBackground(String... voids) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "done";
                }

                @Override
                protected void onPostExecute(String s) {
                    if(s.equals("done") ) {

                        Toast.makeText(MainActivity.this ,"Download Done" ,Toast.LENGTH_SHORT).show();
                        cbtn.doneLoadingAnimation(Color.parseColor("#333639"), BitmapFactory.decodeResource(getResources(),R.drawable.ic_done_white_48dp));
                    }
                }
            };
         cbtn.startAnimation();
         demo.execute();
        }

    });
    }
}
