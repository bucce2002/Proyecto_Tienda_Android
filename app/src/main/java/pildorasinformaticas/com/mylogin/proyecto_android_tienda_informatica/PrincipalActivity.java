package pildorasinformaticas.com.mylogin.proyecto_android_tienda_informatica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.List;
import java.util.Objects;

import pildorasinformaticas.com.mylogin.proyecto_android_tienda_informatica.adaptador.AdaptadorProducto;
import pildorasinformaticas.com.mylogin.proyecto_android_tienda_informatica.entidades.Producto;
import pildorasinformaticas.com.mylogin.proyecto_android_tienda_informatica.modelo.ListaProductos;

public class PrincipalActivity extends AppCompatActivity {
    private RecyclerView miReyclerViewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        miReyclerViewUser = findViewById(R.id.recyclerV);
        miReyclerViewUser.setHasFixedSize(true);
        miReyclerViewUser.setLayoutManager(new LinearLayoutManager(this));

        ListaProductos.getInstance().inicializar();
        List<Producto> listaProducto = ListaProductos.getInstance().getListaProductos();
        AdaptadorProducto adaptadorProducto = new AdaptadorProducto(listaProducto);
        miReyclerViewUser.setAdapter(adaptadorProducto);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onResume() {
        super.onResume();
        Objects.requireNonNull(miReyclerViewUser.getAdapter()).notifyDataSetChanged();
    }
}