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
        assertEquals(list.getSize(), 3);
        assertEquals(list.getFirst().getValue().getStore().getName(), "A");
        assertEquals(list.getLast().getValue().getStore().getName(), "C");
    }
    
    @Test
    void removeElement() {
        RouteList list = new RouteList();
        list.append(new Route(new Store("A"), 1));
        list.remove("A");
        assertEquals(list.getSize(), 0);
    }
}
