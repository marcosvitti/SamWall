package screens;

import controller.ControllerNF;
import controller.ControllerPC;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddProd extends javax.swing.JFrame {

    private final String login;
    private final ArrayList<Integer> update;
    public int gIdPC;
    public int gIdNF;
    public AddProd(String login, String action, int idPC, boolean jPanel, int nF) {
        
        initComponents(); // Inicia Componentes do frame de addProd
        jLabel14.setText(action); // Defini o nome da função desempenhada

        gIdPC = idPC;
        gIdNF = nF;

        jPanel1.setVisible(jPanel);
        jPanel2.setVisible(!jPanel);

        ControllerPC.listarPd(jTable1, gIdPC);
        jTable1.getSelectionModel().addListSelectionListener((e) -> {
            if (!e.getValueIsAdjusting()) {
                arrayUpdade();
            }
        });
        EditPd.setVisible(false);
        this.login = login;
        this.update = new ArrayList<>();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
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
        jlabelId.setText("");// campo para ccarregar o 
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
        jPanel2 = new javax.swing.JPanel();
        Rejeitar = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel29 = new javax.swing.JLabel();
        jlabelId1 = new javax.swing.JLabel();
        Aceitar = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel31 = new javax.swing.JLabel();
        Exit1 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldQtd = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldPcUnit = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldPT = new javax.swing.JTextField();
        Exit = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        cleanUser = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        DelPD = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jTextFieldProd = new javax.swing.JTextField();
        jlabelId = new javax.swing.JLabel();
        AddPd = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        EditPd = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
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
                "Produto", "Quantidade", "Preço unitário", "Preço Total", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            jTable1.getColumnModel().getColumn(4).setMinWidth(0);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 1060, 610));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 1120, 710));

        jPanel2.setBackground(new java.awt.Color(84, 127, 206));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Rejeitar.setBackground(new java.awt.Color(71, 120, 197));
        Rejeitar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Rejeitar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RejeitarMouseClicked(evt);
            }
        });
        Rejeitar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/icons8_xbox_x_32px.png"))); // NOI18N
        Rejeitar.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 30, 25));
        Rejeitar.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 220, 10));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Rejeitar");
        Rejeitar.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 190, 48));

        jPanel2.add(Rejeitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 240, 130));

        jlabelId1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jlabelId1.setForeground(new java.awt.Color(255, 255, 255));
        jlabelId1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel2.add(jlabelId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 290, 30));

        Aceitar.setBackground(new java.awt.Color(71, 120, 197));
        Aceitar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Aceitar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AceitarMouseClicked(evt);
            }
        });
        Aceitar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/icons8_checked_32px.png"))); // NOI18N
        Aceitar.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 6, 30, -1));
        Aceitar.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 220, 10));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Aceitar");
        Aceitar.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 190, 48));

        jPanel2.add(Aceitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 240, 130));

        Exit1.setBackground(new java.awt.Color(71, 120, 197));
        Exit1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Exit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Exit1MouseClicked(evt);
            }
        });
        Exit1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/icons8_back_to_32px.png"))); // NOI18N
        Exit1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));
        Exit1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 120, 10));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Sair");
        Exit1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 190, 48));

        jPanel2.add(Exit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 150, 130));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 710));

        jPanel1.setBackground(new java.awt.Color(84, 127, 206));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel1.add(jTextFieldQtd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 90, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Quantidade");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 290, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Preço Unitário :  ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 290, 30));

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
        jPanel1.add(jTextFieldPcUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 150, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Preço Total");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 290, 30));

        jTextFieldPT.setEditable(false);
        jTextFieldPT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldPT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldsKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFieldPT, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 150, -1));

        Exit.setBackground(new java.awt.Color(71, 120, 197));
        Exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitMouseClicked(evt);
            }
        });
        Exit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/icons8_back_to_32px.png"))); // NOI18N
        Exit.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));
        Exit.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 180, 10));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Sair");
        Exit.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 190, 48));

        jPanel1.add(Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 510, 200, 130));

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

        jPanel1.add(cleanUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 200, 130));

        DelPD.setBackground(new java.awt.Color(71, 120, 197));
        DelPD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DelPD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DelPDMouseClicked(evt);
            }
        });
        DelPD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/icon_close.png"))); // NOI18N
        DelPD.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 25, 25));
        DelPD.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 180, 10));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Remover Item");
        DelPD.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 190, 48));

        jPanel1.add(DelPD, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 200, 130));

        jTextFieldProd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jTextFieldProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 290, -1));

        jlabelId.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jlabelId.setForeground(new java.awt.Color(255, 255, 255));
        jlabelId.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jlabelId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 290, 30));

        AddPd.setBackground(new java.awt.Color(71, 120, 197));
        AddPd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddPd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddPdMouseClicked(evt);
            }
        });
        AddPd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/icons8_save_26px.png"))); // NOI18N
        AddPd.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 25, 25));
        AddPd.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 180, 10));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Incluir Item");
        AddPd.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 190, 48));

        jPanel1.add(AddPd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 200, 130));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Produto:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 290, 30));

        EditPd.setBackground(new java.awt.Color(71, 120, 197));
        EditPd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EditPd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditPdMouseClicked(evt);
            }
        });
        EditPd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/icons8_save_26px.png"))); // NOI18N
        EditPd.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 25, 25));
        EditPd.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 180, 10));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Gravar Alteração");
        EditPd.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 190, 48));

        jPanel1.add(EditPd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 200, 130));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cleanUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cleanUserMouseClicked
        //Método para limpar os campos de input
        limpaCampos(); // Chama o método para limpar os campos
        ControllerPC.listarPd(jTable1, gIdPC);
    }//GEN-LAST:event_cleanUserMouseClicked

    private void DelPDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DelPDMouseClicked
      ControllerPC.delPD( new String[] {jlabelId.getText()}); 
      limpaCampos(); // Chama o método para limpar os campos
      ControllerPC.listarPd(jTable1, gIdPC);
    }//GEN-LAST:event_DelPDMouseClicked

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
        String totalG = Double.toString(total);
        jTextFieldPT.setText(totalG);
    }//GEN-LAST:event_jTextFieldQtdFocusLost

    private void jTextFieldPcUnitFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPcUnitFocusLost
        String valor=jTextFieldPcUnit.getText();
        String qtd = jTextFieldQtd.getText();
        Double total= Double.parseDouble(valor) * Double.parseDouble(qtd);
        String totalG = Double.toString(total);
        jTextFieldPT.setText(totalG);
    }//GEN-LAST:event_jTextFieldPcUnitFocusLost

    private void AddPdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddPdMouseClicked
      ControllerPC.criarPD(new String[] {jTextFieldProd.getText(),jTextFieldQtd.getText(), jTextFieldPcUnit.getText()},gIdPC); 
      limpaCampos(); // Chama o método para limpar os campos
      ControllerPC.listarPd(jTable1, gIdPC);
    }//GEN-LAST:event_AddPdMouseClicked

    private void EditPdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditPdMouseClicked
       ControllerPC.updPD(new String[] {jTextFieldProd.getText(),jTextFieldQtd.getText(), jTextFieldPcUnit.getText(),jlabelId.getText()}); 
      limpaCampos(); // Chama o método para limpar os campos
      ControllerPC.listarPd(jTable1, gIdPC);
      AddPd.setVisible(true);
      EditPd.setVisible(false);
    }//GEN-LAST:event_EditPdMouseClicked

    private void ExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseClicked
       try {
            ControllerPC.totalPC(gIdPC);
            ControllerNF.listNF(login, "Listagem de Notas Fiscais");
        } catch (SQLException ex) {
            Logger.getLogger(AddProd.class.getName()).log(Level.SEVERE, null, ex);
        } finally{

        this.dispose();
    }
    }//GEN-LAST:event_ExitMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    
    }//GEN-LAST:event_formWindowClosed

    private void RejeitarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RejeitarMouseClicked
        // TODO add your handling code here:
        ControllerPC.acao(0, this.gIdNF);
        ControllerNF.listNF(login, "Listagem de Notas Fiscais");
        this.dispose();
    }//GEN-LAST:event_RejeitarMouseClicked

    private void AceitarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AceitarMouseClicked
        // TODO add your handling code here:
        ControllerPC.acao(1, this.gIdNF);
        ControllerNF.listNF(login, "Listagem de Notas Fiscais");
        this.dispose();
    }//GEN-LAST:event_AceitarMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int totalRows = jTable1.getRowCount();

            for (int i = 0; i < totalRows; i++) {
                jTextFieldProd.setText((String) jTable1.getModel().getValueAt(i, 0));
                jTextFieldQtd.setText((String) jTable1.getModel().getValueAt(i, 1));
                jTextFieldPcUnit.setText((String) jTable1.getModel().getValueAt(i, 2));
                jTextFieldPT.setText((String) jTable1.getModel().getValueAt(i, 3));
                jlabelId.setText((String) jTable1.getModel().getValueAt(i,4));

                AddPd.setVisible(false);
                EditPd.setVisible(true);
            }
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void Exit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Exit1MouseClicked
        // TODO add your handling code here:
        try {
            ControllerPC.totalPC(gIdPC);
            ControllerNF.listNF(login, "Listagem de Notas Fiscais");
        } catch (SQLException ex) {
            Logger.getLogger(AddProd.class.getName()).log(Level.SEVERE, null, ex);
        } finally{

            this.dispose();
        }
    }//GEN-LAST:event_Exit1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Aceitar;
    private javax.swing.JPanel AddPd;
    private javax.swing.JPanel DelPD;
    private javax.swing.JPanel EditPd;
    private javax.swing.JPanel Exit;
    private javax.swing.JPanel Exit1;
    private javax.swing.JPanel Rejeitar;
    private javax.swing.JPanel cleanUser;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldPT;
    private javax.swing.JTextField jTextFieldPcUnit;
    private javax.swing.JTextField jTextFieldProd;
    private javax.swing.JTextField jTextFieldQtd;
    private javax.swing.JLabel jlabelId;
    private javax.swing.JLabel jlabelId1;
    // End of variables declaration//GEN-END:variables

}
