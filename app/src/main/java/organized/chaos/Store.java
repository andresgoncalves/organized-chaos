package organized.chaos;

/**
 * Clase Almacén
 * @author Andres
 */
public class Store {
    private String name;
    private final StockList stock = new StockList();
    private final RouteList routes = new RouteList();

    /**
     * Crea un almacén
     * @param name nombre del almacén
     */
    public Store(String name) {
        this.name = name;
    }

    /**
     * Retorna el nombre del almacén
     * @return Nombre del almacén
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del almacén
     * @param name nombre
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna la lista de inventario del almacén
     * @return Lista de inventario
     */
    public StockList getStock() {
        return stock;
    }  

    /**
     * Retorna la lista de rutas del almacén
     * @return Lista de rutas
     */
    public RouteList getRoutes() {
        return routes;
    }   
}
