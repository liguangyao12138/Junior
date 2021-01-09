package com.example.junior;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class ShapeDrawingAvtivity extends AppCompatActivity implements View.OnClickListener {

    private View i_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape_drawing_avtivity);

        //
        findViewById(R.id.btn_rect).setOnClickListener(this);
        //
        findViewById(R.id.btn_oval).setOnClickListener(this);
        //
        i_content = findViewById(R.id.i_content);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn_rect){
            i_content.setBackgroundResource(R.drawable.shape_rect);
        }else if(v.getId()==R.id.btn_oval){
            i_content.setBackgroundResource(R.drawable.shape_oval);
        }
    }
}