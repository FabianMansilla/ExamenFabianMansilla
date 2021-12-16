package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import Objetos.Administrador;

public class MainActivity extends AppCompatActivity {

    private EditText user, pass;
    private TextView msj;
    private Button btn;
    private Administrador adm = new Administrador();
    private ProgressBar barra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            user = findViewById(R.id.etuser);
            pass = findViewById(R.id.etpass);
            msj = findViewById(R.id.msj);
            btn = (Button)findViewById(R.id.btn);
            barra = (ProgressBar)findViewById(R.id.pb);

        msj.setVisibility(View.INVISIBLE);
        barra.setVisibility(View.INVISIBLE);


     btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            //Aqui corremos nuestra tarea Asincrona

            new Task().execute();
        }
    });
}

//tarea asincrona
class Task extends AsyncTask<String, Void, String>
{
    //Configuracion inicial de la tarea asincrona
    @Override
    protected void onPreExecute() {

        super.onPreExecute();
        barra.setVisibility(View.VISIBLE);
    }

    // es quien se encarga de llevar el proceso en segundo plano
    @Override
    protected String doInBackground(String... strings) {

        try
        {
            for(int i = 0; i <=10; i++)
            {
                Thread.sleep(500);
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return null;

    }

    // si la tarea asincrona se realizo o no con exito
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        barra.setVisibility(View.INVISIBLE);


        String usuario = user.getText().toString().trim();
        String contrasena = pass.getText().toString().trim();
        String userObj = adm.getUser().trim();
        String passObj = adm.getPass().trim();

        switch (usuario)
        {
            case "Fabian":
                if(usuario.equals(userObj) && contrasena.equals(passObj))
                {
                    msj.setVisibility(View.INVISIBLE);
                    Intent i = new Intent(getBaseContext(), Home_act.class);
                    startActivity(i);
                }
                break;
            case "":
                if(usuario.equals("") && contrasena.equals(""))
                {
                    msj.setVisibility(View.VISIBLE);
                    msj.setText("Campos vacios. Por favor ingrese nuevamente");
                }
                break;
            default:
                if (!usuario.equals(userObj) && !contrasena.equals(passObj))
                {
                    msj.setVisibility(View.VISIBLE);
                    msj.setText("Campos incorrectos. Por favor ingrese nuevamente");
                }
                break;
        }
    }
}

}