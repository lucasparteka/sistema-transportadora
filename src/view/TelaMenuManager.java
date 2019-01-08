package view;

public class TelaMenuManager extends javax.swing.JFrame {

    private TelaAdicionarEncomenda aB = null;

    public TelaMenuManager() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        managerPanel = new javax.swing.JPanel();
        close = new javax.swing.JLabel();
        buttonAddBox = new javax.swing.JButton();
        btnNaoEntregues = new javax.swing.JButton();
        btnGerarRoteiro = new javax.swing.JButton();
        btnProcurarRoteiro = new javax.swing.JButton();
        btnGerarFeedback = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manager");
        setUndecorated(true);

        managerPanel.setBackground(new java.awt.Color(69, 90, 100));
        managerPanel.setMaximumSize(null);
        managerPanel.setPreferredSize(new java.awt.Dimension(1366, 768));

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icon_close.png"))); // NOI18N
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });

        buttonAddBox.setBackground(new java.awt.Color(255, 112, 67));
        buttonAddBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonAddBox.setForeground(new java.awt.Color(255, 255, 255));
        buttonAddBox.setText("Adicionar Encomenda");
        buttonAddBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddBoxActionPerformed(evt);
            }
        });

        btnNaoEntregues.setBackground(new java.awt.Color(255, 112, 67));
        btnNaoEntregues.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNaoEntregues.setForeground(new java.awt.Color(255, 255, 255));
        btnNaoEntregues.setText("Encomendas não entregues");
        btnNaoEntregues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNaoEntreguesActionPerformed(evt);
            }
        });

        btnGerarRoteiro.setBackground(new java.awt.Color(255, 112, 67));
        btnGerarRoteiro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGerarRoteiro.setForeground(new java.awt.Color(255, 255, 255));
        btnGerarRoteiro.setText("Gerar Roteiro");
        btnGerarRoteiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarRoteiroActionPerformed(evt);
            }
        });

        btnProcurarRoteiro.setBackground(new java.awt.Color(255, 112, 67));
        btnProcurarRoteiro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnProcurarRoteiro.setForeground(new java.awt.Color(255, 255, 255));
        btnProcurarRoteiro.setText("Procurar Roteiro");
        btnProcurarRoteiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarRoteiroActionPerformed(evt);
            }
        });

        btnGerarFeedback.setBackground(new java.awt.Color(255, 112, 67));
        btnGerarFeedback.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGerarFeedback.setForeground(new java.awt.Color(255, 255, 255));
        btnGerarFeedback.setText("Buscar Roteiros");
        btnGerarFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarFeedbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout managerPanelLayout = new javax.swing.GroupLayout(managerPanel);
        managerPanel.setLayout(managerPanelLayout);
        managerPanelLayout.setHorizontalGroup(
            managerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(managerPanelLayout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addGroup(managerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, managerPanelLayout.createSequentialGroup()
                        .addComponent(close)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, managerPanelLayout.createSequentialGroup()
                        .addGroup(managerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnNaoEntregues, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonAddBox, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
                        .addGap(709, 709, 709)
                        .addGroup(managerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGerarFeedback, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGerarRoteiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnProcurarRoteiro, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(89, 89, 89))))
        );
        managerPanelLayout.setVerticalGroup(
            managerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(managerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(close)
                .addGap(66, 66, 66)
                .addGroup(managerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(managerPanelLayout.createSequentialGroup()
                        .addComponent(buttonAddBox, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnNaoEntregues, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(managerPanelLayout.createSequentialGroup()
                        .addGroup(managerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(managerPanelLayout.createSequentialGroup()
                                .addComponent(btnGerarRoteiro, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(136, 136, 136))
                            .addComponent(btnProcurarRoteiro, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addComponent(btnGerarFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(303, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(managerPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(managerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked

        if (aB != null) {
            aB.close();
        }
        this.dispose();

    }//GEN-LAST:event_closeMouseClicked


    private void buttonAddBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddBoxActionPerformed
        aB = new TelaAdicionarEncomenda();
        aB.setVisible(true);
    }//GEN-LAST:event_buttonAddBoxActionPerformed

    private void btnNaoEntreguesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNaoEntreguesActionPerformed
        TelaEncomendasNaoEntregues tne = new TelaEncomendasNaoEntregues();
        tne.setVisible(true);
    }//GEN-LAST:event_btnNaoEntreguesActionPerformed

    private void btnGerarRoteiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarRoteiroActionPerformed
        // TODO add your handling code here:
        TelaGerarRoteiro s = new TelaGerarRoteiro();
        s.setVisible(true);
    }//GEN-LAST:event_btnGerarRoteiroActionPerformed

    private void btnProcurarRoteiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarRoteiroActionPerformed
        // TODO add your handling code here:
        TelaProcurarRoteiros p = new TelaProcurarRoteiros();
        p.setVisible(true);
    }//GEN-LAST:event_btnProcurarRoteiroActionPerformed

    private void btnGerarFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarFeedbackActionPerformed
        // TODO add your handling code here:
        TelaGerenciarRoteiros tfm = new TelaGerenciarRoteiros();
        tfm.setVisible(true);
    }//GEN-LAST:event_btnGerarFeedbackActionPerformed

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
            java.util.logging.Logger.getLogger(TelaMenuManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMenuManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMenuManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMenuManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMenuManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerarFeedback;
    private javax.swing.JButton btnGerarRoteiro;
    private javax.swing.JButton btnNaoEntregues;
    private javax.swing.JButton btnProcurarRoteiro;
    private javax.swing.JButton buttonAddBox;
    private javax.swing.JLabel close;
    private javax.swing.JPanel managerPanel;
    // End of variables declaration//GEN-END:variables
}
