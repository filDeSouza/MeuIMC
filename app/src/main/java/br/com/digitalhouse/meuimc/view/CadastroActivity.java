package br.com.digitalhouse.meuimc.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import br.com.digitalhouse.meuimc.R;

public class CadastroActivity extends AppCompatActivity {

    private TextInputLayout lNome;
    private TextInputLayout lIdade;
    private TextInputLayout lPeso;
    private TextInputLayout lAltura;
    private Button btnComecar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        lNome =findViewById(R.id.txtLayoutNome);
        lIdade = findViewById(R.id.txtLayoutIdade);
        lPeso = findViewById(R.id.txtLayoutPeso);
        lAltura = findViewById(R.id.txtLayoutAltura);
        btnComecar = findViewById(R.id.btnComecar);

        btnComecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome= lNome.getEditText().getText().toString();
                int idade = Integer.parseInt(lIdade.getEditText().getText().toString());
                double peso = Double.parseDouble(lPeso.getEditText().getText().toString());
                double altura = Double.parseDouble(lAltura.getEditText().getText().toString());

                if(!nome.isEmpty() && idade!=0 && peso!=0 && altura!=0){
                Intent intent = new Intent(CadastroActivity.this, InicialActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("NOME", nome);
                bundle.putInt("IDADE", idade);
                bundle.putDouble("PESO", peso);
                bundle.putDouble("ALTURA", altura);

                intent.putExtras(bundle);
                startActivity(intent);

               } else {
                    lNome.setError("Preencha todos os dados");
                    lIdade.setError("Preencha todos os dados");
                    lPeso.setError("Preencha todos os dados");
                    lAltura.setError("Preencha todos os dados");
                }

            }
        });


    }
}
