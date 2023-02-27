package organized.chaos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.awt.CardLayout;

/**
 * Ventana principal del programa
 * @author Andres, Michelle, Diego
 */
public class App extends javax.swing.JFrame {

    private StoreGraph graph;
    private File dataFile;
    
    /**
     * Creates new form App
     */
    public App() {
        initComponents();
    }

    /**
     * Retorna el grafo cargado en memoria
     * @return Grafo de almacenes
     */
    public StoreGraph getGraph() {
        return graph;
    }

    /**
     * Establece el grafo del programa
     * @param graph grafo de almacenes
     */
    public void setGraph(StoreGraph graph) {
        this.graph = graph;
    }

    /**
     * Retorna el archivo de datos utilizado
     * @return Archivo de datos
     */
    public File getDataFile() {
        return dataFile;
    }
    
    /**
     * Establece el archivo de datos utilizado por el programa
     * @param dataFile archivo de datos
     */
    public void setDataFile(File dataFile) {
        this.dataFile = dataFile;
    }

    /**
     * Carga el archivo de texto con las rutas, almacenes y cantidad de productos
     * @param file archivo a leer
     */
    public void loadFile(File file) {
        try {
            graph = Database.readDatabase(file);
            dataFile = file;
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "No se encontrï¿½ el archivo", "Archivo no encontrado", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "No se pudo leer el archivo", "Error de lectura", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Hubo un problema al leer el archivo", "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Guarda el archivo de texto para ejecutar el programa
     */
    public void saveFile() {
        try {
            Database.writeDatabase(graph, dataFile);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "No se encontrï¿½ el archivo", "Archivo no encontrado", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "No se pudo escribir el archivo", "Error de escritura", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Hubo un problema al escribir el archivo", "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Muestra una vista de la interfaz
     * @param name nombre de la vista
     */
    public void show(String name) {
        ((CardLayout) contentPanel.getLayout()).show(contentPanel, name);
    }
    
    /**
     * Muestra la vista de opciones
     */
    public void showOptionsPanel() {
        show("OptionsPanel");
    }
    
    /**
     * Muestra la vista de grafo
     */
    public void showGraphPanel() {
        graphPanel.setGraph(graph);
        graphPanel.setHighlightedPath(null);
        show("GraphPanel");
    }
    
    /**
     * Muestra la vista de grafo con una ruta marcada
     * @param path la secuencia de rutas marcada
     */
    public void showGraphPanel(RouteList path) {
        graphPanel.setGraph(graph);
        graphPanel.setHighlightedPath(path);
        show("GraphPanel");
    }
    
    /**
     * Muestra la vista de gestión de almacenes
     */
    public void showManageStorePanel() {
        manageStorePanel.setStore(null);
        show("ManageStorePanel");
    }
    
    /**
     * Muestra la vista de información de inventario
     */
    public void showStockPanel() {
        stockPanel.updateStock();
        show("StockPanel");
    }
    
    /**
     * Muestra la vista de compra
     */
    public void showBuyPanel() {
        StockList stock = new StockList();

        for (ListNode<Store> storeNode = graph.getStores().getFirst(); storeNode != null; storeNode = storeNode.getNext()) {
            Store store = storeNode.getValue();
            for (ListNode<Stock> stockNode = store.getStock().getFirst(); stockNode != null; stockNode = stockNode.getNext()) {
                Stock product = stockNode.getValue();
                Stock original = stock.find(product.getProduct());
                if(original != null) {
                    original.setAmount(original.getAmount() + product.getAmount());
                }
                else {
                    stock.append(new Stock(product.getProduct(), product.getAmount()));
                }
            }
        }

        buyPanel.setStock(stock);
        show("BuyPanel");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        loadPanel = new organized.chaos.LoadPanel();
        optionsPanel = new organized.chaos.OptionsPanel();
        manageStorePanel = new organized.chaos.ManageStorePanel();
        buyPanel = new organized.chaos.BuyPanel();
        stockPanel = new organized.chaos.StockPanel();
        graphPanel = new organized.chaos.GraphPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Organized Chaos");
        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        contentPanel.setBackground(new java.awt.Color(0, 0, 0));
        contentPanel.setLayout(new java.awt.CardLayout());
        contentPanel.add(loadPanel, "LoadPanel");
        contentPanel.add(optionsPanel, "OptionsPanel");
        contentPanel.add(manageStorePanel, "ManageStorePanel");
        contentPanel.add(buyPanel, "BuyPanel");
        contentPanel.add(stockPanel, "StockPanel");
        contentPanel.add(graphPanel, "GraphPanel");

        getContentPane().add(contentPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
                                           
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private organized.chaos.BuyPanel buyPanel;
    private javax.swing.JPanel contentPanel;
    private organized.chaos.GraphPanel graphPanel;
    private organized.chaos.LoadPanel loadPanel;
    private organized.chaos.ManageStorePanel manageStorePanel;
    private organized.chaos.OptionsPanel optionsPanel;
    private organized.chaos.StockPanel stockPanel;
    // End of variables declaration//GEN-END:variables

    public static App instance;
    
    /**
     * Punto de partida del programa
     * @param args argumentos de línea de comandos
     */
    public static void main(String args[]) {
        /* Set the look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(App.class  .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class  .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class  .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            instance = new App();
            instance.setVisible(true);
        });
    }

    /**
     * Retorna la ventana actual
     * @return Instancia de la aplicación
     */
    public static App getInstance() {
        return instance;
    }
}
