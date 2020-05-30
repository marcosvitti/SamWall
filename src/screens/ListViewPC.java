package screens;

import controller.ControllerNF;
import controller.ControllerPC;
import controller.ControllerUser;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListViewPC extends javax.swing.JFrame {

    private final String login;
    private final ArrayList<Integer> update;

    public ListViewPC(String login, String action) {
        initComponents(); // Inicia Componentes do frame de ListViewPC
        jLabel14.setText(action); // Defini o nome da função desempenhada
        jTable1 = ControllerPC.listarPC(jTable1, new String[] {} , this);// Chamada do método responsável por listar todas os pedidos do sistema


        ControllerNF.carregarComboBox(jComboBoxFornecedor, "FORNECEDOR");
        ControllerNF.carregarComboBox(jComboBoxColaborador, "COLABORADOR");
    
        jTable1.getSelectionModel().addListSelectionListener((e) -> {
            if (!e.getValueIsAdjusting()) {
                arrayUpdade();
            }
        });

        this.login = login;
        this.update = new ArrayList<>();
    }

    private void arrayUpdade() {
        if (jTable1.getSelectedRow() > -1) {
            update.add(jTable1.getSelectedRow());
        }
    }
    
    @Override
    public Image getIconImage() { // Método para alterar o icone da barra de tarefas
        return Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("pictures/iconLogoBar.png")); // Seta uma imagem como ícone
    } // Fim do método para alterar o icone da barra de tarefas

    private void limpaCampos() { // Método para limpar campos do formulário
        jTextFieldId.setText(""); // Limpa campo id
        jTextFieldDataFinal.setText(""); // Limpa campo data final
        jTextFieldDataFinal.setText(""); //Limpar campo data inicial
        jTextFieldContato.setText(""); // Limpar campo contato
        jComboBoxFornecedor.setSelectedItem(0); // Limpa campo cargo
        jComboBoxColaborador.setSelectedItem(0); // Limpa campo tipo
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxColaborador = new javax.swing.JComboBox<>();
        jTextFieldId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        filterNF1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        filterNF = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        cleanNF = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        alterNF = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxFornecedor = new javax.swing.JComboBox<>();
        jTextFieldContato = new javax.swing.JTextField();
        jTextFieldDataFinal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldDataInicial = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(71, 120, 197));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Listagem de Notas Fiscais");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1120, 40));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(71, 120, 197)));
        jScrollPane1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Data Compra", "Contato", "Fornecedor", "Colaborador", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(35);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(130);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(130);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(90);
        }

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 960, 460));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 1040, 710));

        jPanel1.setBackground(new java.awt.Color(84, 127, 206));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Filtros");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 550, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Colaborador :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 290, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Fornecedor :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 290, 30));

        jComboBoxColaborador.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jComboBoxColaborador.setForeground(new java.awt.Color(51, 51, 51));
        jComboBoxColaborador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione..." }));
        jPanel1.add(jComboBoxColaborador, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 290, -1));

        jTextFieldId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldIdKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFieldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 90, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 290, 30));

        filterNF1.setBackground(new java.awt.Color(71, 120, 197));
        filterNF1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        filterNF1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filterNF1MouseClicked(evt);
            }
        });
        filterNF1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/icons8_plus_32px_1.png"))); // NOI18N
        filterNF1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 8, 40, 30));
        filterNF1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 180, 10));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Adicionar Pedido");
        filterNF1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 190, 48));

        jPanel1.add(filterNF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 200, 130));

        filterNF.setBackground(new java.awt.Color(71, 120, 197));
        filterNF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        filterNF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filterNFMouseClicked(evt);
            }
        });
        filterNF.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/icons8_filter_26px.png"))); // NOI18N
        filterNF.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 25, 25));
        filterNF.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 180, 10));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Filtrar Pedidos");
        filterNF.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 190, 48));

        jPanel1.add(filterNF, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 200, 130));

        cleanNF.setBackground(new java.awt.Color(71, 120, 197));
        cleanNF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cleanNF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cleanNFMouseClicked(evt);
            }
        });
        cleanNF.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/icons8_eraser_24px.png"))); // NOI18N
        cleanNF.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 13, 30, 25));
        cleanNF.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 180, 10));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Limpar Filtros");
        cleanNF.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 190, 48));

        jPanel1.add(cleanNF, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 200, 130));

        alterNF.setBackground(new java.awt.Color(71, 120, 197));
        alterNF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        alterNF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alterNFMouseClicked(evt);
            }
        });
        alterNF.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/icon_close.png"))); // NOI18N
        alterNF.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 25, 25));
        alterNF.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 180, 10));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Sair");
        alterNF.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 190, 48));

        jPanel1.add(alterNF, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 500, 200, 130));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Contato:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 290, 30));

        jComboBoxFornecedor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jComboBoxFornecedor.setForeground(new java.awt.Color(51, 51, 51));
        jComboBoxFornecedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione..." }));
        jPanel1.add(jComboBoxFornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 290, -1));

        jTextFieldContato.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldContato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldContatojTextFieldsKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFieldContato, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 290, -1));

        jTextFieldDataFinal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldDataFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDataFinaljTextFieldsKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFieldDataFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 120, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Data Final:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 90, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Data Inicial:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 90, 30));

        jTextFieldDataInicial.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldDataInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDataInicialjTextFieldsKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFieldDataInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 120, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cleanNFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cleanNFMouseClicked
        // Método para limpar os campos de input
        limpaCampos(); // Chama o método para limpar os campos
        jTable1 = ControllerPC.listarPC(jTable1, new String[] {} , this);
    }//GEN-LAST:event_cleanNFMouseClicked

    private void filterNFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filterNFMouseClicked
        // TODO add your handling code here:
        String fdata;
        if(!jTextFieldDataInicial.getText().equals("") && !jTextFieldDataFinal.getText().equals(""))
        {
        fdata= " BETWEEN CONVERT(date, '"+ jTextFieldDataInicial.getText()+"', 103)"  +" AND CONVERT(date, '"+ jTextFieldDataFinal.getText()+"', 103)";
        }else if(jTextFieldDataInicial.getText().equals("") && !jTextFieldDataFinal.getText().equals(""))
        {
        fdata = " = CONVERT(date, '"+ jTextFieldDataFinal.getText()+"', 103)";
        }else if(!jTextFieldDataInicial.getText().equals("") && jTextFieldDataFinal.getText().equals(""))
        {
        fdata = " = CONVERT(date, '"+ jTextFieldDataInicial.getText()+"', 103)";
        }else{
            fdata="LIKE ";
        }
        ArrayList ids = ControllerPC.GetNomesByIds(new String[] { jComboBoxColaborador.getSelectedItem().toString(), 
           jComboBoxFornecedor.getSelectedItem().toString()});
        jTable1 = ControllerPC.listarPC(jTable1, new String[] {jTextFieldId.getText(), fdata,  jTextFieldContato.getText(),  
            ids.get(1).toString(), ids.get(0).toString()} , this);
    }//GEN-LAST:event_filterNFMouseClicked

    private void alterNFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alterNFMouseClicked
       this.dispose();
    }//GEN-LAST:event_alterNFMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            try {
                ControllerPC.main(login, "Pedido de Compra",-1,Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString()));
            } catch (SQLException ex) {
                Logger.getLogger(ListViewPC.class.getName()).log(Level.SEVERE, null, ex);
            }
            dispose();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextFieldIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIdKeyTyped
        // Método usado para verificar a entrada do usuário para evitar SQLInjection
        Matcher matcher = Pattern.compile("[^0-9]").matcher(Character.toString(evt.getKeyChar())); // Compara o caractere digitado com a expressão regular
        if (matcher.find()) { // Se achar o caractere imprópio 
            evt.consume();// Não deixa ele ser escrito
        } // Fim da vetificação
    }//GEN-LAST:event_jTextFieldIdKeyTyped

    private void jTextFieldContatojTextFieldsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldContatojTextFieldsKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldContatojTextFieldsKeyTyped

    private void jTextFieldDataFinaljTextFieldsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDataFinaljTextFieldsKeyTyped
        int k = evt.getKeyChar();
        if((k > 47 && k < 58)) {
            if(jTextFieldDataFinal.getText().length() == 2){ //quando tiver 8 digitos vai mudar o foco
                jTextFieldDataFinal.setText(jTextFieldDataFinal.getText()+"/");
            }else if(jTextFieldDataFinal.getText().length() == 5){ //quando tiver 8 digitos vai mudar o foco
                 jTextFieldDataFinal.setText(jTextFieldDataFinal.getText()+"/");
            }  
            else if(jTextFieldDataFinal.getText().length() == 9){ //quando tiver 8 digitos vai mudar o foco
                jTextFieldContato.requestFocus();
            }
        } else {
            evt.setKeyChar((char)KeyEvent.VK_CLEAR);
        }
    }//GEN-LAST:event_jTextFieldDataFinaljTextFieldsKeyTyped

    private void jTextFieldDataInicialjTextFieldsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDataInicialjTextFieldsKeyTyped
        int k = evt.getKeyChar();
        if((k > 47 && k < 58)) {
            if(jTextFieldDataInicial.getText().length() == 2){ //quando tiver 8 digitos vai mudar o foco
                jTextFieldDataInicial.setText(jTextFieldDataInicial.getText()+"/");
            }else if(jTextFieldDataInicial.getText().length() == 5){ //quando tiver 8 digitos vai mudar o foco
                 jTextFieldDataInicial.setText(jTextFieldDataInicial.getText()+"/");
            }       
            else if(jTextFieldDataInicial.getText().length() == 9){ //quando tiver 8 digitos vai mudar o foco
                jTextFieldDataFinal.requestFocus();
            }
        } else {
            evt.setKeyChar((char)KeyEvent.VK_CLEAR);
        }
    }//GEN-LAST:event_jTextFieldDataInicialjTextFieldsKeyTyped

    private void filterNF1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filterNF1MouseClicked
        // TODO add your handling code here:
        try {
            ControllerPC.main(this.login, "Criar Pedido de Compra", -1, -1);
        } catch (SQLException ex) {
        }
        dispose();
    }//GEN-LAST:event_filterNF1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel alterNF;
    private javax.swing.JPanel cleanNF;
    private javax.swing.JPanel filterNF;
    private javax.swing.JPanel filterNF1;
    private javax.swing.JComboBox<String> jComboBoxColaborador;
    private javax.swing.JComboBox<String> jComboBoxFornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldContato;
    private javax.swing.JTextField jTextFieldDataFinal;
    private javax.swing.JTextField jTextFieldDataInicial;
    private javax.swing.JTextField jTextFieldId;
    // End of variables declaration//GEN-END:variables

}
