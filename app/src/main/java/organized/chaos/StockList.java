package organized.chaos;

import java.util.Objects;

/**
 *
 * @author Andres
 */
public class StockList extends List<Stock> {
    @Override
    protected boolean compareKey(Stock a, Object b) {
        return Objects.equals(a.getProduct(), b);
    }
}
