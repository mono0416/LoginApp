package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.loginapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageList = {R.drawable.black, R.drawable.grren,R.drawable.hatsu, R.drawable.hell,R.drawable.heyn,R.drawable.mosnter,R.drawable.shi8,R.drawable.sprite,R.drawable.vino,R.drawable.vip};
        String[] nameList = {"Black","Grren","Hatsu","Hell","Heyn","Mosnter","Shi8","Sprite","Vino","Vip"};
        String[] timeList = {"30 mins","30 mins","30 mins","30 mins","30 mins","30 mins","30 mins","30 mins","30 mins","30 mins"};

        for (int i = 0; i < imageList.length; i++){
            listData = new ListData(nameList[i],timeList[i],imageList[i]);
            dataArrayList.add(listData);
        }





    }
}
