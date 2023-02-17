package organized.chaos;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Andres
 */
public class FileLoadPanel extends javax.swing.JPanel {

    private File selectedFile;
    
    /**
     * Creates new form FileLoadPanel
     */
    public FileLoadPanel() {
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

        fileChooser = new javax.swing.JFileChooser();
        chooseButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        chooseButton.setText("Seleccionar archivo...");
        chooseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        add(chooseButton, gridBagConstraints);

        loadButton.setText("Cargar datos");
        loadButton.setEnabled(false);
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(loadButton, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void chooseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseButtonActionPerformed
        int result = fileChooser.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            loadButton.setEnabled(true);
        }
    }//GEN-LAST:event_chooseButtonActionPerformed

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        if(selectedFile != null) {
            App.getInstance().loadFile(selectedFile);
        }
    }//GEN-LAST:event_loadButtonActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chooseButton;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JButton loadButton;
    // End of variables declaration//GEN-END:variables
}
