package fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.com.oexl.petagram.Mascota;
import mx.com.oexl.petagram.R;
import mx.com.oexl.petagram.RazasAdaptador;

/**
 * A simple {@link Fragment} subclass.
 */
public class recyclerview_fragment extends Fragment {

    private ArrayList<Mascota> razas;/////////// nuevo
    private RecyclerView listaMascotas;/////////// nuevo


    public recyclerview_fragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.recycler_fragment, container, false);
        View v = inflater.inflate(R.layout.recycler_fragment, container,false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.lstMiLista);/////////// nuevo
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());/////////// nuevo
        llm.setOrientation(LinearLayoutManager.VERTICAL);/////////// nuevo
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }


    public RazasAdaptador adaptador;
    private void inicializarAdaptador() {
        adaptador = new RazasAdaptador(razas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    private void inicializarListaMascotas() {

        razas = new ArrayList<Mascota>();
        razas.add(new Mascota(R.drawable.labrador, R.drawable.huesob, "Labrador", "2", R.drawable.huesob));
        razas.add(new Mascota(R.drawable.siberian_husky, R.drawable.huesob, "Husky", "5", R.drawable.hueso));
        razas.add(new Mascota(R.drawable.coli, R.drawable.huesob, "Coli", "3", R.drawable.huesob));
        razas.add(new Mascota(R.drawable.bulldog, R.drawable.huesob, "Bullgog", "2", R.drawable.huesob));
    }

}
