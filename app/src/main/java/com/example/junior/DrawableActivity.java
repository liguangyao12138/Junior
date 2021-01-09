package com.example.junior;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

public class DrawableActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable);

        ImageView iv_drawable = findViewById(R.id.iv_drawable);
        Drawable drawable = getResources().getDrawable(R.drawable.apple1);
        iv_drawable.setBackground(drawable);

    }
}