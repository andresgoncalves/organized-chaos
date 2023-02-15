package organized.chaos;

/**
 *
 * @author Andres
 */
public class StoreGraph {
    private StoreList stores = new StoreList();
        
    public void addRoute(String a, String b, int distance) {
        Store storeA = stores.find(a);
        Store storeB = stores.find(b);
        if(storeA != null && storeB != null && storeA != storeB) {
            storeA.getRoutes().append(new Route(storeB, distance));
            storeB.getRoutes().append(new Route(storeA, distance));
        }
    }
        
    public void removeRoute(String a, String b) {
        Store storeA = stores.find(a);
        Store storeB = stores.find(b);
        if(storeA != null && storeB != null && storeA != storeB) {
            storeA.getRoutes().remove(b);
            storeB.getRoutes().remove(a);
        }
    }

    public StoreList getStores() {
        return stores;
    }
}
