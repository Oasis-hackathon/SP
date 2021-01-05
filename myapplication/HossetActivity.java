package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kyleduo.switchbutton.SwitchButton;

public class HossetActivity extends AppCompatActivity {

    private RadioGroup rg_wtime;
    private RadioButton rb_smooth,rb_normal,rb_congestion;
    private Button btn_update;
    private String str_update;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_set);

        Switch switch1=(Switch) findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(getApplicationContext(),"운영중",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"운영종료",Toast.LENGTH_SHORT).show();
                }
            }
        });

        rg_wtime=findViewById(R.id.rg_wtime);
        rb_smooth=findViewById(R.id.rb_smooth);
        rb_normal=findViewById(R.id.rb_normal);
        rb_congestion=findViewById(R.id.rb_congestion);
        btn_update=findViewById(R.id.btn_update);


        rg_wtime.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.rb_smooth) {
                    Toast.makeText(getApplicationContext(), "원활", Toast.LENGTH_SHORT).show();
                    str_update = rb_smooth.getText().toString();
                }else if (i==R.id.rb_normal){
                    Toast.makeText(getApplicationContext(),"보통", Toast.LENGTH_SHORT).show();
                    str_update=rb_normal.getText().toString();
                }else if(i==R.id.rb_congestion){
                    Toast.makeText(getApplicationContext(),"혼잡", Toast.LENGTH_SHORT).show();
                    str_update=rb_congestion.getText().toString();
                }
            };
        });

        btn_update.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(str_update != null){
                    Toast.makeText(getApplicationContext(),str_update, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"버튼을 선택해주세요",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
