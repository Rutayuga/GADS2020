package com.example.gads2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.gads2020.databinding.ActivityMainBinding;
import com.example.gads2020.views.activities.Homepage;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //No Need for this because of "android:windowTranslucentStatus" in styles.
        /*// In Activity's onCreate() for instance
        // To make the notification bar transparent.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);*/

        nextPage();
    }

    public void nextPage() {
        new Handler().postDelayed(() -> {
            //Navigate to next page.
            startActivity(new Intent(MainActivity.this, Homepage.class));
            finish();
        }, 500);
    }
}
