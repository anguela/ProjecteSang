package com.android.projectesang;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;


public class PresentationActivity extends ActionBarActivity {
    private final static String TAG = PresentationActivity.class.getName();
    private static final long SPLASH_SCREEN_DELAY = 2000;
    String nombre;
    String contra;
    Intent intentt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_presentation);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                comprovacionLogin();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }


    private void comprovacionLogin() {
        //Sirve para aceder al archivo de preferencias y recuperar el nombre y la contraseña
        SharedPreferences prefs = getSharedPreferences("com.android.projectesang", Context.MODE_PRIVATE);
        nombre = prefs.getString("nombre", "");
        Log.d("Nombre guardado: ", nombre);

        if (nombre != "") {
            intentt = new Intent(this, RegisterActivity.class);
            startActivity(intentt);
            finish();
        } else {
            intentt = new Intent(this, MainActivity.class);
            startActivity(intentt);
            finish();
        }
    }
}