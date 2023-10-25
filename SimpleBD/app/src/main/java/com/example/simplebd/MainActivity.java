package com.example.simplebd;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    ListView lv;
    EditText txtTexto;
    Button botao;

    @SuppressLint({"Range", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.listView);
        txtTexto = findViewById(R.id.txtNota);
        botao = findViewById(R.id.botao);

        db = openOrCreateDatabase("dbNotas", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS user(id INTEGER PRIMARY KEY AUTOINCREMENT, nota VARCHAR);");

        exibir();

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
                exibir();
            }
        });

    }

    private void salvar() {

        ContentValues cv = new ContentValues();
        cv.put("nota", txtTexto.getText().toString());
        db.insert("user", null, cv);

    }

    @SuppressLint("Range")
    private void exibir(){

        Cursor cursor = db.rawQuery("SELECT * FROM user ", null);
        cursor.moveToFirst();
        ArrayList<String> listaNota = new ArrayList<>();

        while (!cursor.isAfterLast()) {
            listaNota.add(cursor.getString(cursor.getColumnIndex("nota")));
            Log.d("tableuser", cursor.getString(cursor.getColumnIndex("id")) +
                    cursor.getString(cursor.getColumnIndex("nota")));
            cursor.moveToNext();

        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, listaNota);
        lv.setAdapter(arrayAdapter);
    }
}
