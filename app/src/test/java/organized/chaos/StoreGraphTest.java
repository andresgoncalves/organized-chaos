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
        graph.createStore("A");
        graph.createStore("B");
        graph.createStore("C");
        graph.createRoute("A", "B", 1);
        graph.createRoute("B", "C", 2);
        assertNull(graph.getStores().find("A").getRoutes().find("C"));
        assertEquals(graph.getStores().find("A").getRoutes().find("B").getDistance(), 1);
    }
}
