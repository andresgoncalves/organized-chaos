package organized.chaos;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Andres
 */
public class DatabaseTest {
    
    private final String testDatabase =
            "Almacenes;\n" +
            "Almacen A:\n" +
            "Pantalla,3\n" +
            "RAM,2\n" +
            "Procesador,1;\n" +
            "Almacen B:\n" +
            "Pantalla,3\n" +
            "Grafica,5;\n" +
            "Almacen C:\n" +
            "Placa,7\n" +
            "Teclado,8;\n" +
            "Almacen D:\n" +
            "Mouse,2;\n" +
            "Almacen E:\n" +
            "Microfono,7\n" +
            "Audifonos,10;\n" +
            "Rutas;\n" +
            "A,B,10\n" +
            "A,C,20\n" +
            "B,C,5\n" +
            "B,D,8\n" +
            "C,D,4\n" +
            "C,E,13\n" +
            "D,E,3\n" +
            "E,A,25";
    
    @Test
    void readDatabase() throws IOException {
        StoreGraph graph = Database.readDatabase(new StringReader(testDatabase));
        
        assertEquals(5, graph.getStores().getSize());
        
        assertEquals(3, graph.getStore("A").getStock().getSize());
        assertEquals(2, graph.getStore("B").getStock().getSize());
        assertEquals(1, graph.getStore("D").getStock().getSize());
        
        assertEquals(0, graph.getDistance("A", "D"));
        assertEquals(-25, graph.getDistance("A", "E"));
        assertEquals(4, graph.getDistance("C", "D"));
    }
    
    @Test
    void writeDatabase() throws IOException {
        Store store;
        StoreGraph graph = new StoreGraph();
        
        store = graph.createStore("A");
        store.getStock().append(new Stock("Pantalla", 3));
        store.getStock().append(new Stock("RAM", 2));
        store.getStock().append(new Stock("Procesador", 1));
        
        store = graph.createStore("B");
        store.getStock().append(new Stock("Pantalla", 3));
        store.getStock().append(new Stock("Grafica", 5));
        
        store = graph.createStore("C");
        store.getStock().append(new Stock("Placa", 7));
        store.getStock().append(new Stock("Teclado", 8));
        
        store = graph.createStore("D");
        store.getStock().append(new Stock("Mouse", 2));
        
        store = graph.createStore("E");
        store.getStock().append(new Stock("Microfono", 7));
        store.getStock().append(new Stock("Audifonos", 10));
        
        graph.createRoute("A", "B", 10);
        graph.createRoute("A", "C", 20);
        graph.createRoute("B", "C", 5);
        graph.createRoute("B", "D", 8);
        graph.createRoute("C", "D", 4);
        graph.createRoute("C", "E", 13);
        graph.createRoute("D", "E", 3);
        graph.createRoute("E", "A", 25);
        
        StringWriter writer = new StringWriter();
        
        Database.writeDatabase(graph, writer);
        
        String result = writer.toString();
        
        for(String line : testDatabase.split("\n")) {
            assertTrue(result.contains(line), "Line not found: " + line);            
        }
    }
}
