package views;

/**
 *
 * @author Júlio Oliveira
 */

import data.Conexao;
import data.adcData;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import model.adcModel;
import table.tableModel;

public class principal extends javax.swing.JFrame {
    
    atualizar enviaDados;
    
    Conexao conex = new Conexao();
    adcModel mod = new adcModel();
    adcData data = new adcData(); 

    public principal() throws ParseException {
        initComponents();
        
        setLocationRelativeTo ( null );
        
        preencherTabela ( "select*from estoque" );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtEstoque = new javax.swing.JTable();
        btAdicionar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jtEstoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtEstoqueMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtEstoque);

        btAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bt_Adc.jpg"))); // NOI18N
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Em estoque");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bt_can.jpg"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Para Atualizar ou Apagar um titulo de livro, basta clicar em cima da opção da tabela");

        jLabel3.setText("e selecionar a opção desejada.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1016, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(137, 137, 137)))
                        .addGap(27, 27, 27))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
        try {
            Adicionar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao transeferir para a tela de Insert! Erro: " + ex);
        }
    }//GEN-LAST:event_btAdicionarActionPerformed

    private void jtEstoqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtEstoqueMouseClicked
        Object[] opcoes = {"Atualizar","Deletar", "Cancelar"};
        int res = JOptionPane.showOptionDialog(
                null,
                "O que deseja fazer com este item?",
                "Opções",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opcoes,
                opcoes[0]);
        
        if ( res == 0 ) {
                Integer linha = jtEstoque.getSelectedRow();
        String nome = "Atualizar o livro: " + jtEstoque.getValueAt (linha, 0).toString();
           
               int escolhida = JOptionPane.showConfirmDialog (null, nome, "Atualização ", JOptionPane.YES_NO_OPTION );
                if ( escolhida == JOptionPane.YES_OPTION ) {
                    try {
                        enviaDados = new atualizar();
               enviaDados.setVisible(true);
               enviaDados.recebeDados(
                       jtEstoque.getValueAt(linha, 1).toString(),
                       jtEstoque.getValueAt(linha, 2).toString(),
                       jtEstoque.getValueAt(linha, 3).toString(),
                       jtEstoque.getValueAt(linha, 4).toString(),
                       jtEstoque.getValueAt (linha, 0).toString()
                       );
                        Atualizacao();
                        
                    } catch (Exception ex) {
                        Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);            
                    }
                }
        } else if (res == 1 ) {
            int linha = jtEstoque.getSelectedRow();
                String nome = "Deletar o livro: " + jtEstoque.getValueAt (linha, 0).toString();
                int escolhida = JOptionPane.showConfirmDialog (null, nome, "Exclusão ", JOptionPane.YES_NO_OPTION );
                if ( escolhida == JOptionPane.YES_OPTION ) {
                    mod.setCodigo ( ( String ) jtEstoque.getValueAt ( linha, 0 ) );
                    
                    data.Delete(mod);
                    
                    preencherTabela ( "select*from estoque" );
                }
        } else {
           setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jtEstoqueMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new principal().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtEstoque;
    // End of variables declaration//GEN-END:variables

public void preencherTabela( String Sql ) {
    ArrayList dados = new ArrayList();
    
    String[] colunas = new String[] { "Código", "Titulo", "Autor", "Preço", "Quantidade" };
    
    conex.conexao();
    
    conex.exeSql ( Sql );
    
    try {
        conex.rs.first();
        do {
            dados.add ( new Object[] {
                conex.rs.getString ( "id" ),
                conex.rs.getString ( "titulo" ),
                conex.rs.getString ( "autor" ),
                conex.rs.getString ( "preco" ),
                conex.rs.getString ( "quantidade" )
            } );
        } while ( conex.rs.next() );
    } catch ( SQLException pT ) {
       JOptionPane.showMessageDialog ( null, "Erro Preencher a Tabela!" + "Erro: " + pT ); 
    }
    
    tableModel model = new tableModel ( dados, colunas );
    
    JTableHeader header = jtEstoque.getTableHeader();
    DefaultTableCellRenderer centralizado = ( DefaultTableCellRenderer ) header.getDefaultRenderer();
    centralizado.setHorizontalAlignment ( SwingConstants.CENTER );
    
    DefaultTableCellRenderer central = new DefaultTableCellRenderer();
    central.setHorizontalAlignment ( SwingConstants.CENTER );
        
    jtEstoque.setModel ( model );
    
    jtEstoque.getColumnModel().getColumn(0).setPreferredWidth(55);
    jtEstoque.getColumnModel().getColumn(0).setResizable(false);
    jtEstoque.getColumnModel().getColumn(0).setCellRenderer(central);
    
    jtEstoque.getColumnModel().getColumn(1).setPreferredWidth(600);
    jtEstoque.getColumnModel().getColumn(1).setResizable(false);
    
    jtEstoque.getColumnModel().getColumn(2).setPreferredWidth(220);
    jtEstoque.getColumnModel().getColumn(2).setResizable(false);
    
    jtEstoque.getColumnModel().getColumn(3).setPreferredWidth(55);
    jtEstoque.getColumnModel().getColumn(3).setResizable(false);
    jtEstoque.getColumnModel().getColumn(3).setCellRenderer(central);
    
    jtEstoque.getColumnModel().getColumn(4).setPreferredWidth(80);
    jtEstoque.getColumnModel().getColumn(4).setResizable(false);
    jtEstoque.getColumnModel().getColumn(4).setCellRenderer(central);
    
    jtEstoque.getTableHeader().setReorderingAllowed(false);
    jtEstoque.setAutoResizeMode ( jtEstoque.AUTO_RESIZE_OFF );
    jtEstoque.setSelectionMode ( ListSelectionModel.SINGLE_SELECTION );
    
    conex.desconexao();
}

private void Adicionar() throws Exception {
        adicionar insert = new adicionar();
        insert.show();
        this.dispose();
    }

private void Atualizacao() throws Exception {
        this.dispose();
    }
}
