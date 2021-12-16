package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import Objetos.Animal;

public class Ingresos_act extends AppCompatActivity {

    private Spinner animal;
    private Spinner enfermedad;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresos);

        animal =findViewById(R.id.spnanimal);
        enfermedad = findViewById(R.id.spnenfermedad);
        result = findViewById(R.id.result);

        Bundle bun = getIntent().getExtras(); //Recibo los extras
        String[] listado = bun.getStringArray("animal");

        ArrayAdapter adaptAnimal = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
        animal.setAdapter(adaptAnimal);

        ArrayAdapter adaptEnfermedad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
        enfermedad.setAdapter(adaptEnfermedad);
    }
}