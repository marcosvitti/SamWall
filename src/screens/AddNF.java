package screens;

import controller.ControllerNF;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddNF extends javax.swing.JFrame {

    public String login; // Declaração da variável logLogin, usada para relatórios de inserção de usuários

    public AddNF(String login, String action, int codigo) { // Método para instanciar o frame addUser
        initComponents(); // Inicia Componentes do frame de addUser
        this.login = login;
        //ControllerNF.carregarComboBox(jComboBoxFornecedor, "FORNECEDOR");
        //ControllerNF.carregarComboBox(jComboBoxColaborador, "COLABORADOR");
        ControllerNF.carregarComboBox(jComboBoxPedidoCompra, "PEDIDO");
        jLabel14.setText(action);
        
        if(codigo > 0) {
            //ArrayList<String> nf = ControllerNF.getNF();
        }
        
    }

    @Override
    public Image getIconImage() { // Método para alterar o icone da barra de tarefas
        return Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("pictures/iconLogoBar.png")); // Seta uma imagem como ícone
    } // Fim do método para alterar o icone da barra de tarefas
    
    private void carregarCampos(ArrayList<String> campos) { 
        
        jTextFieldFornecedor.setText(campos.get(0));
        jTextFieldColaborador.setText(campos.get(1));
        
    }

    private void limpaCampos() { // Método para limpar campos do formulário
        jTextFieldColaborador.setText(""); // Limpa campo Numero da nota fiscal
        jComboBoxPedidoCompra.setSelectedItem(0); // Limpa campo Fornecedor
        jTextFieldColaborador.setText("");// Limpa campo Colaborador
        jTextFieldFornecedor.setText("");// Limpa campo Colaborador
        jTextFieldValor.setText(""); // Limpa campo valor
        jTextFieldObservacao.setText(""); // Limpa campo observação
    }
    
    private void sanitaze(Matcher matcher, KeyEvent evt){
        if(!matcher.find()){
            evt.consume();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldColaborador = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldValor = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextFieldObservacao = new javax.swing.JTextField();
        jComboBoxPedidoCompra = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldNumeroNF = new javax.swing.JTextField();
        jTextFieldFornecedor = new javax.swing.JTextField();
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
        jLabel4.setText("N° do Pedido de Compra :");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 310, 40));

        jTextFieldColaborador.setEditable(false);
        jTextFieldColaborador.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldColaborador.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldColaborador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldColaboradorKeyTyped(evt);
            }
        });
        jPanel6.add(jTextFieldColaborador, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 680, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Fornecedor :");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 310, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Colaborador :  ");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 310, 40));

        jTextFieldValor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldValor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldValorKeyTyped(evt);
            }
        });
        jPanel6.add(jTextFieldValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 310, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Valor :");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 310, 40));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Observações :");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 310, 40));

        jTextFieldObservacao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldObservacao.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel6.add(jTextFieldObservacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 680, 130));

        jComboBoxPedidoCompra.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxPedidoCompraItemStateChanged(evt);
            }
        });
        jPanel6.add(jComboBoxPedidoCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 680, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("N° da Nota Fiscal :");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 310, 40));

        jTextFieldNumeroNF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldNumeroNF.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldNumeroNF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNumeroNFKeyTyped(evt);
            }
        });
        jPanel6.add(jTextFieldNumeroNF, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 680, 30));

        jTextFieldFornecedor.setEditable(false);
        jTextFieldFornecedor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldFornecedor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldFornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldFornecedorKeyTyped(evt);
            }
        });
        jPanel6.add(jTextFieldFornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 680, 30));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 720, 570));

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
        if (ControllerNF.criarNF(new String[] {
            jTextFieldNumeroNF.getText(),
            jTextFieldValor.getText(),
            jTextFieldObservacao.getText(), 
            jComboBoxPedidoCompra.getSelectedItem().toString(), 
            jTextFieldColaborador.getText(),
            jTextFieldFornecedor.getText()})) {
            limpaCampos(); // Método para limpar os campos de inputs
            this.dispose();
        }
    }//GEN-LAST:event_addUserMouseClicked

    private void cleanUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cleanUserMouseClicked
        // Método para limpar os campos de input
        limpaCampos(); // Chama o método para limpar os campos
    }//GEN-LAST:event_cleanUserMouseClicked

    private void jTextFieldValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldValorKeyTyped
        sanitaze(Pattern.compile("[0-9]").matcher(Character.toString(evt.getKeyChar())), evt);
    }//GEN-LAST:event_jTextFieldValorKeyTyped
//sanitaze(Pattern.compile("[a-zA-Z]|[0-9]|@|_|\\.").matcher(Character.toString(evt.getKeyChar())), evt);
    private void jTextFieldColaboradorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldColaboradorKeyTyped
        sanitaze(Pattern.compile("[0-9]").matcher(Character.toString(evt.getKeyChar())), evt);
    }//GEN-LAST:event_jTextFieldColaboradorKeyTyped

    private void jComboBoxPedidoCompraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxPedidoCompraItemStateChanged
        // TODO add your handling code here:
        if(!jComboBoxPedidoCompra.equals("")) {
            ArrayList<String> camposPedido = ControllerNF.GetPedidoCompra(jComboBoxPedidoCompra.getSelectedItem().toString(), login);
            carregarCampos(camposPedido);
        }
    }//GEN-LAST:event_jComboBoxPedidoCompraItemStateChanged

    private void jTextFieldNumeroNFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNumeroNFKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumeroNFKeyTyped

    private void jTextFieldFornecedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFornecedorKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFornecedorKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addUser;
    private javax.swing.JPanel cleanUser;
    private javax.swing.JComboBox<String> jComboBoxPedidoCompra;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextFieldColaborador;
    private javax.swing.JTextField jTextFieldFornecedor;
    private javax.swing.JTextField jTextFieldNumeroNF;
    private javax.swing.JTextField jTextFieldObservacao;
    private javax.swing.JTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables

}
