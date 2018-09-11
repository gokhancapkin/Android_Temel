package com.example.gkhan.hafizaoyun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button) findViewById(R.id.bStart)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent m_oyun = new Intent(MainActivity.this,Oyun.class);
                startActivity(m_oyun);
            }
        });


    }
}
