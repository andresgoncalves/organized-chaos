package organized.chaos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Andres
 */
public class RouteListTest {
    @Test
    void appendElements() {
        RouteList list = new RouteList();
        list.append(new Route(new Store("A"), 1));
        list.append(new Route(new Store("B"), 1));
        list.append(new Route(new Store("C"), 1));
        assertEquals(3, list.getSize());
        assertEquals("A", list.getFirst().getValue().getStore().getName());
        assertEquals("C", list.getLast().getValue().getStore().getName());
    }
    
    @Test
    void removeElement() {
        RouteList list = new RouteList();
        list.append(new Route(new Store("A"), 1));
        list.remove("A");
        assertEquals(0, list.getSize());
    }
}
