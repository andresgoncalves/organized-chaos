package organized.chaos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Andres
 */
public class StockListTest {
    @Test
    void appendElements() {
        StockList list = new StockList();
        list.append(new Stock("A", 1));
        list.append(new Stock("B", 1));
        list.append(new Stock("C", 1));
        assertEquals(3, list.getSize());
        assertEquals("A", list.getFirst().getValue().getProduct());
        assertEquals("C", list.getLast().getValue().getProduct());
    }
    
    @Test
    void removeElement() {
        StockList list = new StockList();
        list.append(new Stock("A", 1));
        list.remove("A");
        assertEquals(0, list.getSize());
    }
}
