
/*@class: BumexMemcached
* Permite el acceso a los datos que están en la cache.
* Obsv: No se pide implementar
* */

public class BumexMemcached {

    private static BumexMemcached instance;

    private BumexMemcached() {

    }

    public static BumexMemcached getInstance(){
        if (instance == null){
            instance = new BumexMemcached();
        }
        return instance;
    }

    public void set(String key, Object value) {

    }

    public Object get(String key) {

        return null;
    }

    public void delete(String key) {

    }
}
