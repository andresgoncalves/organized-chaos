package organized.chaos;

/**
 *
 * @author Andres
 */
public class Store {
    private String name;
    private final StockList stock = new StockList();
    private final RouteList routes = new RouteList();

    public Store(String name) {
        this.name = name;
    }
    
    public Store(String name, Route[] routes) {
        this.name = name;
        for(Route route : routes) {
            this.routes.append(route);
        }
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
