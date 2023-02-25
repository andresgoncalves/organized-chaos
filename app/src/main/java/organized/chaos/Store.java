package organized.chaos;

/**
 * Clase Almac�n
 * @author Andres
 */
public class Store {
    private String name;
    private final StockList stock = new StockList();
    private final RouteList routes = new RouteList();

    /**
     * Crea un almac�n
     * @param name nombre del almac�n
     */
    public Store(String name) {
        this.name = name;
    }

    /**
     * Retorna el nombre del almac�n
     * @return Nombre del almac�n
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del almac�n
     * @param name nombre
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna la lista de inventario del almac�n
     * @return Lista de inventario
     */
    public StockList getStock() {
        return stock;
    }  

    /**
     * Retorna la lista de rutas del almac�n
     * @return Lista de rutas
     */
    public RouteList getRoutes() {
        return routes;
    }   
}
