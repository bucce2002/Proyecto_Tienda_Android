package pildorasinformaticas.com.mylogin.proyecto_android_tienda_informatica;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AyudaActivity extends AppCompatActivity {
    private TextView txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);
        txt1 = findViewById(R.id.textView3);
        txt2 = findViewById(R.id.textView4);
        txt3 = findViewById(R.id.textView5);
        txt4 = findViewById(R.id.textView7);
        txt5 = findViewById(R.id.textView8);
        txt6 = findViewById(R.id.textView11);
        txt7 = findViewById(R.id.textView12);
        txt8 = findViewById(R.id.textView13);

        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AyudaActivity.this);
                builder.setTitle("¿Que es shopinfo?");
                builder.setMessage("Shopinfo es una tienda de informatica exclusivamente online en donde podras comprar al mejor precios distintos articulos informaticos, ya sean computadoras, perifericos, sillas gamers y mas! Tambien ofrecemos los mejores y mas competitivos precios del mercado. ");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AyudaActivity.this);
                builder.setTitle("¿Tiempo para devolver un producto?");
                builder.setMessage("Tiene un lapso de tiempo de 15 dias habiles para devolver cualquier producto, necesitara decirnos el porque de su devolucion para mejorar a futuro.");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AyudaActivity.this);
                builder.setTitle("¿Los productos tienen garantia?");
                builder.setMessage("Todos nuestros productos tienen una garantia completa en caso de daño o hurto durante 5 meses.");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AyudaActivity.this);
                builder.setTitle("Metodos  de pago");
                builder.setMessage("Aceptamos tanto euros como dolares, y el pago puede hacerse por tarjetas de cualquier tipo, paypal y transferencia bancaria (El producto no sera enviado hasta confirmar la trasnferencia).");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        txt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AyudaActivity.this);
                builder.setTitle("Tiempos de entrega aproximados.");
                builder.setMessage("Perifericos y sillas tienen un tiempo aproximado de 3 dias habiles para llegar, mientras computadoras y laptop 5-7 dias aproximadamente.");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        txt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AyudaActivity.this);
                builder.setTitle("¿Que es shopinfo premium?");
                builder.setMessage("Esta es una version con supscripcion la cual tiene varios beneficios sobre la version regular.");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        txt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AyudaActivity.this);
                builder.setTitle("Ventajas de esta version.");
                builder.setMessage("Esta version tiene como principales beneficios el acortar los tiempos de entrega y que estas sean totalmente gratis.");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        txt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AyudaActivity.this);
                builder.setTitle("Suscripcion y precio.");
                builder.setMessage("La suscripcion tiene un costo de 1€ mensual o tambien esta la opcion anual con un coste de 10€.");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}