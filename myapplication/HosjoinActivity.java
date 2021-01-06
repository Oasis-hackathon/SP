package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class HosjoinActivity extends AppCompatActivity {

    private EditText et_id,et_pass,et_name, et_num, et_hos, et_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_join);

        et_id=findViewById(R.id.et_id);
        et_pass=findViewById(R.id.et_pass);
        et_name=findViewById(R.id.et_name);
        et_num=findViewById(R.id.et_num);
        et_hos=findViewById(R.id.et_hos);
        et_add=findViewById(R.id.et_add);

        Button btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String userID = et_id.getText().toString();
                String userPassword=et_pass.getText().toString();
                String userName=et_name.getText().toString();
                String userNum=et_num.getText().toString();
                String userHosName=et_hos.getText().toString();
                String userAddress=et_add.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success =jsonObject.getBoolean("success");
                            if(success) {
                                Toast.makeText(getApplicationContext(), "회원등록에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(HosjoinActivity.this, HosloginActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(getApplicationContext(),"회원등록에 실패하였습니다.",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                JoinRequest joinRequest = new JoinRequest(userID, userPassword, userName, userNum, userHosName, userAddress, responseListener);
                RequestQueue queue= Volley.newRequestQueue(HosjoinActivity.this);
                queue.add(joinRequest);
            }
        });
    }
}

