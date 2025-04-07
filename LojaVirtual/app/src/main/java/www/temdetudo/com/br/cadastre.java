package www.temdetudo.com.br;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class cadastre extends AppCompatActivity {
    EditText nome;
    EditText password;
    EditText confirmPassword;
    Button btnCadastre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro);
        nome = findViewById(R.id.nome);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);
        btnCadastre = findViewById(R.id.btnCadastre);
        btnCadastre.setOnClickListener(view->{
            String getNome = nome.getText().toString();
            String getpassword = password.getText().toString();
            String getConfirmPassword = confirmPassword.getText().toString();
            if(getConfirmPassword.equals(getpassword)) {
                if(!getNome.equals("")||!getConfirmPassword.equals("")) {
                        Intent intent = new Intent(this, confirmacao.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("nome", getNome);
                        intent.putExtras(bundle);
                        startActivity(intent);
                }else{
                    nome.setHintTextColor(getResources().getColor(R.color.Red));
                    nome.setHint("O nome não pode deixar em branco.");
                    password.setHintTextColor(getResources().getColor(R.color.Red));
                    password.setHint("a senha não pode deixar em branco.");
                }
            }else{
                confirmPassword.setHintTextColor(getResources().getColor(R.color.Red));
                confirmPassword.setHint("As senhas não coincidem.");
                confirmPassword.setText("");
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}