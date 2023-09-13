package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.aula3.imc.R;

import java.text.DecimalFormat;

public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Button btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Quando o botão "Voltar para Início" for clicado, encerre a atividade Resultado
                // para voltar à MainActivity
                finish();
            }
        });

        // Vincula os elementos de layout às variáveis
        TextView tvIMC = findViewById(R.id.tvIMC);
        TextView tvWeight = findViewById(R.id.tvWeight);
        TextView tvHeight = findViewById(R.id.tvHeight);
        ImageView ivResultado = findViewById(R.id.ivResultado);

        // Obtém o Bundle com os valores do IMC, peso e altura passados da MainActivity
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            double weight = bundle.getDouble("Weight");
            double height = bundle.getDouble("Height");
            double imc = bundle.getDouble("IMC");

            tvWeight.setText(String.format("Peso: %.2f kg", weight));
            tvHeight.setText(String.format("Altura: %.2f m", height));
            tvIMC.setText(String.format("IMC: %.2f", imc));

            // Exibe a imagem com base no IMC calculado
            int imageResource = bundle.getInt("ImageResource");
            if (imageResource != 0) {
                ivResultado.setImageResource(imageResource);
                ivResultado.setVisibility(View.VISIBLE); // Torna a imagem visível
            }
        }
    }
}
