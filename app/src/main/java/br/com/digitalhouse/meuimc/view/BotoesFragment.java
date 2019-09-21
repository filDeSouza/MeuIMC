package br.com.digitalhouse.meuimc.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.digitalhouse.meuimc.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BotoesFragment extends Fragment {


    public BotoesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_botoes, container, false);
    }

}
