package screens;

import dataBase.DataBase;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class BlockUser extends javax.swing.JFrame {

    private final DataBase con = DataBase.getInstance(); // Declaração da variável interações com o banco de dados
    private String logLogin, username;
    private final ArrayList<Integer> update = new ArrayList<>();

    public BlockUser(String username, String opcao) { // Método para instanciar o frame blockUser
        initComponents(); // Inicia Componentes do frame de blockUser
        buscarLogin(username); // Defini o nome do login
        jLabel14.setText(opcao); // Defini o nome da função desenpenhada
        listarUsers(); // Chamada do método responsável por listar os colaboradores do sistema

        jTable1.getSelectionModel().addListSelectionListener((e) -> {
            if (!e.getValueIsAdjusting()) {
                arrayUpdade();
            }
        });
        this.username = username;
    }

    @Override
    public Image getIconImage() { // Método para alterar o icone da barra de tarefas
        return Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("pictures/iconLogoBar.png")); // Seta uma imagem como ícone
    } // Fim do método para alterar o icone da barra de tarefas

    private void buscarLogin(String username) { // Método para buscar o login do usuário logado no sitema
        try { // Tenta realizar a busca no banco
            this.logLogin = con.buscaLogin(username); // Método para realizar a busca no banco
        } catch (SQLException ex) { // Se ocorrer algum erro
            JOptionPane.showMessageDialog(null, "Usuário não encontrado", "ERROR", JOptionPane.ERROR_MESSAGE); // Mostra a seguinte mensagem ao usuário
        }
    }

    private void listarUsers() { // Método para listar os colaboradores do sistema
        try { // Tentar realizar a listagem dos colaboradores
            jTable1 = con.listaUsers("SELECT * FROM colaboradores", jTable1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar usuários!" + e, "ERRO", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }

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
            System.out.println(jTable1.getSelectedRow());
            update.add(jTable1.getSelectedRow());
        }
    }

    public String formatCPF(String cpf) {
        StringTokenizer tok = new StringTokenizer(cpf, ".");
        String frs = tok.nextToken();
        String sec = tok.nextToken();
        String thr = tok.nextToken();

        StringTokenizer tok2 = new StringTokenizer(thr, "-");
        String prim2 = tok2.nextToken();
        String last = tok2.nextToken();
        String iscpf = frs + sec + prim2 + last;
        return iscpf;
    }

    public static boolean isCPF(String CPF) {
        if (CPF.equals("00000000000")
                || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48);
            }
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
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

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Bloquear Usuário");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 80));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(71, 120, 197)));
        jScrollPane1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Login", "Nome", "Sobrenome", "Cargo", "Telefone", "Celular", "CPF", "Data Cadastro", "Status", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true, false
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
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(5).setMinWidth(0);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(6).setMinWidth(0);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(8).setResizable(false);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(130);
            jTable1.getColumnModel().getColumn(9).setResizable(false);
            jTable1.getColumnModel().getColumn(9).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(10).setMinWidth(0);
            jTable1.getColumnModel().getColumn(10).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(10).setMaxWidth(0);
        }

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 1060, 570));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 1120, 710));

        jPanel1.setBackground(new java.awt.Color(84, 127, 206));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Filtros");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 80));

        jTextFieldNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 300, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Nome :  ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 300, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Sobrenome :  ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 300, 40));

        jTextFieldSobreNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jTextFieldSobreNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 300, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Cargo :  ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 300, 40));

        jTextFieldCargo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jTextFieldCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 300, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Status :  ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 300, 40));

        jComboBoxStatus.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jComboBoxStatus.setForeground(new java.awt.Color(51, 51, 51));
        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Ativo", "Inativo" }));
        jPanel1.add(jComboBoxStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 300, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Tipo :  ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 300, 40));

        jComboBoxTipo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jComboBoxTipo.setForeground(new java.awt.Color(51, 51, 51));
        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Administrador", "Usuário" }));
        jPanel1.add(jComboBoxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 300, 40));

        jTextFieldCPF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldCPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCPFKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFieldCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 300, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("CPF :  ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 300, 40));

        jTextFieldId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jTextFieldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 100, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 300, 40));

        filterUser.setBackground(new java.awt.Color(71, 120, 197));
        filterUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        filterUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filterUserMouseClicked(evt);
            }
        });
        filterUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/iconsFilter.png"))); // NOI18N
        filterUser.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, 30));
        filterUser.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 180, 10));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Filtrar Usuários");
        filterUser.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 180, 48));

        jPanel1.add(filterUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 200, 130));

        cleanUser.setBackground(new java.awt.Color(71, 120, 197));
        cleanUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cleanUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cleanUserMouseClicked(evt);
            }
        });
        cleanUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/iconsClean.png"))); // NOI18N
        cleanUser.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));
        cleanUser.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 180, 10));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Limpar Filtros");
        cleanUser.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 180, 48));

        jPanel1.add(cleanUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 200, 130));

        alterUser.setBackground(new java.awt.Color(71, 120, 197));
        alterUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        alterUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alterUserMouseClicked(evt);
            }
        });
        alterUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/iconsSave.png"))); // NOI18N
        alterUser.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));
        alterUser.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 180, 10));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Salvar");
        alterUser.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 180, 48));

        jPanel1.add(alterUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 420, 200, 130));

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
        listarUsers();
    }//GEN-LAST:event_cleanUserMouseClicked

    private void filterUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filterUserMouseClicked
        // TODO add your handling code here:
        String id = jTextFieldId.getText().equals("") ? "" : "ID_USER='" + jTextFieldId.getText() + "'";
        String nome = jTextFieldNome.getText().equals("") ? "" : "NOME='" + jTextFieldNome.getText() + "'";
        String sobrenome = jTextFieldSobreNome.getText().equals("") ? "" : "SOBRENOME='" + jTextFieldSobreNome.getText() + "'";
        String cargo = jTextFieldCargo.getText().equals("") ? "" : "CARGO='" + jTextFieldCargo.getText() + "'";
        String tipo = jComboBoxTipo.getSelectedItem().toString().equals("Selecione...") ? "" : jComboBoxTipo.getSelectedItem().toString().equals("Administrador") ? "TIPO='A'" : "TIPO='U'";
        String status = jComboBoxStatus.getSelectedItem().toString().equals("Selecione...") ? "" : jComboBoxStatus.getSelectedItem().toString().equals("Ativo") ? "STATUS='1'" : "STATUS='0'";
        String cpf = jTextFieldCPF.getText();

        try {
            if(!cpf.equals("")){
                if(isCPF(formatCPF(jTextFieldCPF.getText()))){
                    cpf = "CPF='" + formatCPF(jTextFieldCPF.getText()) + "'";
                } else {
                    throw new Exception("2");
                }
            } else {
                cpf = "";
            }
            if (((id.equals("1")) && (status.equals("0"))) || (id.equals("1")) && (tipo.equals("U"))) {
                throw new Exception("!");
            }

            con.listaUsers(con.queryBuilder("colaboradores", new String[] {id, nome, sobrenome, cargo, status, cpf, tipo}), jTable1);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao efetuar a atualização" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            switch (ex.getMessage()) {
                case "!":
                    JOptionPane.showMessageDialog(null, "Operação impossivel!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "CPF inváldo!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Dados incorretos!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }//GEN-LAST:event_filterUserMouseClicked

    private void alterUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alterUserMouseClicked
        // TODO add your handling code here:
        try {
            for (Integer row : update) {
                int status = ("Inativo".equals(jTable1.getValueAt(row, 9).toString())) ? 0 : 1;
                con.alterUser("UPDATE colaboradores SET STATUS=" + status + " WHERE ID_USER=" + jTable1.getValueAt(row, 0));
            }
            JOptionPane.showMessageDialog(null, "Usuário(s) alterado(s) com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE); // Mostra a mensagem de sucesso
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao efetuar a atualização" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            listarUsers();
        }
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
            Integer codigo = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            AddUser addUser = new AddUser(this.username, true, codigo); // Instância o novo frame
            addUser.setLocationRelativeTo(null); // Defini a localização no meio da tela
            addUser.setVisible(true); // Defini o frame como visivel
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
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldSobreNome;
    // End of variables declaration//GEN-END:variables

}
