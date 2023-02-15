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
        assertEquals(graph.getDistance("A", "C"), -1);
        assertEquals(graph.getDistance("A", "B"), 1);
        assertEquals(graph.getDistance("B", "A"), 1);
    }
}
