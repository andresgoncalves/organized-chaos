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
        assertEquals(0, graph.getDistance("A", "C"));
        assertEquals(1, graph.getDistance("A", "B"));
        assertEquals(-1, graph.getDistance("B", "A"));
    }
}
