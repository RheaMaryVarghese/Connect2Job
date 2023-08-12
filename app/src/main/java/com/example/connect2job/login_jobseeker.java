package com.example.connect2job;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class login_jobseeker extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton, signup_button;
    private ApiService apiService;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_jobseeker);

        Intent intent1 = getIntent();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8000/") // Replace with your actual backend URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);


        signup_button = (Button) findViewById(R.id.button3);
        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(login_jobseeker.this, signup.class);
                startActivity(intent2);

            }

        });

        // Find views by ID
        usernameEditText = findViewById(R.id.editTextUsername);
        passwordEditText = findViewById(R.id.editTextTextPassword);


        loginButton = findViewById(R.id.button2);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the entered username and password
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Create a LoginRequest object with the entered username and password
                LoginRequest loginRequest = new LoginRequest(username, password);

                // Call the login API endpoint
                Call<ResponseBody> call = apiService.login(loginRequest);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            try {
                                String responseData = response.body().string();
                                Gson gson = new Gson();
                                User user = gson.fromJson(responseData, User.class);
                                Toast.makeText(login_jobseeker.this, "Login successful", Toast.LENGTH_SHORT).show();
                                Intent intent3 = new Intent(login_jobseeker.this, home_jobseeker.class);
                                intent3.putExtra("user", user);
                                startActivity(intent3);

                            } catch (IOException e) {
                                e.printStackTrace();
                                Toast.makeText(login_jobseeker.this, "Login failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            // Authentication failed, handle the response
                            Toast.makeText(login_jobseeker.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        // Handle network or other errors
                        Toast.makeText(login_jobseeker.this, "Login failed" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                });
            }
        });
    }
}