package organized.chaos;

/**
 *
 * @author Andres
 */
public class StoreGraph {
    private final StoreList stores = new StoreList();
    
    public Store createStore(String name) {
        Store store = new Store(name);
        stores.append(store);
        return store;
    }
    
    public Store createStore(String name, Route[] routes) {
        Store store = new Store(name);
        for(Route route : routes) {
            store.getRoutes().append(route);
            route.getStore().getRoutes().append(new Route(store, route.getDistance()));
        }
        stores.append(store);
        return store;
    }
    
    public Store removeStore(String name) {
        Store store = stores.remove(name);
        if(store != null) {
            for(ListNode<Store> node = stores.getFirst(); node != null; node = node.getNext()) {
                node.getValue().getRoutes().remove(name);
            }
        }
        return store;
    }
    
    public Store getStore(String name) {
        return stores.find(name);
    }
        
    public void createRoute(String a, String b, int distance) {
        Store storeA = stores.find(a);
        Store storeB = stores.find(b);
        if(storeA != null && storeB != null) {
            storeA.getRoutes().append(new Route(storeB, distance));
            storeB.getRoutes().append(new Route(storeA, -distance));
        }
    }
        
    public void removeRoute(String a, String b) {
        Store storeA = stores.find(a);
        Store storeB = stores.find(b);
        if(storeA != null && storeB != null) {
            storeA.getRoutes().remove(b);
            storeB.getRoutes().remove(a);
        }
    }
    
    public int getDistance(String a, String b) {
        Store storeA = stores.find(a);
        if(storeA != null) {
            Route route = storeA.getRoutes().find(b);
            if(route != null) {
                return route.getDistance();
            }
        }
        return 0;
    }
    
    public void setDistance(String a, String b, int distance) {
        Store storeA = stores.find(a);
        Store storeB = stores.find(b);
        if(storeA != null && storeB != null) {
            Route routeAB = storeA.getRoutes().find(b);
            Route routeBA = storeB.getRoutes().find(a);
            if(routeAB != null && routeBA != null) {
                routeAB.setDistance(distance);
                routeBA.setDistance(-distance);
            }
        }
    }

    public StoreList getStores() {
        return stores;
    }
}
