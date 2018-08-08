import DAO.PedidosDAO;
import expections.NoExistePedidoException;
import modelo.Pedido;

/*@class: PedidoManager
* Clase que genera una capa de abstración adidicional permitiendo las operaciones
* CRUD de los pedidos.
* */
public class PedidoManager {

    //Crea un pedido y lo guarda en la base de datos y cache
    public void crearPedido(String nombre, int monto, int descuento){
        Pedido newPedido = new Pedido(nombre, monto, descuento);
        PedidosDAO.insertOrUpdate(newPedido);
        BumexMemcached.getInstance().set(String.valueOf(newPedido.getId()), newPedido);
    }

    //Modifica un pedido y actualiza el mismo en la base de datos y cache
    public void modificarPedido(Pedido curPedido){
        PedidosDAO.insertOrUpdate(curPedido);
        BumexMemcached.getInstance().set(String.valueOf(curPedido.getId()), curPedido);
    }

    //Busca un pedido por id, devuelve el pedido si existe null de lo contrario.
    public Pedido buscarPedido(long idPedido){
        Pedido pedido;
        pedido = (Pedido)BumexMemcached.getInstance().get(String.valueOf(idPedido));

        if (pedido == null){
            pedido = PedidosDAO.select(idPedido);
            if (pedido == null)
                return null;
            //actualizo la cache
            BumexMemcached.getInstance().set(String.valueOf(idPedido), pedido);
        }
        return  pedido;
    }

    //Borra un pedido de la base de datos y cache, si el pedido existe sino lanza una expeción
    public void borrarPedido(long idPedido) throws NoExistePedidoException {
        if ( this.buscarPedido(idPedido) == null){
            throw new NoExistePedidoException();
        }

        BumexMemcached.getInstance().delete(String.valueOf(idPedido));
        PedidosDAO.delete(idPedido);
    }

}
