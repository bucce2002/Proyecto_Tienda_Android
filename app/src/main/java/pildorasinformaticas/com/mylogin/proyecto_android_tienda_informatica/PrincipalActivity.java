package pildorasinformaticas.com.mylogin.proyecto_android_tienda_informatica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
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
import java.util.Objects;

import pildorasinformaticas.com.mylogin.proyecto_android_tienda_informatica.adaptador.AdaptadorImagenProducto;
import pildorasinformaticas.com.mylogin.proyecto_android_tienda_informatica.entidades.Producto;


public class PrincipalActivity extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener {
    private RecyclerView miReyclerViewUser;
    private JsonObjectRequest jsonObjectRequest;
    private RequestQueue request;
    ArrayList<Producto> listaProducto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        miReyclerViewUser = findViewById(R.id.recyclerV);
        miReyclerViewUser.setHasFixedSize(true);
        miReyclerViewUser.setLayoutManager(new LinearLayoutManager(this));

        listaProducto = new ArrayList<>();
        request= Volley.newRequestQueue(getBaseContext());
        cargarWebService();
    }

    private void cargarWebService() {
        String URL ="http://10.34.81.17/tienda/Recicler.php";
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,URL,null,this,this);
        request.add(jsonObjectRequest);

    }


    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {
        Producto producto = null;
        JSONArray json = response.optJSONArray("productos");
        try {
            for (int i=0;i<json.length();i++){
                producto=new Producto();
                JSONObject jsonObject=null;
                jsonObject=json.getJSONObject(i);

                producto.setNombre(jsonObject.optString("nombre"));
                producto.setPrecio(jsonObject.optInt("precio"));
                producto.setMarca(jsonObject.optString("marca"));
                producto.setTipo(jsonObject.optString("tipo"));
                producto.setInformacion(jsonObject.optString("informacion"));
                producto.setDato(jsonObject.optString("imagen"));
                listaProducto.add(producto);
            }

            AdaptadorImagenProducto adaptador = new AdaptadorImagenProducto(listaProducto);
            miReyclerViewUser.setAdapter(adaptador);


        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(getBaseContext(), "No se ha podido establecer conexión con el servidor" +
                    " "+response, Toast.LENGTH_LONG).show();
        }
    }
}
