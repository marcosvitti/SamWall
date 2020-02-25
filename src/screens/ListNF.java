package screens;

import dataBase.DataBase;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListNF extends javax.swing.JFrame {

    private DataBase con = DataBase.getInstance();
    private String userName;

    public ListNF(String username, DataBase con) {
        initComponents();
        userName = username;
        this.username.setText(buscarLogin(username));
        //listarNfs();
        this.setLocationRelativeTo(null);
    }

//    private void listarNfs() {
//        try {
//            ((DefaultTableModel) jTableNF.getModel()).setRowCount(0);
//            ResultSet result = con.stm.executeQuery("SELECT ID_NF_A, NUM_NF, DATA_ENTRADA, VALOR_NF, STATUS_NF FROM NF_A ORDER BY ID_NF_A");
//            while (result.next()) {
//                int id = result.getInt(1);
//                String numNF = result.getString(2);
//                String dataE = result.getString(3);
//                Double valorNF = result.getDouble(4);
//                String StatusNF = result.getString(5);
//
//                if (StatusNF.equals("A")) {
//                    StatusNF = "Aprovado";
//                } else if (StatusNF.equals("R")) {
//                    StatusNF = "Reprovado";
//                } else if (StatusNF.equals("P")) {
//                    StatusNF = "Reprovado";
//                }
//
//                String linha[] = {String.valueOf(id),
//                    numNF,
//                    dataE,
//                    String.valueOf(valorNF),
//                    StatusNF};
//                ((DefaultTableModel) jTableNF.getModel()).addRow(linha);
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//    private void listarNf_S_A() {
//        try {
//            ((DefaultTableModel) jTableNF.getModel()).setRowCount(0);
//            ResultSet result = con.stm.executeQuery("SELECT ID_NF_A, NUM_NF, DATA_ENTRADA, VALOR_NF, STATUS_NF FROM NF_A WHERE STATUS_NF = 'A' ORDER BY ID_NF_A");
//            while (result.next()) {
//                int id = result.getInt(1);
//                String numNF = result.getString(2);
//                String dataE = result.getString(3);
//                Double valorNF = result.getDouble(4);
//                String StatusNF = result.getString(5);
//
//                if (StatusNF.equals("A")) {
//                    StatusNF = "Aprovado";
//                } else if (StatusNF.equals("R")) {
//                    StatusNF = "Reprovado";
//                } else if (StatusNF.equals("P")) {
//                    StatusNF = "Pendente";
//                }
//
//                String linha[] = {String.valueOf(id),
//                    numNF,
//                    dataE,
//                    String.valueOf(valorNF),
//                    StatusNF};
//                ((DefaultTableModel) jTableNF.getModel()).addRow(linha);
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//    private void listarNf_S_R() {
//        try {
//            ((DefaultTableModel) jTableNF.getModel()).setRowCount(0);
//            ResultSet result = con.stm.executeQuery("SELECT ID_NF_A, NUM_NF, DATA_ENTRADA, VALOR_NF, STATUS_NF FROM NF_A WHERE STATUS_NF = 'R' ORDER BY ID_NF_A");
//            while (result.next()) {
//                int id = result.getInt(1);
//                String numNF = result.getString(2);
//                String dataE = result.getString(3);
//                Double valorNF = result.getDouble(4);
//                String StatusNF = result.getString(5);
//
//                switch (StatusNF) {
//                    case "A":
//                        StatusNF = "Aprovado";
//                        break;
//                    case "R":
//                        StatusNF = "Reprovado";
//                        break;
//                    case "P":
//                        StatusNF = "Pendente";
//                        break;
//                }
//
//                String linha[] = {String.valueOf(id),
//                    numNF,
//                    dataE,
//                    String.valueOf(valorNF),
//                    StatusNF};
//                ((DefaultTableModel) jTableNF.getModel()).addRow(linha);
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//    private void listarNf_S_P() {
//        try {
//            ((DefaultTableModel) jTableNF.getModel()).setRowCount(0);
//            ResultSet result = con.stm.executeQuery("SELECT ID_NF_A, NUM_NF, DATA_ENTRADA, VALOR_NF, STATUS_NF FROM NF_A WHERE STATUS_NF = 'P' ORDER BY ID_NF_A");
//            while (result.next()) {
//                int id = result.getInt(1);
//                String numNF = result.getString(2);
//                String dataE = result.getString(3);
//                Double valorNF = result.getDouble(4);
//                String StatusNF = result.getString(5);
//
//                if (StatusNF.equals("A")) {
//                    StatusNF = "Aprovado";
//                } else if (StatusNF.equals("R")) {
//                    StatusNF = "Reprovado";
//                } else if (StatusNF.equals("P")) {
//                    StatusNF = "Pendente";
//                }
//
//                String linha[] = {String.valueOf(id),
//                    numNF,
//                    dataE,
//                    String.valueOf(valorNF),
//                    StatusNF};
//                ((DefaultTableModel) jTableNF.getModel()).addRow(linha);
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
//        }
//    }

    private String carregarCampos(int linha) {
        DefaultTableModel model = (DefaultTableModel) jTableNF.getModel();
        //int id = (Integer)model.getValueAt(linha, 0);
        String numNF = ((String) model.getValueAt(linha, 1));
        //String dataE=((String)model.getValueAt(linha, 1));
        // Double valorNF =((Double)model.getValueAt(linha, 2));
        //String StatusNF=((String)model.getValueAt(linha, 3));

        return numNF;
    }

    public String buscarLogin(String username) {
        String userLogin = "";
        try {
            userLogin = con.buscaLogin(username);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Usuário não encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return userLogin;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioPendentes = new javax.swing.JRadioButton();
        jRadioReprovados = new javax.swing.JRadioButton();
        jRadioTodos = new javax.swing.JRadioButton();
        jRadioAprovados = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableNF = new javax.swing.JTable();
        returnScreen = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jRadioPendentes.setText("Pendentes");
        jRadioPendentes.setBorder(null);
        jRadioPendentes.setOpaque(false);
        jRadioPendentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioPendentesActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioPendentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, -1, -1));

        jRadioReprovados.setText("Reprovados");
        jRadioReprovados.setBorder(null);
        jRadioReprovados.setOpaque(false);
        jRadioReprovados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioReprovadosActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioReprovados, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, -1, -1));

        jRadioTodos.setSelected(true);
        jRadioTodos.setText("Todos");
        jRadioTodos.setBorder(null);
        jRadioTodos.setOpaque(false);
        jRadioTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioTodosActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, -1, -1));

        jRadioAprovados.setText("Aprovados");
        jRadioAprovados.setBorder(null);
        jRadioAprovados.setOpaque(false);
        jRadioAprovados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioAprovadosActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioAprovados, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, -1, -1));

        jScrollPane1.setOpaque(false);

        jTableNF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NF", "Emissão", "Valor", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableNF.setOpaque(false);
        jTableNF.getTableHeader().setResizingAllowed(false);
        jTableNF.getTableHeader().setReorderingAllowed(false);
        jTableNF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableNFMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableNF);
        if (jTableNF.getColumnModel().getColumnCount() > 0) {
            jTableNF.getColumnModel().getColumn(0).setMaxWidth(100);
            jTableNF.getColumnModel().getColumn(1).setResizable(false);
            jTableNF.getColumnModel().getColumn(2).setMaxWidth(100);
            jTableNF.getColumnModel().getColumn(3).setResizable(false);
            jTableNF.getColumnModel().getColumn(4).setMaxWidth(150);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 141, 620, 430));

        returnScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/iconBack.png"))); // NOI18N
        returnScreen.setBorder(null);
        returnScreen.setBorderPainted(false);
        returnScreen.setContentAreaFilled(false);
        returnScreen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        returnScreen.setFocusPainted(false);
        returnScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnScreenActionPerformed(evt);
            }
        });
        getContentPane().add(returnScreen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/iconsExit.png"))); // NOI18N
        exit.setBorder(null);
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.setFocusPainted(false);
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/background2.0.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 590));

        username.setText("jLabel2");
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void returnScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnScreenActionPerformed
        // Botão para voltar à tela anterior
        Main main = new Main(username.getText());
        main.setVisible(true);
        dispose();
    }//GEN-LAST:event_returnScreenActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // Fecha o programa (tem q fechar a conexão com o banco)
        con.disconnection();
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void jRadioPendentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioPendentesActionPerformed
        jRadioReprovados.setSelected(false);
        jRadioTodos.setSelected(false);
        jRadioAprovados.setSelected(false);
        jRadioPendentes.setSelected(true);
        //listarNf_S_P();

    }//GEN-LAST:event_jRadioPendentesActionPerformed

    private void jRadioReprovadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioReprovadosActionPerformed
        jRadioTodos.setSelected(false);
        jRadioPendentes.setSelected(false);
        jRadioAprovados.setSelected(false);
        jRadioReprovados.setSelected(true);
        //listarNf_S_R();
    }//GEN-LAST:event_jRadioReprovadosActionPerformed

    private void jRadioTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioTodosActionPerformed
        jRadioReprovados.setSelected(false);
        jRadioPendentes.setSelected(false);
        jRadioAprovados.setSelected(false);
        jRadioTodos.setSelected(true);
        //listarNfs();
    }//GEN-LAST:event_jRadioTodosActionPerformed

    private void jRadioAprovadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioAprovadosActionPerformed
        jRadioReprovados.setSelected(false);
        jRadioPendentes.setSelected(false);
        jRadioTodos.setSelected(false);
        jRadioAprovados.setSelected(true);
        //listarNf_S_A();
    }//GEN-LAST:event_jRadioAprovadosActionPerformed

    private void jTableNFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableNFMouseClicked
        if (jTableNF.isEnabled()) {
            if (evt.getClickCount() == 2) {
                String nF = carregarCampos(jTableNF.getSelectedRow());
                try {
                    con.selectNFCommandSQL("SELECT * FROM nf_a WHERE NUM_NF='" + nF + "'");
                    SearchNF s = new SearchNF(userName, con, nF);
                    s.setVisible(true);
                    dispose();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao carregar a NF-e", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jTableNFMouseClicked

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        // TODO add your handling code here:
        //this.requestFocus();
    }//GEN-LAST:event_formWindowLostFocus

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioAprovados;
    private javax.swing.JRadioButton jRadioPendentes;
    private javax.swing.JRadioButton jRadioReprovados;
    private javax.swing.JRadioButton jRadioTodos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableNF;
    private javax.swing.JButton returnScreen;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
