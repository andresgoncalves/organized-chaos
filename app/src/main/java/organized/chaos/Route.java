package organized.chaos;

/**
 *
 * @author Andres
 */
public class Route {
    private Store storeA, storeB;
    private int distance;

    public Route(Store storeA, Store storeB) {
        this.storeA = storeA;
        this.storeB = storeB;
        this.distance = -1;
    }

    public Route(Store storeA, Store storeB, int distance) {
        this.storeA = storeA;
        this.storeB = storeB;
        this.distance = distance;
    }

    public Store getStoreA() {
        return storeA;
    }

    public void setStoreA(Store storeA) {
        this.storeA = storeA;
    }

    public Store getStoreB() {
        return storeB;
    }

    public void setStoreB(Store storeB) {
        this.storeB = storeB;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }  
}
