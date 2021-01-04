package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class HosloginActivity extends AppCompatActivity {
    private EditText et_id, et_pw;
    private Button btn_log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_login);

        et_id = findViewById(R.id.et_id);
        et_pw = findViewById(R.id.et_pw);

        btn_log=findViewById(R.id.btn_log);
        btn_log.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),HossetActivity.class);
                startActivity(intent); //액티비티 이동

                String userID = et_id.getText().toString();
                String userPassword = et_pw.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) {
                                String userID = jsonObject.getString("success");
                                String userPassword = jsonObject.getString("success");

                                Toast.makeText(getApplicationContext(), "로그인에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(HosloginActivity.this, HosMainActivity.class);
                                intent.putExtra("userID", userID);
                                intent.putExtra("userPass", userPassword);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "회원등록에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                loginRequest loginRequest = new loginRequest(userID, userPassword, responseListener);
                RequestQueue queue = Volley.newRequestQueue(HosloginActivity.this);
                queue.add(loginRequest);
            }
        });
    }
}

