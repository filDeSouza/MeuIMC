package br.com.digitalhouse.meuimc.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ReportFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import br.com.digitalhouse.meuimc.interfaces.Comunicador;
import br.com.digitalhouse.meuimc.model.Operacional;
import br.com.digitalhouse.meuimc.R;

public class CalcularActivity extends AppCompatActivity implements Comunicador {
    private FloatingActionButton btnReiniciar;


    public static final String SO_KEY = "SO";


            @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular);

        btnReiniciar = findViewById(R.id.botaoReiniciar);

                btnReiniciar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(CalcularActivity.this,CadastroActivity.class));

                    }

                });

        replaceFragment(R.id.containerDois, new BotoesFragment());


    }

    @Override
    public void receberMensagen(Operacional operacional) {
        setBundleToFragment(operacional, SO_KEY);

    }

    private void replaceFragment (int container, Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.commit();
    }


    private void setBundleToFragment(Operacional so, String CHAVE){
        Bundle bundle = new Bundle();
        bundle.putParcelable(CHAVE, so);

        Fragment InformacoesFragment = new InformacoesFragment();
        InformacoesFragment.setArguments(bundle);

        replaceFragment(R.id.containerUm, InformacoesFragment);
    }


}
