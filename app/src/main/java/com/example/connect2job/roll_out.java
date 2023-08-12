package com.example.connect2job;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class roll_out extends AppCompatActivity {

    Button invite_button;
    EditText Jobrolein,Descin;

    String company;
    User_company user;

    ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roll_out);

        Intent intent = getIntent();
        user = (User_company) intent.getSerializableExtra("user");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8000/") // Replace with your FastAPI backend URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);


        Jobrolein = (EditText) findViewById(R.id.editTextrole);


        Descin = (EditText) findViewById(R.id.editTextdesc);
        company=user.getName();





        invite_button = (Button) findViewById(R.id.button2);
        invite_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jobrole = Jobrolein.getText().toString();
                String desc = Descin.getText().toString();


                ApiService apiService = retrofit.create(ApiService.class);
                storeOpportunities_Model data = new storeOpportunities_Model(company,jobrole, desc);
                Call<Void> call = apiService.storeOpportunity(data);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()) {


                            Toast.makeText(roll_out.this, "Applications invited successfully", Toast.LENGTH_SHORT).show();
                        } else {

                            Toast.makeText(roll_out.this, "Failed to invite applications", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        // Handle network or other errors

                        Toast.makeText(roll_out.this, "Failed to invite applications"+t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });


    }}
