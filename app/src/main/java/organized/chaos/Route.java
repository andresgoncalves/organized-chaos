package organized.chaos;

/**
 * Clase Ruta
 * @author Andres
 */
public class Route {
    private Store store;
    private int distance;

    /**
     * Crea una ruta
     * @param store almac�n de destino
     * @param distance distancia (una distancia negativa indica que la ruta es en sentido opuesto)
     */
    public Route(Store store, int distance) {
        this.store = store;
        this.distance = distance;
    }

    /**
     * Retorna el almac�n de destino de la ruta
     * @return almac�n de destino
     */
    public Store getStore() {
        return store;
    }
    
    /**
     * Establece el almac�n de destino de la ruta
     * @param store almac�n de destino
     */
    public void setStore(Store store) {
        this.store = store;
    }    
    
    /**
     * Retorna la distancia de la ruta
     * @return distancia (una distancia negativa indica que la ruta es en sentido opuesto)
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Establece la distancia de la ruta
     * @param distance distancia (una distancia negativa indica que la ruta es en sentido opuesto)
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }  
    
    /**
     * Indica si la ruta est� en sentido opuesto
     * @return {@code true} si la distancia es negativa, si no {@code false}
     */
    public boolean isBackwards() {
        return distance < 0;
    }
}
