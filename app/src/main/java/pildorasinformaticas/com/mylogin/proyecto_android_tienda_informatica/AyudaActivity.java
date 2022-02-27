package pildorasinformaticas.com.mylogin.proyecto_android_tienda_informatica;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class AyudaActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);
        ImageView menu = findViewById(R.id.menuIc);
        ImageView filtro = findViewById(R.id.filtroIc);
        ImageView logo = findViewById(R.id.logoIc);
        TextView txt1 = findViewById(R.id.textView3);
        TextView txt2 = findViewById(R.id.textView4);
        TextView txt3 = findViewById(R.id.textView5);
        TextView txt4 = findViewById(R.id.textView7);
        TextView txt5 = findViewById(R.id.textView8);
        TextView txt6 = findViewById(R.id.textView11);
        TextView txt7 = findViewById(R.id.textView12);
        TextView txt8 = findViewById(R.id.textView13);

        logo.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),PrincipalActivity.class);
            startActivity(intent);
        });

        filtro.setOnClickListener(v -> {
            PopupMenu popup = new PopupMenu(AyudaActivity.this, v);
            popup.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()){
                    case R.id.opcion1:
                        Toast.makeText(AyudaActivity.this, "Opcion 1", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.opcion2:
                        return true;
                    case R.id.opcion3:
                        Toast.makeText(AyudaActivity.this, "Opcion 2", Toast.LENGTH_SHORT).show();
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
            PopupMenu popup = new PopupMenu(AyudaActivity.this, v);
            popup.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()){
                    case R.id.opcion1:
                        irPerfil();
                        return true;
                    case R.id.opcion2:
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

        txt1.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(AyudaActivity.this);
            builder.setTitle("¿Que es shopinfo?");
            builder.setMessage("Shopinfo es una tienda de informatica exclusivamente online en donde podras comprar al mejor precios distintos articulos informaticos, ya sean computadoras, perifericos, sillas gamers y mas! Tambien ofrecemos los mejores y mas competitivos precios del mercado. ");
            AlertDialog dialog = builder.create();
            dialog.show();
        });

        txt2.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(AyudaActivity.this);
            builder.setTitle("¿Tiempo para devolver un producto?");
            builder.setMessage("Tiene un lapso de tiempo de 15 dias habiles para devolver cualquier producto, necesitara decirnos el porque de su devolucion para mejorar a futuro.");
            AlertDialog dialog = builder.create();
            dialog.show();
        });

        txt3.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(AyudaActivity.this);
            builder.setTitle("¿Los productos tienen garantia?");
            builder.setMessage("Todos nuestros productos tienen una garantia completa en caso de daño o hurto durante 5 meses.");
            AlertDialog dialog = builder.create();
            dialog.show();
        });

        txt4.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(AyudaActivity.this);
            builder.setTitle("Metodos  de pago");
            builder.setMessage("Aceptamos tanto euros como dolares, y el pago puede hacerse por tarjetas de cualquier tipo, paypal y transferencia bancaria (El producto no sera enviado hasta confirmar la trasnferencia).");
            AlertDialog dialog = builder.create();
            dialog.show();
        });

        txt5.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(AyudaActivity.this);
            builder.setTitle("Tiempos de entrega aproximados.");
            builder.setMessage("Perifericos y sillas tienen un tiempo aproximado de 3 dias habiles para llegar, mientras computadoras y laptop 5-7 dias aproximadamente.");
            AlertDialog dialog = builder.create();
            dialog.show();
        });

        txt6.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(AyudaActivity.this);
            builder.setTitle("¿Que es shopinfo premium?");
            builder.setMessage("Esta es una version con supscripcion la cual tiene varios beneficios sobre la version regular.");
            AlertDialog dialog = builder.create();
            dialog.show();
        });

        txt7.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(AyudaActivity.this);
            builder.setTitle("Ventajas de esta version.");
            builder.setMessage("Esta version tiene como principales beneficios el acortar los tiempos de entrega y que estas sean totalmente gratis.");
            AlertDialog dialog = builder.create();
            dialog.show();
        });

        txt8.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(AyudaActivity.this);
            builder.setTitle("Suscripcion y precio.");
            builder.setMessage("La suscripcion tiene un costo de 1€ mensual o tambien esta la opcion anual con un coste de 10€.");
            AlertDialog dialog = builder.create();
            dialog.show();
        });
    }

    public void salir(){
        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(intent);
    }

    public void irPerfil(){
        Intent intent = new Intent(getApplicationContext(),PerfilActivity.class);
        startActivity(intent);
    }
}