package views;

/**
 *
 * @author Julio Oliveira
 */

import data.Conexao;
import data.adcData;
import javax.swing.JOptionPane;
import model.adcModel;

public class atualizar extends javax.swing.JFrame {
    Conexao conex = new Conexao();
    adcModel mod = new adcModel();
    adcData data = new adcData();

    public atualizar() {
        initComponents();
        
        lblCodigo.setVisible(false);
        
        setLocationRelativeTo ( null );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btUpdate = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        tfTitulo = new javax.swing.JTextField();
        tfAutor = new javax.swing.JTextField();
        tfPreco = new javax.swing.JTextField();
        tfQuantidade = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        btUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bt_Ok.jpg"))); // NOI18N
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bt_can.jpg"))); // NOI18N
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        tfPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPrecoActionPerformed(evt);
            }
        });

        lblCodigo.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTitulo)
                    .addComponent(tfAutor)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(104, 104, 104))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                                .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(47, 47, 47)
                        .addComponent(lblCodigo)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblCodigo)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        try {
            Principal();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao transeferir para a tela de Principal! Erro: " + ex);
        }
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
        if ( validaCampos() ) {    
        try {
                mod.setTitulo ( tfTitulo.getText() );
                mod.setAutor ( tfAutor.getText() );
                mod.setPreco ( tfPreco.getText().replace (",", ".") );
                mod.setQuantidade ( tfQuantidade.getText() );
                mod.setCodigo ( lblCodigo.getText() );
                
                data.update( mod ); 
                
                Principal();                
                
            } catch ( Exception upd ) {
                JOptionPane.showMessageDialog ( null, "Erro ao Inserir estes dados! Erro: " + upd );
            }
        }
    }//GEN-LAST:event_btUpdateActionPerformed

    private void tfPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPrecoActionPerformed
           mod .setTitulo ( tfTitulo.getText());
           mod .setAutor ( tfAutor.getText());
           mod .setPreco ( tfPreco.getText());
           mod .setQuantidade ( tfQuantidade.getText());
           mod.setCodigo(lblCodigo.getText());
    }//GEN-LAST:event_tfPrecoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(adicionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adicionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adicionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adicionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adicionar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btUpdate;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JTextField tfAutor;
    private javax.swing.JTextField tfPreco;
    private javax.swing.JTextField tfQuantidade;
    private javax.swing.JTextField tfTitulo;
    // End of variables declaration//GEN-END:variables

private void Principal() throws Exception {
    principal inicial = new principal();
    inicial.show();
    this.dispose();
}

public void recebeDados (String A, String B, String C, String D, String E) {
    tfTitulo.setText(A);
    tfAutor.setText(B);
    tfPreco.setText(C);
    tfQuantidade.setText(D);
    lblCodigo.setText(E);
}

private boolean validaCampos() {
    if ( tfTitulo.getText().equals ("")) {
        JOptionPane.showMessageDialog ( this, "Preencha o campo Titulo, pro favor!" );
        tfTitulo.requestFocus();        
    return false; }
    
    if ( tfAutor.getText().equals ("")) {
        JOptionPane.showMessageDialog ( this, "Preencha o campo Autor, pro favor!" );
        tfAutor.requestFocus();        
    return false; }
    
    if ( tfPreco.getText().equals ("")) {
        JOptionPane.showMessageDialog ( this, "Preencha o campo Preco, pro favor!" );
        tfPreco.requestFocus();        
    return false; }
    
    if ( tfQuantidade.getText().equals ("")) {
        JOptionPane.showMessageDialog ( this, "Preencha o campo Quantidade, pro favor!" );
        tfQuantidade.requestFocus();        
    return false; }
    return true;
}
}
