package br.com.digitalhouse.meuimc.fragments;


import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.digitalhouse.meuimc.model.Operacional;
import br.com.digitalhouse.meuimc.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalculoRespostaFragment extends Fragment {

    private ImageView image;
    private TextView texto;


    public CalculoRespostaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_calculo_resposta, container, false);

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
