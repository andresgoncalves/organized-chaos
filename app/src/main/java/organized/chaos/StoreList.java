package organized.chaos;

import java.util.Objects;

/**
 * Lista Enlazada de tipo almacén
 * @author Andres
 */
public class StoreList extends List<Store> {
    
    /**
     * Compara el nombre de un almacén con un objeto
     * @param a almacén
     * @param b nombre a comparar
     * @return {@code true} si el nombre coincide, si no {@code false}
     * @see find
     * @see remove
     */
    @Override
    protected boolean compareKey(Store a, Object b) {
        return Objects.equals(a.getName(), b);
    }   
}
