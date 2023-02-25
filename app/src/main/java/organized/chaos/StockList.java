package organized.chaos;

import java.util.Objects;

/**
 * Lista Enlazada de tipo inventario
 * @author Andres
 */
public class StockList extends List<Stock> {
    
    /**
     * Compara el nombre de un producto con un objeto
     * @param a producto
     * @param b nombre a comparar
     * @return {@code true} si el nombre coincide, si no {@code false}
     * @see find
     * @see remove
     */
    @Override
    protected boolean compareKey(Stock a, Object b) {
        return Objects.equals(a.getProduct(), b);
    }
}
