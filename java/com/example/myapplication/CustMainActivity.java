package com.example.myapplication;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CustMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);;
        setContentView(R.layout.cust);

        SearchView searchView=findViewById(R.id.search_view);
        TextView resultTextView = findViewById(R.id.textView);
        resultTextView.setText();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query){
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText){
                return true;
            }
        });
    }
    private String search(String query){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<items.size();i++){
            String item=items.get(i);
            if(item.toLowerCase().contains(query.toLowerCase())){
                sb.append(item);
                if(i != items.size() -1){
                    sb.append("\n");
                }
            }
            return sb.toString();
        }
        private String getResult(){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<item.size();i++){
                String item=item.get(i);
                if(i==items.size() -1){
                    sb.append(item);
                }else{
                    sb.append(item);
                    sb.append("\n");
                }
            }
            return sb.toString();
        }
    }
}