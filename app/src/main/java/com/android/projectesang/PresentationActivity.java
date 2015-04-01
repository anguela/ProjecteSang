package com.android.projectesang;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;


public class PresentationActivity extends Activity {
    private final static String TAG = PresentationActivity.class.getName();
    private static final long SPLASH_SCREEN_DELAY = 2000;
    String nombre;
    Intent intentt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT < 16) {
            Log.e("Version: ", "< than 16");
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        else{
            Log.e("Version: ", "> than 16");
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
            ActionBar actionBar = getActionBar();
            actionBar.hide();
        }

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
        Log.e("Nombre guardado: ", nombre);

        if (nombre != "") {
            intentt = new Intent(this, MainActivity.class);
            startActivity(intentt);
            finish();
        } else {
            intentt = new Intent(this, RegisterActivity.class);
            startActivity(intentt);
            finish();
        }
    }
}