package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button buthospital = (Button)findViewById(R.id.buthospital);
        buthospital.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),HosMainActivity.class);
                startActivity(intent); //액티비티 이동
            }
        });

        Button butcust = (Button) findViewById(R.id.butcust);
        butcust.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),CustMainActivity.class);
                startActivity(intent); //액티비티 이동
            }
        });

    }
}