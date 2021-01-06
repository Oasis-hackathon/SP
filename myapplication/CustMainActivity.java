package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SearchView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CustMainActivity extends AppCompatActivity {
    private String str_up;
    private SearchView search_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cust);

        final RadioGroup rg = (RadioGroup) findViewById(R.id.rg_all);
        Button b = (Button) findViewById(R.id.update);
        final TextView tv = (TextView) findViewById(R.id.result);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(id);
                tv.setText(rb.getText().toString());
            }
        });

        search_view = findViewById(R.id.search_view);
        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }
}
