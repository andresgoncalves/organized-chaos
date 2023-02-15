package organized.chaos;

/**
 *
 * @author Andres
 */
public class Route {
    private Store store;
    private int distance;

    public Route(Store store, Store storeB) {
        this.store = store;
        this.distance = -1;
    }

    public Route(Store store, int distance) {
        this.store = store;
        this.distance = distance;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }  
}
