package organized.chaos;

/**
 *
 * @author Andres
 */
public class Stock {
    private String product;
    private int amount;

    public Stock(String product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
