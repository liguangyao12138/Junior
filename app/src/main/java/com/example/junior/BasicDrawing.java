package com.example.junior;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BasicDrawing extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_drawing);

        //
        findViewById(R.id.btn_drawable).setOnClickListener(this);
        //
        findViewById(R.id.btn_statusListDrawable).setOnClickListener(this);
        //
        findViewById(R.id.btn_shapeDrawing).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //
        if(v.getId()==R.id.btn_drawable){
            Intent intent = new Intent(this,DrawableActivity.class);
            startActivity(intent);

            //
        }else if(v.getId()==R.id.btn_statusListDrawable){
            Intent intent = new Intent(this,StatusListDrawableActivity.class);
            startActivity(intent);

            //
        }else if(v.getId()==R.id.btn_shapeDrawing){
            Intent intent = new Intent(this, ShapeDrawingAvtivity.class);
            startActivity(intent);
        }
    }
}