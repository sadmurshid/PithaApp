package com.pitha.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mainButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainButton = findViewById(R.id.testButton);

        mainButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mainButton){
            startActivity(new Intent(this, Login.class));
        }
    }
}
