package com.example.connect2job;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
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

public class opportunities extends AppCompatActivity {

    private LinearLayout containerLayout;
    Retrofit retrofit;
    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opportunities);
        Intent intent = getIntent();
        user = (User) intent.getSerializableExtra("user");


        containerLayout = findViewById(R.id.linear_layout2);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8000/") // Replace with your FastAPI backend URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<OpportunitiesModel>> call = apiService.getOpportunities();

        call.enqueue(new Callback<List<OpportunitiesModel>>() {
            @Override
            public void onResponse(Call<List<OpportunitiesModel>> call, Response<List<OpportunitiesModel>> response) {
                if (response.isSuccessful()) {
                    List<OpportunitiesModel> opportunities = response.body();
                    displayOpportunities(opportunities);
                }
            }

            @Override
            public void onFailure(Call<List<OpportunitiesModel>> call, Throwable t) {
                // Handle failure
            }
        });
    }

    private void displayOpportunities(List<OpportunitiesModel> opportunities) {
        for (OpportunitiesModel opportunity : opportunities) {
            LinearLayout itemLayout = new LinearLayout(this);
            itemLayout.setOrientation(LinearLayout.HORIZONTAL);
            TextView textView = new TextView(this);
            String Company = opportunity.getCompany();
            String Job_Role = String.valueOf(opportunity.getJob_Role());

            String htmlText = "<font color='#000000'>" + Company + "</font>"
                    + "<font color='#000000'" + Job_Role + "</font>";
            textView.setText(HtmlCompat.fromHtml(htmlText, HtmlCompat.FROM_HTML_MODE_LEGACY));


            Button applyButton = new Button(this);
            applyButton.setText("Apply");
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
                    apply_job(user.getName(),user.getUsername(),Company,Job_Role);
                }
            });
            itemLayout.addView(textView);
            itemLayout.addView(applyButton);
            containerLayout.addView(itemLayout);
        }



    }


    private void apply_job(String Name,String Username,String Company,String Job_Role) {

        ApiService apiService = retrofit.create(ApiService.class);
        Apply_JobModel data = new Apply_JobModel(Name,Username,Company,Job_Role);
        Call<Void> call = apiService.applyjob(data);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    // Lent transaction added successfully
                    Toast.makeText(opportunities.this, "Application sent successfully", Toast.LENGTH_SHORT).show();
                } else {
                    // Handle error response
                    Toast.makeText(opportunities.this, "Failed to apply", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // Handle network or other errors
                Toast.makeText(opportunities.this, "Failed to apply", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
