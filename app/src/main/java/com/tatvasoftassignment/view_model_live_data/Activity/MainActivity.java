package com.tatvasoftassignment.view_model_live_data.Activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import com.tatvasoftassignment.view_model_live_data.Model.MainActivityDataGenerator;
import com.tatvasoftassignment.view_model_live_data.R;
import com.tatvasoftassignment.view_model_live_data.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MainActivityDataGenerator model = new ViewModelProvider(this).get(MainActivityDataGenerator.class);
        LiveData<String> random_number = model.getRandom_number();
        random_number.observe(this, s -> {
            binding.txtNumber.setText(s);
            Log.i("main", "data updated in ui");

        });
        binding.btnLiveData.setOnClickListener(v -> model.CreateNumber());
    }
}