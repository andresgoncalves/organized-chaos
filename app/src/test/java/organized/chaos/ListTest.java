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
        assertEquals(list.getSize(), 3);
        assertEquals(list.getFirst().getValue(), 1);
        assertEquals(list.getLast().getValue(), 3);
    }
    
    @Test
    void removeFirstElement() {
        List<Integer> list = new List<Integer>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.remove(1);
        assertEquals(list.getSize(), 2);
        assertEquals(list.getFirst().getValue(), 2);
        assertEquals(list.getLast().getValue(), 3);
    }
    
    @Test
    void removeMiddleElement() {
        List<Integer> list = new List<Integer>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.remove(2);
        assertEquals(list.getSize(), 2);
        assertEquals(list.getFirst().getValue(), 1);
        assertEquals(list.getLast().getValue(), 3);
    }
    
    @Test
    void removeLastElement() {
        List<Integer> list = new List<Integer>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.remove(3);
        assertEquals(list.getSize(), 2);
        assertEquals(list.getFirst().getValue(), 1);
        assertEquals(list.getLast().getValue(), 2);
    }
    
    @Test
    void removeOnlyElement() {
        List<Integer> list = new List<Integer>();
        list.append(1);
        list.remove(1);
        assertEquals(list.getSize(), 0);
        assertNull(list.getFirst());
        assertNull(list.getLast());
    }
}
