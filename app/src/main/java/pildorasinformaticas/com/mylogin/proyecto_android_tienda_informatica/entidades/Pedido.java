package pildorasinformaticas.com.mylogin.proyecto_android_tienda_informatica.entidades;

import java.io.Serializable;

public class Pedido implements Serializable {
    private int id_pedido;
    private int id_producto;
    private int id_cliente;

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
}
