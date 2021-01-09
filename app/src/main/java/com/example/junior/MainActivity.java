package com.example.junior;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.junior.calculator.CalculatorActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    //初始化控件
    private void initView() {
        findViewById(R.id.btn_simpleLayout).setOnClickListener(this);
        findViewById(R.id.btn_simpleWidget).setOnClickListener(this);
        findViewById(R.id.btn_basicDrawing).setOnClickListener(this);
        findViewById(R.id.btn_main_calculator).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_simpleLayout){
            Intent intent = new Intent(this,SimpleLayout.class);
            startActivity(intent);

        }else if(v.getId()==R.id.btn_simpleWidget){
            Intent intent = new Intent(this,SimpleWidget.class);
            startActivity(intent);

        }else if(v.getId() == R.id.btn_basicDrawing){
            Intent intent = new Intent(this,BasicDrawing.class);
            startActivity(intent);

        }else if(v.getId()==R.id.btn_main_calculator){
            Intent intent = new Intent(this, CalculatorActivity.class);
            startActivity(intent);
        }
    }
}