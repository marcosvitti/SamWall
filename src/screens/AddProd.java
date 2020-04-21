package screens;

import controller.ControllerPC;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddProd extends javax.swing.JFrame {

    private final String login;
    private final ArrayList<Integer> update;
    public int gIdPC;
    public AddProd(String login, String action, int idPC) {
        initComponents(); // Inicia Componentes do frame de addProd
        jLabel14.setText(action); // Defini o nome da função desempenhada
        
        jTable1 = ControllerPC.listarPd(jTable1, idPC); // Chamada do método responsável por listar os colaboradores do sistema
        gIdPC = idPC;
        jTable1.getSelectionModel().addListSelectionListener((e) -> {
            if (!e.getValueIsAdjusting()) {
                arrayUpdade();
            }
        });

        this.login = login;
        this.update = new ArrayList<>();
    }


    @Override
    public Image getIconImage() { // Método para alterar o icone da barra de tarefas
        return Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("pictures/iconLogoBar.png")); // Seta uma imagem como ícone
    } // Fim do método para alterar o icone da barra de tarefas

    private void limpaCampos() { // Método para limpar campos do formulário
        jTextFieldProd.setText("");// Limpa campo Produto
        jTextFieldQtd.setText(""); // Limpa campo Quantidade
        jTextFieldPcUnit.setText(""); // Limpa campo Preço unitário
        jTextFieldPT.setText(""); // Limpa campo Preço Total
        
    }

    private void arrayUpdade() {
        if (jTable1.getSelectedRow() > -1) {
            update.add(jTable1.getSelectedRow());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldQtd = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldPcUnit = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldPT = new javax.swing.JTextField();
        cleanUser = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        AddPd = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jTextFieldProd = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(71, 120, 197));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Lista de Produtos");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1120, 40));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(71, 120, 197)));
        jScrollPane1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Quantidade", "Preço unitário", "Preço Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setGridColor(new java.awt.Color(71, 120, 197));
        jTable1.setRowHeight(40);
        jTable1.setSelectionBackground(new java.awt.Color(49, 162, 252));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setSurrendersFocusOnKeystroke(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(130);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(130);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(80);
        }

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 1060, 610));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 1120, 710));

        jPanel1.setBackground(new java.awt.Color(84, 127, 206));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 550, 40));

        jTextFieldQtd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldQtd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldQtdFocusLost(evt);
            }
        });
        jTextFieldQtd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldsKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFieldQtd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 290, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Quantidade");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 290, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Preço Unitário :  ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 290, 30));

        jTextFieldPcUnit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldPcUnit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldPcUnitFocusLost(evt);
            }
        });
        jTextFieldPcUnit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldsKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFieldPcUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 290, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Preço Total");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 290, 30));

        jTextFieldPT.setEditable(false);
        jTextFieldPT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldPT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldsKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFieldPT, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 290, -1));

        cleanUser.setBackground(new java.awt.Color(71, 120, 197));
        cleanUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cleanUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cleanUserMouseClicked(evt);
            }
        });
        cleanUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/icons8_eraser_24px.png"))); // NOI18N
        cleanUser.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 13, 30, 25));
        cleanUser.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 180, 10));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Limpar Campos");
        cleanUser.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 190, 48));

        jPanel1.add(cleanUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, 200, 130));

        AddPd.setBackground(new java.awt.Color(71, 120, 197));
        AddPd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddPd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddPdMouseClicked(evt);
            }
        });
        AddPd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/icons8_save_26px.png"))); // NOI18N
        AddPd.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 25, 25));
        AddPd.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 180, 10));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Incluir Item");
        AddPd.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 190, 48));

        jPanel1.add(AddPd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 200, 130));

        jTextFieldProd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jTextFieldProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 290, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Produto:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 290, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cleanUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cleanUserMouseClicked
        //Método para limpar os campos de input
        limpaCampos(); // Chama o método para limpar os campos
        ControllerPC.listarPd(jTable1, gIdPC);
    }//GEN-LAST:event_cleanUserMouseClicked

    private void AddPdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddPdMouseClicked

      ControllerPC.criarPD(new String[] {jTextFieldProd.getText(),jTextFieldQtd.getText(), jTextFieldPcUnit.getText()},gIdPC); 
      ControllerPC.listarPd(jTable1, gIdPC);
    }//GEN-LAST:event_AddPdMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
//        // TODO add your handling code here:
//        if (evt.getClickCount() == 2) {
//            ControllerPC.main(login, null, Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString()));
//            dispose();
//        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextFieldsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldsKeyTyped
        // Método usado para verificar a entrada do usuário para evitar SQLInjection
        Matcher matcher = Pattern.compile("[^0-9|,]").matcher(Character.toString(evt.getKeyChar())); // Compara o caractere digitado com a expressão regular
        if (matcher.find()) { // Se achar o caractere imprópio 
            evt.consume();// Não deixa ele ser escrito
        } // Fim da vetificação
    }//GEN-LAST:event_jTextFieldsKeyTyped

    private void jTextFieldQtdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldQtdFocusLost
        String valor=jTextFieldPcUnit.getText();
        String qtd = jTextFieldQtd.getText();
        Double total= Double.parseDouble(valor) * Double.parseDouble(qtd);
        
        jTextFieldPT.setText(Double.toString(total));
    }//GEN-LAST:event_jTextFieldQtdFocusLost

    private void jTextFieldPcUnitFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPcUnitFocusLost
        String valor=jTextFieldPcUnit.getText();
        String qtd = jTextFieldQtd.getText();
        Double total= Double.parseDouble(valor)* Double.parseDouble(qtd);
        
        jTextFieldPT.setText(Double.toString(total));
    }//GEN-LAST:event_jTextFieldPcUnitFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddPd;
    private javax.swing.JPanel cleanUser;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldPT;
    private javax.swing.JTextField jTextFieldPcUnit;
    private javax.swing.JTextField jTextFieldProd;
    private javax.swing.JTextField jTextFieldQtd;
    // End of variables declaration//GEN-END:variables

}
