package screens;

import controller.ControllerPC;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.sound.midi.Soundbank;
import javax.swing.JOptionPane;

public class AddPC extends javax.swing.JFrame {

    public String login; // Declaração da variável logLogin, usada para relatórios de inserção de usuários
    public int idPC;
    public AddPC(String login, String action) throws SQLException { // Método para instanciar o frame addUser
        initComponents(); // Inicia Componentes do frame de addUser
        
        this.login = login;
        
        jTextFieldColab.setText(ControllerPC.nomeColab(login));
        jTextFieldContato.setText(" ");
        ControllerPC.carregarComboBox(jComboBoxFornecedor, "FORNECEDOR");
        
        jLabel14.setText(action); 
        addItens.setVisible(false);
    }

    @Override
    public Image getIconImage() { // Método para alterar o icone da barra de tarefas
        return Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("pictures/iconLogoBar.png")); // Seta uma imagem como ícone
    } // Fim do método para alterar o icone da barra de tarefas
    
    private void carregarCampos(ArrayList<String> campos) { 
        /*
        jTextFieldLogin.setText(campos.get(1));
        jTextFieldNumeroNF.setText(campos.get(2));
        jTextFieldSobreNome.setText(campos.get(3));
        jTextFieldCargo.setText(campos.get(4));
        jTextFieldObservacao.setText(campos.get(5));
        jTextFieldCelular.setText(campos.get(6));
        jTextFieldCPF.setText(campos.get(7));
        jComboBoxStatus.setSelectedItem(campos.get(8));
        jComboBoxTipo.setSelectedItem(campos.get(9));     
        jTextFieldEmail.setText(campos.get(10));
        */
    }

    private void limpaCampos() { // Método para limpar campos do formulário
        jComboBoxFornecedor.setSelectedItem(0);// Limpa campo Colaborador
        jTextFieldColab.setText(""); //Limpa campo Quantidade parcela
        jTextFieldContato.setText(""); // Limpa campo valor
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
        lId = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldColab = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextFieldObservacao = new javax.swing.JTextField();
        jComboBoxFornecedor = new javax.swing.JComboBox<>();
        jTextFieldContato = new javax.swing.JTextField();
        addItens = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldValor1 = new javax.swing.JTextField();
        addPC = new javax.swing.JPanel();
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
        jLabel14.setText("Pedido de Compra");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 780, 40));

        jPanel6.setBackground(new java.awt.Color(84, 127, 206));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lId.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lId.setForeground(new java.awt.Color(255, 255, 255));
        lId.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel6.add(lId, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 310, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Fornecedor :");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 310, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Colaborador :  ");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 310, 40));

        jTextFieldColab.setEditable(false);
        jTextFieldColab.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldColab.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldColab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldColabKeyTyped(evt);
            }
        });
        jPanel6.add(jTextFieldColab, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 180, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Valor :");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 310, 40));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Observações :");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 310, 40));

        jTextFieldObservacao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldObservacao.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel6.add(jTextFieldObservacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 680, 130));

        jPanel6.add(jComboBoxFornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 330, 30));

        jTextFieldContato.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldContato.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldContato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldContatoKeyTyped(evt);
            }
        });
        jPanel6.add(jTextFieldContato, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 330, 30));

        addItens.setBackground(new java.awt.Color(84, 127, 206));
        addItens.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addItens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addItensMouseClicked(evt);
            }
        });
        addItens.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/iconsAddUser.png"))); // NOI18N
        addItens.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));
        addItens.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 326, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Inserir Itens");
        addItens.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 170, 48));

        jPanel6.add(addItens, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, 190, 130));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("N° do Pedido de Compra :");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 310, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Contato:");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 310, 40));

        jTextFieldValor1.setEditable(false);
        jTextFieldValor1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldValor1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldValor1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldValor1KeyTyped(evt);
            }
        });
        jPanel6.add(jTextFieldValor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 180, 30));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 720, 570));

        addPC.setBackground(new java.awt.Color(84, 127, 206));
        addPC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addPC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addPCMouseClicked(evt);
            }
        });
        addPC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/iconsAddUser.png"))); // NOI18N
        addPC.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));
        addPC.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 326, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Gravar Pedido");
        addPC.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 326, 48));

        jPanel4.add(addPC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 350, 130));

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

    private void addPCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPCMouseClicked
        if(jComboBoxFornecedor.getSelectedItem().toString().equals("Selecione...")){
            JOptionPane.showMessageDialog(null,"Selecione um fornecedor");
        }
            if (ControllerPC.criarPC(new String[] {
            jComboBoxFornecedor.getSelectedItem().toString(),
            jTextFieldContato.getText(),
            login, 
            jTextFieldObservacao.getText(), 
            })){ 
        String newIdPC;
            try {
                newIdPC = Integer.toString(ControllerPC.idPC());
                lId.setText(newIdPC);
                idPC=Integer.parseInt(newIdPC);
                
            } catch (SQLException ex) {
            }
        }
           
           addItens.setVisible(true);
    }//GEN-LAST:event_addPCMouseClicked

    private void cleanUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cleanUserMouseClicked
        // Método para limpar os campos de input
        limpaCampos(); // Chama o método para limpar os campos
    }//GEN-LAST:event_cleanUserMouseClicked

    private void jTextFieldColabKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldColabKeyTyped
        sanitaze(Pattern.compile("[0-9]").matcher(Character.toString(evt.getKeyChar())), evt);
    }//GEN-LAST:event_jTextFieldColabKeyTyped

    private void jTextFieldContatoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldContatoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldContatoKeyTyped

    private void addItensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addItensMouseClicked
        ControllerPC.inserirItens(this.login, "Listar produtos", this.idPC);
    }//GEN-LAST:event_addItensMouseClicked

    private void jTextFieldValor1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldValor1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldValor1KeyTyped
//sanitaze(Pattern.compile("[a-zA-Z]|[0-9]|@|_|\\.").matcher(Character.toString(evt.getKeyChar())), evt);
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addItens;
    private javax.swing.JPanel addPC;
    private javax.swing.JPanel cleanUser;
    private javax.swing.JComboBox<String> jComboBoxFornecedor;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField jTextFieldColab;
    private javax.swing.JTextField jTextFieldContato;
    private javax.swing.JTextField jTextFieldObservacao;
    private javax.swing.JTextField jTextFieldValor1;
    private javax.swing.JLabel lId;
    // End of variables declaration//GEN-END:variables

}
