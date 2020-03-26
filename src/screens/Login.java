package screens;

//==================================> Importações pertinentes á execução do frame
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import controller.ControllerLogin;
import javax.swing.JOptionPane;
//==================================> Fim das importações

public class Login extends javax.swing.JFrame {

    public Login() {  // Método para instanciar o frame login
        initComponents(); // Inicia Componentes do frame de login
        password.setEchoChar(Character.forDigit(0, 0)); // Inicializa o campo password como caracteres visíveis
        this.setLocationRelativeTo(null); // Inicializa o frame centralizado na tela
        jLabel1.requestFocus();
    } // Fim do método de instanciação

    @Override
    public Image getIconImage() { // Método para alterar o icone da barra de tarefas
        return Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("pictures/iconLogoBar.png")); // Seta uma imagem como ícone
    } // Fim do método para alterar o icone da barra de tarefas

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        username = new javax.swing.JTextField();
        showPass = new javax.swing.JToggleButton();
        password = new javax.swing.JPasswordField();
        iconUser = new javax.swing.JLabel();
        iconLockPass = new javax.swing.JLabel();
        logon = new javax.swing.JButton();
        iconInfo = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setIconImage(getIconImage());
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        username.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        username.setForeground(new java.awt.Color(153, 153, 153));
        username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        username.setText("Username");
        username.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        username.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        username.setName(""); // NOI18N
        username.setNextFocusableComponent(password);
        username.setVerifyInputWhenFocusTarget(false);
        username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameFocusLost(evt);
            }
        });
        username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usernameKeyTyped(evt);
            }
        });
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 210, 205, 35));

        showPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/iconsShowPassLogin.png"))); // NOI18N
        showPass.setBorder(null);
        showPass.setContentAreaFilled(false);
        showPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showPass.setFocusPainted(false);
        showPass.setNextFocusableComponent(logon);
        showPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPassActionPerformed(evt);
            }
        });
        getContentPane().add(showPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 30, 35));

        password.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        password.setForeground(new java.awt.Color(153, 153, 153));
        password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        password.setText("Password");
        password.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        password.setNextFocusableComponent(logon);
        password.setPreferredSize(new java.awt.Dimension(76, 28));
        password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFocusLost(evt);
            }
        });
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordKeyTyped(evt);
            }
        });
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 260, 160, 35));

        iconUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/iconsUserLogin.png"))); // NOI18N
        getContentPane().add(iconUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 30, 35));

        iconLockPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/iconsLockPass.png"))); // NOI18N
        getContentPane().add(iconLockPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 30, 35));

        logon.setBackground(new java.awt.Color(102, 255, 102));
        logon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        logon.setForeground(new java.awt.Color(255, 255, 255));
        logon.setText("Logon");
        logon.setBorderPainted(false);
        logon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logon.setDefaultCapable(false);
        logon.setFocusPainted(false);
        logon.setNextFocusableComponent(exit);
        logon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logonMouseExited(evt);
            }
        });
        logon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logonActionPerformed(evt);
            }
        });
        getContentPane().add(logon, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 150, 40));

        iconInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/iconsInfo.png"))); // NOI18N
        iconInfo.setToolTipText("");
        getContentPane().add(iconInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 30, 40));

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/iconsExit.png"))); // NOI18N
        exit.setBorder(null);
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.setNextFocusableComponent(username);
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/iconLogoSamuWall.png"))); // NOI18N
        jLabel1.setNextFocusableComponent(username);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, 150));

        jTextField2.setBorder(null);
        jTextField2.setFocusable(false);
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 260, 20, 35));

        jTextField1.setBorder(null);
        jTextField1.setFocusable(false);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 30, 35));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/background.jpg"))); // NOI18N
        background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backgroundMouseClicked(evt);
            }
        });
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(-320, 0, 570, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusGained
        // Método para realizar a primeira parte do placeholder, quando o campo ganha foco o texto padrão é retirado
        if (username.getText().equals("Username")) { // Inicio da verificação do campo username se estiver com o texto padrão
            username.setText(""); // O texto padrão é retirado
        }
    }//GEN-LAST:event_usernameFocusGained

    private void usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusLost
        // Método para realizar a segunda parte do placeholder, quando o campo ganha foco o texto padrão é retirado
        if (username.getText().equals("")) { // Inicio da verificação do campo username se estiver com o texto vazio
            username.setText("Username"); // O texto é substituido pelo texto padrão
        }
    }//GEN-LAST:event_usernameFocusLost

    private void passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusGained
        // Método para realizar a primeira parte do placeholder, quando o campo ganha foco o texto padrão é retirado
        if (password.getText().equals("Password")) { // Inicio da verificação do campo password se estiver com o texto padrão
            password.setText(""); // O texto padrão é retirado
            password.setEchoChar('*'); // O campo password é alterado para caracteres ' * '
        }
    }//GEN-LAST:event_passwordFocusGained

    private void passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusLost
        // Método para realizar a segunda parte do placeholder, quando o campo ganha foco o texto padrão é retirado
        if (password.getText().equals("")) { // Inicio da verificação do campo password se estiver com o texto vazio
            password.setText("Password"); // O texto é substituido pelo texto padrão
            password.setEchoChar(Character.forDigit(0, 0)); // O campo password é alterado como caracteres visíveis
        }
    }//GEN-LAST:event_passwordFocusLost

    private void showPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPassActionPerformed
        // Método para realizar a alteração da visibilidade da senha
        if (password.getEchoChar() == '*') { // Inicio da verificação do campo password se estiver com caracteres ' * '
            password.setEchoChar(Character.forDigit(0, 0)); // O password é alterado como caracteres visíveis
        } else if (!password.getText().equals("Password")) { // Se não, é verificado se o campo password não está com o texto padrão
            password.setEchoChar('*'); // Se não estiver com o texto padrão, os caracteres são trocados para invisiveis ' * '
        }
    }//GEN-LAST:event_showPassActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // Método para realizar o encerramento da aplicação
        ControllerLogin.disconnection(); // Realiza da desconexão com o banco
        System.exit(0); // Fecha o frame da aplicação
    }//GEN-LAST:event_exitActionPerformed

    private void logonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logonActionPerformed
        // Método para chamar a método logar, responsável por realizar o login ao sistema 
        String[] resp = ControllerLogin.logar(username.getText(), password.getText());
        if (resp[0].equals("OK")) {
            this.dispose();
            System.out.println("fechando LOGIN! CLIQUE");
        }
        username.setText(resp[0]);
        password.setText(resp[1]);
        password.setEchoChar(Character.forDigit(0, 0));
        username.requestFocus();
    }//GEN-LAST:event_logonActionPerformed

    private void logonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logonMouseEntered
        // Método para realizar a troca de cor (Azul) quando o mouse entra no botão 
        logon.setBackground(new Color(135, 206, 250)); // Troca a cor do botão (Azul)
    }//GEN-LAST:event_logonMouseEntered

    private void logonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logonMouseExited
        // Método para realizar a troca de cor (Verde) quando o mouse sai no botão
        logon.setBackground(new Color(102, 255, 102)); // Troca a cor do botão (Verde)
    }//GEN-LAST:event_logonMouseExited

    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed
        // Método para realizar o login quando a tecla 'ENTER' for pressinada e estiver no campo password
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) { // Verifica se a tecla 'ENTER' foi pressionada
            String[] resp = ControllerLogin.logar(username.getText(), password.getText()); // Chama o método logar
             if (resp[0].equals("OK")) {
                this.dispose();
                System.out.println("fechando LOGIN! ENTER");
            }
            username.setText(resp[0]);
            password.setText(resp[1]);
            password.setEchoChar(Character.forDigit(0, 0));
            exit.requestFocus();
        } // Fim da verificação
    }//GEN-LAST:event_passwordKeyPressed

    private void backgroundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundMouseClicked
        // Método para mudar o foco para o background
        background.requestFocus(); // Mudando o foco background
    }//GEN-LAST:event_backgroundMouseClicked

    private void usernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyTyped
        // Método usado para verificar a entrada do usuário para evitar SQLInjection
        Matcher matcher = Pattern.compile("[^\\w]").matcher(Character.toString(evt.getKeyChar())); // Compara o caractere digitado com a expressão regular
        if (matcher.find()) { // Se achar o caractere imprópio 
            evt.consume();// Não deixa ele ser escrito
        } // Fim da vetificação
    }//GEN-LAST:event_usernameKeyTyped

    private void passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyTyped
        // Método usado para verificar a entrada do usuário para evitar SQLInjection
        Matcher matcher = Pattern.compile("[^\\w]").matcher(Character.toString(evt.getKeyChar())); // Compara o caractere digitado com a expressão regular
        if (matcher.find()) { // Se achar o caractere imprópio 
            evt.consume();// Não deixa ele ser escrito
        } // Fim da vetificação
    }//GEN-LAST:event_passwordKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton exit;
    private javax.swing.JLabel iconInfo;
    private javax.swing.JLabel iconLockPass;
    private javax.swing.JLabel iconUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton logon;
    private javax.swing.JPasswordField password;
    private javax.swing.JToggleButton showPass;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
