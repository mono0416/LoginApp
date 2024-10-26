package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.loginapp.databinding.ActivityDetailedBinding;

public class DetailedActivity extends AppCompatActivity {

    ActivityDetailedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityDetailedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();
        if (intent != null) {
        String name = intent.getStringExtra("name");
        String time = intent.getStringExtra("time");
        int image = intent.getIntExtra("image", R.drawable.black);

        binding.detailName.setText(name);
        binding.detailTime.setText(time);
        binding.detailImage.setImageResource(image);



        }

    };
}
