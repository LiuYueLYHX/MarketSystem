package www.lanchefacil.com.br;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class ResumoDoPedido extends AppCompatActivity {
    TextView nomeFinal;
    TextView lancheFinal;
    Button btnVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resumo_do_pedido);
        nomeFinal = findViewById(R.id.nomeFinal);
        btnVoltar = findViewById(R.id.btnVoltar);
        Bundle bundle = getIntent().getExtras();
        String getNomeFinal = bundle.getString("nome");
        nomeFinal.setText(getNomeFinal);
        List<String> listLanche = new ArrayList<>();
        listLanche.add(bundle.getString("lanche1"));
        listLanche.add(bundle.getString("lanche2"));
        listLanche.add(bundle.getString("lanche3"));
        listLanche.add(bundle.getString("lanche4"));
        listLanche.add(bundle.getString("lanche5"));
        listLanche.add(bundle.getString("lanche6"));
        String textLanche = "";
        for(String s: listLanche){
            if(s != null){
            textLanche = textLanche + "- " + s + "\n";
            }
        }
        lancheFinal = findViewById(R.id.lancheFinal);
        lancheFinal.setText(textLanche);
        btnVoltar.setOnClickListener(view->{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}