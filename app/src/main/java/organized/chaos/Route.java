package organized.chaos;

/**
 *
 * @author Andres
 */
public class Route {
    private final Store store;
    private int distance;

    public Route(Store store, int distance) {
        this.store = store;
        this.distance = distance;
    }

    public Store getStore() {
        return store;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }  
}
