package pildorasinformaticas.com.mylogin.proyecto_android_tienda_informatica.adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import pildorasinformaticas.com.mylogin.proyecto_android_tienda_informatica.R;
import pildorasinformaticas.com.mylogin.proyecto_android_tienda_informatica.entidades.Producto;

public class AdaptadorProducto extends RecyclerView.Adapter<AdaptadorProducto.ViewHolder>{
    private List<Producto> listaProductos;



    public AdaptadorProducto(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image, informacion, carritos;
        private TextView nombre, precio, marca, tipo, caracteristicas;

        public ViewHolder(View v) {
            super(v);
            image = v.findViewById(R.id.imagen);
            informacion = v.findViewById(R.id.info);
            carritos = v.findViewById(R.id.carrito);
            nombre=v.findViewById(R.id.txtNombre);
            precio=v.findViewById(R.id.txtPrecio);
            marca=v.findViewById(R.id.txtMarca);
            tipo=v.findViewById(R.id.txtTipo);
            caracteristicas=v.findViewById(R.id.txtInformacion);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.principal, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nombre.setText("Nombre: " + listaProductos.get(position).getNombre());
        String Precio = String.valueOf(listaProductos.get(position).getPrecio());
        holder.precio.setText("Precio: " + Precio);
        holder.marca.setText("Marca: " + listaProductos.get(position).getMarca());
        holder.tipo.setText("Tipo: " + listaProductos.get(position).getTipo());
        holder.caracteristicas.setText("Caracteristicas: " + listaProductos.get(position).getInformacion());

        ////holder.informacion.setOnClickListener(view -> {
           // Toast.makeText(holder.id.getContext(), "Personaje editado", Toast.LENGTH_SHORT).show();
        //});

       // holder.carritos.setOnClickListener(view -> {
        //    Toast.makeText(holder.id.getContext(), "Personaje eliminado ", Toast.LENGTH_SHORT).show();
          //  PersonajeSingleton.getInstance().borrar(listaPersonajes.get(position));
          //  notifyDataSetChanged();
        //});
    }

    public int getItemCount() {
        return listaProductos.size();
    }
}