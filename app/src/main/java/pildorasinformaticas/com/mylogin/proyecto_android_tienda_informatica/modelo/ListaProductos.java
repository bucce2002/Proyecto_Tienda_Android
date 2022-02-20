package pildorasinformaticas.com.mylogin.proyecto_android_tienda_informatica.modelo;

import java.util.ArrayList;
import java.util.List;

import pildorasinformaticas.com.mylogin.proyecto_android_tienda_informatica.entidades.Producto;

public class ListaProductos {
    private static ListaProductos instance;
    private List<Producto> listaProductos;
    private int contador = 1;
    private ListaProductos(){
        super();
    }

    public static ListaProductos getInstance() {
        if(instance == null){
            instance = new ListaProductos();
        }
        return instance;
    }
    public void inicializar(){
        listaProductos = new ArrayList<>();
        Producto producto = new Producto();
        //producto.setId_producto(contador++);
        producto.setPrecio(10);
        producto.setMarca("nintendo");
        producto.setTipo("Mario");
        producto.setNombre("nintendo");
        producto.setInformacion("Mario");
        //producto.setImagen("nintendo");
        listaProductos.add(producto);

        producto = new Producto();
        //producto.setId_producto(contador++);
        producto.setPrecio(10);
        producto.setMarca("nintendo");
        producto.setTipo("Mario");
        producto.setNombre("nintendo");
        producto.setInformacion("Mario");
        //producto.setImagen("nintendo");
        listaProductos.add(producto);

        producto = new Producto();
        //producto.setId_producto(contador++);
        producto.setPrecio(10);
        producto.setMarca("nintendo");
        producto.setTipo("Mario");
        producto.setNombre("nintendo");
        producto.setInformacion("Mario");
        //producto.setImagen("nintendo");
        listaProductos.add(producto);

        producto = new Producto();
        //producto.setId_producto(contador++);
        producto.setPrecio(10);
        producto.setMarca("nintendo");
        producto.setTipo("Mario");
        producto.setNombre("nintendo");
        producto.setInformacion("Mario");
        //producto.setImagen("nintendo");
        listaProductos.add(producto);

        producto = new Producto();
        //producto.setId_producto(contador++);
        producto.setPrecio(10);
        producto.setMarca("nintendo");
        producto.setTipo("Mario");
        producto.setNombre("nintendo");
        producto.setInformacion("Mario");
        //producto.setImagen("nintendo");
        listaProductos.add(producto);
        System.out.println("#########################" + listaProductos);
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }
}
