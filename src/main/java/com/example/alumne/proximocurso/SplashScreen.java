package com.example.alumne.proximocurso;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class SplashScreen extends AppCompatActivity {


    //la duracion de la splash screen
    private static  final long SPLASH_SCREEN_DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        //le decimos que tiene que ser orientacion portrait
        setRequiestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //escondemos la title bar
        requiestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_splash_screen);

        Thread timerThread = new Thread(){

            public void run(){
                try{
                    sleep(SPLASH_SCREEN_DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();*/
    }

    @Override
    protected void onPause(){

        super.onPause();
        finish();
    }
}
