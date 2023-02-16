package organized.chaos;

import java.io.IOException;
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
            "Almacen A,Almacen B,10\n" +
            "Almacen A,Almacen C,20\n" +
            "Almacen A,Almacen E,25\n" +
            "Almacen B,Almacen C,5\n" +
            "Almacen B,Almacen D,8\n" +
            "Almacen C,Almacen D,4\n" +
            "Almacen C,Almacen E,13\n" +
            "Almacen E,Almacen D,3";
    
    @Test
    void writeDatabase() throws IOException {
        Store store;
        StoreGraph graph = new StoreGraph();
        
        store = graph.createStore("Almacen A");
        store.getStock().append(new Stock("Pantalla", 3));
        store.getStock().append(new Stock("RAM", 2));
        store.getStock().append(new Stock("Procesador", 1));
        
        store = graph.createStore("Almacen B");
        store.getStock().append(new Stock("Pantalla", 3));
        store.getStock().append(new Stock("Grafica", 5));
        
        store = graph.createStore("Almacen C");
        store.getStock().append(new Stock("Placa", 7));
        store.getStock().append(new Stock("Teclado", 8));
        
        store = graph.createStore("Almacen D");
        store.getStock().append(new Stock("Mouse", 2));
        
        store = graph.createStore("Almacen E");
        store.getStock().append(new Stock("Microfono", 7));
        store.getStock().append(new Stock("Audifonos", 10));
        
        graph.createRoute("Almacen A", "Almacen B", 10);
        graph.createRoute("Almacen A", "Almacen C", 20);
        graph.createRoute("Almacen B", "Almacen C", 5);
        graph.createRoute("Almacen B", "Almacen D", 8);
        graph.createRoute("Almacen C", "Almacen D", 4);
        graph.createRoute("Almacen C", "Almacen E", 13);
        graph.createRoute("Almacen D", "Almacen E", 3);
        graph.createRoute("Almacen E", "Almacen A", 25);
        
        StringWriter writer = new StringWriter();
        
        Database.writeDatabase(graph, writer);
        
        String result = writer.toString();
        
        System.out.println(result);
        
        for(String line : testDatabase.split("\n")) {
            assertTrue(result.contains(line), "Line not found: " + line);            
        }
    }
}
