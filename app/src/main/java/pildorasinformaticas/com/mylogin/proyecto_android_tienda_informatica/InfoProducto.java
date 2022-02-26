package pildorasinformaticas.com.mylogin.proyecto_android_tienda_informatica;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class InfoProducto extends AppCompatActivity {

    public InfoProducto() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_producto);
        RelativeLayout relativeLayout = findViewById(R.id.productLayout);
        ImageView fotoProd = findViewById(R.id.fotoProd);
        TextView nombreProd = findViewById(R.id.nombreProd);
        TextView precioProd = findViewById(R.id.precioProd);


        //fotoProd.setImageBitmap((Bitmap) getIntent().getExtras().get("imagen"));
        nombreProd.setText(getIntent().getExtras().getString("nombre"));
        precioProd.setText(String.valueOf(getIntent().getExtras().getInt("precio")));

        //ANIMACION DEL FONDO
        AnimationDrawable animationDrawable =  (AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();


    }
}