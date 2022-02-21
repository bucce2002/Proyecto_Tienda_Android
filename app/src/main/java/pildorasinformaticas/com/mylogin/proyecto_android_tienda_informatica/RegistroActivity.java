package pildorasinformaticas.com.mylogin.proyecto_android_tienda_informatica;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;

public class RegistroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Button b1 = findViewById(R.id.btnRegistro);
        RelativeLayout relativeLayout = findViewById(R.id.mainLayout);

        //ANIMACION DEL FONDO
        AnimationDrawable animationDrawable =  (AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

        //BOTON REGISTRARME
        b1.setOnClickListener(v -> abrirLogin());
    }
    private void abrirLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        //overridePendingTransition(R.anim.in,R.anim.out);
    }
}