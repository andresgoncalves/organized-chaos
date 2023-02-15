package organized.chaos;

import java.util.Objects;

/**
 *
 * @author Andres
 */
public class StoreList extends List<Store> {

    @Override
    protected boolean compareKey(Store a, Object b) {
        return Objects.equals(a.getName(), b);
    }
    
}
