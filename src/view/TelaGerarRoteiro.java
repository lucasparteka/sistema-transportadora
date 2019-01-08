package view;

import controller.EncomendaController;
import controller.MotoristaController;
import controller.RoteiroController;
import controller.VeiculoController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.Motorista;
import util.StatusEncomenda;
import util.TipoCNH;
import util.TipoVeiculo;

public class TelaGerarRoteiro extends javax.swing.JFrame {

    private int totalCaixasSelecionadas;
    private int quantidadeEncomendasRetornadas = 0;
    private MotoristaController motoristaController = new MotoristaController();
    private VeiculoController veiculoController = new VeiculoController();
    private EncomendaController encomendaController = new EncomendaController();
    private RoteiroController roteiroController;

    public TelaGerarRoteiro() {
        initComponents();

        DefaultTableModel dtm = (DefaultTableModel) table_Motoristas.getModel();
        table_Motoristas.setRowSorter(new TableRowSorter(dtm));
        List<Motorista> listaMotoristas = motoristaController.listarMotoristas(2);

        //preenche tabela com motoristas disponiveis
        for (int i = 0; i < listaMotoristas.size(); i++) {
            Object[] dados = {listaMotoristas.get(i).getNomeMotorista(),
                listaMotoristas.get(i).getNumeroCnh(),
                listaMotoristas.get(i).getCategoriaCnh()};
            dtm.addRow(dados);

        }

        DefaultTableModel dtm2 = (DefaultTableModel) table_Veiculos.getModel();
        table_Veiculos.setRowSorter(new TableRowSorter(dtm2));

        //preenche tabela com veiculos disponiveis ao passar o valor 2 como parametro
        for (int i = 0; i < veiculoController.listarVeiculosDisponiveis(2).size(); i++) {
            Object[] dados2 = {veiculoController.listarVeiculosDisponiveis(2).get(i).getTipoVeiculo(),
                veiculoController.listarVeiculosDisponiveis(2).get(i).getPlacaVeiculo(),
                veiculoController.listarVeiculosDisponiveis(2).get(i).getCapacidadeCarga()};
            dtm2.addRow(dados2);
        }

        DefaultTableModel dtm3 = (DefaultTableModel) table_Encomendas.getModel();
        table_Encomendas.setRowSorter(new TableRowSorter(dtm3));

        //preenche a tabela com as encomendas passiveis de serem entregues.
        for (int i = 0; i < encomendaController.retornaEncomendas().size(); i++) {
            Object[] dados3 = {encomendaController.retornaEncomendas().get(i).getCodigoEncomenda(),
                encomendaController.retornaEncomendas().get(i).getStatusEncomenda().getTextoStatus()};
            dtm3.addRow(dados3);
        }

        quantidadeEncomendasRetornadas = encomendaController.retornaEncomendas().size();
        String qtdEncomendas = Integer.toString(quantidadeEncomendasRetornadas);
        label_qtd.setText(qtdEncomendas);
        dtm.fireTableDataChanged();
        dtm2.fireTableDataChanged();
        dtm3.fireTableDataChanged();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        slidertotalCaixas = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        botaoSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_Veiculos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_Motoristas = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_Encomendas = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        botaoCancelar = new javax.swing.JButton();
        label_qtd = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(38, 50, 56));

        slidertotalCaixas.setBackground(new java.awt.Color(38, 50, 56));
        slidertotalCaixas.setForeground(new java.awt.Color(0, 255, 204));
        slidertotalCaixas.setMajorTickSpacing(1);
        slidertotalCaixas.setMaximum(10);
        slidertotalCaixas.setMinimum(0);
        slidertotalCaixas.setMinorTickSpacing(1);
        slidertotalCaixas.setPaintLabels(true);
        slidertotalCaixas.setPaintTicks(true);
        slidertotalCaixas.setPaintTrack(false);
        slidertotalCaixas.setToolTipText("");
        slidertotalCaixas.setValue(1);
        slidertotalCaixas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slidertotalCaixasStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Total de caixas:");

