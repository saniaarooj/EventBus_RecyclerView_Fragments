package com.example.salman.assignment_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class DetailsActivity extends AppCompatActivity {
    Gson gson;
    TextView t1;
    TextView t2;
    TextView t3;


    String infoString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        t1 = (TextView) findViewById(R.id.t1);
        t2 = (TextView) findViewById(R.id.t2);
        t3 = (TextView) findViewById(R.id.t3);
        Gson gson = new Gson();

        String target = getIntent().getStringExtra("MyObjectString");
        Contact contact = gson.fromJson(target, Contact.class);
        t1.setText(contact.getName().toString());
        t2.setText(contact.getEmail().toString());
        t3.setText(contact.getPhone().toString());
    }
}
