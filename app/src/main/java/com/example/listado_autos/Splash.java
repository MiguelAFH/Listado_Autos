package com.example.listado_autos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(1500 );
                }catch(Exception e){

                }finally{
                    Intent intent = new Intent(Splash.this, Llenado.class);
                    startActivity(intent);
                    finish();
                }
            }
        };

        timer.start();
    }
}