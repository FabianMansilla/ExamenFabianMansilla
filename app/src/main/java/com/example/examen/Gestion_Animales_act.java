package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.examen.database.AdminSQLiteOpenHelper;

public class Gestion_Animales_act extends AppCompatActivity {

    private EditText fich, ani, tipo, edad, enfe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_animales);

        fich = findViewById(R.id.fich);
        ani = findViewById(R.id.ani);
        tipo = findViewById(R.id.tipo);
        edad = findViewById(R.id.edad);
        enfe = findViewById(R.id.enfe);
    }
    public void guardarFicha(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "gestion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //permisos de sobreescritura

        String ficha = fich.getText().toString();
        String animal = ani.getText().toString();
        String tipoe = tipo.getText().toString();
        String edada = edad.getText().toString();
        String enfermedad = enfe.getText().toString();

        if(!ficha.isEmpty() && !animal.isEmpty() && !tipoe.isEmpty() && !edada.isEmpty() && !enfermedad.isEmpty())
        {
            ContentValues cont = new ContentValues();
            cont.put("Ficha", ficha);
            cont.put("Animal", animal);
            cont.put("Tipo Animal", tipoe);
            cont.put("Edad", edada);
            cont.put("Enfermedad", enfermedad);

            db.insert("gestion", null, cont);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(), "has guardado una ficha", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getBaseContext(), "Los campos estan vacios...", Toast.LENGTH_SHORT).show();
        }

    }

    public void mostrarFicha(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "gestion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //permisos de sobreescritura

        String ficha = fich.getText().toString();
        if(!ficha.isEmpty())
        {
            Cursor file = db.rawQuery("SELECT clase, intensidadFROM tarot WHERE codigo ="+ficha, null);

            if(file.moveToFirst()) //verifica si hay clases
            {
                ani.setText(file.getString(0));
                edad.setText(file.getString(1));
                tipo.setText(file.getString(2));
                enfe.setText(file.getString(3));
            }
            else
            {
                Toast.makeText(getBaseContext(), "No hay datos asociada a la ficha", Toast.LENGTH_LONG).show();
            }

        }
        else
        {
            Toast.makeText(getBaseContext(), "La ficha esta vacia...", Toast.LENGTH_SHORT).show();
        }
    }

    public void eliminarFicha(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "gestion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String ficha = fich.getText().toString();

        if(!ficha.isEmpty())
        {
            db.delete("gestion", "ficha="+ficha, null);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(), "Eliminaste una ficha", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getBaseContext(), "la ficha viene vacia...", Toast.LENGTH_SHORT).show();
        }

    }

    public void Clean()
    {
        fich.setText("");
        edad.setText("");
        tipo.setText("");
        enfe.setText("");
    }
}