package screens;

import controller.ControllerNF;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.regex.Matcher;

public class ActionViewAddNF extends javax.swing.JFrame {

    public String login; // Declaração da variável logLogin, usada para relatórios de inserção de usuários
    public int Id_nf;
    
    
    public ActionViewAddNF(String login, String action, int codigo) { // Método para instanciar o frame addUser
        initComponents(); // Inicia Componentes do frame de addUser
        this.login = login;
        jLabel14.setText(action);
        
        ArrayList<String> camposNF = ControllerNF.GetPedidoById(codigo);
        carregarCampos(camposNF);
        Id_nf = codigo;
    }

    @Override
    public Image getIconImage() { // Método para alterar o icone da barra de tarefas
        return Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("pictures/iconLogoBar.png")); // Seta uma imagem como ícone
    } // Fim do método para alterar o icone da barra de tarefas
    
    private void carregarCampos(ArrayList<String> campos) {
        jTextFieldNumeroNF.setText(campos.get(0));
        jTextFieldPedidoCompra.setText(campos.get(1));
        jTextFieldFornecedor.setText(campos.get(2));
        jTextFieldColaborador.setText(campos.get(3));
        jTextFieldValor.setText(campos.get(4));
        jTextFieldObservacao.setText(campos.get(5));
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
        jLabel6 = new javax.swing.JLabel();
        jTextFieldPedidoCompra = new javax.swing.JTextField();
        jTextFieldFornecedor = new javax.swing.JTextField();
        jTextFieldNumeroNF = new javax.swing.JTextField();
        addUser = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();

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
        jPanel6.add(jTextFieldColaborador, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 260, 30));

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
        jPanel6.add(jTextFieldValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 190, 30));

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

        jTextFieldObservacao.setEditable(false);
        jTextFieldObservacao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldObservacao.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel6.add(jTextFieldObservacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 680, 130));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("N° da Nota Fiscal :");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 310, 40));

        jTextFieldPedidoCompra.setEditable(false);
        jTextFieldPedidoCompra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldPedidoCompra.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel6.add(jTextFieldPedidoCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 260, 30));

        jTextFieldFornecedor.setEditable(false);
        jTextFieldFornecedor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldFornecedor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel6.add(jTextFieldFornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 680, 30));

        jTextFieldNumeroNF.setEditable(false);
        jTextFieldNumeroNF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldNumeroNF.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel6.add(jTextFieldNumeroNF, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 680, 30));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 720, 570));

        addUser.setBackground(new java.awt.Color(84, 127, 206));
        addUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addUserMouseClicked(evt);
            }
        });
        addUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/iconsExit.png"))); // NOI18N
        addUser.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));
        addUser.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 326, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Inativar Nota");
        addUser.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 326, 48));

        jPanel4.add(addUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 350, 130));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 810));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserMouseClicked
        //Botão para Inativar Nota Fiscal
        if (ControllerNF.verificarStatusNF(this, Id_nf)) {
            ControllerNF.inativarNota(Id_nf);
        }
    }//GEN-LAST:event_addUserMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addUser;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextFieldColaborador;
    private javax.swing.JTextField jTextFieldFornecedor;
    private javax.swing.JTextField jTextFieldNumeroNF;
    private javax.swing.JTextField jTextFieldObservacao;
    private javax.swing.JTextField jTextFieldPedidoCompra;
    private javax.swing.JTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables

}
