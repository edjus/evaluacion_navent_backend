package expections;

public class NoExistePedidoException extends Exception {

    public NoExistePedidoException() {
        super("No existe el id del producto");
    }
}
