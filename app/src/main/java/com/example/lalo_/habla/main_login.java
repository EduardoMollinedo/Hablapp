package com.example.lalo_.habla;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class main_login extends AppCompatActivity {
    String ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        SharedPreferences prefs = getSharedPreferences("preferencias", MODE_PRIVATE);
        ID = prefs.getString("ID", "");//"No name defined" is the default value.
        String Name = prefs.getString("Name", ""); //0 is the default value.
        Toast.makeText(getApplicationContext(),ID,Toast.LENGTH_SHORT).show();
        if(!ID.equals("")){
            Intent i = new Intent(getApplicationContext(), mail_login.class);
            startActivity(i);
            finish();

        }
        if (Build.VERSION.SDK_INT > 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        setContentView(R.layout.login);

        //Declarando
        Button btnIngresar = (Button) findViewById(R.id.btnIngresar);
        Button btnRegistrar = (Button) findViewById(R.id.btnRegistrar);

        //Cambiar fuente de botones
        String carpetaFuente = "font/Splatch.ttf";
        Typeface fuente = Typeface.createFromAsset(getAssets(), carpetaFuente);
        btnIngresar.setTypeface(fuente);
        btnRegistrar.setTypeface(fuente);
    }
    public void btnRegistrar(View v){
        Intent i = new Intent(v.getContext(), hp_register.class);
        startActivity(i);
    }

    public void btnIngresar(View v){
        Intent i = new Intent(v.getContext(), mail_login.class);
        Toast.makeText(getApplicationContext(),"INGRESAR",Toast.LENGTH_SHORT).show();
        startActivity(i);
    }

}
