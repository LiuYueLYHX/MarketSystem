package com.example.calculodosalario;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView resultado;
    RadioGroup rbSalario;
    EditText salario;
    Button finaliza;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        rbSalario = findViewById(R.id.rbSalario);
        resultado = findViewById(R.id.resultado);
        salario = findViewById(R.id.Salario);
        rbSalario.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb40) {
                    Log.d("RadioButton", "40% selected");
                    float dinheiro = Float.parseFloat(salario.getText().toString());
                    resultado.setText("\n\n       Total:                                                                                         "+"\n\n                                                                                                "+String.format("%.2f",dinheiro*1.4f));
                } else if (checkedId == R.id.rb45) {
                    Log.d("RadioButton", "45% selected");
                    float dinheiro = Float.parseFloat(salario.getText().toString());
                    resultado.setText("\n\n       Total:                                                                                         "+"\n\n                                                                                                "+String.format("%.2f",dinheiro*1.45f));
                } else if (checkedId == R.id.rb50) {
                    Log.d("RadioButton", "50% selected");
                    float dinheiro = Float.parseFloat(salario.getText().toString());
                    resultado.setText("\n\n       Total:                                                                                         "+"\n\n                                                                                                "+String.format("%.2f",dinheiro*1.5f));
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}