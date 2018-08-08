package modelo;

/* @class: Pedido
*  Modela un pedido de acuerdo a las necesidades del negocio
*/
public class Pedido {

    private long id;
    private String nombre;
    private int monto;
    private int descuento;

    public Pedido(String nombre, int monto, int descuento) {
        this.nombre = nombre;
        this.monto = monto;
        this.descuento = descuento;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMonto() {
        return monto;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
}
