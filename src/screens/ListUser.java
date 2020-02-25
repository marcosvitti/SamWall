package screens;

import dataBase.DataBase;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListUser extends javax.swing.JFrame {

    public DataBase con;
    public String id;
    public String username;

    public ListUser(String username, DataBase con) {
        initComponents();
        setConnection(con);
        this.username = buscarLogin(username);
        listarUsers();
        jTextFieldId.setVisible(false);
        this.setLocationRelativeTo(null);
    }

    public void setConnection(DataBase con) {
        this.con = con;
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

    private void listarUsers() {
        try {
            ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
            jTable1 = con.listaUsers("SELECT * FROM colaboradores", jTable1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar usuários!", "ERRO", JOptionPane.ERROR_MESSAGE);
            Main main = new Main(username);
            main.setVisible(true);
            dispose();
        }
    }

    private void limpaCampos() {
        jTextFieldId.setText("");
        jTextFieldLogin.setText("");
        jTextFieldSenha.setText("");
        jPasswordField1.setText("");
        jTextFieldNome.setText("");
        jTextFieldSobreNome.setText("");
        jTextFieldCargo.setText("");
        jComboBoxStatus.setSelectedItem(0);
        jTextFieldCelular.setText("");
        jTextFieldTelefone.setText("");
        jTextFieldCPF.setText("");
        jComboBoxTipo.setSelectedItem(0);
        jTextFieldId.setVisible(false);
    }

    private void carregarCampos(int linha) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        jTextFieldId.setText((String) model.getValueAt(linha, 0));
        if (jTextFieldId.getText().equals("1")) {
            jTextFieldLogin.setEnabled(false);
            jTextFieldSenha.setEnabled(false);
            jPasswordField1.setEnabled(false);
        }
        jTextFieldLogin.setText((String) model.getValueAt(linha, 1));
        jTextFieldNome.setText((String) model.getValueAt(linha, 2));
        jTextFieldSobreNome.setText((String) model.getValueAt(linha, 3));
        jComboBoxStatus.setSelectedItem((String) model.getValueAt(linha, 9));
        jTextFieldCargo.setText((String) model.getValueAt(linha, 4));
        jTextFieldTelefone.setText((String) model.getValueAt(linha, 5));
        jTextFieldCelular.setText((String) model.getValueAt(linha, 6));
        jTextFieldCPF.setText((String) model.getValueAt(linha, 7));
        jComboBoxTipo.setSelectedItem((String) model.getValueAt(linha, 10));
    }

    private void reiniciaBotoes() {
        inserir.setEnabled(true);
        limpar.setEnabled(true);
        alterar.setEnabled(false);
        excluir.setEnabled(false);
    }

    private void defineBotoes() {
        inserir.setEnabled(false);
        alterar.setEnabled(true);
        excluir.setEnabled(true);
        limpar.setEnabled(true);
    }

    public String formatCPF() {
        StringTokenizer tok = new StringTokenizer(jTextFieldCPF.getText(), ".");
        String frs = tok.nextToken();
        String sec = tok.nextToken();
        String thr = tok.nextToken();

        StringTokenizer tok2 = new StringTokenizer(thr, "-");
        String prim2 = tok2.nextToken();
        String last = tok2.nextToken();
        String iscpf = frs + sec + prim2 + last;
        return iscpf;
    }

    public String formatContato(String contato) {
        StringTokenizer tok = new StringTokenizer(contato, " ");
        String ddd = tok.nextToken().substring(1, 3);
        String t = tok.nextToken();

        StringTokenizer tok2 = new StringTokenizer(t, "-");
        String t1 = tok2.nextToken();
        String t2 = tok2.nextToken();

        String tel = ddd + t1 + t2;
        return tel;
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

        inserir = new javax.swing.JButton();
        limpar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        alterar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldLogin = new javax.swing.JTextField();
        jTextFieldSenha = new javax.swing.JPasswordField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldSobreNome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldCargo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxStatus = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldTelefone = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter tel= new javax.swing.text.MaskFormatter("(##) ####-####");
            jTextFieldTelefone = new javax.swing.JFormattedTextField(tel);
        }
        catch (Exception e){
        }
        jLabel10 = new javax.swing.JLabel();
        jTextFieldCelular = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter cel= new javax.swing.text.MaskFormatter("(##) #####-####");
            jTextFieldCelular = new javax.swing.JFormattedTextField(cel);
        }
        catch (Exception e){
        }
        jLabel9 = new javax.swing.JLabel();
        jTextFieldCPF = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter cpf= new javax.swing.text.MaskFormatter("###.###.###-##");
            jTextFieldCPF = new javax.swing.JFormattedTextField(cpf);
        }
        catch (Exception e){
        }
        jLabel3 = new javax.swing.JLabel();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inserir.setText("Inserir");
        inserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirActionPerformed(evt);
            }
        });
        getContentPane().add(inserir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 70, -1));

        limpar.setText("Limpar");
        limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparActionPerformed(evt);
            }
        });
        getContentPane().add(limpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 70, -1));

        excluir.setText("Excluir");
        excluir.setEnabled(false);
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });
        getContentPane().add(excluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 70, -1));

        alterar.setText("Alterar");
        alterar.setEnabled(false);
        alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarActionPerformed(evt);
            }
        });
        getContentPane().add(alterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 70, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3), "Informações do novo login", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 18), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel2.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldLogin.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel2.add(jTextFieldLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 210, 25));

        jTextFieldSenha.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel2.add(jTextFieldSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 210, 25));

        jPasswordField1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel2.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 210, 25));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Senha :  ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 25));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Login :  ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 150, 25));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText(" Confirma Senha :  ");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 150, 25));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 130));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3), "Informações pessoais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 18), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel3.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Nome :  ");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 120, 25));

        jTextFieldNome.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel3.add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 160, 25));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Sobrenome :  ");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 120, 25));

        jTextFieldSobreNome.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel3.add(jTextFieldSobreNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 160, 25));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Cargo :  ");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 120, 25));

        jTextFieldCargo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel3.add(jTextFieldCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 160, 25));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Status :  ");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 120, 25));

        jComboBoxStatus.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jComboBoxStatus.setForeground(new java.awt.Color(51, 51, 51));
        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ativo", "Inativo" }));
        jPanel3.add(jComboBoxStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 80, 25));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Telefone :  ");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 120, 25));

        jTextFieldTelefone.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel3.add(jTextFieldTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 160, 25));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Celular :  ");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 120, 25));

        jTextFieldCelular.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel3.add(jTextFieldCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 160, 25));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("CPF :  ");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 120, 25));

        jTextFieldCPF.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel3.add(jTextFieldCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 160, 25));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Tipo :  ");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 120, 25));

        jComboBoxTipo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jComboBoxTipo.setForeground(new java.awt.Color(51, 51, 51));
        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Usuário" }));
        jPanel3.add(jComboBoxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, -1, 25));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3), "df sdfdsf ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 18))); // NOI18N
        jPanel1.setOpaque(false);
        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 10, 140));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 570, 160));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Login", "Nome", "Sobrenome", "Cargo", "Telefone", "Celular", "CPF", "Data Cadastro", "Status", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setMinWidth(0);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(6).setMinWidth(0);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(7).setMinWidth(0);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(8).setMinWidth(100);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(8).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(9).setResizable(false);
            jTable1.getColumnModel().getColumn(9).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(10).setMinWidth(0);
            jTable1.getColumnModel().getColumn(10).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(10).setMaxWidth(0);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 950, 340));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/background3.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-290, 0, 1280, 560));

        jTextFieldId.setEditable(false);
        getContentPane().add(jTextFieldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirActionPerformed
        // TODO add your handling code here:
        String login = jTextFieldLogin.getText();
        String senha = jTextFieldSenha.getText();
        String senha1 = jPasswordField1.getText();
        String nome = jTextFieldNome.getText();
        String sobrenome = jTextFieldSobreNome.getText();
        String cargo = jTextFieldCargo.getText();
        String status = (String) jComboBoxStatus.getSelectedItem();
        String telefone = jTextFieldTelefone.getText();
        String celular = jTextFieldCelular.getText();
        String cpf = formatCPF();
        String tipo = (String) jComboBoxTipo.getSelectedItem();
        if (status.equals("Ativo")) {
            status = "1";
        } else if (status.equals("Inativo")) {
            status = "0";
        }
        if (tipo.equals("Administrador")) {
            tipo = "A";
        } else if (tipo.equals("Usuário")) {
            tipo = "U";
        }

        try {
            int rowAffected = con.verifUser("SELECT LOGIN FROM colaboradores WHERE login='" + login + "'");
            if (rowAffected != 0) {
                throw new Exception("1");
            }

            if ((login.equals("")) || (senha.equals("")) || (senha1.equals("")) || (status.equals("")) || (sobrenome.equals(""))) {
                if (!senha1.equals(senha)) {
                    throw new Exception("2");
                }
                throw new Exception("3");
            }
            con.inserirUser("INSERT INTO colaboradores ( LOGIN, SENHA, NOME, SOBRENOME, CARGO, TELEFONE, CELULAR, CPF, DATA_CADASTRO, STATUS, TIPO) "
                    + "VALUES ('" + login + "',SHA1('" + senha + "'),'" + nome + "','" + sobrenome + "','" + cargo + "','" + telefone + "','" + celular + "','" + cpf + "', NOW(), " + status + ",'" + tipo + "')");
            JOptionPane.showMessageDialog(null, "Erro no cadastro do usuário", "ERROR", JOptionPane.ERROR_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no cadastro do usuário", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            if (ex.getMessage().equals("1")) {
                JOptionPane.showMessageDialog(null, "Usuário já Cadastrado", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            if (ex.getMessage().equals("2")) {
                JOptionPane.showMessageDialog(null, "As senhas não são identicas", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            if (ex.getMessage().equals("3")) {
                JOptionPane.showMessageDialog(null, "Preencha os campos corretamente!", "AVISO", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        limpaCampos();
        listarUsers();
    }//GEN-LAST:event_inserirActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {
            jTextFieldLogin.setEnabled(true);
            jTextFieldSenha.setEnabled(true);
            jPasswordField1.setEnabled(true);
            carregarCampos(jTable1.getSelectedRow());
            listarUsers();
            defineBotoes();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparActionPerformed
        limpaCampos();
        reiniciaBotoes();
    }//GEN-LAST:event_limparActionPerformed

    private void alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarActionPerformed

        id = jTextFieldId.getText();
        String login = jTextFieldLogin.getText();
        String senha = jTextFieldSenha.getText();
        String senha1 = jPasswordField1.getText();
        String nome = jTextFieldNome.getText();
        String sobrenome = jTextFieldSobreNome.getText();
        String cargo = jTextFieldCargo.getText();
        String status = (String) jComboBoxStatus.getSelectedItem();
        String telefone = formatContato(jTextFieldTelefone.getText());
        String celular = formatContato(jTextFieldCelular.getText());
        String cpf = formatCPF();
        String tipo = (String) jComboBoxTipo.getSelectedItem();
        if (status.equals("Ativo")) {
            status = "1";
        } else if (status.equals("Inativo")) {
            status = "0";
        }
        if (tipo.equals("Administrador")) {
            tipo = "A";
        } else if (tipo.equals("Usuário")) {
            tipo = "U";
        }
        int select = 0;
        try {
            if (!isCPF(cpf)) {
                throw new Exception("2");
            }
            if ((id.equals("1")) && (status.equals("0"))) {
                throw new Exception("!");
            }
            if ((!senha.equals("")) && (!senha1.equals("")) || (senha.equals("")) && (!senha1.equals("")) || (!senha.equals("")) && (senha1.equals(""))) {
                if (!senha1.equals(senha)) {
                    throw new Exception("1");
                }
            } else {
                select = 1;
            }
            if (select == 0) {
                con.alterUser("UPDATE colaboradores SET SENHA= SHA1('" + senha + "'), NOME='" + nome + "', SOBRENOME='" + sobrenome + "', CARGO='" + cargo + "',STATUS='" + status + "', TELEFONE='" + telefone + "',CELULAR='" + celular + "', CPF='" + cpf + "',TIPO='" + tipo + "' WHERE ID_USER=" + id);
            } else {
                con.alterUser("UPDATE colaboradores SET NOME='" + nome + "', SOBRENOME='" + sobrenome + "', CARGO='" + cargo + "',STATUS='" + status + "', TELEFONE='" + telefone + "',CELULAR='" + celular + "', CPF='" + cpf + "',TIPO='" + tipo + "' WHERE ID_USER=" + id);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao efetuar a atualização" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            if (ex.getMessage().equals("!")) {
                JOptionPane.showMessageDialog(null, "Operação impossivel!", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (ex.getMessage().equals("1")) {
                JOptionPane.showMessageDialog(null, "As senhas não são identicas!", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (ex.getMessage().equals("2")) {
                JOptionPane.showMessageDialog(null, "CPF inváldo!", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Dados incorretos!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        limpaCampos();
        listarUsers();
        reiniciaBotoes();
    }//GEN-LAST:event_alterarActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        // TODO add your handling code here:
        try {

            id = this.jTextFieldId.getText();
            if (id.equals("1")) {
                JOptionPane.showMessageDialog(null, "Usuário Administrador não pode ser excluído", "Erro", JOptionPane.ERROR_MESSAGE);
                throw new SQLException("1");
            }
            int ret = JOptionPane.showConfirmDialog(null, "Tem Certeza?", "Confirmação de exclusão", JOptionPane.WARNING_MESSAGE);
            if (ret == JOptionPane.OK_OPTION) {
                con.delProduto("DELETE FROM colaboradores WHERE ID_USER='" + id + "'");
                JOptionPane.showMessageDialog(null, "Usuário Removido", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            if (!e.getMessage().equals("1")) {
                JOptionPane.showMessageDialog(null, "Erro na remoção do produto", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        limpaCampos();
        reiniciaBotoes();
        listarUsers();
    }//GEN-LAST:event_excluirActionPerformed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        // TODO add your handling code here:
        this.requestFocus();
    }//GEN-LAST:event_formWindowLostFocus

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(RegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(RegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(RegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(RegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new RegisterUser().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterar;
    private javax.swing.JButton excluir;
    private javax.swing.JButton inserir;
    private javax.swing.JComboBox jComboBoxStatus;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldCPF;
    private javax.swing.JTextField jTextFieldCargo;
    private javax.swing.JTextField jTextFieldCelular;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldLogin;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JPasswordField jTextFieldSenha;
    private javax.swing.JTextField jTextFieldSobreNome;
    private javax.swing.JTextField jTextFieldTelefone;
    private javax.swing.JButton limpar;
    // End of variables declaration//GEN-END:variables

}
