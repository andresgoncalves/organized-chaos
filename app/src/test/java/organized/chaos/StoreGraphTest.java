package organized.chaos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Andres
 */
public class StoreGraphTest {
    @Test
    void connectStores() {
        StoreGraph graph = new StoreGraph();
        graph.getStores().append(new Store("A"));
        graph.getStores().append(new Store("B"));
        graph.getStores().append(new Store("C"));
        graph.addRoute("A", "B", 1);
        graph.addRoute("B", "C", 2);
        assertNull(graph.getStores().find("A").getRoutes().find("C"));
        assertEquals(graph.getStores().find("A").getRoutes().find("B").getDistance(), 1);
    }
}
