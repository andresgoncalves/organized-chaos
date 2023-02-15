package organized.chaos;

import java.util.Objects;

/**
 *
 * @author Andres
 */
public class RouteList extends List<Route> {

    @Override
    protected boolean compareKey(Route a, Object b) {
        return Objects.equals(a.getStore().getName(), b);
    }    
}
