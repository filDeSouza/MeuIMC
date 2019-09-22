package br.com.digitalhouse.meuimc.view;


import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.digitalhouse.meuimc.R;
import br.com.digitalhouse.meuimc.model.Operacional;

import static br.com.digitalhouse.meuimc.view.CalcularActivity.SO_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class InformacoesFragment extends Fragment {

    private ImageView image;
    private TextView texto;



    public InformacoesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_informacoes, container, false);


            initView(view);

            if (!getArguments().isEmpty()){
                Operacional Operacional = getArguments().getParcelable(SO_KEY);

                if (Operacional != null){

                    Drawable drawable = getResources().getDrawable(Operacional.getImagem());

                    image.setImageDrawable(drawable);
                    texto.setText(Operacional.getTexto());
                }
            }
            return view;
        }

        private void initView(View view){
            image = view.findViewById(R.id.imageView);
            texto = view.findViewById(R.id.textView);
        }

    }

