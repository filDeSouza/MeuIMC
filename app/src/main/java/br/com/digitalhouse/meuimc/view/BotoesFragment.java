package br.com.digitalhouse.meuimc.view;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.com.digitalhouse.meuimc.R;
import br.com.digitalhouse.meuimc.interfaces.Comunicador;
import br.com.digitalhouse.meuimc.model.Operacional;

import static br.com.digitalhouse.meuimc.view.InicialActivity.NOME_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class BotoesFragment extends Fragment  {

    private Comunicador comunicador;
    private Button btnCalculo;
    private Button btnInforma;


    public BotoesFragment() {

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            comunicador = (Comunicador) context;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_botoes, container, false);

        initView(view);

        btnCalculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Operacional calculo = new Operacional(R.drawable.professora,"logica de calculo");

                comunicador.receberMensagen(calculo);

            }

        });

        btnInforma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Operacional info = new Operacional(R.drawable.tabela,"IMC significa Índice de Massa Corporal e trata-se de uma \n medida do peso de cada pessoa, sendo uma relação entre a massa da pessoa e a sua altura. Para determinar o IMC, basta dividir o peso do indivíduo (massa) pela sua altura ao quadrado. A massa deve ser definida em quilogramas (kg) e a altura em metros.");

                comunicador.receberMensagen(info);
            }
        });

        return view;

    }

    public void initView(View view){
        btnCalculo = view.findViewById(R.id.botaoCalcular);
        btnInforma = view.findViewById(R.id.botaoInformar);
    }
}
