package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    CheckBox item1;
    CheckBox item2;
    CheckBox item3;
    CheckBox item4;
    CheckBox item5;
    Button finaliza;
    TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void OnClick(View view) {
        item1 = findViewById(R.id.item1);
        item2 = findViewById(R.id.item2);
        item3 = findViewById(R.id.item3);
        item4 = findViewById(R.id.item4);
        item5 = findViewById(R.id.item5);
        finaliza = findViewById(R.id.finaliza);
        resultado = findViewById(R.id.resultado);
        float resolucao = 0.0f;
        if(item1.isChecked()){
            resolucao += 2.69f;
        }if(item2.isChecked()){
            resolucao += 2.70f;
        }if(item3.isChecked()){
            resolucao += 16.70f;
        }if(item4.isChecked()){
            resolucao += 3.38f;
        }if(item5.isChecked()){
            resolucao += 3.00f;
        }
        resultado.setText("\n\n       Total:                                                                                         " +"\n\n                                                                                                       "+String.format("%.2f",resolucao));
    }
}