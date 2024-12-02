/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.a3.testpsc;

import java.awt.Color;
import javax.swing.JOptionPane;
//tentando
/**
 *
 * @author layon
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form ForgotPassword
     */
    public Menu() {
        initComponents();
        jTextFieldEmail.setBackground(new Color(0, 0, 0, 1));
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextFieldEmail = new javax.swing.JTextField();
        EditCard = new javax.swing.JButton();
        AddCard = new javax.swing.JButton();
        ListCards = new javax.swing.JButton();
        DeleteCard = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Recuperar Senha");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 90, 60, 20));

        jButton2.setToolTipText("");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 60, 170, 20));

        jTextFieldEmail.setToolTipText("");
        jTextFieldEmail.setBorder(null);
        jTextFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEmailActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 64, 170, 20));

        EditCard.setBorder(null);
        EditCard.setBorderPainted(false);
        EditCard.setContentAreaFilled(false);
        EditCard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EditCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditCardActionPerformed(evt);
            }
        });
        getContentPane().add(EditCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 110, 30));

        AddCard.setBorder(null);
        AddCard.setBorderPainted(false);
        AddCard.setContentAreaFilled(false);
        AddCard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCardActionPerformed(evt);
            }
        });
        getContentPane().add(AddCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 120, 30));

        ListCards.setBorder(null);
        ListCards.setBorderPainted(false);
        ListCards.setContentAreaFilled(false);
        ListCards.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ListCards.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListCardsActionPerformed(evt);
            }
        });
        getContentPane().add(ListCards, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 170, 120, 30));

        DeleteCard.setBorder(null);
        DeleteCard.setBorderPainted(false);
        DeleteCard.setContentAreaFilled(false);
        DeleteCard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DeleteCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteCardActionPerformed(evt);
            }
        });
        getContentPane().add(DeleteCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 170, 140, 30));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Facul USJT\\Programaçao de Software\\Projeto A3\\Imagens\\Menu2.png")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, -2, 1280, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CrudBD crudBD = new CrudBD();
        String email = jTextFieldEmail.getText();

        if (email == null || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo de email está vazio!");
        } else {
            boolean emailCheck = crudBD.recuperarreg(email);

            if (emailCheck) {
                boolean deleted = crudBD.excluirReg(email);
                if (deleted) {
                    JOptionPane.showMessageDialog(null, "Conta deletada com sucesso.");
                    this.setVisible(false);
                    Login login = new Login();
                    login.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao deletar a conta.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Email não encontrado.");
            }
        }



    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmailActionPerformed

    }//GEN-LAST:event_jTextFieldEmailActionPerformed

    private void EditCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditCardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditCardActionPerformed

    private void AddCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCardActionPerformed
       Cartas carta = new Cartas();
       CrudCarta crudCarta = new CrudCarta();

        carta.setNome(JOptionPane.showInputDialog("Digite o nome da carta: "));
        carta.setTipo(JOptionPane.showInputDialog("Digite o tipo da carta: "));
        carta.setAtributo(JOptionPane.showInputDialog("Digite o atributo da carta: "));
        carta.setEfeito(JOptionPane.showInputDialog("Digite o efeito da carta: "));
        carta.setNivel(Integer.parseInt(JOptionPane.showInputDialog("Digite o nivel da carta: ")));
        carta.setAtaque(Integer.parseInt(JOptionPane.showInputDialog("Digite o ataque da carta: ")));
        carta.setDefesa(Integer.parseInt(JOptionPane.showInputDialog("Digite a defesa da carta: ")));

        crudCarta.InsertCarta(carta);

        String email = JOptionPane.showInputDialog("Digite o email do usuário para confirmação: ");
        int idUsuario = crudCarta.GetUsuarioByEmail(email);

        crudCarta.InsertCartaUsuario(carta.getNumero(), idUsuario);

        JOptionPane.showMessageDialog(null, "Carta cadastrada com sucesso!");
    }//GEN-LAST:event_AddCardActionPerformed

    private void ListCardsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListCardsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ListCardsActionPerformed

    private void DeleteCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteCardActionPerformed
        
    }//GEN-LAST:event_DeleteCardActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCard;
    private javax.swing.JButton DeleteCard;
    private javax.swing.JButton EditCard;
    private javax.swing.JButton ListCards;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextFieldEmail;
    // End of variables declaration//GEN-END:variables
}
