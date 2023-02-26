package organized.chaos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.awt.CardLayout;

/**
 *
 * @author Andres
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

    public StoreGraph getGraph() {
        return graph;
    }

    public void setGraph(StoreGraph graph) {
        this.graph = graph;
    }

    public File getDataFile() {
        return dataFile;
    }

    public void setDataFile(File dataFile) {
        this.dataFile = dataFile;
    }

    public void loadFile(File file) {
        try {
            graph = Database.readDatabase(file);
            dataFile = file;
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "No se encontrˇ el archivo", "Archivo no encontrado", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "No se pudo leer el archivo", "Error de lectura", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Hubo un problema al leer el archivo", "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void saveFile() {
        try {
            Database.writeDatabase(graph, dataFile);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "No se encontrˇ el archivo", "Archivo no encontrado", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "No se pudo leer el archivo", "Error de lectura", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Hubo un problema al leer el archivo", "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void show(String name) {
        ((CardLayout) contentPanel.getLayout()).show(contentPanel, name);
    }
    
    public void showOptionsPanel() {
        show("OptionsPanel");
    }
    
    public void showStoresPanel() {
        show("OptionsPanel");
    }
    
    public void showAddStorePanel() {
        addStorePanel.setStore(null);
        show("AddStorePanel");
    }
    
    public void showStockPanel() {
        stockPanel.updateStock();
        show("StockPanel");
    }
    
    public void showAddRoutePanel() {
        show("AddRoutePanel");
    }
    
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
    
    public void showUpdateStockPanel() {
        show("UpdateStockPanel");
    }
    
    public void showUpdateDataPanel() {
        addStorePanel.setStore(null);
        show("UpdateDataPanel");
    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel7 = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        loadPanel = new organized.chaos.LoadPanel();
        optionsPanel = new organized.chaos.OptionsPanel();
        addStorePanel = new organized.chaos.AddStorePanel();
        buyPanel = new organized.chaos.BuyPanel();
        stockPanel = new organized.chaos.StockPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mainMenu = new javax.swing.JMenu();
        chargeFile = new javax.swing.JMenu();
        requestOption = new javax.swing.JMenu();
        showGraph = new javax.swing.JMenu();
        storesManage = new javax.swing.JMenu();

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Organized Chaos");
        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        contentPanel.setBackground(new java.awt.Color(0, 0, 0));
        contentPanel.setLayout(new java.awt.CardLayout());
        contentPanel.add(loadPanel, "LoadPanel");
        contentPanel.add(optionsPanel, "OptionsPanel");
        contentPanel.add(addStorePanel, "AddStorePanel");
        contentPanel.add(buyPanel, "BuyPanel");
        contentPanel.add(stockPanel, "StockPanel");

        getContentPane().add(contentPanel, java.awt.BorderLayout.CENTER);

        mainMenu.setText("Menu");
        mainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuActionPerformed(evt);
            }
        });
        jMenuBar1.add(mainMenu);

        chargeFile.setText("Archivo");
        jMenuBar1.add(chargeFile);

        requestOption.setText("Realizar Pedido");
        requestOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestOptionActionPerformed(evt);
            }
        });
        jMenuBar1.add(requestOption);

        showGraph.setText("Ver AlmacÚn");
        jMenuBar1.add(showGraph);

        storesManage.setText("Gestionar AlmacÚn");
        jMenuBar1.add(storesManage);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
                                           
    private void mainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuActionPerformed
       
    }//GEN-LAST:event_mainMenuActionPerformed

    private void requestOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestOptionActionPerformed
       
    }//GEN-LAST:event_requestOptionActionPerformed

/*
    private void FieldA├▒adirNuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldA├▒adirNuevoProductoActionPerformed
        // TODO add your handing code here:
    }//GEN-LAST:event_FieldA├▒adirNuevoProductoActionPerformed

    private void BotonA├▒adirNuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonA├▒adirNuevoProductoActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_BotonA├▒adirNuevoProductoActionPerformed
*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private organized.chaos.AddStorePanel addStorePanel;
    private organized.chaos.BuyPanel buyPanel;
    private javax.swing.JMenu chargeFile;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private organized.chaos.LoadPanel loadPanel;
    private javax.swing.JMenu mainMenu;
    private organized.chaos.OptionsPanel optionsPanel;
    private javax.swing.JMenu requestOption;
    private javax.swing.JMenu showGraph;
    private organized.chaos.StockPanel stockPanel;
    private javax.swing.JMenu storesManage;
    // End of variables declaration//GEN-END:variables

    public static App instance;
    
    /**
     * @param args the command line arguments
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

    public static App getInstance() {
        return instance;
    }
}
