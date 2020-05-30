package screens;

import controller.ControllerNF;
import controller.ControllerUser;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListViewNF extends javax.swing.JFrame {

    private final String login;
    private final ArrayList<Integer> update;

    public ListViewNF(String login, String action) {
        initComponents(); // Inicia Componentes do frame de ListViewNF
        jLabel14.setText(action); // Defini o nome da função desempenhada
        jTable1 = ControllerNF.listarNF(jTable1, new String[] {} , this);// Chamada do método responsável por listar todas as notas fiscais do sistema


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
        jTextFieldNF.setText(""); // Limpa campo N da Nota fiscal
        jComboBoxStatus.setSelectedItem(0); //Limpar campo fornecedor
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
        jLabel6 = new javax.swing.JLabel();
        jComboBoxColaborador = new javax.swing.JComboBox<>();
        jTextFieldId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        filterNF = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        cleanNF = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldNF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxStatus = new javax.swing.JComboBox<>();
        jComboBoxFornecedor = new javax.swing.JComboBox<>();

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
                "ID", "N° da Nota Fiscal", "Colaborador", "Fornecedor", "Status", "Valor", "Data Cadastro", "Pagamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
        }

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 960, 460));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 1070, 570));

        jPanel1.setBackground(new java.awt.Color(84, 127, 206));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Filtros");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 450, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Colaborador :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 290, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Fornecedor :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 290, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Status :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 290, 30));

        jComboBoxColaborador.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jComboBoxColaborador.setForeground(new java.awt.Color(51, 51, 51));
        jComboBoxColaborador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione..." }));
        jPanel1.add(jComboBoxColaborador, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 420, -1));

        jTextFieldId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldIdKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFieldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 190, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 290, 30));

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
        jLabel18.setText("Filtrar Notas");
        filterNF.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 190, 48));

        jPanel1.add(filterNF, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 200, 130));

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

        jPanel1.add(cleanNF, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, 200, 130));

        jTextFieldNF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldNF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldsKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFieldNF, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 420, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("N° da Nota Fiscal :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 290, 30));

        jComboBoxStatus.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jComboBoxStatus.setForeground(new java.awt.Color(51, 51, 51));
        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Ativo", "Inativo" }));
        jPanel1.add(jComboBoxStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 420, -1));

        jComboBoxFornecedor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jComboBoxFornecedor.setForeground(new java.awt.Color(51, 51, 51));
        jComboBoxFornecedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione..." }));
        jPanel1.add(jComboBoxFornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 420, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cleanNFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cleanNFMouseClicked
        // Método para limpar os campos de input
        limpaCampos(); // Chama o método para limpar os campos
        jTable1 = ControllerNF.listarNF(jTable1, new String[] {} , this);
    }//GEN-LAST:event_cleanNFMouseClicked

    private void filterNFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filterNFMouseClicked
        // TODO add your handling code here:
        ArrayList ids = ControllerNF.GetNomesByIds(new String[] {jComboBoxColaborador.getSelectedItem().toString(), jComboBoxFornecedor.getSelectedItem().toString()});
        jTable1 = ControllerNF.listarNF(jTable1, new String[] {jTextFieldId.getText(), "", jTextFieldNF.getText(), ids.get(0).toString(), ids.get(1).toString(), jComboBoxStatus.getSelectedItem().toString()} , this);
    }//GEN-LAST:event_filterNFMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            try {
                ControllerNF.main(login, "Nota Fiscal",-1,Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString())); 
            } catch (SQLException ex) {
                Logger.getLogger(ListViewNF.class.getName()).log(Level.SEVERE, null, ex);
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

    private void jTextFieldsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldsKeyTyped
        // Método usado para verificar a entrada do usuário para evitar SQLInjection
        Matcher matcher = Pattern.compile("[^\\w]").matcher(Character.toString(evt.getKeyChar())); // Compara o caractere digitado com a expressão regular
        if (matcher.find()) { // Se achar o caractere imprópio 
            evt.consume();// Não deixa ele ser escrito
        } // Fim da vetificação
    }//GEN-LAST:event_jTextFieldsKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cleanNF;
    private javax.swing.JPanel filterNF;
    private javax.swing.JComboBox<String> jComboBoxColaborador;
    private javax.swing.JComboBox<String> jComboBoxFornecedor;
    private javax.swing.JComboBox<String> jComboBoxStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldNF;
    // End of variables declaration//GEN-END:variables

}
