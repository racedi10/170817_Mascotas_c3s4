package mx.com.oexl.petagram;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Raul on 13/07/2017.
 */
public class RazasAdaptador extends RecyclerView.Adapter<RazasAdaptador.RazasViewHolder>{
    ArrayList<Mascota> razas;
    Activity activity;

    public RazasAdaptador(ArrayList<Mascota> razas, Activity activity) {
        this.razas = razas;
        this.activity = activity;
    }

    @Override
    public RazasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listado_mascotas, parent, false);
        return new RazasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RazasViewHolder razasViewHolder, int position) {
        final Mascota raza = razas.get(position);
        razasViewHolder.imagenFoto.setImageResource(raza.getFoto());
        razasViewHolder.imaHuesoB.setImageResource(raza.getHuesoB());
        razasViewHolder.tvNombreTV.setText(raza.getNombre());
        razasViewHolder.tvNumeroTV.setText(raza.getNumero());
        razasViewHolder.imagenHueso.setImageResource(raza.getHuesoA());
    }

    @Override
    public int getItemCount() {
        return razas.size();
    }

    public class RazasViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagenFoto;
        private ImageView imaHuesoB;
        private TextView tvNombreTV;
        private TextView tvNumeroTV;
        private ImageView imagenHueso;

        public RazasViewHolder(View itemView) {
            super(itemView);
            imagenFoto    = (ImageView) itemView.findViewById(R.id.imaFoto);
            imaHuesoB     = (ImageView) itemView.findViewById(R.id.imaHueso);
            tvNombreTV    = (TextView) itemView.findViewById(R.id.tvNombre);
            tvNumeroTV    = (TextView) itemView.findViewById(R.id.tvNumero);
            imagenHueso   = (ImageView) itemView.findViewById(R.id.imaHuesoA);
        }
    }
}
