package pildorasinformaticas.com.mylogin.proyecto_android_tienda_informatica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class PerfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        ImageView menu = findViewById(R.id.menuIc);
        ImageView logo = findViewById(R.id.logoIc);

        menu.setOnClickListener(v -> {
            PopupMenu popup = new PopupMenu(PerfilActivity.this, v);
            popup.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()){
                    case R.id.opcion1:
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

        logo.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),PrincipalActivity.class);
            startActivity(intent);
        });
    }
    public void irAyuda(){
        Intent intent = new Intent(getApplicationContext(),AyudaActivity.class);
        startActivity(intent);
    }

    public void salir(){
        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(intent);
    }
}