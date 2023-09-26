package com.aula3.lista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<itemChurrasco> listaitemChurrasco = new ArrayList<itemChurrasco>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        listaitemChurrasco.add(new itemChurrasco(1, "Carne", R.drawable.carne));
        listaitemChurrasco.add(new itemChurrasco(2, "Linguiça", R.drawable.linguica));
        listaitemChurrasco.add(new itemChurrasco(3, "Pão de alho", R.drawable.pao_de_alho));
        listaitemChurrasco.add(new itemChurrasco(4, "Refri", R.drawable.refrigerante));

        itemChurrascoAdapter adapter = new itemChurrascoAdapter(this, R.layout.item_churrasco, listaitemChurrasco);
        listView.setAdapter(adapter);
    }
}