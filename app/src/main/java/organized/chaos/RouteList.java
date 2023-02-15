package organized.chaos;

import java.util.Objects;

/**
 *
 * @author Andres
 */
public class RouteList extends List<Route> {

    @Override
    protected boolean compareKey(Route a, Object b) {
        if(a == b) return true;
        if(b instanceof Route) {
            return (
                Objects.equals(a.getStoreA().getName(), ((Route) b).getStoreA().getName()) &&
                Objects.equals(a.getStoreB().getName(), ((Route) b).getStoreB().getName())
            ) || (
                Objects.equals(a.getStoreA().getName(), ((Route) b).getStoreB().getName()) &&
                Objects.equals(a.getStoreB().getName(), ((Route) b).getStoreA().getName())
            );
        }
        return false;
    }
    
   
    
}
