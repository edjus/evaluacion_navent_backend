package DAO;

import modelo.Pedido;

/* @class: PedidosDAO
* Clase que abstrae el acceso a la base de datos usando el patrón
* DAO (Data Access Object).
*  Obsv: no se pide crear la lógica para esta clase.
* */
public class PedidosDAO {

    //Inserta o modifica un nuevo pedido en la base de datos
    public static void insertOrUpdate(Pedido pedido){
    }

    //Eliminar el pedido de la base de datos
    public static void delete(long idPedido){

    }

    //Busca un pedido en la base de datos devuelve un Pedido
    //null si no existe.
    public static Pedido select(long idPedido){
        return null;
    }
}
