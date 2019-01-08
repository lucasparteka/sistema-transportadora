/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JFrame;

/**
 *
 * @author Lucas
 */
public class TelaMenuRegister extends javax.swing.JFrame {

    private TelaAdicionarMotorista aD = null;
    private TelaMotoristasCadastrados sD = null;
    private TelaAdicionarVeiculo aV = null;
    private TelaVeiculosCadastrados sV = null;
    public TelaMenuRegister() {
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

        registerPanel = new javax.swing.JPanel();
        close = new javax.swing.JLabel();
        buttonAddDriver = new javax.swing.JButton();
        buttonShowDriver = new javax.swing.JButton();
        buttonAddVehicle = new javax.swing.JButton();
        buttonShowVehicle = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setTitle("Register");
        setUndecorated(true);

        registerPanel.setBackground(new java.awt.Color(69, 90, 100));
        registerPanel.setPreferredSize(new java.awt.Dimension(500, 600));

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icon_close.png"))); // NOI18N
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });

        buttonAddDriver.setBackground(new java.awt.Color(255, 112, 67));
        buttonAddDriver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/addDriver.png"))); // NOI18N
        buttonAddDriver.setMaximumSize(new java.awt.Dimension(100, 25));
        buttonAddDriver.setMinimumSize(new java.awt.Dimension(100, 25));
        buttonAddDriver.setPreferredSize(new java.awt.Dimension(100, 25));
        buttonAddDriver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddDriverActionPerformed(evt);
            }
        });

        buttonShowDriver.setBackground(new java.awt.Color(255, 112, 67));
        buttonShowDriver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/showDriver.png"))); // NOI18N
        buttonShowDriver.setMaximumSize(new java.awt.Dimension(100, 25));
        buttonShowDriver.setMinimumSize(new java.awt.Dimension(100, 25));
        buttonShowDriver.setPreferredSize(new java.awt.Dimension(100, 25));
        buttonShowDriver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonShowDriverActionPerformed(evt);
            }
        });

        buttonAddVehicle.setBackground(new java.awt.Color(255, 112, 67));
        buttonAddVehicle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/addVehicle.png"))); // NOI18N
        buttonAddVehicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddVehicleActionPerformed(evt);
            }
        });

        buttonShowVehicle.setBackground(new java.awt.Color(255, 112, 67));
        buttonShowVehicle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/showVehicle.png"))); // NOI18N
        buttonShowVehicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonShowVehicleActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/vehicle.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/driver.png"))); // NOI18N

        javax.swing.GroupLayout registerPanelLayout = new javax.swing.GroupLayout(registerPanel);
        registerPanel.setLayout(registerPanelLayout);
        registerPanelLayout.setHorizontalGroup(
            registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerPanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(buttonAddDriver, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonShowDriver, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, registerPanelLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 460, Short.MAX_VALUE)
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(126, 126, 126)
                        .addComponent(close)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerPanelLayout.createSequentialGroup()
                        .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonShowVehicle, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonAddVehicle, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51))))
        );
        registerPanelLayout.setVerticalGroup(
            registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerPanelLayout.createSequentialGroup()
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registerPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(close))
                    .addGroup(registerPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonAddDriver, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAddVehicle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106)
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonShowDriver, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonShowVehicle, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(322, 322, 322))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked

        if (aD != null) {

            aD.close();

        }
        
        if (sD != null) {
            sD.close();
        }
        if (aV != null) {
            aV.close();
        }
     
        if (sV != null) {
            sV.close();
        }

        this.dispose();

    }//GEN-LAST:event_closeMouseClicked

    private void buttonShowVehicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonShowVehicleActionPerformed
        sV = new TelaVeiculosCadastrados();
        sV.setVisible(true);
    }//GEN-LAST:event_buttonShowVehicleActionPerformed

    private void buttonAddDriverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddDriverActionPerformed

        aD = new TelaAdicionarMotorista();
        aD.setVisible(true);


    }//GEN-LAST:event_buttonAddDriverActionPerformed

    private void buttonAddVehicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddVehicleActionPerformed
        aV = new TelaAdicionarVeiculo();

        aV.setVisible(true);
    }//GEN-LAST:event_buttonAddVehicleActionPerformed

    private void buttonShowDriverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonShowDriverActionPerformed
        sD = new TelaMotoristasCadastrados();
        sD.setVisible(true);
    }//GEN-LAST:event_buttonShowDriverActionPerformed

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
            java.util.logging.Logger.getLogger(TelaMenuRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMenuRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMenuRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMenuRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMenuRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddDriver;
    private javax.swing.JButton buttonAddVehicle;
    private javax.swing.JButton buttonShowDriver;
    private javax.swing.JButton buttonShowVehicle;
    private javax.swing.JLabel close;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel registerPanel;
    // End of variables declaration//GEN-END:variables
}