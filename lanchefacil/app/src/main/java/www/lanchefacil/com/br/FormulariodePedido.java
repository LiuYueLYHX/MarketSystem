package www.lanchefacil.com.br;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class FormulariodePedido extends AppCompatActivity {
     Button btnResumo;
     CheckBox lanche1;
     CheckBox lanche2;
     CheckBox lanche3;
     CheckBox lanche4;
     CheckBox lanche5;
     CheckBox lanche6;
     EditText nomeDigite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formulariode_pedido);
        btnResumo = findViewById(R.id.btnResumo);
        lanche1 = findViewById(R.id.lanche1);
        lanche2 = findViewById(R.id.lanche2);
        lanche3 = findViewById(R.id.lanche3);
        lanche4 = findViewById(R.id.lanche4);
        lanche5 = findViewById(R.id.lanche5);
        lanche6 = findViewById(R.id.lanche6);
        nomeDigite = findViewById(R.id.nomeDigite);
        Intent intent = new Intent(this, ResumoDoPedido.class);

        btnResumo.setOnClickListener(view->{
            String getNomeDigite =  nomeDigite.getText().toString();
            if(!getNomeDigite.equals("")){
                if(lanche1.isChecked()){
                    intent.putExtra("lanche1","Coca-Cola");
                }
                if(lanche2.isChecked()){
                    intent.putExtra("lanche2","Batata Frita");
                }
                if(lanche3.isChecked()){
                    intent.putExtra("lanche3","Hamburguer");
                }
                if(lanche4.isChecked()){
                    intent.putExtra("lanche4","Arroz");
                }
                if(lanche5.isChecked()){
                    intent.putExtra("lanche5","Suco");
                }
                if(lanche6.isChecked()){
                    intent.putExtra("lanche6","Pastel");
                }
                intent.putExtra("nome",getNomeDigite);
                startActivity(intent);
            }else{
                nomeDigite.setHint("O nome não pode deixar em branco");
                nomeDigite.setHintTextColor(getResources().getColor(R.color.red));
            }

        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}