package pildorasinformaticas.com.mylogin.proyecto_android_tienda_informatica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.List;

import pildorasinformaticas.com.mylogin.proyecto_android_tienda_informatica.adaptador.AdaptadorProducto;
import pildorasinformaticas.com.mylogin.proyecto_android_tienda_informatica.entidades.Producto;
import pildorasinformaticas.com.mylogin.proyecto_android_tienda_informatica.modelo.ListaProductos;

public class MainActivity extends AppCompatActivity {
    private RecyclerView miReyclerViewUser;
    private AdaptadorProducto adaptadorProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miReyclerViewUser = findViewById(R.id.recyclerV);
        miReyclerViewUser.setHasFixedSize(true);
        miReyclerViewUser.setLayoutManager(new LinearLayoutManager(this));

        ListaProductos.getInstance().inicializar();
        List<Producto> listaProducto = ListaProductos.getInstance().getListaProductos();
        adaptadorProducto = new AdaptadorProducto(listaProducto);
        miReyclerViewUser.setAdapter(adaptadorProducto);
    }

    @Override
    protected void onResume() {
        super.onResume();
        miReyclerViewUser.getAdapter().notifyDataSetChanged();
    }
}