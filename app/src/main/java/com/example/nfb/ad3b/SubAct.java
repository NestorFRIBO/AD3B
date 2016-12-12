package com.example.nfb.ad3b;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import static com.example.nfb.ad3b.MainActivity.PREFS;

public class SubAct extends AppCompatActivity {

    TextView datos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);


        datos = (TextView) findViewById(R.id.Mostrar);


        SharedPreferences mySharedPreferences = getSharedPreferences(PREFS, Activity.MODE_PRIVATE);

        // crear tantas variables como datos se quiera recoger
        String nombreS = mySharedPreferences.getString("nombre","");
        String dniS = mySharedPreferences.getString("dni","");
        String fechaS = mySharedPreferences.getString("fecha","");
        Boolean sexoS =  mySharedPreferences.getBoolean("hombre",true);
        Boolean sexoS2 =  mySharedPreferences.getBoolean("mujer",true);

        datos.setText("Nombre: " +nombreS+ " DNI: " +dniS+ " Fecha: " +fechaS+ " Sexo hombre: "+sexoS + " Sexo mujer: " +sexoS2);



    }
}
