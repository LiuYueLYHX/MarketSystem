package www.temdetudo.com.br;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class confirmacao extends AppCompatActivity {
    Button btnVoltar;
    TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_confirmacao);
        btnVoltar = findViewById(R.id.btnVoltar);
        resultado = findViewById(R.id.resultado);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String getNome = bundle.getString("nome");
        resultado.setText("Bem-vindo, " + getNome);
        btnVoltar.setOnClickListener(view->{
            Intent volta = new Intent(this, MainActivity.class);
            startActivity(volta);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}