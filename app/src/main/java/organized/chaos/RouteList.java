package organized.chaos;

import java.util.Objects;

/**
 * Lista Enlazada de tipo ruta
 * @author Andres
 */
public class RouteList extends List<Route> {
    
    /**
     * Retorna un arreglo con la cantidad de rutas de entrada y la cantidad de rutas de salida del nodo
     * @return Un arreglo donde el primer elemento es la cantidad de rutas de entrada, y el segundo la cantidad de rutas de salida
     */
    public int[] getDirectedCount() {
        int[] count = new int[]{0,0};
        for(ListNode<Route> node = getFirst(); node != null; node = node.getNext()) {
            if(node.getValue().isBackwards()) {
                count[1]++;
            }
            else {
                count[0]++;
            }
        }
        return count;
    }
    
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
