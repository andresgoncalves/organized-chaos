package organized.chaos;

import java.util.Objects;

/**
 *
 * @author Andres
 */
public class StockList extends List<Stock> {

    @Override
    protected boolean nodeEquals(Stock a, Object b) {
        return Objects.equals(a.getProduct(), b);
    }
    
}
