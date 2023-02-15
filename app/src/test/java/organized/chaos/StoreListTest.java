package organized.chaos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Andres
 */
public class StoreListTest {
    @Test
    void appendElements() {
        StoreList list = new StoreList();
        list.append(new Store("A"));
        list.append(new Store("B"));
        list.append(new Store("C"));
        assertEquals(list.getSize(), 3);
        assertEquals(list.getFirst().getValue().getName(), "A");
        assertEquals(list.getLast().getValue().getName(), "C");
    }
    
    @Test
    void removeElement() {
        StoreList list = new StoreList();
        list.append(new Store("A"));
        list.remove("A");
        assertEquals(list.getSize(), 0);
    }
}
