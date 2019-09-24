package br.com.digitalhouse.meuimc.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import br.com.digitalhouse.meuimc.R;

public class InicialActivity extends AppCompatActivity {

    private TextView textoOla;
    private TextView textoIdade;
    private TextView textoPeso;
    private TextView textoAltura;
    private Button buttonAvancar;

    public static final String NOME_KEY = "NOME";
    public static final String IDADE_KEY = "IDADE";
    public static final String PESO_KEY = "PESO";
    public static final String ALTURA_KEY = "ALTURA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);

        textoOla =findViewById(R.id.viewTextoOla);
        textoIdade =findViewById(R.id.viewTextoIdade);
        textoPeso =findViewById(R.id.viewTextoPeso);
        textoAltura =findViewById(R.id.viewTextoAltura);
        buttonAvancar = findViewById(R.id.buttonVai);

        Intent intent = getIntent();

        if (getIntent() != null && intent.getExtras() != null){

            Bundle bundle = intent.getExtras();
            String ola = "Seja bem vindo(a) " + bundle.getString(NOME_KEY) + "! Esse é um aplicativo que\n" +
                    "te ajuda a saber e calcular o seu Indice de Massa \n" +
                    "Corporal";
            String idade = String.valueOf(bundle.getInt(IDADE_KEY));
            String peso = String.valueOf(bundle.getDouble(PESO_KEY));
            String altura = String.valueOf(bundle.getDouble(ALTURA_KEY));

            textoOla.setText(ola);
            textoIdade.setText(idade);
            textoPeso.setText(peso);
            textoAltura.setText(altura);

        }else{
            Snackbar.make(textoOla, "Não há dados!", Snackbar.LENGTH_LONG).show();
        }

        buttonAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InicialActivity.this, CalcularActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("NOME", bundle.getString(NOME_KEY));
                bundle.putInt("IDADE", Integer.parseInt(IDADE_KEY));
                bundle.putDouble("PESO", Double.parseDouble(PESO_KEY));
                bundle.putDouble("ALTURA", Double.parseDouble(ALTURA_KEY));


                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}