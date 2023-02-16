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
        assertEquals(3, list.getSize());
        assertEquals("A", list.getFirst().getValue().getName());
        assertEquals("C", list.getLast().getValue().getName());
    }
    
    @Test
    void removeElement() {
        StoreList list = new StoreList();
        list.append(new Store("A"));
        list.remove("A");
        assertEquals(0, list.getSize());
    }
}
