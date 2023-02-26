package organized.chaos;

import javax.swing.AbstractListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Andres
 */
public class BuyPanel extends javax.swing.JPanel {

    private StockList stock;
    private StockList cart;
    
    private StockListModel stockListModel = new StockListModel();
    private StockListModel cartListModel = new StockListModel();
    
    /**
     * Creates new form BuyPanel
     */
    public BuyPanel() {
        initComponents();
    }
    
    public void setStock(StockList stock) {
        this.stock = stock;
        cart = new StockList();
        nameComboBox.removeAllItems();
        for (ListNode<Store> storeNode = App.getInstance().getGraph().getStores().getFirst(); storeNode != null; storeNode = storeNode.getNext()) {
            nameComboBox.addItem(storeNode.getValue().getName());
        }
        stockListModel.setList(stock);
        cartListModel.setList(cart);
    }
    
    public void updateStatus() {
        if(((String) nameComboBox.getSelectedItem()).isBlank()) {
            statusLabel.setText("Seleccione un almacén");
            statusLabel.setVisible(true);
            buyButton.setEnabled(false);
        }
        else if(cart.getSize() == 0) {
            statusLabel.setText("Agregue un producto al carrito");
            statusLabel.setVisible(true);
            buyButton.setEnabled(false);
        }
        else {
            statusLabel.setVisible(false);
            buyButton.setEnabled(true);
        }
    }
    
    private boolean hasStock(Store store, StockList list) {
        for(ListNode<Stock> node = list.getFirst(); node != null; node = node.getNext()) {
            Stock listProduct = node.getValue();
            Stock storeProduct = store.getStock().find(listProduct.getProduct());
            if(storeProduct == null || storeProduct.getAmount() < listProduct.getAmount()) {
                return false;
            }
        }
        return true;
    }
    
    private RouteList findNearestRoute(Store target, StockList list) {
        int minDistance = Integer.MAX_VALUE;
        Store minStore = null;
        
        StoreList paths = new StoreList();
        RouteList pending = new RouteList(), visited = new RouteList();
        pending.append(new Route(target, 0));
        
        Store newPath = new Store(target.getName());
        newPath.getRoutes().append(new Route(target, 0));
        paths.append(newPath);

        for (ListNode<Route> sourceNode = pending.getFirst(); sourceNode != null; sourceNode = sourceNode.getNext()) {
            Route source = sourceNode.getValue();
            Store path = paths.find(source.getStore().getName());
            for (ListNode<Route> routeNode = source.getStore().getRoutes().getFirst(); routeNode != null; routeNode = routeNode.getNext()) {
                Route route = routeNode.getValue();
                if(route.isBackwards()) {
                    int distance = source.getDistance() - route.getDistance();
                    
                    if(distance > minDistance) {
                        continue;
                    }
                    
                    Route visitedRoute = visited.find(route.getStore().getName());
                    Route pendingRoute = pending.find(route.getStore().getName());
                    
                    /* Agregar ruta actual */
                    newPath = new Store(route.getStore().getName());
                    if(path != null) {
                        for (ListNode<Route> pathNode = path.getRoutes().getFirst(); pathNode != null; pathNode = pathNode.getNext()) {
                            newPath.getRoutes().append(pathNode.getValue());
                        }
                    }
                    newPath.getRoutes().append(new Route(route.getStore(), distance));
                    paths.remove(newPath.getName());
                    paths.append(newPath);
                    
                    /* Agregar ruta o actualizar distancia */
                    if(hasStock(route.getStore(), list) && distance < minDistance) {
                        minDistance = distance;
                        minStore = route.getStore();
                    }
                    
                    /* Agregar ruta o actualizar distancia */
                    if(visitedRoute == null && pendingRoute == null) {
                        pending.append(new Route(route.getStore(), distance));
                    }    
                    else if(pendingRoute != null && pendingRoute.getDistance() > distance) {
                        pendingRoute.setDistance(distance);
                    }
                    else if(visitedRoute != null && visitedRoute.getDistance() > distance) {
                        visitedRoute.setDistance(distance);
                    }
                }
            }
            pending.remove(source.getStore().getName());
            visited.append(source);
        }
        
        return minStore != null ? paths.find(minStore.getName()).getRoutes() : null;
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

        bottomPanel = new javax.swing.JPanel();
        bottomFiller = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        statusLabel = new javax.swing.JLabel();
        buyButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        centerPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        nameComboBox = new javax.swing.JComboBox<>();
        stockLabel = new javax.swing.JLabel();
        cartLabel = new javax.swing.JLabel();
        stockScrollPane = new javax.swing.JScrollPane();
        stockList = new javax.swing.JList<>();
        cartScrollPane = new javax.swing.JScrollPane();
        cartList = new javax.swing.JList<>();
        stockButtonsPanel = new javax.swing.JPanel();
        stockFiller = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        amountSpinner = new javax.swing.JSpinner();
        addProductButton = new javax.swing.JButton();
        cartButtonsPanel = new javax.swing.JPanel();
        cartFiller = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        removeProductButton = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        bottomPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        bottomPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 1.0;
        bottomPanel.add(bottomFiller, gridBagConstraints);

        statusLabel.setForeground(java.awt.Color.red);
        statusLabel.setText("Agrega un producto al carrito");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        bottomPanel.add(statusLabel, gridBagConstraints);

        buyButton.setText("Comprar");
        buyButton.setEnabled(false);
        buyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        bottomPanel.add(buyButton, gridBagConstraints);

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        bottomPanel.add(cancelButton, gridBagConstraints);

        add(bottomPanel, java.awt.BorderLayout.SOUTH);

        centerPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(40, 40, 20, 40));
        centerPanel.setLayout(new java.awt.GridBagLayout());

