package Views.Maintenances.Product.Products;

import java.util.List;

import javax.swing.JOptionPane;

import Controller.ProductController;
import DTOs.Objects.DtoBrand;
import DTOs.Objects.DtoProducts;

/**
 *
 * @author kalfe
 */
public class DeleteProduct extends java.awt.Dialog {
    private ProductController controller;
    private int id;
    private Products form;

    /**
     * Creates new form DeleteProduct
     */
    public DeleteProduct(java.awt.Frame parent, boolean modal, ProductController controller, Products form) {
        super(parent, modal);
        this.id = id;
        this.controller = controller;
        this.form = form;
        setLocationRelativeTo(null);
        initComponents();
    }
    
    public void setProductData(String name, int productID){
        jLabel_viewDataProduct.setText("<html>Está seguro que desea eliminar el Producto: <b>"+name+"</b></html>");
        id = productID;
        
    }

    private void deleteProduct(){
        int idProduct = id;
        int result = controller.deleteProduct(idProduct);
        if(result > 0){
            JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente");
            List<DtoProducts> products = controller.loadProducts();
            form.updateTable(products);
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "No se puedo eliminar el Producto.");
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_back = new javax.swing.JPanel();
        jLabel_title = new javax.swing.JLabel();
        jLabel_viewDataProduct = new javax.swing.JLabel();
        jBttn_delete = new javax.swing.JButton();
        jBttn_cancel = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel_back.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_title.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel_title.setText("Eliminar Producto");
        jPanel_back.add(jLabel_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        jLabel_viewDataProduct.setText("jLabel1");
        jPanel_back.add(jLabel_viewDataProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 330, 110));

        jBttn_delete.setText("Eliminar");
        jBttn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_deleteActionPerformed(evt);
            }
        });
        jPanel_back.add(jBttn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, -1, -1));

        jBttn_cancel.setText("Cancelar");
        jBttn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_cancelActionPerformed(evt);
            }
        });
        jPanel_back.add(jBttn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_back, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_back, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void jBttn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttn_deleteActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "¿Esta seguro de eliminar este Producto?", "Confirmar Eliminacion", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            deleteProduct();
        }
    }//GEN-LAST:event_jBttn_deleteActionPerformed

    private void jBttn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttn_cancelActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBttn_cancelActionPerformed

    /**
     * @param args the command line arguments
     */
    //public static void main(String args[]) {
        //java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Products productForm = new Products();
                ProductController controller = new ProductController();
                DeleteProduct dialog = new DeleteProduct(new java.awt.Frame(), true, controller, productForm);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        //});
   // }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBttn_cancel;
    private javax.swing.JButton jBttn_delete;
    private javax.swing.JLabel jLabel_title;
    private javax.swing.JLabel jLabel_viewDataProduct;
    private javax.swing.JPanel jPanel_back;
    // End of variables declaration//GEN-END:variables
}
