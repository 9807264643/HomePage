package com.example.jobopportunity.detailPageActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.jobopportunity.MainActivity;
import com.example.jobopportunity.R;

public class DetailPageActivities extends AppCompatActivity {
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page_activities);

        back = findViewById(R.id.back_icon);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailPageActivities.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
