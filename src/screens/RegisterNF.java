package screens;

import dataBase.DataBase;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RegisterNF extends javax.swing.JFrame {

    private DataBase con = new DataBase();
    private int qtdT;
    private Double precoT;

    public RegisterNF(String username, DataBase con, String numNF) {
        initComponents();
        setConnection(con);
        userName.setText(buscarLogin(username));
        //userName.setText(username);
        jTextFieldNumNF.setText(numNF);
        jTextFieldValor.setText("0.00");
        comboBox();
        listarTabela(numNF);
        this.setLocationRelativeTo(null);
    }

    public Image getIconImage() {
        Image retvalue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("pictures/iconLogoBar.png"));
        return retvalue;
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

    public void comboBox() {
        try {
            jComboBoxFornecedor = con.selectFornecedor("SELECT RAZAO_SOCIAL FROM fornecedor", jComboBoxFornecedor);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de fornecedor", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setConnection(DataBase con) {
        this.con = con;
    }

    public void listarTabela(String numNF) {
        try {
            int idNF = con.acharIdNF("SELECT ID_NF_A FROM nf_a WHERE NUM_NF='" + numNF + "'");
            ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
            jTable1 = con.listaTabelaRegisterNF("SELECT ID_PROD_NF,DESCRICAO_PROD,QTD_PROD,VALOR_UNIT FROM produto_nf WHERE ID_NF_FK=" + idNF, jTable1);
        } catch (SQLException ex) {
            if (ex.getMessage().equals("1")) {
                JOptionPane.showMessageDialog(null, "Erro de Produto", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            if (ex.getMessage().equals("2")) {
                JOptionPane.showMessageDialog(null, "Erro na Nota", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void habilitaProduto() {
        preco.setEnabled(true);
        produto.setEnabled(true);
        quantidade.setEnabled(true);
        addProd.setEnabled(true);
        clear.setEnabled(true);
    }

    public void desabilitaNF() {
        jComboBoxFornecedor.setEnabled(false);
        jComboBoxStatus.setEnabled(false);
        jTextFieldValor.setEnabled(false);
        jTextFieldData.setEnabled(false);
        jTextAreaObservacoes.setEnabled(false);
        jTextFieldNumParcela.setEnabled(false);
        confirm.setEnabled(false);
    }

    private void carregarCampos(int linha) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        id.setText((String) model.getValueAt(linha, 0));
        produto.setText((String) model.getValueAt(linha, 1));
        preco.setText((String) model.getValueAt(linha, 2));
        quantidade.setText((String) model.getValueAt(linha, 3));
    }

    public void limpaCampos() {
        this.id.setText("");
        this.produto.setText("");
        this.preco.setText("");
        this.quantidade.setText("");
    }

    public void limpaBotoes() {
        addProd.setEnabled(true);
        alterar.setEnabled(false);
        remove.setEnabled(false);
    }

    public void atualizaPrecoTotal(int qtdT, Double precoT) {
        this.qtdT = qtdT;
        this.precoT = precoT;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        returnScreen = new javax.swing.JButton();
        numNF = new javax.swing.JLabel();
        nameForn = new javax.swing.JLabel();
        jTextFieldNumNF = new javax.swing.JTextField();
        jComboBoxFornecedor = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jComboBoxStatus = new javax.swing.JComboBox<>();
        jTextFieldData = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter date= new javax.swing.text.MaskFormatter("##-##-####");
            jTextFieldData = new javax.swing.JFormattedTextField(date);
        }
        catch (Exception e){
        }
        jTextFieldValor = new javax.swing.JTextField();
        valorNota = new javax.swing.JLabel();
        dataEmiton = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        jTextFieldNumParcela = new javax.swing.JTextField();
        numParcelas = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTextAreaObservacoes = new javax.swing.JTextArea();
        observacoes = new javax.swing.JLabel();
        confirm = new javax.swing.JButton();
        viewNF = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        produto1 = new javax.swing.JLabel();
        produto2 = new javax.swing.JLabel();
        produto3 = new javax.swing.JLabel();
        produto4 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        preco = new javax.swing.JTextField();
        quantidade = new javax.swing.JTextField();
        produto = new javax.swing.JTextField();
        addProd = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        alterar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        submit = new javax.swing.JButton();
        background = new javax.swing.JLabel();
        userName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("REGISTRAR NOTA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 530, -1));

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/iconsExit.png"))); // NOI18N
        exit.setBorder(null);
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.setFocusPainted(false);
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, -1, -1));

        returnScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/iconBack.png"))); // NOI18N
        returnScreen.setBorder(null);
        returnScreen.setBorderPainted(false);
        returnScreen.setContentAreaFilled(false);
        returnScreen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        returnScreen.setFocusPainted(false);
        returnScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnScreenActionPerformed(evt);
            }
        });
        getContentPane().add(returnScreen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        numNF.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        numNF.setForeground(new java.awt.Color(51, 51, 51));
        numNF.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        numNF.setText("N° da NF :  ");
        getContentPane().add(numNF, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 150, 20));

        nameForn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        nameForn.setForeground(new java.awt.Color(51, 51, 51));
        nameForn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nameForn.setText("Fornecedor :  ");
        getContentPane().add(nameForn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 150, 20));
        nameForn.getAccessibleContext().setAccessibleName("");
        nameForn.getAccessibleContext().setAccessibleDescription("");

        jTextFieldNumNF.setEditable(false);
        jTextFieldNumNF.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextFieldNumNF.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldNumNF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(240, 240, 240), new java.awt.Color(240, 240, 240), new java.awt.Color(240, 240, 240), new java.awt.Color(240, 240, 240)));
        getContentPane().add(jTextFieldNumNF, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 330, 20));

        jComboBoxFornecedor.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jComboBoxFornecedor.setBorder(null);
        getContentPane().add(jComboBoxFornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 330, 20));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3), "Informações da NF-e", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 18), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxStatus.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Aprovada", "Reprovada", "Pendente" }));
        jComboBoxStatus.setBorder(null);
        jPanel2.add(jComboBoxStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 130, 20));

        jTextFieldData.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextFieldData.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldData.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jPanel2.add(jTextFieldData, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 130, 20));

        jTextFieldValor.setEditable(false);
        jTextFieldValor.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextFieldValor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldValor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(240, 240, 240), new java.awt.Color(240, 240, 240), new java.awt.Color(240, 240, 240), new java.awt.Color(240, 240, 240)));
        jPanel2.add(jTextFieldValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 130, 20));

        valorNota.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        valorNota.setForeground(new java.awt.Color(51, 51, 51));
        valorNota.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        valorNota.setText("Valor Nota :  ");
        valorNota.setToolTipText("");
        jPanel2.add(valorNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 140, 20));
        valorNota.getAccessibleContext().setAccessibleName("");

        dataEmiton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        dataEmiton.setForeground(new java.awt.Color(51, 51, 51));
        dataEmiton.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dataEmiton.setText("Data da Emissão :  ");
        dataEmiton.setToolTipText("");
        jPanel2.add(dataEmiton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 140, 20));
        dataEmiton.getAccessibleContext().setAccessibleName("");

        status.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        status.setForeground(new java.awt.Color(51, 51, 51));
        status.setText("Status da NF-e :  ");
        jPanel2.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jTextFieldNumParcela.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextFieldNumParcela.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldNumParcela.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jPanel2.add(jTextFieldNumParcela, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 50, 20));

        numParcelas.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        numParcelas.setForeground(new java.awt.Color(51, 51, 51));
        numParcelas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        numParcelas.setText("Nº de Parcela(s) :  ");
        numParcelas.setToolTipText("");
        jPanel2.add(numParcelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 150, 20));
        numParcelas.getAccessibleContext().setAccessibleName("");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3), "Descrição", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 18), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 10, 160));

        jTextAreaObservacoes.setColumns(20);
        jTextAreaObservacoes.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextAreaObservacoes.setRows(5);
        jTextAreaObservacoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jPanel2.add(jTextAreaObservacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 210, 90));

        observacoes.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        observacoes.setForeground(new java.awt.Color(51, 51, 51));
        observacoes.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        observacoes.setText("Observações :  ");
        observacoes.setToolTipText("");
        jPanel2.add(observacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 120, 20));
        observacoes.getAccessibleContext().setAccessibleName("");

        confirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/iconConfirm.png"))); // NOI18N
        confirm.setBorder(null);
        confirm.setBorderPainted(false);
        confirm.setContentAreaFilled(false);
        confirm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        confirm.setFocusPainted(false);
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });
        jPanel2.add(confirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, -1, -1));

        viewNF.setBackground(new java.awt.Color(255, 255, 255));
        viewNF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/iconAdd.png"))); // NOI18N
        viewNF.setToolTipText("View NF-e");
        viewNF.setBorder(null);
        viewNF.setBorderPainted(false);
        viewNF.setContentAreaFilled(false);
        viewNF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewNF.setFocusPainted(false);
        viewNF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewNFActionPerformed(evt);
            }
        });
        jPanel2.add(viewNF, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 620, 180));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3), "Produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 18), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        produto1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        produto1.setForeground(new java.awt.Color(51, 51, 51));
        produto1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        produto1.setText("Quantidade : ");
        produto1.setToolTipText("");
        jPanel4.add(produto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 100, 20));

        produto2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        produto2.setForeground(new java.awt.Color(51, 51, 51));
        produto2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        produto2.setText("Preço Unit. : ");
        produto2.setToolTipText("");
        jPanel4.add(produto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 100, -1));

        produto3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        produto3.setForeground(new java.awt.Color(51, 51, 51));
        produto3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        produto3.setText("Produto : ");
        produto3.setToolTipText("");
        jPanel4.add(produto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 100, 20));

        produto4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        produto4.setForeground(new java.awt.Color(51, 51, 51));
        produto4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        produto4.setText("ID : ");
        produto4.setToolTipText("");
        jPanel4.add(produto4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, 20));

        id.setEditable(false);
        id.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        id.setEnabled(false);
        jPanel4.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 50, 20));

        preco.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        preco.setEnabled(false);
        jPanel4.add(preco, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 90, 20));

        quantidade.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        quantidade.setEnabled(false);
        jPanel4.add(quantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 50, 20));

        produto.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        produto.setEnabled(false);
        jPanel4.add(produto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 160, 20));

        addProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/iconEdit.png"))); // NOI18N
        addProd.setBorder(null);
        addProd.setBorderPainted(false);
        addProd.setContentAreaFilled(false);
        addProd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addProd.setEnabled(false);
        addProd.setFocusPainted(false);
        addProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProdActionPerformed(evt);
            }
        });
        jPanel4.add(addProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/iconNotEdit.png"))); // NOI18N
        remove.setBorder(null);
        remove.setBorderPainted(false);
        remove.setContentAreaFilled(false);
        remove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        remove.setEnabled(false);
        remove.setFocusPainted(false);
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel4.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, 50));

        clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/iconsClear.png"))); // NOI18N
        clear.setBorder(null);
        clear.setBorderPainted(false);
        clear.setContentAreaFilled(false);
        clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clear.setEnabled(false);
        clear.setFocusPainted(false);
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel4.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, -1));

        alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/iconAlterar.png"))); // NOI18N
        alterar.setBorder(null);
        alterar.setBorderPainted(false);
        alterar.setContentAreaFilled(false);
        alterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        alterar.setEnabled(false);
        alterar.setFocusPainted(false);
        alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarActionPerformed(evt);
            }
        });
        jPanel4.add(alterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, 50));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 410, 150));

        jScrollPane1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PRODUTO", "PREÇO", "QUANTIDADE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 620, 200));

        submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/iconsSubmit.png"))); // NOI18N
        submit.setBorder(null);
        submit.setBorderPainted(false);
        submit.setContentAreaFilled(false);
        submit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submit.setFocusPainted(false);
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 670, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/background2.0.jpg"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 720));
        getContentPane().add(userName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 30, 20));

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // Fecha o programa (tem q fechar a conexão com o banco) 
        con.disconnection();
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void returnScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnScreenActionPerformed
        // Botão para voltar à tela anterior
        Main main = new Main(userName.getText(), con);
        main.setVisible(true);
        dispose();
    }//GEN-LAST:event_returnScreenActionPerformed

    private void viewNFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewNFActionPerformed
        File file = null;
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile().getAbsoluteFile();
            try {//PENSAR EM COMO FGAZER PRA SALVAR A IMG DA NOTA 
                File dir = new File(".");
                System.out.println("Current dir : " + dir.getCanonicalPath());// CAMINHO DA APLICAÇÃO
                System.out.println("IMG dir : " + file.getCanonicalPath());
                Runtime.getRuntime().exec( dir.getCanonicalPath() + "mkdir IMG_NF-e");//COMANDO PRA EXECUTAR COMANDOS NO PROMPT, NO CASO NO COMEÇO DA APLICAÇÃO PRECISARIA CRIAR UM DIRETORIO PRA SALVAR AS IMAGENS
                //COMANDO PRA COPIAR ARQUIVO É O xcopy <Partição>:\<caminho> <Partição>:\<caminho> /i
                //-i serve para criar o diretório se ele não existir
                String path = file.toString();
                ViewNF viewNF = new ViewNF(path);
                viewNF.setVisible(true);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro na importação da imagem", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            file = null;
        }

    }//GEN-LAST:event_viewNFActionPerformed

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        try {
            if ((jTextFieldNumParcela.getText().equals("")) || (jTextFieldData.getText().equals("  -  -    "))) {
                throw new Exception();
            }
            Double valor = new Double(jTextFieldValor.getText());
            int parcela = Integer.parseInt(jTextFieldNumParcela.getText());
            String n_nf = jTextFieldNumNF.getText();
            String dat_emissao = jTextFieldData.getText();
            String obs = jTextAreaObservacoes.getText();
            String user = userName.getText();
            String status = (String) jComboBoxStatus.getSelectedItem();

            if (status.equals("Aprovada")) {
                status = "A";
            } else if (status.equals("Reprovada")) {
                status = "R";
            } else if (status.equals("Pendente")) {
                status = "P";
            } else if (status.equals("Selecione...")) {
                throw new SecurityException();
            }
            String f = (String) jComboBoxFornecedor.getSelectedItem();
            int fornece = con.obterFornecedor("SELECT ID_FORNECEDOR FROM FORNECEDOR WHERE RAZAO_SOCIAL= '" + f + "'");

            int id_colab = con.obterColab("SELECT ID_USER FROM COLABORADORES WHERE LOGIN= '" + user + "'");

            con.insereNF("INSERT INTO nf_a (ID_FORNECEDOR_FK, VALOR_NF, NUM_NF, QTD_PARCELA, ID_COLAB_FK, DATA_ENTRADA, STATUS_NF,OBSERVACOES) "
                    + "VALUES (" + fornece + "," + valor + ",'" + n_nf + "'," + parcela + "," + id_colab + ",NOW(),'" + status + "','" + obs + "')");
            habilitaProduto();
            desabilitaNF();
        } catch (SQLException ex) {
            if (ex.getMessage().equals("1")) {
                JOptionPane.showMessageDialog(null, "Fornecedores não encontrados", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            if (ex.getMessage().equals("2")) {
                JOptionPane.showMessageDialog(null, "Colaboradores não encontrados", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            if (ex.getMessage().equals("3")) {
                JOptionPane.showMessageDialog(null, "Erro de inserção", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SecurityException ex) {
            JOptionPane.showMessageDialog(null, "Selecione um Status para a NF-e", "ERROR", JOptionPane.INFORMATION_MESSAGE);
            jComboBoxStatus.requestFocus();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Informação inválida", "ERROR", JOptionPane.ERROR_MESSAGE);
            jComboBoxFornecedor.requestFocus();
        }
    }//GEN-LAST:event_confirmActionPerformed

    private void addProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProdActionPerformed
        // TODO add your handling code here:
        String produto = this.produto.getText();
        String preco = this.preco.getText();
        String qtd = this.quantidade.getText();
        int idNF;
        try {
            if (produto.equals("") || (preco.equals("")) || (quantidade.equals(""))) {
                throw new SQLException();
            }
            idNF = con.acharIdNF("SELECT ID_NF_A FROM nf_a WHERE NUM_NF='" + jTextFieldNumNF.getText() + "'");
            con.inserirProduto("INSERT INTO produto_nf ( DESCRICAO_PROD, ID_NF_FK, QTD_PROD, VALOR_UNIT) "
                    + "VALUES ('" + produto + "'," + idNF + "," + qtd + "," + preco + ")");
            Double valorAnt = Double.parseDouble(jTextFieldValor.getText());
            Double valorAtu = Double.parseDouble(preco);
            Double valorQnt = Double.parseDouble(qtd);
            valorAtu = (valorAtu * valorQnt) + valorAnt;
            System.out.println("VALOR ATUAL : " + valorAtu);
            jTextFieldValor.setText(valorAtu.toString(valorAtu));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na inserção do produto", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        limpaCampos();
        listarTabela(jTextFieldNumNF.getText());
    }//GEN-LAST:event_addProdActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        // TODO add your handling code here:
        try {
            String produto = this.produto.getText();
            String preco = this.preco.getText();
            String qtd = this.quantidade.getText();

            int ret = JOptionPane.showConfirmDialog(null, "Tem Certeza?", "Confirmação de exclusao", JOptionPane.WARNING_MESSAGE);
            if (ret == JOptionPane.OK_OPTION) {
                con.delProduto("DELETE FROM produto_nf WHERE ID_PROD_NF=" + id.getText());
                JOptionPane.showMessageDialog(null, "Produto Removido", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
                Double valorAnt = Double.parseDouble(jTextFieldValor.getText());
                Double valorAtu = Double.parseDouble(preco);
                Double valorQnt = Double.parseDouble(qtd);

                valorAtu = (valorAnt - (valorAtu * valorQnt));

                System.out.println("VALOR ATUAL : " + valorAtu);
                jTextFieldValor.setText(valorAtu.toString(valorAtu));
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na remoção do produto", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        limpaCampos();
        limpaBotoes();
        listarTabela(jTextFieldNumNF.getText());
    }//GEN-LAST:event_removeActionPerformed

    private void alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarActionPerformed
        // TODO add your handling code here:
        try {
            String produto = this.produto.getText();
            String preco = this.preco.getText();
            String qtd = this.quantidade.getText();
            if (produto.equals("") || (preco.equals("")) || (quantidade.equals(""))) {
                throw new SQLException();
            }
            con.alterProduto("UPDATE produto_nf SET DESCRICAO_PROD='" + produto + "',QTD_PROD=" + qtd + ",VALOR_UNIT=" + preco + " WHERE ID_PROD_NF=" + id.getText());
            
            Double valorAnt = Double.parseDouble(jTextFieldValor.getText());
            Double valorAtu = Double.parseDouble(preco);
            Double valorQnt = Double.parseDouble(qtd);
            valorAtu = (valorAnt - (precoT * qtdT)) + valorAtu * valorQnt;
            jTextFieldValor.setText(valorAtu.toString(valorAtu));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na alteração do produto", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        limpaCampos();
        limpaBotoes();
        listarTabela(jTextFieldNumNF.getText());
    }//GEN-LAST:event_alterarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            carregarCampos(jTable1.getSelectedRow());
            listarTabela(jTextFieldNumNF.getText());
            alterar.setEnabled(true);
            remove.setEnabled(true);
            addProd.setEnabled(false);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        limpaCampos();
        limpaBotoes();
    }//GEN-LAST:event_clearActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
       if (jTable1.getRowCount() > 0) {
            Double valor = new Double(jTextFieldValor.getText());
            try {
                con.updateNota("UPDATE nf_a SET VALOR_NF =" + valor + " WHERE NUM_NF =" + jTextFieldNumNF.getText());
                Main main = new Main(userName.getText(), con);
                main.setVisible(true);
                dispose();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao finalizar o cadastro", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_submitActionPerformed

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
    //            java.util.logging.Logger.getLogger(RegisterNF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        } catch (InstantiationException ex) {
    //            java.util.logging.Logger.getLogger(RegisterNF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        } catch (IllegalAccessException ex) {
    //            java.util.logging.Logger.getLogger(RegisterNF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    //            java.util.logging.Logger.getLogger(RegisterNF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        }
    //        //</editor-fold>
    //        //</editor-fold>
    //
    //        /* Create and display the form */
    //        java.awt.EventQueue.invokeLater(new Runnable() {
    //            public void run() {
    //                new RegisterNF().setVisible(true);
    //            }
    //        });
    //    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProd;
    private javax.swing.JButton alterar;
    private javax.swing.JLabel background;
    private javax.swing.JButton clear;
    private javax.swing.JButton confirm;
    private javax.swing.JLabel dataEmiton;
    private javax.swing.JButton exit;
    private javax.swing.JTextField id;
    private javax.swing.JComboBox<String> jComboBoxFornecedor;
    private javax.swing.JComboBox<String> jComboBoxStatus;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextAreaObservacoes;
    private javax.swing.JTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldNumNF;
    private javax.swing.JTextField jTextFieldNumParcela;
    private javax.swing.JTextField jTextFieldValor;
    private javax.swing.JLabel nameForn;
    private javax.swing.JLabel numNF;
    private javax.swing.JLabel numParcelas;
    private javax.swing.JLabel observacoes;
    private javax.swing.JTextField preco;
    private javax.swing.JTextField produto;
    private javax.swing.JLabel produto1;
    private javax.swing.JLabel produto2;
    private javax.swing.JLabel produto3;
    private javax.swing.JLabel produto4;
    private javax.swing.JTextField quantidade;
    private javax.swing.JButton remove;
    private javax.swing.JButton returnScreen;
    private javax.swing.JLabel status;
    private javax.swing.JButton submit;
    private javax.swing.JLabel userName;
    private javax.swing.JLabel valorNota;
    private javax.swing.JButton viewNF;
    // End of variables declaration//GEN-END:variables
}
