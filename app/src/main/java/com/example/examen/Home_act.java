package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import Objetos.Animal;

public class Home_act extends AppCompatActivity {

    private Animal an = new Animal();
    private VideoView videoview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        videoview = findViewById(R.id.vw);


        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(ruta);
        videoview.setVideoURI(uri);
    }

    public void Ingresos(View view)
    {
        Intent i = new Intent (this, Ingresos_act.class);

        Bundle bun = new Bundle(); //
        bun.putStringArray("animal", an.getAnimal());
        i.putExtras(bun);
        startActivity(i);
    }

    public void Gestion_Animales (View view)
    {
        Intent i = new Intent(this, Gestion_Animales_act.class);
        startActivity(i);
    }
}