package pildorasinformaticas.com.mylogin.proyecto_android_tienda_informatica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import pildorasinformaticas.com.mylogin.proyecto_android_tienda_informatica.adaptador.AdaptadorImagenProducto;
import pildorasinformaticas.com.mylogin.proyecto_android_tienda_informatica.entidades.Producto;


public class PrincipalActivity extends AppCompatActivity implements AdaptadorImagenProducto.OnProductListener, Response.Listener<JSONObject>,Response.ErrorListener{
    private RecyclerView miReyclerViewUser;
    private JsonObjectRequest jsonObjectRequest;
    private RequestQueue request;
    ArrayList<Producto> listaProducto;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        ImageView menu = findViewById(R.id.menuIc);
        ImageView filtro = findViewById(R.id.filtroIc);
        miReyclerViewUser = findViewById(R.id.recyclerV);
        miReyclerViewUser.setHasFixedSize(true);
        miReyclerViewUser.setLayoutManager(new LinearLayoutManager(this));


        filtro.setOnClickListener(v -> {
            PopupMenu popup = new PopupMenu(PrincipalActivity.this, v);
            popup.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()){
                    case R.id.opcion1:
                        listaProducto.clear();
                        cargarWebServicePerifericos();
                        return true;
                    case R.id.opcion2:
                        listaProducto.clear();
                        cargarWebServiceOrdenador();
                        return true;
                    case R.id.opcion3:
                        listaProducto.clear();
                        cargarWebServiceTelefonos();
                        return true;
                    case R.id.opcion4:
                        listaProducto.clear();
                        cargarWebServicePrincipal();
                        return true;
                    default:
                        return false;
                }

            });
            MenuInflater inflater = popup.getMenuInflater();
            inflater.inflate(R.menu.menu_filtro, popup.getMenu());
            popup.show();
        });

        menu.setOnClickListener(v -> {
            PopupMenu popup = new PopupMenu(PrincipalActivity.this, v);
            popup.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()){
                    case R.id.opcion1:
                        irPerfil();
                        return true;
                    case R.id.opcion2:
                        irAyuda();
                        return true;
                    case R.id.opcion3:
                        salir();
                        return true;
                    default:
                        return false;
                }

            });
            MenuInflater inflater = popup.getMenuInflater();
            inflater.inflate(R.menu.menu_principal, popup.getMenu());
            popup.show();
        });

        listaProducto = new ArrayList<>();
        request= Volley.newRequestQueue(getBaseContext());
        cargarWebServicePrincipal();
    }

    private void cargarWebServicePrincipal() {
        String URL ="http://10.34.82.76/tienda/Recicler.php";
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,URL,null,this,this);
        request.add(jsonObjectRequest);
    }
    private void cargarWebServiceOrdenador() {
        String URL ="http://10.34.82.76/tienda/ReciclerOrdenador.php";
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,URL,null,this,this);
        request.add(jsonObjectRequest);

    }
    private void cargarWebServicePerifericos() {
        String URL ="http://10.34.82.76/tienda/ReciclerPerifericos.php";
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,URL,null,this,this);
        request.add(jsonObjectRequest);

    }
    private void cargarWebServiceTelefonos() {
        String URL ="http://10.34.82.76/tienda/ReciclerTelefono.php";
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,URL,null,this,this);
        request.add(jsonObjectRequest);

    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }
    @Override
    public void onResponse(JSONObject response) {
        Producto producto;
        JSONArray json = response.optJSONArray("productos");
        try {
            for (int i=0;i<json.length();i++){
                producto=new Producto();
                JSONObject jsonObject;
                jsonObject=json.getJSONObject(i);

                producto.setNombre(jsonObject.optString("nombre"));
                producto.setPrecio(jsonObject.optInt("precio"));
                producto.setMarca(jsonObject.optString("marca"));
                producto.setTipo(jsonObject.optString("tipo"));
                producto.setInformacion(jsonObject.optString("informacion"));
                producto.setDato(jsonObject.optString("imagen"));
                listaProducto.add(producto);
            }


            PrincipalActivity.this.onStart();

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(getBaseContext(), "No se ha podido establecer conexión con el servidor" +
                    " "+response, Toast.LENGTH_LONG).show();
        }
    }

    public void irAyuda(){
        Intent intent = new Intent(getApplicationContext(),AyudaActivity.class);
        startActivity(intent);
    }

    public void salir(){
        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(intent);
    }

    public void irPerfil(){
        Intent intent = new Intent(getApplicationContext(),PerfilActivity.class);
        startActivity(intent);
    }

    @Override
    public void onProductClick(int position) {
        Intent intent = new Intent(this, InfoProducto.class);
        //intent.putExtra("imagen",listaProducto.get(position).getImagen());
        intent.putExtra("nombre",listaProducto.get(position).getNombre());
        intent.putExtra("precio",listaProducto.get(position).getPrecio());
        startActivity(intent);
    }
    @Override
    protected void onStart() {
        AdaptadorImagenProducto adaptador = new AdaptadorImagenProducto(listaProducto, this);
        miReyclerViewUser.setAdapter(adaptador);
        super.onStart();
    }
}
