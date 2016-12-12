package com.example.nfb.ad3b;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    Button guardar;
    Button cargar;
    EditText dni;
    EditText nombre;
    EditText fecha;
    RadioButton hombre;
    RadioButton mujer;

    public static final  String PREFS = "My preferencias";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guardar = (Button) findViewById(R.id.guardar);
        cargar = (Button) findViewById(R.id.cargar);

        dni = (EditText) findViewById(R.id.dni);
        nombre = (EditText) findViewById(R.id.nombre);
        fecha = (EditText) findViewById(R.id.fecha);
        hombre = (RadioButton) findViewById(R.id.H);
        mujer = (RadioButton) findViewById(R.id.F);

        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, SubAct.class);

                startActivity(i);

            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences mySharedPreferences = getSharedPreferences(PREFS, Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = mySharedPreferences.edit();

                boolean marcat = hombre.isChecked();
                editor.putBoolean("hombre",marcat);

                boolean marcat2 = mujer.isChecked();
                editor.putBoolean("mujer",marcat2);

                String nom = nombre.getText().toString();
                editor.putString("nombre", nom);

                Integer data = Integer.valueOf(fecha.getText().toString());
                editor.putString("fecha", String.valueOf(data));

                Integer dni2 = Integer.valueOf(dni.getText().toString());
                editor.putString("dni", String.valueOf(dni2));

                editor.commit();





            }
        });
    }
}
