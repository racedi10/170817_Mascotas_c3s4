package mx.com.oexl.petagram;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import fragment.perfil_fragment;
import fragment.recyclerview_fragment;
import mx.com.oexl.petagram.adapter.PageAdapter;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    SwipeRefreshLayout sfiMiIndicadorRefresh;
    ListView lstMiLista;
    //Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.miActionBar);
        tabLayout = (TabLayout)findViewById(R.id.tabLayuot);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        setUpViewPager();

        if (toolbar !=null){
            setSupportActionBar(toolbar);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mContact:
                Intent intent = new Intent(this, Contacto.class);
                startActivity(intent);
                break;

            case R.id.mAbout:
                Intent i = new Intent(this, Acerca.class);
                startActivity(i);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void presionoBoton(View v){
        Intent intent = new Intent(this, DetalleMascota.class);
        System.out.println(intent);

        startActivity(intent);
    }

    /*public void refrescandoContenido(){
        String[]razas = getResources().getStringArray(R.array.razas);
        lstMiLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1,razas));
        sfiMiIndicadorRefresh.setRefreshing(false);
    }

    public void agregarFAB(){
        FloatingActionButton miFAB = (FloatingActionButton) findViewById(R.id.fabMiFAB);
        miFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),getResources().getString(R.string.mensaje),Toast.LENGTH_SHORT).show();
                Snackbar.make(v,getResources().getString(R.string.mensaje),Snackbar.LENGTH_SHORT)
                        .setAction(getResources().getString(R.string.texto_accion), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.i("SNACKBAR","Click en Snackbar");
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                        .show();
            }
        });*/

    private ArrayList<Fragment> agregarFragment(){
        ArrayList<Fragment>fragments =new ArrayList<>();

        fragments.add(new recyclerview_fragment());
        fragments.add(new perfil_fragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dog);

    }
}

