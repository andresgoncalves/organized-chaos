package organized.chaos;

import java.util.Objects;

/**
 * Lista Enlazada de tipo ruta
 * @author Andres
 */
public class RouteList extends List<Route> {
    
    /**
     * Compara el nombre del destino de una ruta con un objeto
     * @param a ruta
     * @param b nombre a comparar
     * @return {@code true} si el nombre coincide, si no {@code false}
     * @see find
     * @see remove
     */
    @Override
    protected boolean compareKey(Route a, Object b) {
        return Objects.equals(a.getStore().getName(), b);
    }    
}
