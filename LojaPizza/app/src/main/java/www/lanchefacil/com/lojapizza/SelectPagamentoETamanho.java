package www.lanchefacil.com.lojapizza;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class SelectPagamentoETamanho extends AppCompatActivity {
    TextView selectItem;
    RadioGroup selectTamanho;
    Button btnDinheiro;
    Button btnCartao;
    LinearLayout LayoutPizza;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_select_pagamento_etamanho);
        btnDinheiro = findViewById(R.id.btnDinheiro);
        btnCartao = findViewById(R.id.btnCartao);
        LayoutPizza = findViewById(R.id.LayoutPizza);
        Intent intent = new Intent(this, ResumoDoPedido.class);
        List<String> listPizza = new ArrayList<>();
        Bundle bundle = getIntent().getExtras();
        listPizza.add(bundle.getString("pizza1"));
        listPizza.add(bundle.getString("pizza2"));
        listPizza.add(bundle.getString("pizza3"));
        listPizza.add(bundle.getString("pizza4"));
        listPizza.add(bundle.getString("pizza5"));
        for(String s: listPizza ){
            if(s != null) {
                TextView typePizza = new TextView(this);
                typePizza.setText(s);

                RadioGroup groupTypePizza = new RadioGroup(this);
                groupTypePizza.setOrientation(RadioGroup.HORIZONTAL);

                RadioButton pequeno = new RadioButton(this);
                pequeno.setText("pequeno");
                groupTypePizza.addView(pequeno);

                RadioButton media = new RadioButton(this);
                media.setText("Média");
                groupTypePizza.addView(media);

                RadioButton grande = new RadioButton(this);
                grande.setText("Grande");
                groupTypePizza.addView(grande);

                LayoutPizza.addView(typePizza);
                LayoutPizza.addView(groupTypePizza);
                if(s.equals(bundle.getString("pizza1"))){
                    intent.putExtra("pizza1","Margherita");
                    groupTypePizza.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            if(checkedId == pequeno.getId()){
                                intent.putExtra("tamanho1","Pizza Margherita Pequena");
                                intent.putExtra("preco1","20.99");
                            }else if(checkedId == media.getId()){
                                intent.putExtra("tamanho1","Pizza Margherita Média");
                                intent.putExtra("preco1","25.99");
;                            } else if (checkedId == grande.getId()) {
                                intent.putExtra("tamanho1","Pizza Margherita Grande");
                                intent.putExtra("preco1","30.99");
                            }
                        }
                    });
                }
                if(s.equals(bundle.getString("pizza2"))){
                    intent.putExtra("pizza2","Calabresa");
                    groupTypePizza.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            if (checkedId == pequeno.getId()) {
                                intent.putExtra("tamanho2", "Pizza Calabresa Pequena");
                                intent.putExtra("preco2", "22.99");
                            } else if (checkedId == media.getId()) {
                                intent.putExtra("tamanho2", "Pizza Calabresa Média");
                                intent.putExtra("preco2", "24.99");
                            } else if (checkedId == grande.getId()) {
                                intent.putExtra("tamanho2", "Pizza Calabresa Grande");
                                intent.putExtra("preco2", "28.99");
                            }
                        }});
                }
                if(s.equals(bundle.getString("pizza3"))){
                    intent.putExtra("pizza3","Portuguesa");
                    groupTypePizza.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            if (checkedId == pequeno.getId()) {
                                intent.putExtra("tamanho3", "Pizza Portuguesa Pequena");
                                intent.putExtra("preco3", "24.99");
                            } else if (checkedId == media.getId()) {
                                intent.putExtra("tamanho3", "Pizza Portuguesa Média");
                                intent.putExtra("preco3", "37.99");
                            } else if (checkedId == grande.getId()) {
                                intent.putExtra("tamanho3", "Pizza Portuguesa Grande");
                                intent.putExtra("preco3", "50.99");
                            }
                        }});
                }
                if(s.equals(bundle.getString("pizza4"))){
                    intent.putExtra("pizza4","Mussarela");
                    groupTypePizza.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            if (checkedId == pequeno.getId()) {
                                intent.putExtra("tamanho4", "Pizza Mussarela Pequena");
                                intent.putExtra("preco2", "21.99");
                            } else if (checkedId == media.getId()) {
                                intent.putExtra("tamanho4", "Pizza Mussarela Média");
                                intent.putExtra("preco2", "22.99");
                            } else if (checkedId == grande.getId()) {
                                intent.putExtra("tamanho4", "Pizza Mussarela Grande");
                                intent.putExtra("preco2", "23.99");
                            }
                        }});
                }
                if(s.equals(bundle.getString("pizza5"))){
                    intent.putExtra("pizza5","Frango com catupiry");
                    groupTypePizza.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            if (checkedId == pequeno.getId()) {
                                intent.putExtra("tamanho5", "Pizza Frango com catupiry Pequena");
                                intent.putExtra("preco5", "22.99");
                            } else if (checkedId == media.getId()) {
                                intent.putExtra("tamanho5", "Pizza Frango com catupiry Média");
                                intent.putExtra("preco5", "24.99");
                            } else if (checkedId == grande.getId()) {
                                intent.putExtra("tamanho5", "Pizza Frango com catupiry Grande");
                                intent.putExtra("preco5", "28.99");
                            }
                        }});
                }


            }
        }
        btnDinheiro.setOnClickListener(view->{
            intent.putExtra("formaPagamento","Dinheiro");
            startActivity(intent);
        });
        btnCartao.setOnClickListener(view->{
            intent.putExtra("formaPagamento","Cartão");
            startActivity(intent);
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}