package screens;

import controller.ControllerNF;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddNF extends javax.swing.JFrame {
    public int gidNF;
    public String login; // Declaração da variável logLogin, usada para relatórios de inserção de usuários
    boolean pago;
    boolean inativo;
    public AddNF(String login, String action, int codigo, int id) throws SQLException { // Método para instanciar o frame addUser
        initComponents(); // Inicia Componentes do frame de addUser
        this.login = login;
        
        ControllerNF.carregarComboBox(jComboBoxPedidoCompra, "PEDIDO");
        jLabel14.setText(action);
        
        if(id>0){
        addUser.setVisible(false);
        addGravar.setVisible(true);
        gidNF=id;
        ArrayList campos = ControllerNF.carregarCamposNF(gidNF, jComboBoxPedidoCompra);
        //ID_NF_A","ID_FORNECEDOR_FK", "VALOR_NF", "NUM_NF", "ID_COLAB_FK", "OBSERVACOES", "ID_PEDIDO_FK
        jTextFieldFornecedor.setText(campos.get(1).toString());
        jTextFieldValor.setText(campos.get(2).toString());
        jTextFieldNumeroNF.setText(campos.get(3).toString());
        jTextFieldColaborador.setText(campos.get(4).toString());
        jTextFieldObservacao.setText(campos.get(5).toString());
        
            pago =ControllerNF.verifPago(gidNF);
            if(pago==true){
                pagar.setVisible(false);
                CancelaPag.setVisible(true);
            }else {
                pagar.setVisible(true);
                CancelaPag.setVisible(false);
            }
                
             inativo =ControllerNF.verifInativo(gidNF);
            if(inativo==true){
                ativarNF.setVisible(true);
                inativarNF.setVisible(false);
            }else {
                inativarNF.setVisible(true);
                ativarNF.setVisible(false);
            }
        }else{
            ativarNF.setVisible(false);
            pagar.setVisible(false);
            CancelaPag.setVisible(false);
            inativarNF.setVisible(false);
            
            //botões incluir e gravar
            addUser.setVisible(true);
            addGravar.setVisible(false);
        }
        
    }

    @Override
    public Image getIconImage() { // Método para alterar o icone da barra de tarefas
        return Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("pictures/iconLogoBar.png")); // Seta uma imagem como ícone
    } // Fim do método para alterar o icone da barra de tarefas
    
    private void carregarCampos(ArrayList<String> campos) {
        jTextFieldFornecedor.setText(campos.get(0));
        jTextFieldColaborador.setText(campos.get(1));
        jTextFieldValor.setText(campos.get(2));
    }

    private void limpaCampos() { // Método para limpar campos do formulário
        jComboBoxPedidoCompra.setSelectedItem(0); // Limpa campo Fornecedor
        jTextFieldValor.setText(""); // Limpa campo valor
        jTextFieldObservacao.setText(""); // Limpa campo observação
        jTextFieldNumeroNF.setText("");
    }
    
    private void sanitaze(Matcher matcher, KeyEvent evt){
        if(!matcher.find()){
            evt.consume();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ativarNF = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        pagarUpd2 = new javax.swing.JLabel();
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
        pagar = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        pagarUpd1 = new javax.swing.JLabel();
        CancelaPag = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        pagarUpd3 = new javax.swing.JLabel();
        addUser = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        addGravar = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        cleanUser = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        inativarNF = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        pagarUpd = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ativarNF.setBackground(new java.awt.Color(84, 127, 206));
        ativarNF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ativarNF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ativarNFMouseClicked(evt);
            }
        });
        ativarNF.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/iconsClean.png"))); // NOI18N
        ativarNF.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));
        ativarNF.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 210, 10));

        pagarUpd2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        pagarUpd2.setForeground(new java.awt.Color(255, 255, 255));
        pagarUpd2.setText("Ativar");
        ativarNF.add(pagarUpd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 190, 48));

        getContentPane().add(ativarNF, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 650, 230, 130));

        jPanel4.setBackground(new java.awt.Color(71, 120, 197));
        jPanel4.setPreferredSize(new java.awt.Dimension(780, 840));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Novo Nota Fiscal");
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
        jPanel6.add(jTextFieldColaborador, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 240, 30));

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

        jTextFieldValor.setEditable(false);
        jTextFieldValor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldValor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldValorKeyTyped(evt);
            }
        });
        jPanel6.add(jTextFieldValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 240, 30));

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
        jPanel6.add(jComboBoxPedidoCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 240, 30));

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
        jPanel6.add(jTextFieldFornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 500, 30));

        pagar.setBackground(new java.awt.Color(71, 120, 197));
        pagar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pagarMouseClicked(evt);
            }
        });
        pagar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/iconsClean.png"))); // NOI18N
        pagar.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));
        pagar.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 210, -1));

        pagarUpd1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        pagarUpd1.setForeground(new java.awt.Color(255, 255, 255));
        pagarUpd1.setText("Pagar");
        pagar.add(pagarUpd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 190, 48));

        jPanel6.add(pagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 230, 130));

        CancelaPag.setBackground(new java.awt.Color(71, 120, 197));
        CancelaPag.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CancelaPag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelaPagMouseClicked(evt);
            }
        });
        CancelaPag.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/iconsClean.png"))); // NOI18N
        CancelaPag.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));
        CancelaPag.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 230, 10));

        pagarUpd3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        pagarUpd3.setForeground(new java.awt.Color(255, 255, 255));
        pagarUpd3.setText("Cancelar Pagamento");
        CancelaPag.add(pagarUpd3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 240, 48));

        jPanel6.add(CancelaPag, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 250, 130));

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
        addUser.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 190, 10));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Inserir Nota");
        addUser.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 150, 48));

        jPanel4.add(addUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 210, 130));

        addGravar.setBackground(new java.awt.Color(84, 127, 206));
        addGravar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addGravar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addGravarMouseClicked(evt);
            }
        });
        addGravar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/iconsAddUser.png"))); // NOI18N
        addGravar.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));
        addGravar.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 190, 10));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Gravar Nota");
        addGravar.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 150, 48));

        jPanel4.add(addGravar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 210, 130));

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
        cleanUser.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 190, 10));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Limpar Campos");
        cleanUser.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 326, 48));

        jPanel4.add(cleanUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 650, 220, 130));

        inativarNF.setBackground(new java.awt.Color(84, 127, 206));
        inativarNF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inativarNF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inativarNFMouseClicked(evt);
            }
        });
        inativarNF.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/iconsClean.png"))); // NOI18N
        inativarNF.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));
        inativarNF.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 210, 10));

        pagarUpd.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        pagarUpd.setForeground(new java.awt.Color(255, 255, 255));
        pagarUpd.setText("Inativar NF");
        inativarNF.add(pagarUpd, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 190, 48));

        jPanel4.add(inativarNF, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 650, 230, 130));

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
        }
        String newIdPC;
        try {
            gidNF = ControllerNF.idNF();
            inativarNF.setVisible(true);
            pagar.setVisible(true);
            addGravar.setVisible(true);
            addUser.setVisible(false);
        } catch (SQLException ex) {
            
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

    private void inativarNFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inativarNFMouseClicked
      ControllerNF.AtivaNota(gidNF);
      ativarNF.setVisible(true);
      inativarNF.setVisible(false);
    }//GEN-LAST:event_inativarNFMouseClicked

    private void pagarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pagarMouseClicked
      ControllerNF.pagarNota(gidNF);
      CancelaPag.setVisible(true);
      pagar.setVisible(false);
    }//GEN-LAST:event_pagarMouseClicked

    private void ativarNFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ativarNFMouseClicked
       ControllerNF.inativarNota(gidNF);
       ativarNF.setVisible(false);
       inativarNF.setVisible(true);
    }//GEN-LAST:event_ativarNFMouseClicked

    private void CancelaPagMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelaPagMouseClicked
        ControllerNF.cancelaPagar(gidNF);
        pagar.setVisible(true);
        CancelaPag.setVisible(false);
    }//GEN-LAST:event_CancelaPagMouseClicked

    private void addGravarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addGravarMouseClicked
        try {
            if (ControllerNF.updNF(new String[] {
                jTextFieldFornecedor.getText(),
                jTextFieldValor.getText(),
                jTextFieldNumeroNF.getText(),
                jTextFieldColaborador.getText(),
                jTextFieldObservacao.getText(),            
                jComboBoxPedidoCompra.getSelectedItem().toString(),
                Integer.toString(gidNF)})){
                this.dispose();
            
        }}
        catch (SQLException ex) {
            Logger.getLogger(AddNF.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_addGravarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CancelaPag;
    private javax.swing.JPanel addGravar;
    private javax.swing.JPanel addUser;
    private javax.swing.JPanel ativarNF;
    private javax.swing.JPanel cleanUser;
    private javax.swing.JPanel inativarNF;
    private javax.swing.JComboBox<String> jComboBoxPedidoCompra;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTextField jTextFieldColaborador;
    private javax.swing.JTextField jTextFieldFornecedor;
    private javax.swing.JTextField jTextFieldNumeroNF;
    private javax.swing.JTextField jTextFieldObservacao;
    private javax.swing.JTextField jTextFieldValor;
    private javax.swing.JPanel pagar;
    private javax.swing.JLabel pagarUpd;
    private javax.swing.JLabel pagarUpd1;
    private javax.swing.JLabel pagarUpd2;
    private javax.swing.JLabel pagarUpd3;
    // End of variables declaration//GEN-END:variables

}
