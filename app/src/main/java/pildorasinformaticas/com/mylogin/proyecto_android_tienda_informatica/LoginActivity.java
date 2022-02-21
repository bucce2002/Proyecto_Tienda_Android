package pildorasinformaticas.com.mylogin.proyecto_android_tienda_informatica;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button b1 = findViewById(R.id.btnEntrar);
        Button b2 = findViewById(R.id.btnRegistro);
        RelativeLayout relativeLayout = findViewById(R.id.mainLayout);

        //ANIMACION DEL FONDO
        AnimationDrawable animationDrawable =  (AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

        //ABRIR PAGINA PRINCIPAL
        b1.setOnClickListener(v -> abrirPrincipal());

        //ABRIR REGISTRO
        b2.setOnClickListener(v -> abrirRegistro());
    }
    private void abrirRegistro() {
        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
        //overridePendingTransition(R.anim.in,R.anim.out);
    }
    private void abrirPrincipal() {
        Intent intent = new Intent(this, PrincipalActivity.class);
        startActivity(intent);
        //overridePendingTransition(R.anim.in,R.anim.out);
    }
}