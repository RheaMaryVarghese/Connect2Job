package com.example.connect2job;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class home_company extends AppCompatActivity {


    Button profile_button, applications_button, invite_button, post_button;
    User_company user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_company);

        Intent intent = getIntent();
        user = (User_company) intent.getSerializableExtra("user");

        profile_button = (Button) findViewById(R.id.button9);
        profile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(home_company.this, profile_company.class);
                intent2.putExtra("user", user);
                startActivity(intent2);

            }

        });


        applications_button = (Button) findViewById(R.id.button10);
        applications_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(home_company.this, view_applications.class);
                intent2.putExtra("user", user);
                startActivity(intent2);

            }

        });


        invite_button = (Button) findViewById(R.id.button11);
        invite_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(home_company.this, roll_out.class);
                intent2.putExtra("user", user);
                startActivity(intent2);

            }

        });

        post_button = (Button) findViewById(R.id.button14);
        post_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(home_company.this, post_company.class);
                intent2.putExtra("user", user);
                startActivity(intent2);

            }

        });

    }







}