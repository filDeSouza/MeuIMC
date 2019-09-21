package br.com.digitalhouse.meuimc.view;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.com.digitalhouse.meuimc.interfaces.Comunicador;
import br.com.digitalhouse.meuimc.model.Operacional;
import br.com.digitalhouse.meuimc.R;

public class CalcularActivity extends Fragment {

    private Comunicador comunicador;
    private Button btnCalculo;
    private Button btnInformacao;
    private Button btnReiniciar;

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
        public View onCreateView (LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState){
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.activity_calcular, container, false);


            initView(view);

            btnCalculo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //Criando o Objeto
                    Operacional calculo = new Operacional(R.drawable.icon, "Informaçoes do imc implementar");

                    comunicador.receberMensagen(calculo);

                }
            });

            btnInformacao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Operacional informacao = new Operacional(R.mipmap.tabela, "IMC significa Índice de Massa Corporal e trata-se de uma medida do peso de cada pessoa, sendo uma relação entre a massa da pessoa e a sua altura. ... Para determinar o IMC, basta dividir o peso do indivíduo (massa) pela sua altura ao quadrado. A massa deve ser definida em quilogramas (kg) e a altura em metros.");

                    comunicador.receberMensagen(informacao);
                }
            });

            btnReiniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(CalcularActivity.this, InicialActivity.class));
                }
            });

            return view;


        }

        public void initView (View view){
            btnCalculo = view.findViewById(R.id.botaoCalcular);
            btnInformacao = view.findViewById(R.id.botaoInformacoes);
            btnReiniciar = view.findViewById(R.id.botaoReiniciar);
        }

    }


