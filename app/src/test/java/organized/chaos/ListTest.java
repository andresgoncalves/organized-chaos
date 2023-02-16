package organized.chaos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Andres
 */
public class ListTest {
    @Test
    void appendElements() {
        List<Integer> list = new List<Integer>();
        list.append(1);
        list.append(2);
        list.append(3);
        assertEquals(3, list.getSize());
        assertEquals(1, list.getFirst().getValue());
        assertEquals(3, list.getLast().getValue());
    }
    
    @Test
    void removeFirstElement() {
        List<Integer> list = new List<Integer>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.remove(1);
        assertEquals(2, list.getSize());
        assertEquals(2, list.getFirst().getValue());
        assertEquals(3, list.getLast().getValue());
    }
    
    @Test
    void removeMiddleElement() {
        List<Integer> list = new List<Integer>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.remove(2);
        assertEquals(2, list.getSize());
        assertEquals(1, list.getFirst().getValue());
        assertEquals(3, list.getLast().getValue());
    }
    
    @Test
    void removeLastElement() {
        List<Integer> list = new List<Integer>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.remove(3);
        assertEquals(2, list.getSize());
        assertEquals(1, list.getFirst().getValue());
        assertEquals(2, list.getLast().getValue());
    }
    
    @Test
    void removeOnlyElement() {
        List<Integer> list = new List<Integer>();
        list.append(1);
        list.remove(1);
        assertEquals(0, list.getSize());
        assertNull(list.getFirst());
        assertNull(list.getLast());
    }
}
