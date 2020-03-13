package screens;

import dataBase.DataBase;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class AddUser extends javax.swing.JFrame {

    public DataBase con = DataBase.getInstance(); // Declaração da variável interações com o banco de dados
    public String logLogin; // Declaração da variável logLogin, usada para relatórios de inserção de usuários

    public AddUser(String username, boolean opcao, Integer codigo) { // Método para instanciar o frame addUser
        initComponents(); // Inicia Componentes do frame de addUser
        buscarLogin(username); // Defini o nome do login
        if(opcao && codigo != -1){
            try{
                System.out.println("SELECT * FROM colaboradores WHERE ID_USER='" + codigo + "'");
                con.connection();
                ArrayList<String> campos = con.selectUser("SELECT * FROM colaboradores WHERE ID_USER='" + codigo + "'"); // Verifica se há o usuário no banco de dados
                System.out.println(campos);
                jLabel14.setText("Edição do Usuário > " + campos.get(1));
                carregarCampos(campos);
            } catch (SQLException ex) { // Caso falhe a interação com o banco
                JOptionPane.showMessageDialog(null, "Erro na busca dos dados do usuário!", "ERROR", JOptionPane.ERROR_MESSAGE); // Mostra a mensagem de erro      
            } finally {
                con.connection();
            }
        }
    }

    @Override
    public Image getIconImage() { // Método para alterar o icone da barra de tarefas
        return Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("pictures/iconLogoBar.png")); // Seta uma imagem como ícone
    } // Fim do método para alterar o icone da barra de tarefas

    private void buscarLogin(String login) { // Método para buscar o login do usuário logado no sitema
        this.logLogin = login; // Método para realizar a busca no banco
    }
    
    private void carregarCampos(ArrayList<String> campos) {
        jTextFieldLogin.setText(campos.get(1));
        jTextFieldNome.setText(campos.get(2));
        jTextFieldSobreNome.setText(campos.get(3));
        jTextFieldCargo.setText(campos.get(4));
        jTextFieldTelefone.setText(campos.get(5));
        jTextFieldCelular.setText(campos.get(6));
        jTextFieldCPF.setText(campos.get(7));
        jComboBoxStatus.setSelectedItem(campos.get(8));
        jComboBoxTipo.setSelectedItem(campos.get(9));     
        jTextFieldEmail.setText(campos.get(10));
    }

    private void limpaCampos() { // Método para limpar campos do formulário
        jTextFieldNome.setText(""); // Limpa campo nome
        jTextFieldSobreNome.setText(""); // Limpa campo sobrenome
        jTextFieldCPF.setText(""); // Limpa campo cpf
        jTextFieldTelefone.setText(""); // Limpa campo telefone
        jTextFieldCelular.setText(""); // Limpa campo celular
        jTextFieldEmail.setText(""); // Limpa campo email
        
        jTextFieldCargo.setText(""); // Limpa campo cargo
        jComboBoxStatus.setSelectedItem(0); // Limpa campo status
        jComboBoxTipo.setSelectedItem(0); // Limpa campo tipo
        
        jTextFieldLogin.setText(""); // Limpa campo login
        jTextFieldSenha.setText(""); // Limpa campo senha
        jPasswordField1.setText(""); // Limpa campo confirmar senha
    }
    
    private void sanitaze(Matcher matcher, KeyEvent evt){
        if(!matcher.find()){
            evt.consume();
        }
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

        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldSenha = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldLogin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldSobreNome = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldCPF = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter cpf= new javax.swing.text.MaskFormatter("###.###.###-##");
            jTextFieldCPF = new javax.swing.JFormattedTextField(cpf);
        }
        catch (Exception e){
        }
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
        jLabel18 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter cel= new javax.swing.text.MaskFormatter("(##) #####-####");
            jTextFieldCelular = new javax.swing.JFormattedTextField(cel);
        }
        catch (Exception e){
        }
        jPanel7 = new javax.swing.JPanel();
        jTextFieldCargo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxStatus = new javax.swing.JComboBox();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        addUser = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        cleanUser = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(71, 120, 197));
        jPanel4.setPreferredSize(new java.awt.Dimension(780, 840));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(84, 127, 206));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPasswordField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel5.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 310, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText(" Confirma Senha :  ");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 310, 40));

        jTextFieldSenha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel5.add(jTextFieldSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 310, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Senha :  ");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 310, 40));

        jTextFieldLogin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldLoginKeyTyped(evt);
            }
        });
        jPanel5.add(jTextFieldLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 310, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Login :  ");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 310, 40));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, 350, 280));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Novo Usuário");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 780, 40));

        jPanel6.setBackground(new java.awt.Color(84, 127, 206));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Nome :  ");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 310, 40));

        jTextFieldNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldNome.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNomeKeyTyped(evt);
            }
        });
        jPanel6.add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 310, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Sobrenome :  ");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 310, 40));

        jTextFieldSobreNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldSobreNome.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldSobreNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldSobreNomeKeyTyped(evt);
            }
        });
        jPanel6.add(jTextFieldSobreNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 310, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("CPF :  ");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 310, 40));

        jTextFieldCPF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldCPF.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldCPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCPFKeyTyped(evt);
            }
        });
        jPanel6.add(jTextFieldCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 310, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Telefone :  ");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 310, 40));

        jTextFieldTelefone.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldTelefone.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTelefoneKeyTyped(evt);
            }
        });
        jPanel6.add(jTextFieldTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 310, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Celular :  ");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 310, 40));

        jTextFieldCelular.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldCelular.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCelularKeyTyped(evt);
            }
        });
        jPanel6.add(jTextFieldCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 310, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("E-mail :");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 310, 40));

        jTextFieldEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldEmail.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldEmailKeyTyped(evt);
            }
        });
        jPanel6.add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 310, 30));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 350, 570));

        jPanel7.setBackground(new java.awt.Color(84, 127, 206));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldCargo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCargoKeyTyped(evt);
            }
        });
        jPanel7.add(jTextFieldCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 310, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Cargo :  ");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 310, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Status :  ");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 310, 40));

        jComboBoxStatus.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ativo", "Inativo" }));
        jComboBoxStatus.setBorder(null);
        jComboBoxStatus.setEnabled(false);
        jPanel7.add(jComboBoxStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 310, 30));

        jComboBoxTipo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Usuário" }));
        jComboBoxTipo.setBorder(null);
        jPanel7.add(jComboBoxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 310, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Tipo :  ");
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 310, 40));

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 350, 280));

        addUser.setBackground(new java.awt.Color(84, 127, 206));
        addUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addUserMouseClicked(evt);
            }
        });
        addUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/iconsAddUser.png"))); // NOI18N
        addUser.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));
        addUser.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 326, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Inserir Usuário");
        addUser.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 326, 48));

        jPanel4.add(addUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 350, 130));

        cleanUser.setBackground(new java.awt.Color(84, 127, 206));
        cleanUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cleanUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cleanUserMouseClicked(evt);
            }
        });
        cleanUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/iconsClean.png"))); // NOI18N
        cleanUser.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));
        cleanUser.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 326, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Limpar Campos");
        cleanUser.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 326, 48));

        jPanel4.add(cleanUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 650, 350, 130));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 810));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserMouseClicked
        // Método para adicionar um novo usuário no sistema
        String nome = jTextFieldNome.getText(); // Inicializa a variável
        String sobrenome = jTextFieldSobreNome.getText(); // Inicializa a variável
        String cpf = formatCPF(); // Inicializa a variável
        String telefone = jTextFieldTelefone.getText(); // Inicializa a variável
        String celular = jTextFieldCelular.getText(); // Inicializa a variável
        String email = jTextFieldEmail.getText(); // Inicializa a variável
        
        String cargo = jTextFieldCargo.getText(); // Inicializa a variável
        String status = (String) jComboBoxStatus.getSelectedItem(); // Inicializa a variável
        String tipo = (String) jComboBoxTipo.getSelectedItem(); // Inicializa a variável
        
        String login = jTextFieldLogin.getText(); // Inicializa a variável
        String senha = jTextFieldSenha.getText(); // Inicializa a variável
        String comfirmaSenha = jPasswordField1.getText(); // Inicializa a variável
        
        status = status.equals("Ativo") ? "1" : "0"; // Verificação ternária, se status for 'Ativo' status recebe '1' caso contrário recebe '0'
        tipo = tipo.equals("Administrador") ? "A" : "U"; // Verificação ternária, se tipo for 'Administrador' tipo recebe 'A' caso contrário recebe 'U'

        try { // Tentar realizar a inserção no banco
            int rowAffected = con.verifUser("SELECT LOGIN FROM colaboradores WHERE login='" + login + "'"); // Verifica se há o usuário no banco de dados
            if (rowAffected != 0) { // Se rowAffected for diferente de 0
                throw new Exception("1"); // Gera uma nova exceção
            }

            if ((login.equals("")) || (senha.equals("")) || (comfirmaSenha.equals("")) || (status.equals("")) || (sobrenome.equals(""))) { // Verifica se as entradas não são vazias
                if (!comfirmaSenha.equals(senha)) { // Verifica se as entradas de senhas são iguais
                    throw new Exception("2"); // Gera uma nova exceção caso atenda as duas condições
                }
                throw new Exception("3"); // Gera uma nova exceção caso atenda a primeira condição
            }
            
            con.inserirDados("INSERT INTO colaboradores ( LOGIN, SENHA, NOME, SOBRENOME, CARGO, TELEFONE, CELULAR, CPF, DATA_CADASTRO, STATUS, TIPO, EMAIL) "
                    + "VALUES ('" + login + "'," + DataBase.SHA1(senha) + ",'" + nome + "','" + sobrenome + "','" + cargo + "','" + telefone + "','" + celular + "','" + cpf + "', getdate(), " + status + ",'" + tipo + "','" + email + "');");
            // Realiza a inserção do novo usuário no banco
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE); // Mostra a mensagem de sucesso

        } catch (SQLException ex) { // Caso falhe a interação com o banco
            JOptionPane.showMessageDialog(null, "Erro no cadastro do usuário!", "ERROR", JOptionPane.ERROR_MESSAGE); // Mostra a mensagem de erro
        } catch (Exception ex) { // Caso falhe as verificações de inputs
            if (ex.getMessage().equals("1")) { // Se a mensagem for igual a 1
                JOptionPane.showMessageDialog(null, "Usuário já cadastrado no sistema!", "ERROR", JOptionPane.ERROR_MESSAGE); // Mostra a mensagem de erro
            }
            if (ex.getMessage().equals("2")) { // Se a mensagem for igual a 2
                JOptionPane.showMessageDialog(null, "As senhas não são identicas!", "ERROR", JOptionPane.ERROR_MESSAGE); // Mostra a mensagem de erro
            }
            if (ex.getMessage().equals("3")) { // Se a mensagem for igual a 3
                JOptionPane.showMessageDialog(null, "Preencha os campos corretamente!", "AVISO", JOptionPane.INFORMATION_MESSAGE); // Mostra a mensagem de aviso
            }
        }
        limpaCampos(); // Método para limpar os campos de inputs
    }//GEN-LAST:event_addUserMouseClicked

    private void cleanUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cleanUserMouseClicked
        // Método para limpar os campos de input
        limpaCampos(); // Chama o método para limpar os campos
    }//GEN-LAST:event_cleanUserMouseClicked

    private void jTextFieldSobreNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSobreNomeKeyTyped
        sanitaze(Pattern.compile("[a-zA-Z]|[\\W]").matcher(Character.toString(evt.getKeyChar())), evt);
    }//GEN-LAST:event_jTextFieldSobreNomeKeyTyped

    private void jTextFieldCPFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCPFKeyTyped
        sanitaze(Pattern.compile("[0-9]").matcher(Character.toString(evt.getKeyChar())), evt);
    }//GEN-LAST:event_jTextFieldCPFKeyTyped

    private void jTextFieldTelefoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelefoneKeyTyped
        sanitaze(Pattern.compile("[0-9]").matcher(Character.toString(evt.getKeyChar())), evt);
    }//GEN-LAST:event_jTextFieldTelefoneKeyTyped

    private void jTextFieldCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCelularKeyTyped
        sanitaze(Pattern.compile("[0-9]").matcher(Character.toString(evt.getKeyChar())), evt);
    }//GEN-LAST:event_jTextFieldCelularKeyTyped

    private void jTextFieldEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEmailKeyTyped
        sanitaze(Pattern.compile("[a-zA-Z]|[0-9]|@|_|\\.").matcher(Character.toString(evt.getKeyChar())), evt);
    }//GEN-LAST:event_jTextFieldEmailKeyTyped

    private void jTextFieldNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeKeyTyped
        sanitaze(Pattern.compile("[a-zA-Z]|[\\W]").matcher(Character.toString(evt.getKeyChar())), evt);
    }//GEN-LAST:event_jTextFieldNomeKeyTyped

    private void jTextFieldCargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCargoKeyTyped
        // TODO add your handling code here:
        sanitaze(Pattern.compile("[a-zA-Z]|[0-9]").matcher(Character.toString(evt.getKeyChar())), evt);
    }//GEN-LAST:event_jTextFieldCargoKeyTyped

    private void jTextFieldLoginKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldLoginKeyTyped
        // TODO add your handling code here:
        sanitaze(Pattern.compile("[a-zA-Z]|[0-9]").matcher(Character.toString(evt.getKeyChar())), evt);
    }//GEN-LAST:event_jTextFieldLoginKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addUser;
    private javax.swing.JPanel cleanUser;
    private javax.swing.JComboBox jComboBoxStatus;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextFieldCPF;
    private javax.swing.JTextField jTextFieldCargo;
    private javax.swing.JTextField jTextFieldCelular;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldLogin;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JPasswordField jTextFieldSenha;
    private javax.swing.JTextField jTextFieldSobreNome;
    private javax.swing.JTextField jTextFieldTelefone;
    // End of variables declaration//GEN-END:variables

}
