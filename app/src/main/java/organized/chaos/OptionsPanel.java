package organized.chaos;

/**
 *
 * @author Andres
 */
public class OptionsPanel extends javax.swing.JPanel {

    /**
     * Creates new form OptionsPanel
     */
    public OptionsPanel() {
        initComponents();
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

        titleLabel = new javax.swing.JLabel();
        subtitleLabel = new javax.swing.JLabel();
        showStoresButton = new javax.swing.JButton();
        showStockButton = new javax.swing.JButton();
        buyButton = new javax.swing.JButton();
        addStoreButton = new javax.swing.JButton();
        updateDataButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 40, 20, 40));
        setLayout(new java.awt.GridBagLayout());

        titleLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        titleLabel.setText("Sistema de Distribución de Amazon");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        add(titleLabel, gridBagConstraints);

        subtitleLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        subtitleLabel.setText("Seleccione una opción");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        add(subtitleLabel, gridBagConstraints);

        showStoresButton.setBackground(new java.awt.Color(255, 204, 51));
        showStoresButton.setForeground(new java.awt.Color(0, 0, 0));
        showStoresButton.setText("Ver Almacenes");
        showStoresButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showStoresButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(showStoresButton, gridBagConstraints);

        showStockButton.setBackground(new java.awt.Color(255, 204, 51));
        showStockButton.setForeground(new java.awt.Color(0, 0, 0));
        showStockButton.setText("Consultar Disponibilidad");
        showStockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showStockButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(showStockButton, gridBagConstraints);

        buyButton.setBackground(new java.awt.Color(255, 204, 51));
        buyButton.setForeground(new java.awt.Color(0, 0, 0));
        buyButton.setText("Realizar Pedido");
        buyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(buyButton, gridBagConstraints);

        addStoreButton.setBackground(new java.awt.Color(255, 204, 51));
        addStoreButton.setForeground(new java.awt.Color(0, 0, 0));
        addStoreButton.setText("Agregar Almacén");
        addStoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStoreButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(addStoreButton, gridBagConstraints);

        updateDataButton.setBackground(new java.awt.Color(255, 204, 51));
        updateDataButton.setForeground(new java.awt.Color(0, 0, 0));
        updateDataButton.setText("Gestionar Almacenes");
        updateDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateDataButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(updateDataButton, gridBagConstraints);

        closeButton.setBackground(new java.awt.Color(255, 204, 51));
        closeButton.setForeground(new java.awt.Color(0, 0, 0));
        closeButton.setText("Cerrar programa");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(closeButton, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void updateDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateDataButtonActionPerformed
        App.getInstance().showManageStorePanel();
    }//GEN-LAST:event_updateDataButtonActionPerformed

    private void showStockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showStockButtonActionPerformed
        App.getInstance().showStockPanel();
    }//GEN-LAST:event_showStockButtonActionPerformed

    private void addStoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStoreButtonActionPerformed
        App.getInstance().showManageStorePanel();
    }//GEN-LAST:event_addStoreButtonActionPerformed

    private void buyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyButtonActionPerformed
        App.getInstance().showBuyPanel();
    }//GEN-LAST:event_buyButtonActionPerformed

    private void showStoresButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showStoresButtonActionPerformed
        App.getInstance().showGraphPanel();
    }//GEN-LAST:event_showStoresButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        App.getInstance().dispose();
        System.exit(0);
    }//GEN-LAST:event_closeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addStoreButton;
    private javax.swing.JButton buyButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JButton showStockButton;
    private javax.swing.JButton showStoresButton;
    private javax.swing.JLabel subtitleLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton updateDataButton;
    // End of variables declaration//GEN-END:variables
}
