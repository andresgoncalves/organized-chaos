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
    private String[] products;
    private Integer[] amountProducts;
    /**
     * Creates new form App
     */
    public App() {
        initComponents();
        this.products=null;
        this.amountProducts=null;
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
            JOptionPane.showMessageDialog(this, "No se encontr� el archivo", "Archivo no encontrado", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(this, "No se encontr� el archivo", "Archivo no encontrado", JOptionPane.ERROR_MESSAGE);
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
        show("StockPanel");
    }
    
    //DFS recursivo
    public void recorrerProfundidad(StoreGraph graph, int v, boolean[] discovered) {
        discovered[v] = true; //Se marca el nodo actual como descubierto
        System.out.println(v + " ");  //Se van imprimiendo los nodos
        // Se buscan los almacenes adyacentes a "v" para continuar el recorrido
        for (int i = 0; i < graph.getStores().getSize(); i++) {    
            if ((v != i) && (!discovered[i])) {
                recorrerProfundidad(graph, v, discovered);
            }
        }
    }
    
    //DFS iterativo
    public void profundidad(StoreGraph graph) {
        int numVertices = graph.getStores().getSize();
        boolean[] visitados = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visitados[i] = false;
        }
        for (int i = 0; i < numVertices; i++) {
            if (!visitados[i]) {
                recorrerProfundidad(graph, i, visitados);
            }
        }
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
        disponibilidadPanel = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        FieldDFS = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        FieldBFS = new javax.swing.JTextArea();
        pedidoPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productosInput = new javax.swing.JTextArea();
        JCStores = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        confirmRequest = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        JProductsAmount = new javax.swing.JSpinner();
        addproduct = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        userList = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        JProducts = new javax.swing.JComboBox<>();
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

        disponibilidadPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Recorrido en Anchura (BFS)");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Recorrido en Profundidad (DFS)");

        FieldDFS.setColumns(20);
        FieldDFS.setRows(5);
        jScrollPane4.setViewportView(FieldDFS);

        FieldBFS.setColumns(20);
        FieldBFS.setRows(5);
        jScrollPane5.setViewportView(FieldBFS);

        javax.swing.GroupLayout disponibilidadPanelLayout = new javax.swing.GroupLayout(disponibilidadPanel);
        disponibilidadPanel.setLayout(disponibilidadPanelLayout);
        disponibilidadPanelLayout.setHorizontalGroup(
            disponibilidadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(disponibilidadPanelLayout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addGroup(disponibilidadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(disponibilidadPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel22))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(184, 184, 184)
                .addGroup(disponibilidadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addContainerGap(355, Short.MAX_VALUE))
        );
        disponibilidadPanelLayout.setVerticalGroup(
            disponibilidadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(disponibilidadPanelLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(disponibilidadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(disponibilidadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(363, Short.MAX_VALUE))
        );

        contentPanel.add(disponibilidadPanel, "card8");

        pedidoPanel.setBackground(new java.awt.Color(255, 255, 255));
        pedidoPanel.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Tekton Pro Ext", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("PRODUCTOS DISPONIBLES:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 170, 0, 0);
        pedidoPanel.add(jLabel3, gridBagConstraints);

        productosInput.setBackground(new java.awt.Color(255, 204, 51));
        productosInput.setColumns(20);
        productosInput.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        productosInput.setForeground(new java.awt.Color(0, 0, 0));
        productosInput.setRows(5);
        jScrollPane1.setViewportView(productosInput);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 314;
        gridBagConstraints.ipady = 469;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(1, 130, 0, 0);
        pedidoPanel.add(jScrollPane1, gridBagConstraints);

        JCStores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCStoresActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 158;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(35, 140, 0, 0);
        pedidoPanel.add(JCStores, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Seleccione un almacén:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.ipady = -2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(34, 190, 0, 0);
        pedidoPanel.add(jLabel4, gridBagConstraints);

        confirmRequest.setBackground(new java.awt.Color(255, 204, 51));
        confirmRequest.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        confirmRequest.setForeground(new java.awt.Color(0, 0, 0));
        confirmRequest.setText("Confirmar Pedido");
        confirmRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmRequestActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 77;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 110, 0, 0);
        pedidoPanel.add(confirmRequest, gridBagConstraints);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Seleccione el producto a pedir e idique la cantidad");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(60, 120, 0, 0);
        pedidoPanel.add(jLabel17, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(43, 10, 0, 0);
        pedidoPanel.add(JProductsAmount, gridBagConstraints);

        addproduct.setBackground(new java.awt.Color(204, 204, 204));
        addproduct.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        addproduct.setForeground(new java.awt.Color(0, 0, 0));
        addproduct.setText("Agregar producto");
        addproduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addproductActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 57;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(60, 190, 0, 0);
        pedidoPanel.add(addproduct, gridBagConstraints);

        userList.setColumns(20);
        userList.setForeground(new java.awt.Color(0, 0, 0));
        userList.setRows(5);
        jScrollPane2.setViewportView(userList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 218;
        gridBagConstraints.ipady = 394;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 100, 0, 0);
        pedidoPanel.add(jScrollPane2, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Tu lista:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 34;
        gridBagConstraints.ipady = -1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 110, 0, 0);
        pedidoPanel.add(jLabel5, gridBagConstraints);

        JProducts.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 98;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(43, 120, 0, 0);
        pedidoPanel.add(JProducts, gridBagConstraints);

        contentPanel.add(pedidoPanel, "car8");

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

        showGraph.setText("Ver Almacén");
        jMenuBar1.add(showGraph);

        storesManage.setText("Gestionar Almacén");
        jMenuBar1.add(storesManage);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmRequestActionPerformed(java.awt.event.ActionEvent evt) {                                               
        String storeSelected = JCStores.getSelectedItem().toString();
        Store storeGet=null;
        for(ListNode<Store> recorrer= graph.getStores().getFirst();recorrer!=null;recorrer=recorrer.getNext()){
            if(storeSelected.equals(recorrer.getValue().getName())){
                storeGet=recorrer.getValue();
            }

        }
        
        for(int i = 0; i < products.length; i++) {
            Stock stock = storeGet.getStock().find(products[i]);
            if(stock==null){
                //codigo solicitar
            }else{
                stock.setAmount(stock.getAmount()-Integer.parseInt(JProductsAmount.getValue().toString()));
            }
        }
  
    }                                              

    private void JCStoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCStoresActionPerformed
        
    }//GEN-LAST:event_JCStoresActionPerformed

    private void mainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuActionPerformed
       
    }//GEN-LAST:event_mainMenuActionPerformed

    private void requestOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestOptionActionPerformed
       
    }//GEN-LAST:event_requestOptionActionPerformed

    private void addproductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addproductActionPerformed
        for (int i = 0; i < JProducts.getItemCount(); i++) {
            String selectItem=JProducts.getSelectedItem().toString();
            products[i]=selectItem; 
            amountProducts[i]=Integer.parseInt(JProductsAmount.getValue().toString());
        }
        for (int i = 0; i < products.length; i++) {
        userList.setText(products[i]);
        }
    }//GEN-LAST:event_addproductActionPerformed

    // Variables declaration - do not modify                     
    private javax.swing.JComboBox<String> ProductsShow;
