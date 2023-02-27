package organized.chaos;

/**
 * Grafo que representa un conjunto de almacenes y las rutas que los conectan
 * @author Andres, Diego, Michelle
 */
public class StoreGraph {

    private final StoreList stores = new StoreList();

    /**
     * Crea un nuevo almac�n en el grafo
     * @param name nombre del almac�n
     * @return El almac�n creado
     */
    public Store createStore(String name) {
        Store store = new Store(name);
        stores.append(store);
        return store;
    }
    
    /**
     * Elimina un almac�n del grafo
     * @param name nombre del almac�n
     * @return El almac�n eliminado
     */
    public Store removeStore(String name) {
        Store store = stores.remove(name);
        if (store != null) {
            for (ListNode<Store> node = stores.getFirst(); node != null; node = node.getNext()) {
                node.getValue().getRoutes().remove(name);
            }
        }
        return store;
    }

    /**
     * Retorna un almac�n seg�n su nombre
     * @param name nombre del almac�n
     * @return El almac�n encontrado, o {@code null} si no se encontr�
     */
    public Store getStore(String name) {
        return stores.find(name);
    }

    /**
     * Crea una nueva ruta entre dos almacenes
     * @param a nombre del almac�n de origen
     * @param b nombre del almac�n de destino
     * @param distance distancia entre los almacenes
     */
    public void createRoute(String a, String b, int distance) {
        Store storeA = stores.find(a);
        Store storeB = stores.find(b);
        if(storeA != null && storeB != null) {
            storeA.getRoutes().append(new Route(storeB, distance));
            storeB.getRoutes().append(new Route(storeA, -distance));
        }
    }

    /**
     * Elimina la ruta entre dos almacenes
     * @param a nombre del almac�n de origen
     * @param b nombre del almac�n de destinos
     */
    public void removeRoute(String a, String b) {
        Store storeA = stores.find(a);
        Store storeB = stores.find(b);
        if(storeA != null && storeB != null) {
            storeA.getRoutes().remove(b);
            storeB.getRoutes().remove(a);
        }
    }

    /**
     * Retorna la distancia entre dos almacenes
     * @param a nombre del almac�n de origen
     * @param b nombre del almac�n de destino
     * @return La distancia entre dos almacenes
     */
    public int getDistance(String a, String b) {
        Store storeA = stores.find(a);
        if (storeA != null) {
            Route route = storeA.getRoutes().find(b);
            if (route != null) {
                return route.getDistance();
            }
        }
        return 0;
    }

    /**
     * Actualiza la ruta entre dos almacenes
     * @param a nombre del almac�n de origen
     * @param b nombre del almac�n de destino
     * @param distance distancia entre los almacenes
     */
    public void setDistance(String a, String b, int distance) {
        Store storeA = stores.find(a);
        Store storeB = stores.find(b);
        if(storeA != null && storeB != null) {
            Route routeAB = storeA.getRoutes().find(b);
            Route routeBA = storeB.getRoutes().find(a);
            if (routeAB != null && routeBA != null) {
                routeAB.setDistance(distance);
                routeBA.setDistance(-distance);
            }
            else {
                storeA.getRoutes().append(new Route(storeB, distance));
                storeB.getRoutes().append(new Route(storeA, -distance));
            }
        }
    }

    /**
     * Retorna la lista de almacenes
     * @return Lista de almacenes
     */
    public StoreList getStores() {
        return stores;
    }

}
