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

public class AdaptadorImagenProducto extends RecyclerView.Adapter<AdaptadorImagenProducto.ViewHolder>{
    private List<Producto> listaProductos;
    private OnProductListener mOnProductListener;



    public AdaptadorImagenProducto(List<Producto> listaProductos, OnProductListener onProductListener) {
        this.listaProductos = listaProductos;
        this.mOnProductListener = onProductListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView image, info, carritos;
        private TextView nombre, precio, marca, tipo, informacion;
        private OnProductListener onProductListener;


        public ViewHolder(View v, OnProductListener onProductListener) {
            super(v);
            this.onProductListener = onProductListener;
            image = v.findViewById(R.id.imagen);
            info = v.findViewById(R.id.info);
            carritos = v.findViewById(R.id.carrito);
            nombre=v.findViewById(R.id.txtNombre);
            precio=v.findViewById(R.id.txtPrecio);
            marca=v.findViewById(R.id.txtMarca);
            tipo=v.findViewById(R.id.txtTipo);
            informacion=v.findViewById(R.id.txtInformacion);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onProductListener.onProductClick(getAdapterPosition());
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.principal, parent, false);
        RecyclerView.LayoutParams layoutParams=new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(layoutParams);
        return new ViewHolder(v,mOnProductListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nombre.setText(listaProductos.get(position).getNombre());
        String Precio = String.valueOf(listaProductos.get(position).getPrecio());
        holder.precio.setText("Precio: " + Precio);

        holder.marca.setText("Marca: " + listaProductos.get(position).getMarca());
        holder.tipo.setText("Tipo: " + listaProductos.get(position).getTipo());
        holder.informacion.setText("Caracteristicas: " + listaProductos.get(position).getInformacion());

        if(listaProductos.get(position).getImagen()!=null){
            holder.image.setImageBitmap(listaProductos.get(position).getImagen());
        }else{
            holder.image.setImageResource(R.drawable.feaf);
        }
    }
    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public interface OnProductListener{
        void onProductClick(int position);
    }
}