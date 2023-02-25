package organized.chaos;

/**
 * Clase Inventario
 * @author Andres
 */
public class Stock {
    private String product;
    private int amount;

    /**
     * Crea un inventario
     * @param product nombre del producto
     * @param amount cantidad de productos
     */
    public Stock(String product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    /**
     * Retorna el nombre del producto
     * @return Nombre del producto
     */
    public String getProduct() {
        return product;
    }

    /**
     * Establece el nombre del producto
     * @param product nombre del producto
     */
    public void setProduct(String product) {
        this.product = product;
    }

    /**
     * Retorna la cantidad de productos
     * @return Cantidad de productos
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Establece la cantidad de productos
     * @param amount cantidad de productos
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
