package com.example.connect2job;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button jobseeker_button,companies_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        jobseeker_button = (Button) findViewById(R.id.jobseeker_button);
        jobseeker_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, login_jobseeker.class);
                startActivity(intent1);

            }

        });

        companies_button = (Button) findViewById(R.id.company_button);
        companies_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, login_company.class);
                startActivity(intent2);

            }

        });



    }








}