        botaoSalvar.setBackground(new java.awt.Color(9, 151, 147));
        botaoSalvar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoSalvar.setForeground(new java.awt.Color(225, 218, 218));
        botaoSalvar.setText("Salvar");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        table_Veiculos.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        table_Veiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Placa", "Capacidade"
            }
        ));
        jScrollPane1.setViewportView(table_Veiculos);

        table_Motoristas.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        table_Motoristas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CNH", "Categoria"
            }
        ));
        jScrollPane2.setViewportView(table_Motoristas);

        table_Encomendas.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        table_Encomendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Status"
            }
        ));
        jScrollPane3.setViewportView(table_Encomendas);

        jLabel4.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Motoristas Disponiveis:");

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Veículos Disponiveis:");

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Encomendas Disponiveis:");

        jLabel6.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Gerar Roteiro");

        botaoCancelar.setBackground(new java.awt.Color(28, 24, 24));
        botaoCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoCancelar.setForeground(new java.awt.Color(225, 218, 218));
        botaoCancelar.setText("Fechar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        label_qtd.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        label_qtd.setForeground(new java.awt.Color(0, 255, 204));
        label_qtd.setText("qtd");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(188, 188, 188)
                        .addComponent(jLabel4)
                        .addGap(0, 158, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(slidertotalCaixas, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botaoCancelar))
                                .addGap(105, 105, 105))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_qtd))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(label_qtd))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoSalvar)
                            .addComponent(botaoCancelar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(slidertotalCaixas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed

        //getModel pega as informações setadas na tabela
        TableModel tabelaVel = table_Veiculos.getModel();
        TableModel tabelaMot = table_Motoristas.getModel();

        //getSelectedRow pega o index da linha selecionada na tabela
        int linhaVeiculoSelecionado = table_Veiculos.getSelectedRow();
        int linhaMotoristaSelecionado = table_Motoristas.getSelectedRow();
        roteiroController = new RoteiroController();

        //if para verificar se todos os valores foram informados.
        if (totalCaixasSelecionadas > 0 && !table_Veiculos.getSelectionModel().isSelectionEmpty() && !table_Motoristas.getSelectionModel().isSelectionEmpty()) {

            //if para verificar se o motorista pode dirigir o caminhao selecionado
            if (TipoVeiculo.valueOf(tabelaVel.getValueAt(linhaVeiculoSelecionado, 0).toString()).getId()
                    <= TipoCNH.valueOf(tabelaMot.getValueAt(linhaMotoristaSelecionado, 2).toString()).getValorCNH()) {

                //if para verificar se o numero de caixas selecionadas é maior que o de caixas disponiveis
                if (totalCaixasSelecionadas <= quantidadeEncomendasRetornadas) {

                    //if para chamar o metodo de gerar roteiro retornando o resultado true ou false.
                    if (roteiroController.gerarRoteiro(tabelaMot.getValueAt(linhaMotoristaSelecionado, 1).toString(), tabelaVel.getValueAt(linhaVeiculoSelecionado, 1).toString(), totalCaixasSelecionadas) == true) {
                        JOptionPane.showMessageDialog(null, "Roteiro gerado com sucesso");
                    } else {
                        JOptionPane.showMessageDialog(null, "Falha ao gerar roteiro");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Numeros de caixas selecionadas maior que o disponível");
                }

            } else {
                JOptionPane.showMessageDialog(null, "O motorista selecionado nao possui habilitação para dirigir o veiculo");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!");
        }

    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void slidertotalCaixasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slidertotalCaixasStateChanged
        totalCaixasSelecionadas = slidertotalCaixas.getValue();
    }//GEN-LAST:event_slidertotalCaixasStateChanged

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaGerarRoteiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGerarRoteiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGerarRoteiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGerarRoteiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaGerarRoteiro().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel label_qtd;
    private javax.swing.JSlider slidertotalCaixas;
    private javax.swing.JTable table_Encomendas;
    private javax.swing.JTable table_Motoristas;
    private javax.swing.JTable table_Veiculos;
    // End of variables declaration//GEN-END:variables
}
