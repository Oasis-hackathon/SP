package com.example.myapplication;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class JoinRequest extends StringRequest {
    final static private String URL = "http://sp2018.dothome.co.kr/Join.php";
    private Map<String,String> map;

    public JoinRequest(String userID, String userPassword, String userName, String userNumber, String userHosName, String userAddress, Response.Listener<String> listener){
        super(Method.POST,URL, listener,null);

        map=new HashMap<>();
        map.put("userID",userID);
        map.put("userPassword",userPassword);
        map.put("userName",userName);
        map.put("userNumber",userNumber);
        map.put("userHosName",userHosName);
        map.put("userAddress",userAddress);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