/*
    private void FieldAñadirNuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldAñadirNuevoProductoActionPerformed
        // TODO add your handing code here:
    }//GEN-LAST:event_FieldAñadirNuevoProductoActionPerformed

    private void BotonAñadirNuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAñadirNuevoProductoActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_BotonAñadirNuevoProductoActionPerformed
*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea FieldBFS;
    private javax.swing.JTextArea FieldDFS;
    private static javax.swing.JComboBox<String> JCStores;
    private javax.swing.JComboBox<String> JProducts;
    private javax.swing.JSpinner JProductsAmount;
    private organized.chaos.AddStorePanel addStorePanel;
    private javax.swing.JButton addproduct;
    private organized.chaos.BuyPanel buyPanel;
    private javax.swing.JMenu chargeFile;
    private javax.swing.JButton confirmRequest;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel disponibilidadPanel;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private organized.chaos.LoadPanel loadPanel;
    private javax.swing.JMenu mainMenu;
    private organized.chaos.OptionsPanel optionsPanel;
    private javax.swing.JPanel pedidoPanel;
    private javax.swing.JTextArea productosInput;
    private javax.swing.JMenu requestOption;
    private javax.swing.JMenu showGraph;
    private javax.swing.JMenu storesManage;
    private javax.swing.JTextArea userList;
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
