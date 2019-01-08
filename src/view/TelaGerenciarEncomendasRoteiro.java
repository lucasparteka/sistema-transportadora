package view;

import controller.RoteiroController;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import util.StatusEncomenda;

public class TelaGerenciarEncomendasRoteiro extends javax.swing.JFrame {

    RoteiroController roteiroController = new RoteiroController();
    private String cnhMotorista;
    private String placaVeiculo;
    private int codigoRoteiro;

    public TelaGerenciarEncomendasRoteiro(int codRoteiro, String cnh, String placa) {
        initComponents();
        cnhMotorista = cnh;
        placaVeiculo = placa;
        codigoRoteiro = codRoteiro;
        DefaultTableModel dtm = (DefaultTableModel) tableEncomendas.getModel();
        tableEncomendas.setRowSorter(new TableRowSorter(dtm));

        for (int i = 0; i < roteiroController.retornaEncomendasRoteiro(codRoteiro).size(); i++) {
            Object[] dados = {roteiroController.retornaEncomendasRoteiro(codRoteiro).get(i).getCodigoEncomenda(),
                roteiroController.retornaEncomendasRoteiro(codRoteiro).get(i).getDataPostagem(),
                roteiroController.retornaEncomendasRoteiro(codRoteiro).get(i).getPeso(),};

            dtm.addRow(dados);
        }
    }

    private TelaGerenciarEncomendasRoteiro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableEncomendas = new javax.swing.JTable();
        btnAtualizar = new javax.swing.JButton();
        btnConcluir = new javax.swing.JButton();
        cbStatusEncomenda = new javax.swing.JComboBox<>();
        labelCodigoRoteiro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(69, 90, 100));

        tableEncomendas.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tableEncomendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Encomenda", "Data Postagem", "Peso"
            }
        ));
        jScrollPane2.setViewportView(tableEncomendas);

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnConcluir.setText("Concluir");
        btnConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConcluirActionPerformed(evt);
            }
        });

        cbStatusEncomenda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entregue", "Não Entregue" }));

        labelCodigoRoteiro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelCodigoRoteiro.setForeground(new java.awt.Color(255, 255, 255));
        labelCodigoRoteiro.setText("Encomendas do roteiro");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(labelCodigoRoteiro))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbStatusEncomenda, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAtualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnConcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCodigoRoteiro)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtualizar)
                    .addComponent(cbStatusEncomenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConcluir))
                .addContainerGap(176, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcluirActionPerformed

        if (tableEncomendas.getRowCount() > 0) {
            JOptionPane.showMessageDialog(null, "Ainda existem encomendas para informar o status");
        } else {
            if(roteiroController.finalizarRoteiro(codigoRoteiro, cnhMotorista, placaVeiculo)){
                JOptionPane.showMessageDialog(null, "Roteiro finalizado com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao finalizar roteiro");
            }
            this.dispose();
        }
    }//GEN-LAST:event_btnConcluirActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed

        //pega as informações da tabela
        DefaultTableModel model = (DefaultTableModel) tableEncomendas.getModel();
        
        //if para verificar se alguma linha foi selecionada
        if (tableEncomendas.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum roteiro selecionado");
        } else {
            
            //getSelectedRow pega a linha selecionada na tabela
            int linhaRoteiroSelecionado = tableEncomendas.getSelectedRow();
            int codigoEncomenda = (int) model.getValueAt(linhaRoteiroSelecionado, 0);
            
            //remove o roteiro da tabela
            model.removeRow(linhaRoteiroSelecionado);

            //seta a encomenda com status entregue
            if (cbStatusEncomenda.getSelectedIndex() == 0) {
                roteiroController.alterarStatusEncomenda(codigoEncomenda, StatusEncomenda.ENTREGUE);

                //seta a encomanda com status não entregue
            } else if (cbStatusEncomenda.getSelectedIndex() == 1) {
                roteiroController.alterarStatusEncomenda(codigoEncomenda, StatusEncomenda.NAO_ENTREGUE);
            }
        }

    }//GEN-LAST:event_btnAtualizarActionPerformed

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarEncomendasRoteiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarEncomendasRoteiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarEncomendasRoteiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarEncomendasRoteiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaGerenciarEncomendasRoteiro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnConcluir;
    private javax.swing.JComboBox<String> cbStatusEncomenda;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCodigoRoteiro;
    private javax.swing.JTable tableEncomendas;
    // End of variables declaration//GEN-END:variables
}
