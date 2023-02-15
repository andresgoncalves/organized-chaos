package organized.chaos;

/**
 *
 * @author Andres
 */
public class Store {
    private String name;
    private StockList stock = new StockList();
    private RouteList routes = new RouteList();

    public Store(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StockList getStock() {
        return stock;
    }  

    public RouteList getRoutes() {
        return routes;
    }   
}
