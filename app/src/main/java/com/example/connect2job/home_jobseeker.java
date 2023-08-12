package com.example.connect2job;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class home_jobseeker extends AppCompatActivity {


    Button profile_button, opportunities_button, companies_button, post_button, feed_button, interviewtimes_button;
    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_jobseeker);

        Intent intent = getIntent();
        user = (User) intent.getSerializableExtra("user");

        profile_button = (Button) findViewById(R.id.button9);
        profile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(home_jobseeker.this, profile_jobseeker.class);
                startActivity(intent2);

            }

        });


        opportunities_button = (Button) findViewById(R.id.button10);
        opportunities_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(home_jobseeker.this, opportunities.class);
                intent2.putExtra("user", user);
                startActivity(intent2);

            }

        });


        interviewtimes_button = (Button) findViewById(R.id.button15);
        interviewtimes_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(home_jobseeker.this, interviewtimes.class);
                startActivity(intent2);

            }

        });

    }




}
