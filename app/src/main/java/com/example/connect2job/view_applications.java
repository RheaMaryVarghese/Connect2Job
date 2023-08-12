package com.example.connect2job;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class view_applications extends AppCompatActivity {

    private LinearLayout containerLayout;
    EditText timein;

    Button Schedule_Button;

    String time;
    Retrofit retrofit;
    User_company user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_applications);
        Intent intent = getIntent();
        user = (User_company) intent.getSerializableExtra("user");


        containerLayout = findViewById(R.id.linear_layout2);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8000/") // Replace with your FastAPI backend URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<View_ApplicationsModel>> call = apiService.getApplications();

        call.enqueue(new Callback<List<View_ApplicationsModel>>() {
            @Override
            public void onResponse(Call<List<View_ApplicationsModel>> call, Response<List<View_ApplicationsModel>> response) {
                if (response.isSuccessful()) {
                    List<View_ApplicationsModel> applications = response.body();
                    displayApplications(applications);
                }
            }

            @Override
            public void onFailure(Call<List<View_ApplicationsModel>> call, Throwable t) {
                // Handle failure
            }
        });
    }

    private void displayApplications(List<View_ApplicationsModel> applications) {
        for (View_ApplicationsModel application : applications) {
            LinearLayout itemLayout = new LinearLayout(this);
            itemLayout.setOrientation(LinearLayout.HORIZONTAL);
            TextView textView = new TextView(this);
            String Name = application.getName();
            String htmlText = "<font color='#000000'>" + Name + "</font>";
            textView.setText(HtmlCompat.fromHtml(htmlText, HtmlCompat.FROM_HTML_MODE_LEGACY));


            Button applyButton = new Button(this);
            applyButton.setText("Schedule Interview");
            applyButton.setTextColor(Color.BLACK);
            applyButton.setTextSize(16);
            applyButton.setBackgroundColor(Color.parseColor("#D86FEA"));
            int widthInDp = 113;
            int heightInDp = 55;
            int widthInPixels = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, widthInDp, getResources().getDisplayMetrics());
            int heightInPixels = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, heightInDp, getResources().getDisplayMetrics());
            applyButton.setLayoutParams(new LinearLayout.LayoutParams(widthInPixels, heightInPixels));


            // Add the click listener to handle settling
            applyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView.setTextColor(Color.GRAY);
                    textView.setText(HtmlCompat.fromHtml("<font color='#808080'>Applied</font>", HtmlCompat.FROM_HTML_MODE_LEGACY));
                    itemLayout.removeView(applyButton);
                    scheduleinterview();
                }
            });
            itemLayout.addView(textView);
            itemLayout.addView(applyButton);
            containerLayout.addView(itemLayout);
        }


    }


    private void scheduleinterview() {

        Dialog dialog2 = new Dialog(this);
        dialog2.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog2.setContentView(R.layout.schedule_interview_dialog);
        dialog2.setCancelable(false);
        dialog2.show();


        timein = (EditText) dialog2.findViewById(R.id.editTextname2);
        Schedule_Button = (Button) dialog2.findViewById(R.id.okay2_button);
        Schedule_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                time= timein.getText().toString();
                //schedule(time);

            }
        });


    }

    /*private void schedule(String time){

        ApiService apiService = retrofit.create(ApiService.class);
        LentTransactionData data = new LentTransactionData(name, amount);
        Call<Void> call = apiService.addLentTransaction(data);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    // Lent transaction added successfully
                    Toast.makeText(view_applications.this, "Scheduled successfully", Toast.LENGTH_SHORT).show();
                } else {
                    // Handle error response
                    Toast.makeText(view_applications.this, "Failed to schedule", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // Handle network or other errors
                Toast.makeText(view_applications.this, "Failed to schedule", Toast.LENGTH_SHORT).show();
            }
        });*/

    }







