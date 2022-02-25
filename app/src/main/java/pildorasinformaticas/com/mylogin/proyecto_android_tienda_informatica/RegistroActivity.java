package pildorasinformaticas.com.mylogin.proyecto_android_tienda_informatica;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegistroActivity extends AppCompatActivity {
    EditText nombres,clave,correo_elecronico;
    EditText direcciones;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Button b1 = findViewById(R.id.btnRegistro);
         nombres = findViewById(R.id.txtNombreRegistro);
         clave = findViewById(R.id.txtContrasenaRegistro);
        direcciones = findViewById(R.id.txtDireccionRegistro);
        correo_elecronico = findViewById(R.id.txtEmailRegistro);
        RelativeLayout relativeLayout = findViewById(R.id.mainLayout);




        //ANIMACION DEL FONDO
        AnimationDrawable animationDrawable =  (AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

        //BOTON REGISTRARME
        b1.setOnClickListener(v -> insertData());

    }

    private void insertData() {

        final String direccion = direcciones.getText().toString().trim();
        final String nombre = nombres.getText().toString().trim();
        final String email = correo_elecronico.getText().toString().trim();
        final String password = clave.getText().toString().trim();


        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("cargando...");

        if(nombre.isEmpty()){
            nombres.setError("complete los campos");
        }
        else if(email.isEmpty()){
            correo_elecronico.setError("complete los campos");
        }
        else if(direccion.isEmpty()){
            direcciones.setError("complete los campos");
        }
        else if(password.isEmpty()){
            clave.setError("complete los campos");
        }



        else{
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "http://10.34.82.230/tienda/ingresarUsuario.php",
                    response -> {

                        if(response.equalsIgnoreCase("Datos insertados")){

                            Toast.makeText(RegistroActivity.this, "Datos insertados", Toast.LENGTH_SHORT).show();

                            progressDialog.dismiss();


                        }
                        else{
                            Toast.makeText(RegistroActivity.this, response, Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                            abrirLogin();
                            Toast.makeText(RegistroActivity.this, "Datos insertados", Toast.LENGTH_SHORT).show();
                        }

                    }, error -> {
                        Toast.makeText(RegistroActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }

            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String> params = new HashMap<>();
                    params.put("nombre",nombre);
                    params.put("clave",password);
                    params.put("correo_electronico",email);
                    params.put("direccion",direccion);
                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(RegistroActivity.this);
            requestQueue.add(request);


        }

    }
    private void abrirLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        //overridePendingTransition(R.anim.in,R.anim.out);
    }
}