package screens;

import controller.ControllerUser;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BlockUser extends javax.swing.JFrame {

    private final String login;
    private final ArrayList<Integer> update;

    public BlockUser(String login, String action) {
        initComponents(); // Inicia Componentes do frame de blockUser
        jLabel14.setText(action); // Defini o nome da função desempenhada
        jTable1 = ControllerUser.listarUsers(jTable1, new String[] {}, this); // Chamada do método responsável por listar os colaboradores do sistema

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
        jTextFieldId.setText(""); // Limpa campo id
        jTextFieldNome.setText(""); // Limpa campo nome
        jTextFieldSobreNome.setText(""); // Limpa campo sobrenome
        jTextFieldCPF.setText(""); // Limpa campo cpf
        jTextFieldCargo.setText(""); // Limpa campo cargo
        jComboBoxStatus.setSelectedItem(0); // Limpa campo status
        jComboBoxTipo.setSelectedItem(0); // Limpa campo tipo
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
        jTextFieldNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldSobreNome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldCargo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxStatus = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jTextFieldCPF = new javax.swing.JTextField();
        /*try{
            javax.swing.text.MaskFormatter cpf= new javax.swing.text.MaskFormatter("###.###.###-##");
            jTextFieldCPF = new javax.swing.JFormattedTextField(cpf);
        }
        catch (Exception e){
        }*/
        jLabel9 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        filterUser = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        cleanUser = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        alterUser = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jTextFieldLogin = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(71, 120, 197));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Bloquear Usuário");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1120, 40));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(71, 120, 197)));
        jScrollPane1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Login", "Nome", "Sobrenome", "Cargo", "Data Cadastro", "Status", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false
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
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(90);
        }

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 1060, 570));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 1120, 710));

        jPanel1.setBackground(new java.awt.Color(84, 127, 206));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Filtros");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 580, 40));

        jTextFieldNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 320, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Nome :  ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 320, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Sobrenome :  ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 320, 30));

        jTextFieldSobreNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jTextFieldSobreNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 320, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Cargo :  ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 320, 30));

        jTextFieldCargo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jTextFieldCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 320, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Status :  ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 320, 30));

        jComboBoxStatus.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jComboBoxStatus.setForeground(new java.awt.Color(51, 51, 51));
        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Ativo", "Inativo" }));
        jPanel1.add(jComboBoxStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 320, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Tipo :  ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 320, 30));

        jComboBoxTipo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jComboBoxTipo.setForeground(new java.awt.Color(51, 51, 51));
        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Administrador", "Usuário" }));
        jPanel1.add(jComboBoxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 320, -1));

        jTextFieldCPF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldCPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCPFKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFieldCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 320, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("CPF :  ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 320, 30));

        jTextFieldId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jTextFieldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 120, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 320, 30));

        filterUser.setBackground(new java.awt.Color(71, 120, 197));
        filterUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        filterUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filterUserMouseClicked(evt);
            }
        });
        filterUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/icons8_filter_26px.png"))); // NOI18N
        filterUser.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 25, 25));
        filterUser.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 180, 10));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Filtrar Usuários");
        filterUser.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 190, 48));

        jPanel1.add(filterUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 200, 130));

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
        jLabel16.setText("Limpar Filtros");
        cleanUser.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 190, 48));

        jPanel1.add(cleanUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 200, 130));

        alterUser.setBackground(new java.awt.Color(71, 120, 197));
        alterUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        alterUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alterUserMouseClicked(evt);
            }
        });
        alterUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/icons8_save_26px.png"))); // NOI18N
        alterUser.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 25, 25));
        alterUser.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 180, 10));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Salvar");
        alterUser.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 190, 48));

        jPanel1.add(alterUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, 200, 130));

        jTextFieldLogin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jTextFieldLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 320, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Login :  ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 320, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        // TODO add your handling code here:
        this.requestFocus();
    }//GEN-LAST:event_formWindowLostFocus

    private void cleanUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cleanUserMouseClicked
        // Método para limpar os campos de input
        limpaCampos(); // Chama o método para limpar os campos
        ControllerUser.listarUsers(jTable1, new String[] {}, this);
    }//GEN-LAST:event_cleanUserMouseClicked

    private void filterUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filterUserMouseClicked
        // TODO add your handling code here:
        jTable1 = ControllerUser.listarUsers(jTable1, new String[] {jTextFieldId.getText(),jTextFieldLogin.getText(),jTextFieldNome.getText(),jTextFieldSobreNome.getText(),jTextFieldCargo.getText(),jComboBoxTipo.getSelectedItem().toString(),jComboBoxStatus.getSelectedItem().toString()}, this);
    }//GEN-LAST:event_filterUserMouseClicked

    private void alterUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alterUserMouseClicked
        // TODO add your handling code here:
       ControllerUser.updateUser(jTable1, update);
       ControllerUser.listarUsers(jTable1, new String[] {}, this);
    }//GEN-LAST:event_alterUserMouseClicked

    private void jTextFieldCPFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCPFKeyTyped
        // Método usado para verificar a entrada do usuário para evitar SQLInjection
        if (jTextFieldCPF.getText().length() > 13) {
            evt.consume();
        } else {
            Matcher matcher = Pattern.compile("[a-zA-Z]|[\\W]").matcher(Character.toString(evt.getKeyChar())); // Compra o caractere digitado com a expressão regular
            if (matcher.find()) { // Se achar o caractere imprópio 
                evt.consume();// Não deixa ele ser escrito
            } else {
                matcher = Pattern.compile("([\\d]{3}){3}(\\d{1})").matcher(jTextFieldCPF.getText());
               if (matcher.find()) { // Se o pattern for igual a string do textfieldCPF
                   jTextFieldCPF.setText(jTextFieldCPF.getText().replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{1})", "$1.$2.$3-$4"));
               }
            }
        }
    }//GEN-LAST:event_jTextFieldCPFKeyTyped

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            ControllerUser.main(login, null, Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString()));
            dispose();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel alterUser;
    private javax.swing.JPanel cleanUser;
    private javax.swing.JPanel filterUser;
    private javax.swing.JComboBox jComboBoxStatus;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldCPF;
    private javax.swing.JTextField jTextFieldCargo;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldLogin;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldSobreNome;
    // End of variables declaration//GEN-END:variables

}
