package mx.com.oexl.petagram;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ListadoMascotas extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvNumero;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_mascotas);

        Bundle parametros = getIntent().getExtras();

        String nombre = parametros.getString("nombre");
        String numero = parametros.getString("numero");

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvNumero = (TextView) findViewById(R.id.tvNumero);

        tvNombre.setText(nombre);
        tvNumero.setText(numero);
    }
}
