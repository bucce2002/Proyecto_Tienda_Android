package pildorasinformaticas.com.mylogin.proyecto_android_tienda_informatica;

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

public class LoginActivity extends AppCompatActivity {
    EditText clave,correo;
    String clave2,correo2;
    Button backdoor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button b1 = findViewById(R.id.btnEntrar);
        Button b2 = findViewById(R.id.btnRegistro);
        RelativeLayout relativeLayout = findViewById(R.id.mainLayout);
        backdoor=findViewById(R.id.backdoor);
        backdoor.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),PrincipalActivity.class);
            startActivity(intent);
        });
        clave = findViewById(R.id.txtContrasenaLogin);
        correo = findViewById(R.id.txtEmailLogin);



        //ANIMACION DEL FONDO
        AnimationDrawable animationDrawable =  (AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

   b1.setOnClickListener(v -> {
       clave2=clave.getText().toString();
       correo2=correo.getText().toString();
       if (!clave2.isEmpty() && !correo2.isEmpty()){
       validarUsuario("http://10.34.83.240/tienda/validarUsuario.php");
   }else{
           Toast.makeText(LoginActivity.this,"Rellena ambos campos",Toast.LENGTH_LONG);
       }});
        //ABRIR REGISTRO
        b2.setOnClickListener(v -> abrirRegistro());
    }
    private void abrirRegistro() {
        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
        //overridePendingTransition(R.anim.in,R.anim.out);
    }

    private void validarUsuario(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, response -> {

            if (response.equals("200")){
                Intent intent = new Intent(getApplicationContext(),PrincipalActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(LoginActivity.this, "Email or Password Invalid", Toast.LENGTH_LONG).show();
            }

        }, error -> Toast.makeText(LoginActivity.this, error.toString(), Toast.LENGTH_LONG).show()){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<>();
                parametros.put("correo_electronico", correo.getText().toString());
                parametros.put("clave", clave.getText().toString());
                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}
