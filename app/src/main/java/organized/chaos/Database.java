package organized.chaos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import javax.swing.JOptionPane;

/**
 *
 * @author Andres
 */
public class Database {

    private static final String STORES_SECTION = "Almacenes;";
    private static final String ROUTES_SECTION = "Rutas;";
    private static final String STORE_PREFIX = "Almacen ";
    private static final int READING_NULL = 0;
    private static final int READING_STORE = 1;
    private static final int READING_STOCK = 2;
    private static final int READING_ROUTE = 3;

    private Database() {
    }

    public static StoreGraph readDatabase(File file) throws IOException {
        return readDatabase(new FileReader(file));
    }

    public static StoreGraph readDatabase(Reader baseReader) throws IOException {
        StoreGraph graph = new StoreGraph();

        try (BufferedReader reader = new BufferedReader(baseReader)) {

            int mode = READING_NULL;
            Store store = null;

            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                if (line.startsWith(STORES_SECTION)) {
                    mode = READING_STORE;
                } else if (line.startsWith(ROUTES_SECTION)) {
                    mode = READING_ROUTE;
                } else if (mode == READING_STORE) {
                    String name = line.replace(":", "").replace(STORE_PREFIX, "");
                    store = graph.createStore(name);
                    mode = READING_STOCK;
                } else if (mode == READING_STOCK) {
                    String[] data = line.replace(";", "").split(",");
                    if (store != null && data.length >= 2) {
                        Stock stock = new Stock(data[0], Integer.parseInt(data[1]));
                        store.getStock().append(stock);
                    }
                    if (line.endsWith(";")) {
                        mode = READING_STORE;
                    }
                } else if (mode == READING_ROUTE) {
                    String[] data = line.split(",");
                    if (data.length >= 3) {
                        graph.createRoute(data[0], data[1], Integer.parseInt(data[2]));
                    }
                }
            }
        }

        return graph;
    }

    public static void writeDatabase(StoreGraph graph, File file) throws IOException {
        writeDatabase(graph, new FileWriter(file));
    }

    public static void writeDatabase(StoreGraph graph, Writer baseWriter) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(baseWriter)) {

            writer.write("%s\n".formatted(STORES_SECTION));

            for (ListNode<Store> storeNode = graph.getStores().getFirst(); storeNode != null; storeNode = storeNode.getNext()) {
                Store store = storeNode.getValue();
                writer.write("%s%s:".formatted(STORE_PREFIX, store.getName()));
                for (ListNode<Stock> stockNode = store.getStock().getFirst(); stockNode != null; stockNode = stockNode.getNext()) {
                    Stock stock = stockNode.getValue();
                    writer.write("\n%s,%d".formatted(stock.getProduct(), stock.getAmount()));
                }
                writer.write(";\n");
            }

            StoreList pending = new StoreList(), visited = new StoreList();
            pending.append(graph.getStores().getFirst().getValue());

            writer.write("%s\n".formatted(ROUTES_SECTION));

            for (ListNode<Store> storeNode = pending.getFirst(); storeNode != null; storeNode = storeNode.getNext()) {
                Store store = storeNode.getValue();
                for (ListNode<Route> routeNode = store.getRoutes().getFirst(); routeNode != null; routeNode = routeNode.getNext()) {
                    Route route = routeNode.getValue();
                    if(route.getDistance() > 0) {
                        writer.write("%s,%s,%d\n".formatted(store.getName(), route.getStore().getName(), route.getDistance()));
                    }
                    if(visited.find(route.getStore().getName()) == null && pending.find(route.getStore().getName()) == null) {
                        pending.append(route.getStore());
                    }
                }
                pending.remove(store.getName());
                visited.append(store);
            }

            writer.flush();
        }
    }
}
