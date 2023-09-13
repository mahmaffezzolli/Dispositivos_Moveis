package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.aula3.imc.R;

public class MainActivity extends AppCompatActivity {

    EditText editTextWeight;
    EditText editTextHeight;
    Button buttonCalculate;
    ImageView imageViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vincula os elementos de entrada de peso, altura e botão de cálculo a objetos EditText e Button
        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);
        buttonCalculate = findViewById(R.id.calculateButton);
        imageViewResult = findViewById(R.id.imageView);

        // Define um OnClickListener para o botão de cálculo
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateIMC();
            }
        });
    }

    private void calculateIMC() {
        // Obtém os valores de peso e altura inseridos pelo usuário como strings
        String weightStr = editTextWeight.getText().toString();
        String heightStr = editTextHeight.getText().toString();

        // Verifica se os campos de peso e altura não estão vazios
        if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
            // Converte as strings de peso e altura em valores numéricos (double)
            double weight = Double.parseDouble(weightStr);
            double height = Double.parseDouble(heightStr);

            // Calcula o IMC
            double imc = weight / (height * height);

            // Obtém o recurso da imagem com base no IMC calculado
            int imageResource = getImageResource(imc);

            // Cria um Bundle para passar os valores do IMC, peso, altura e recurso da imagem
            Bundle bundle = new Bundle();
            bundle.putDouble("Weight", weight);
            bundle.putDouble("Height", height);
            bundle.putDouble("IMC", imc);
            bundle.putInt("ImageResource", imageResource);

            // Cria uma intenção (Intent) para iniciar a atividade Resultado
            Intent intent = new Intent(this, Resultado.class);

            // Associa o Bundle à Intent
            intent.putExtras(bundle);

            // Inicia a atividade Resultado
            startActivity(intent);
        }
    }
    protected void onResume() {
        super.onResume();
        editTextWeight.setText(""); // Limpa o campo de peso
        editTextHeight.setText(""); // Limpa o campo de altura
    }

    private int getImageResource(double bmi) {
        if (bmi < 18.5) {
            return R.drawable.abaixopeso;
        } else if (bmi < 24.9) {
            return R.drawable.normal;
        } else if (bmi < 29.9) {
            return R.drawable.sobrepeso;
        } else if (bmi < 34.9) {
            return R.drawable.obesidade1;
        } else if (bmi < 39.9) {
            return R.drawable.obesidade2;
        } else {
            return R.drawable.obesidade3;
        }
    }
}
