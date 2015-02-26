package com.android.projectesang;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;


public class RegisterActivity extends ActionBarActivity {
    EditText username;
    EditText quant;
    EditText grup;
    String nombre, grupo, quantitat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = (EditText) findViewById(R.id.editNom);
        grup = (EditText) findViewById(R.id.editGrup);
        quant = (EditText) findViewById(R.id.editQuant);
    }
    public void Regist(View v) {

        nombre = username.getText().toString();
        grupo = grup.getText().toString();
        quantitat = quant.getText().toString();

        SharedPreferences prefs = getSharedPreferences(
                "com.android.projectesang", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("nombre", nombre);
        editor.putString("grupo", grupo);
        editor.putString("quantitat", quantitat);
        editor.commit();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
