package com.example.sorteio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText edMin, edMax;
    TextView tvResultado1, tvResultado2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edMin = findViewById(R.id.edMin);
        edMax = findViewById(R.id.edMax);
        tvResultado1 = findViewById(R.id.txt1);
        tvResultado2 = findViewById(R.id.txt2);
    }

    public void sorteia(View v) {
        int min = Integer.parseInt(edMin.getText().toString());
        int max = Integer.parseInt(edMax.getText().toString());

        int random1 = (int) (Math.random() * (max - min + 1)) + min;
        tvResultado1.setText(Integer.toString(random1));

        Random utilRandom = new Random();
        int random2 = utilRandom.nextInt(max - min + 1) + min;
        tvResultado2.setText(Integer.toString(random2));
    }
}
