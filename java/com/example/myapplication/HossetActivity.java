package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HossetActivity extends AppCompatActivity {

    private RadioGroup rg_wtime;
    private RadioButton rb_smooth,rb_normal,rb_congestion;
    private Button btn_update;
    private String str_update;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_set);

        Switch sw=(Switch)findViewById(R.id.switch1);

        rg_wtime=findViewById(R.id.rg_wtime);
        rb_smooth=findViewById(R.id.rb_smooth);
        rb_normal=findViewById(R.id.rb_normal);
        rb_congestion=findViewById(R.id.rb_congestion);
        btn_update=findViewById(R.id.btn_update);

        rg_wtime.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            private final Object CompoundButton;
            @Override
            sw.setOnCheckedChangeListener(new void OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
            Toast.makeTet(HossetActivity.this, "체크상태 = " + isChecked, Toast.LENGTH_SHORT).show();
            }
            }
        }
            public void onCheckedChanged(RadioGroup radiogroup, int i) {
                if(i==R.id.rb_smooth) {
                    Toast.makeText(HossetActivity.this, "원활", Toast.LENGTH_SHORT).show();
                    str_update = rb_smooth.getText().toString();
                }else if (i==R.id.rb_normal){
                    Toast.makeText(HossetActivity.this,"보통", Toast.LENGTH_SHORT).show();
                    str_update=rb_normal.getText().toString();
                }else if(i==R.id.rb_congestion){
                    Toast.makeText(HossetActivity.this,"혼잡", Toast.LENGTH_SHORT).show();
                    str_update=rb_congestion.getText().toString();
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(str_update != null){
                    Toast.makeText(HossetActivity.this,str_update, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(HossetActivity.this,"버튼을 선택해주세요",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}