        nameLabel.setText("Almacén: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        centerPanel.add(nameLabel, gridBagConstraints);

        nameComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        centerPanel.add(nameComboBox, gridBagConstraints);

        stockLabel.setText("Disponibles:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        centerPanel.add(stockLabel, gridBagConstraints);

        cartLabel.setText("Carrito:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        centerPanel.add(cartLabel, gridBagConstraints);

        stockList.setModel(stockListModel);
        stockScrollPane.setViewportView(stockList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        centerPanel.add(stockScrollPane, gridBagConstraints);

        cartList.setModel(cartListModel);
        cartScrollPane.setViewportView(cartList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        centerPanel.add(cartScrollPane, gridBagConstraints);

        stockButtonsPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 1.0;
        stockButtonsPanel.add(stockFiller, gridBagConstraints);
        stockButtonsPanel.add(amountSpinner, new java.awt.GridBagConstraints());

        addProductButton.setText("Agregar al carrito");
        addProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        stockButtonsPanel.add(addProductButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        centerPanel.add(stockButtonsPanel, gridBagConstraints);

        cartButtonsPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 1.0;
        cartButtonsPanel.add(cartFiller, gridBagConstraints);

        removeProductButton.setText("Eliminar del carrito");
        removeProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeProductButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        cartButtonsPanel.add(removeProductButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        centerPanel.add(cartButtonsPanel, gridBagConstraints);

        add(centerPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void buyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyButtonActionPerformed
        Store target = App.getInstance().getGraph().getStore((String) nameComboBox.getSelectedItem());
        StockList borrowList = new StockList();
        
        for(ListNode<Stock> node = cart.getFirst(); node != null; node = node.getNext()) {
            Stock cartProduct = node.getValue();
            Stock targetProduct = target.getStock().find(cartProduct.getProduct());
            if(targetProduct == null) {
                borrowList.append(new Stock(cartProduct.getProduct(), cartProduct.getAmount()));
            }    
            else if(cartProduct.getAmount() > targetProduct.getAmount()) {
                borrowList.append(new Stock(cartProduct.getProduct(), cartProduct.getAmount() - targetProduct.getAmount()));
            }               
        }
        
        if(borrowList.isEmpty()) {
            for(ListNode<Stock> node = cart.getFirst(); node != null; node = node.getNext()) {
                Stock cartProduct = node.getValue();
                Stock targetProduct = target.getStock().find(cartProduct.getProduct());
                targetProduct.setAmount(targetProduct.getAmount() - cartProduct.getAmount());
            }
            App.getInstance().saveFile();
            JOptionPane.showMessageDialog(this, "La compra se procesó exitosamente", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
        App.getInstance().showOptionsPanel();
        }
        else {
            RouteList borrowPath = findNearestRoute(target, borrowList);
            Store borrowStore = borrowPath.getLast().getValue().getStore();
            if(borrowPath == null) {
                JOptionPane.showMessageDialog(this, "No fue posible enviar todos los productos", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            for(ListNode<Stock> node = cart.getFirst(); node != null; node = node.getNext()) {
                Stock cartProduct = node.getValue();
                Stock targetProduct = target.getStock().find(cartProduct.getProduct());
                if(targetProduct != null) {
                    targetProduct.setAmount(targetProduct.getAmount() > cartProduct.getAmount() ? targetProduct.getAmount() - cartProduct.getAmount() : 0);
                }
            }
            for(ListNode<Stock> node = borrowList.getFirst(); node != null; node = node.getNext()) {
                Stock cartProduct = node.getValue();
                Stock targetProduct = borrowStore.getStock().find(cartProduct.getProduct());
                targetProduct.setAmount(targetProduct.getAmount() - cartProduct.getAmount());
            }
            App.getInstance().saveFile();
            JOptionPane.showMessageDialog(this, "La compra se procesó exitosamente abasteciendo desde el Almacén %s, a una distancia de %d km".formatted(borrowStore.getName(), borrowPath.getLast().getValue().getDistance()), "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
            App.getInstance().showGraphPanel(borrowPath);
        }
    }//GEN-LAST:event_buyButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        App.getInstance().showOptionsPanel();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void removeProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeProductButtonActionPerformed
        int row = cartList.getSelectedIndex();
        if(row >= 0) {
            Stock removed = cart.removeAt(row);
            Stock original = stock.find(removed.getProduct());
            original.setAmount(original.getAmount() + removed.getAmount());
            stockListModel.update();
            cartListModel.update();
            updateStatus();
        }
    }//GEN-LAST:event_removeProductButtonActionPerformed

    private void addProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductButtonActionPerformed
        int row = stockList.getSelectedIndex();
        int amount = (int) amountSpinner.getValue();
        
        if(row < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        else if(amount <= 0) {
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad mayor a 0", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Stock original = stock.at(row);
        if(amount > original.getAmount()) {
            JOptionPane.showMessageDialog(this, "No hay suficientes productos en inventario", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Stock added = new Stock(original.getProduct(), (int) amountSpinner.getValue());
        original.setAmount(original.getAmount() - added.getAmount());
        cart.append(added);
        stockListModel.update();
        cartListModel.update();
        amountSpinner.setValue(0);
        updateStatus();
    }//GEN-LAST:event_addProductButtonActionPerformed
   
    class StockListModel extends AbstractListModel {

        private StockList list = new StockList();

        public void setList(StockList list) {
            this.list = list;
            update();
        }
        
        public void update() {
            this.fireContentsChanged(this, 0, list.getSize());
        }
        
        @Override
        public int getSize() {
            return list.getSize();
        }

        @Override
        public Object getElementAt(int index) {
            Stock product = list.at(index);
            return "%s (%d)".formatted(product.getProduct(), product.getAmount());
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProductButton;
    private javax.swing.JSpinner amountSpinner;
    private javax.swing.Box.Filler bottomFiller;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton buyButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel cartButtonsPanel;
    private javax.swing.Box.Filler cartFiller;
    private javax.swing.JLabel cartLabel;
    private javax.swing.JList<String> cartList;
    private javax.swing.JScrollPane cartScrollPane;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JComboBox<String> nameComboBox;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton removeProductButton;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JPanel stockButtonsPanel;
    private javax.swing.Box.Filler stockFiller;
    private javax.swing.JLabel stockLabel;
    private javax.swing.JList<String> stockList;
    private javax.swing.JScrollPane stockScrollPane;
    // End of variables declaration//GEN-END:variables
}
