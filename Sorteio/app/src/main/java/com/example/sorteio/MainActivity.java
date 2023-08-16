package com.example.sorteio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText edMin,edMax;

    TextView tvReultado1,  tvReultado2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edMin = findViewById(R.id.edMin);
        edMax = findViewById(R.id.edMax);
        tvReultado1=findViewById(R.id.txt1);
        tvReultado2=findViewById(R.id.txt2);

    }


    public void sorteia(View v){
        int min,max;

        min = Integer.parseInt(edMin.getText().toString());
        max = Integer.parseInt(edMax.getText().toString());

        int random =(int) (Math.random()* (max=min+1))+min;
        tvReultado1.setText(Integer.toString(random));

        Random utilRandom = new Random();
        random = utilRandom.nextInt(max-min+1)+min;
        tvReultado2.setText(Integer.toString(random));
    }



    }
