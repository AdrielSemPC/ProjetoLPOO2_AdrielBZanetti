/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lpoo.sistemaautescola.gui;

/**
 *
 * @author adrie
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
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

        barraMenu = new javax.swing.JMenuBar();
        btnCadastro = new javax.swing.JMenu();
        btnAluno = new javax.swing.JMenuItem();
        btnInstrutor = new javax.swing.JMenuItem();
        btnFuncionario = new javax.swing.JMenuItem();
        btnAgenda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCadastro.setText("Cadastro");

        btnAluno.setText("Novo Aluno");
        btnAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlunoActionPerformed(evt);
            }
        });
        btnCadastro.add(btnAluno);

        btnInstrutor.setText("Novo Instrutor");
        btnInstrutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInstrutorActionPerformed(evt);
            }
        });
        btnCadastro.add(btnInstrutor);

        btnFuncionario.setText("Novo Funcionário");
        btnFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncionarioActionPerformed(evt);
            }
        });
        btnCadastro.add(btnFuncionario);

        barraMenu.add(btnCadastro);

        btnAgenda.setText("Agenda");
        barraMenu.add(btnAgenda);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncionarioActionPerformed
        FuncionarioFrame telaFuncionario = new FuncionarioFrame();
        telaFuncionario.setVisible(true);
    }//GEN-LAST:event_btnFuncionarioActionPerformed

    private void btnAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlunoActionPerformed
        AlunoFrame telaAluno = new AlunoFrame();
        telaAluno.setVisible(true);
    }//GEN-LAST:event_btnAlunoActionPerformed

    private void btnInstrutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstrutorActionPerformed
        InstrutorFrame telaInstrutor = new InstrutorFrame();
        telaInstrutor.setVisible(true);
    }//GEN-LAST:event_btnInstrutorActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JMenu btnAgenda;
    private javax.swing.JMenuItem btnAluno;
    private javax.swing.JMenu btnCadastro;
    private javax.swing.JMenuItem btnFuncionario;
    private javax.swing.JMenuItem btnInstrutor;
    // End of variables declaration//GEN-END:variables
}
