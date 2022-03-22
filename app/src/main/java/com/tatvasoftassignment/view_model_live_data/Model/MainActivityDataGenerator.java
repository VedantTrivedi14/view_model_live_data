package com.tatvasoftassignment.view_model_live_data.Model;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MainActivityDataGenerator extends ViewModel {

    private MutableLiveData<String> random_number;


    public MutableLiveData<String> getRandom_number() {
        Log.i("main", "getNumber");
        if (random_number == null) {
            random_number = new MutableLiveData<>();
            CreateNumber();
        }
        return random_number;
    }

    public void CreateNumber() {
        Log.i("main", "Create new number");
        random_number.setValue("Number: " + (new Random().nextInt(10 - 1) + 1));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i("main", "view model is destroy");
    }

}
