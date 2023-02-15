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
        list.append(new Route(new Store("A"), new Store("B"), 1));
        list.append(new Route(new Store("B"), new Store("C"), 1));
        list.append(new Route(new Store("A"), new Store("C"), 1));
        assertEquals(list.getSize(), 3);
        assertEquals(list.getFirst().getValue().getStoreA().getName(), "A");
        assertEquals(list.getLast().getValue().getStoreA().getName(), "A");
    }
    
    @Test
    void removeElement() {
        RouteList list = new RouteList();
        list.append(new Route(new Store("A"), new Store("B"), 1));
        list.append(new Route(new Store("A"), new Store("C"), 1));
        list.remove(new Route(new Store("A"), new Store("B")));
        assertEquals(list.getSize(), 1);
        list.remove(new Route(new Store("C"), new Store("A")));
        assertEquals(list.getSize(), 0);
    }
}
