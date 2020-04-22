package screens;

//==================================> Importações pertinentes á execução do frame
import controller.ControllerMain;
import controller.ControllerNF;
import controller.ControllerPC;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//==================================> Fim das importações

public class Main extends javax.swing.JFrame {

    String login;
    String idUser;

    public Main(String login) { // Método para instanciar o frame main
        initComponents();
        this.login = login;
        String[] resp = ControllerMain.buscaUserName(login);
        inicializar(resp);
    } // Fim do método de instanciação

    private void inicializar(String[] resp) {
        completNameUser.setText(resp[0]);
        btnUsuarios.setVisible(Boolean.parseBoolean(resp[1]));
        this.idUser = resp[2] ;
        side_pane.setPreferredSize(new Dimension(170, Toolkit.getDefaultToolkit().getScreenSize().height));
        resetPanels(new JPanel[]{jPanelPerfil, jPanelGerenciamentoUser, jPanelGerenciamentoNotasFiscais, jPanelGerenciamentoPedidoCompra});
        resetColor(new JPanel[]{btnPerfil,btnHome,btnPC,btnUsuarios,btnNotasFiscais}, new JPanel[]{ind_6,ind_1,ind_4,ind_3,ind_2});
    }

    @Override
    public Image getIconImage() { // Método para alterar o icone da barra de tarefas
        return Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("pictures/iconLogoBar.png"));
    } // Fim do método para alterar o icone da barra de tarefas

    private void setColor(JPanel pane) { // Método para definir a cor dos botões do menu
        pane.setBackground(new Color(41, 57, 80)); // Defini a cor do background do botão
    } // Fim do método para definir a cor dos botões do menu

    private void resetColor(JPanel[] pane, JPanel[] indicators) { // Método para dar reset na cor dos botões 
        for (JPanel pane1 : pane) { // Para todo elemento da lista
            pane1.setBackground(new Color(23, 35, 51)); // É mudado a cor do background
        }
        for (JPanel indicator : indicators) { // Para todo elemento da lista
            indicator.setOpaque(false); // É mudado a opacidade do indicador
        }
    } // Fim do método para resetar as cores do botão

    private void resetPanels(JPanel[] pane) { // Método para esconder os panels do menu
        for (JPanel pane1 : pane) { // Para todo elemento da lista
            pane1.setVisible(false);   // Mude a visibilidade para false
        } // Fim do for
    } // Fim do método resetPanels

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        side_pane = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnHome = new javax.swing.JPanel();
        ind_1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnPC = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        ind_4 = new javax.swing.JPanel();
        btnNotasFiscais = new javax.swing.JPanel();
        ind_2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnPerfil = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        ind_6 = new javax.swing.JPanel();
        btnUsuarios = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        ind_3 = new javax.swing.JPanel();
        jPanelGerenciamentoNotasFiscais = new javax.swing.JPanel();
        editNF = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel30 = new javax.swing.JLabel();
        listNF = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel32 = new javax.swing.JLabel();
        tittleGerenciamentoUser1 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JSeparator();
        jPanelGerenciamentoPedidoCompra = new javax.swing.JPanel();
        addPC = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel36 = new javax.swing.JLabel();
        listPC = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jSeparator17 = new javax.swing.JSeparator();
        jLabel40 = new javax.swing.JLabel();
        tittleGerenciamentoUser2 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jSeparator19 = new javax.swing.JSeparator();
        jPanelGerenciamentoUser = new javax.swing.JPanel();
        actionAddUser = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        actionsUser = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        tittleGerenciamentoUser = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jPanelPerfil = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btn_exit = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        completNameUser = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jPanel11 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconImage(getIconImage());
        setSize(new java.awt.Dimension(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        side_pane.setBackground(new java.awt.Color(23, 35, 51));
        side_pane.setPreferredSize(new java.awt.Dimension(0, 0));
        side_pane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/iconLogoBar.png"))); // NOI18N
        jLabel1.setToolTipText("");
        side_pane.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 90, 80));

        btnHome.setBackground(new java.awt.Color(23, 35, 51));
        btnHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHomeMouseExited(evt);
            }
        });

        ind_1.setOpaque(false);
        ind_1.setPreferredSize(new java.awt.Dimension(3, 51));

        javax.swing.GroupLayout ind_1Layout = new javax.swing.GroupLayout(ind_1);
        ind_1.setLayout(ind_1Layout);
        ind_1Layout.setHorizontalGroup(
            ind_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );
        ind_1Layout.setVerticalGroup(
            ind_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Home");

        javax.swing.GroupLayout btnHomeLayout = new javax.swing.GroupLayout(btnHome);
        btnHome.setLayout(btnHomeLayout);
        btnHomeLayout.setHorizontalGroup(
            btnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnHomeLayout.createSequentialGroup()
                .addComponent(ind_1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnHomeLayout.setVerticalGroup(
            btnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnHomeLayout.createSequentialGroup()
                .addComponent(ind_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        side_pane.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 170, 50));

        btnPC.setBackground(new java.awt.Color(23, 35, 51));
        btnPC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPC.setPreferredSize(new java.awt.Dimension(182, 51));
        btnPC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPCMouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Pedido de Compra");
        jLabel12.setPreferredSize(new java.awt.Dimension(49, 25));
        jLabel12.setRequestFocusEnabled(false);

        ind_4.setOpaque(false);
        ind_4.setPreferredSize(new java.awt.Dimension(3, 51));

        javax.swing.GroupLayout ind_4Layout = new javax.swing.GroupLayout(ind_4);
        ind_4.setLayout(ind_4Layout);
        ind_4Layout.setHorizontalGroup(
            ind_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );
        ind_4Layout.setVerticalGroup(
            ind_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout btnPCLayout = new javax.swing.GroupLayout(btnPC);
        btnPC.setLayout(btnPCLayout);
        btnPCLayout.setHorizontalGroup(
            btnPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPCLayout.createSequentialGroup()
                .addComponent(ind_4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnPCLayout.setVerticalGroup(
            btnPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ind_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        side_pane.add(btnPC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 170, 50));

        btnNotasFiscais.setBackground(new java.awt.Color(23, 35, 51));
        btnNotasFiscais.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNotasFiscais.setPreferredSize(new java.awt.Dimension(182, 51));
        btnNotasFiscais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNotasFiscaisMouseClicked(evt);
            }
        });

        ind_2.setOpaque(false);
        ind_2.setPreferredSize(new java.awt.Dimension(3, 51));

        javax.swing.GroupLayout ind_2Layout = new javax.swing.GroupLayout(ind_2);
        ind_2.setLayout(ind_2Layout);
        ind_2Layout.setHorizontalGroup(
            ind_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );
        ind_2Layout.setVerticalGroup(
            ind_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Notas Fiscais");

        javax.swing.GroupLayout btnNotasFiscaisLayout = new javax.swing.GroupLayout(btnNotasFiscais);
        btnNotasFiscais.setLayout(btnNotasFiscaisLayout);
        btnNotasFiscaisLayout.setHorizontalGroup(
            btnNotasFiscaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnNotasFiscaisLayout.createSequentialGroup()
                .addComponent(ind_2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnNotasFiscaisLayout.setVerticalGroup(
            btnNotasFiscaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ind_2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        side_pane.add(btnNotasFiscais, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 170, 50));

        btnPerfil.setBackground(new java.awt.Color(23, 35, 51));
        btnPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPerfil.setPreferredSize(new java.awt.Dimension(182, 51));
        btnPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPerfilMouseClicked(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Perfil");

        ind_6.setOpaque(false);
        ind_6.setPreferredSize(new java.awt.Dimension(3, 51));

        javax.swing.GroupLayout ind_6Layout = new javax.swing.GroupLayout(ind_6);
        ind_6.setLayout(ind_6Layout);
        ind_6Layout.setHorizontalGroup(
            ind_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        ind_6Layout.setVerticalGroup(
            ind_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout btnPerfilLayout = new javax.swing.GroupLayout(btnPerfil);
        btnPerfil.setLayout(btnPerfilLayout);
        btnPerfilLayout.setHorizontalGroup(
            btnPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPerfilLayout.createSequentialGroup()
                .addComponent(ind_6, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        btnPerfilLayout.setVerticalGroup(
            btnPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ind_6, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        side_pane.add(btnPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 170, 50));
        btnPerfil.getAccessibleContext().setAccessibleName("Perfil");

        btnUsuarios.setBackground(new java.awt.Color(23, 35, 51));
        btnUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuarios.setPreferredSize(new java.awt.Dimension(182, 51));
        btnUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Usuários");

        ind_3.setOpaque(false);
        ind_3.setPreferredSize(new java.awt.Dimension(3, 51));

        javax.swing.GroupLayout ind_3Layout = new javax.swing.GroupLayout(ind_3);
        ind_3.setLayout(ind_3Layout);
        ind_3Layout.setHorizontalGroup(
            ind_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );
        ind_3Layout.setVerticalGroup(
            ind_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout btnUsuariosLayout = new javax.swing.GroupLayout(btnUsuarios);
        btnUsuarios.setLayout(btnUsuariosLayout);
        btnUsuariosLayout.setHorizontalGroup(
            btnUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnUsuariosLayout.createSequentialGroup()
                .addComponent(ind_3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnUsuariosLayout.setVerticalGroup(
            btnUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ind_3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        side_pane.add(btnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 170, 50));

        getContentPane().add(side_pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanelGerenciamentoNotasFiscais.setBackground(new java.awt.Color(71, 120, 197));
        jPanelGerenciamentoNotasFiscais.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editNF.setBackground(new java.awt.Color(84, 127, 206));
        editNF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editNF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editNFMouseClicked(evt);
            }
        });
        editNF.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/iconsEngrenagem.png"))); // NOI18N
        editNF.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 25, 25));
        editNF.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 45, 176, 10));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Nova Nota Fiscal");
        editNF.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 62, 190, 70));

        jPanelGerenciamentoNotasFiscais.add(editNF, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 200, 140));

        listNF.setBackground(new java.awt.Color(84, 127, 206));
        listNF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listNF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listNFMouseClicked(evt);
            }
        });
        listNF.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/iconsEngrenagem.png"))); // NOI18N
        listNF.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 25, 25));
        listNF.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 46, 176, 10));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Listar Notas Fiscais");
        listNF.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 190, 60));

        jPanelGerenciamentoNotasFiscais.add(listNF, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 200, 140));

        tittleGerenciamentoUser1.setBackground(new java.awt.Color(71, 120, 197));

        jLabel35.setBackground(new java.awt.Color(80, 120, 206));
        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Gerenciar Notas Fiscais");

        javax.swing.GroupLayout tittleGerenciamentoUser1Layout = new javax.swing.GroupLayout(tittleGerenciamentoUser1);
        tittleGerenciamentoUser1.setLayout(tittleGerenciamentoUser1Layout);
        tittleGerenciamentoUser1Layout.setHorizontalGroup(
            tittleGerenciamentoUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tittleGerenciamentoUser1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator14, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addContainerGap())
        );
        tittleGerenciamentoUser1Layout.setVerticalGroup(
            tittleGerenciamentoUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tittleGerenciamentoUser1Layout.createSequentialGroup()
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelGerenciamentoNotasFiscais.add(tittleGerenciamentoUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 460, 60));

        getContentPane().add(jPanelGerenciamentoNotasFiscais, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 460, 250));

        jPanelGerenciamentoPedidoCompra.setBackground(new java.awt.Color(71, 120, 197));
        jPanelGerenciamentoPedidoCompra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addPC.setBackground(new java.awt.Color(84, 127, 206));
        addPC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addPC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addPCMouseClicked(evt);
            }
        });
        addPC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swing/images/icons8_Contacts_25px.png"))); // NOI18N
        addPC.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 25, 25));
        addPC.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 45, 176, 10));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Novo Pedido");
        addPC.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 188, 70));

        jPanelGerenciamentoPedidoCompra.add(addPC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 200, 140));

        listPC.setBackground(new java.awt.Color(84, 127, 206));
        listPC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listPC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listPCMouseClicked(evt);
            }
        });
        listPC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/iconsLista.png"))); // NOI18N
        listPC.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 25, 25));
        listPC.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 45, 176, 10));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Listar Pedidos");
        listPC.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 188, 70));

        jPanelGerenciamentoPedidoCompra.add(listPC, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 200, 140));

        tittleGerenciamentoUser2.setBackground(new java.awt.Color(71, 120, 197));

        jLabel43.setBackground(new java.awt.Color(80, 120, 206));
        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Gerenciar Pedidos de Compra");

        javax.swing.GroupLayout tittleGerenciamentoUser2Layout = new javax.swing.GroupLayout(tittleGerenciamentoUser2);
        tittleGerenciamentoUser2.setLayout(tittleGerenciamentoUser2Layout);
        tittleGerenciamentoUser2Layout.setHorizontalGroup(
            tittleGerenciamentoUser2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tittleGerenciamentoUser2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator19, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tittleGerenciamentoUser2Layout.setVerticalGroup(
            tittleGerenciamentoUser2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tittleGerenciamentoUser2Layout.createSequentialGroup()
                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelGerenciamentoPedidoCompra.add(tittleGerenciamentoUser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 460, 60));

        getContentPane().add(jPanelGerenciamentoPedidoCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 460, 250));

        jPanelGerenciamentoUser.setBackground(new java.awt.Color(71, 120, 197));
        jPanelGerenciamentoUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        actionAddUser.setBackground(new java.awt.Color(84, 127, 206));
        actionAddUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        actionAddUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actionAddUserMouseClicked(evt);
            }
        });
        actionAddUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swing/images/icons8_Contacts_25px.png"))); // NOI18N
        actionAddUser.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));
        actionAddUser.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 45, 180, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Novo Usuário");
        actionAddUser.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 62, 190, 70));

        jPanelGerenciamentoUser.add(actionAddUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 200, 140));

        actionsUser.setBackground(new java.awt.Color(84, 127, 206));
        actionsUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        actionsUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actionsUserMouseClicked(evt);
            }
        });
        actionsUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/iconsEngrenagem.png"))); // NOI18N
        actionsUser.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));
        actionsUser.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 45, 180, 10));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Editar Usuário");
        actionsUser.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 62, 190, 70));

        jPanelGerenciamentoUser.add(actionsUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 200, 140));

        tittleGerenciamentoUser.setBackground(new java.awt.Color(71, 120, 197));

        jLabel27.setBackground(new java.awt.Color(80, 120, 206));
        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Gerenciar Usuários");

        javax.swing.GroupLayout tittleGerenciamentoUserLayout = new javax.swing.GroupLayout(tittleGerenciamentoUser);
        tittleGerenciamentoUser.setLayout(tittleGerenciamentoUserLayout);
        tittleGerenciamentoUserLayout.setHorizontalGroup(
            tittleGerenciamentoUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tittleGerenciamentoUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator6, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tittleGerenciamentoUserLayout.setVerticalGroup(
            tittleGerenciamentoUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tittleGerenciamentoUserLayout.createSequentialGroup()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelGerenciamentoUser.add(tittleGerenciamentoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 460, 60));

        getContentPane().add(jPanelGerenciamentoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 460, 250));

        jPanelPerfil.setBackground(new java.awt.Color(71, 120, 197));
        jPanelPerfil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(120, 168, 252));
        jPanel4.setPreferredSize(new java.awt.Dimension(285, 90));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swing/images/icons8_Exit_25px.png"))); // NOI18N
        btn_exit.setToolTipText("Deslogar");
        btn_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_exitMousePressed(evt);
            }
        });
        jPanel4.add(btn_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, 46));

        user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swing/images/imge_1.jpg"))); // NOI18N
        jPanel4.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 86, -1));

        completNameUser.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        completNameUser.setForeground(new java.awt.Color(255, 255, 255));
        completNameUser.setToolTipText("Usuário logado");
        jPanel4.add(completNameUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, 30));

        jPanelPerfil.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 460, -1));

        jPanel12.setBackground(new java.awt.Color(84, 127, 206));
        jPanel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/iconsEngrenagem.png"))); // NOI18N
        jPanel12.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 25, 25));
        jPanel12.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 45, 290, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Configurações");
        jPanel12.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 62, 190, 70));

        jPanelPerfil.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 200, 140));

        jPanel3.setBackground(new java.awt.Color(71, 120, 197));

        jLabel28.setBackground(new java.awt.Color(80, 120, 206));
        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Perfil");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator7, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelPerfil.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 460, 60));

        jPanel11.setBackground(new java.awt.Color(84, 127, 206));
        jPanel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/iconsCamera.png"))); // NOI18N
        jPanel11.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 25, 25));
        jPanel11.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 45, 290, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Alterar Foto");
        jPanel11.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 62, 190, 70));

        jPanelPerfil.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 200, 140));

        getContentPane().add(jPanelPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 460, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_exitMousePressed
        // Método para fechar deslogar do sistema
        ControllerMain.logout(this.idUser);
        dispose();
    }//GEN-LAST:event_btn_exitMousePressed

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered
        // Método para mudar a cor do botão quando o mouse passa por cima, dando um efeito de hover
        setColor(btnHome);
        ind_1.setOpaque(true);
        resetPanels(new JPanel[]{jPanelPerfil, jPanelGerenciamentoNotasFiscais,jPanelGerenciamentoUser,jPanelGerenciamentoPedidoCompra}); 
        resetColor(new JPanel[]{btnPerfil,btnPC,btnUsuarios,btnNotasFiscais}, new JPanel[]{ind_6,ind_4,ind_3,ind_2});
    }//GEN-LAST:event_btnHomeMouseEntered

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited
        // Método para redefinir as cores do botão e do indice
        resetColor(new JPanel[]{btnHome}, new JPanel[]{ind_1}); // Método que realiza a redifinição
        ind_1.setOpaque(false); // Defini o indice como opaco
        resetPanels(new JPanel[]{jPanelPerfil, jPanelGerenciamentoNotasFiscais,jPanelGerenciamentoUser,jPanelGerenciamentoPedidoCompra});
    }//GEN-LAST:event_btnHomeMouseExited

    private void actionAddUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actionAddUserMouseClicked
        // Método abrir o frame para adicionar um usuário
        ControllerMain.userAction(this.login, "Novo Usuário", -1);
        resetPanels(new JPanel[]{jPanelGerenciamentoUser}); // Método para mudar a visibilidade do menu
    }//GEN-LAST:event_actionAddUserMouseClicked

    private void listNFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listNFMouseClicked
        // Método abrir frame para listagem das Notas Fiscais
        ControllerMain.nfAction(this.login, "Listagem de Notas Fiscais", -2);
        resetPanels(new JPanel[]{jPanelGerenciamentoNotasFiscais});
    }//GEN-LAST:event_listNFMouseClicked

    private void actionsUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actionsUserMouseClicked
        // Método abrir o frame para adicionar um usuário
        ControllerMain.userAction(this.login, "Edição de Usuários", -2);
        resetPanels(new JPanel[]{jPanelGerenciamentoUser}); // Método para mudar a visibilidade do menu
    }//GEN-LAST:event_actionsUserMouseClicked

    private void addPCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPCMouseClicked
        try {
            //                Método para mudar a cor do botão quando o mouse passa por cima, dando um efeito de hover
//        setColor(btnPC);
//        ind_4.setOpaque(true);
//
//        jPanelGerenciamentoPedidoCompra.setVisible(!jPanelGerenciamentoPedidoCompra.isVisible());
//        resetPanels(new JPanel[]{jPanelGerenciamentoUser, jPanelPerfil,jPanelGerenciamentoNotasFiscais});
//
//        resetColor(new JPanel[]{btnHome,btnPerfil,btnNotasFiscais,btnUsuarios}, new JPanel[]{ind_1,ind_6,ind_2,ind_3});
// TODO add your handling code here:
ControllerPC.main(this.login, "Criar Pedido de Compras", -1, -1);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addPCMouseClicked

    private void listPCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listPCMouseClicked
        ControllerPC.listPc(this.login, "Listar Pedidos de Compras");
    
    }//GEN-LAST:event_listPCMouseClicked

    private void btnPCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPCMouseClicked
        // Método para mudar a cor do botão quando o mouse passa por cima, dando um efeito de hover
        setColor(btnPC);
        ind_4.setOpaque(true);

        jPanelGerenciamentoPedidoCompra.setVisible(!jPanelGerenciamentoPedidoCompra.isVisible());

        resetPanels(new JPanel[]{jPanelGerenciamentoUser, jPanelGerenciamentoNotasFiscais, jPanelPerfil}); // Método para mudar a visibilidade dos outros menus 

        resetColor(new JPanel[]{btnHome,btnPerfil,btnUsuarios,btnNotasFiscais}, new JPanel[]{ind_1,ind_6,ind_3,ind_2});
    }//GEN-LAST:event_btnPCMouseClicked

    private void btnPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerfilMouseClicked
        // Método para mudar a cor do botão quando o mouse passa por cima, dando um efeito de hover
        setColor(btnPerfil);
        ind_6.setOpaque(true);
        
        jPanelPerfil.setVisible(!jPanelPerfil.isVisible());

        resetPanels(new JPanel[]{jPanelGerenciamentoUser, jPanelGerenciamentoNotasFiscais,jPanelGerenciamentoPedidoCompra}); 

        resetColor(new JPanel[]{btnHome,btnPC,btnUsuarios,btnNotasFiscais}, new JPanel[]{ind_1,ind_4,ind_3,ind_2});
    }//GEN-LAST:event_btnPerfilMouseClicked

    private void btnUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseClicked
        // Método para mudar a cor do botão quando o mouse passa por cima, dando um efeito de hover
        setColor(btnUsuarios);
        ind_3.setOpaque(true);
        
        jPanelGerenciamentoUser.setVisible(!jPanelGerenciamentoUser.isVisible());
        
        resetPanels(new JPanel[]{jPanelPerfil, jPanelGerenciamentoNotasFiscais,jPanelGerenciamentoPedidoCompra}); 
        
        resetColor(new JPanel[]{btnHome,btnPC,btnPerfil,btnNotasFiscais}, new JPanel[]{ind_1,ind_4,ind_6,ind_2});
    }//GEN-LAST:event_btnUsuariosMouseClicked

    private void btnNotasFiscaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNotasFiscaisMouseClicked
        // Método para mudar a cor do botão quando o mouse passa por cima, dando um efeito de hover
        setColor(btnNotasFiscais);
        ind_2.setOpaque(true);

        jPanelGerenciamentoNotasFiscais.setVisible(!jPanelGerenciamentoNotasFiscais.isVisible());
        resetPanels(new JPanel[]{jPanelGerenciamentoUser, jPanelPerfil,jPanelGerenciamentoPedidoCompra});

        resetColor(new JPanel[]{btnHome,btnPerfil,btnPC,btnUsuarios}, new JPanel[]{ind_1,ind_6,ind_4,ind_3});
    }//GEN-LAST:event_btnNotasFiscaisMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ControllerMain.logout(this.idUser);
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void editNFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editNFMouseClicked
        // TODO add your handling code here:
        ControllerMain.nfAction(this.login, "Criar Nota Fiscal", -1);
    }//GEN-LAST:event_editNFMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionAddUser;
    private javax.swing.JPanel actionsUser;
    private javax.swing.JPanel addPC;
    private javax.swing.JPanel btnHome;
    private javax.swing.JPanel btnNotasFiscais;
    private javax.swing.JPanel btnPC;
    private javax.swing.JPanel btnPerfil;
    private javax.swing.JPanel btnUsuarios;
    private javax.swing.JLabel btn_exit;
    private javax.swing.JLabel completNameUser;
    private javax.swing.JPanel editNF;
    private javax.swing.JPanel ind_1;
    private javax.swing.JPanel ind_2;
    private javax.swing.JPanel ind_3;
    private javax.swing.JPanel ind_4;
    private javax.swing.JPanel ind_6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelGerenciamentoNotasFiscais;
    private javax.swing.JPanel jPanelGerenciamentoPedidoCompra;
    private javax.swing.JPanel jPanelGerenciamentoUser;
    private javax.swing.JPanel jPanelPerfil;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JPanel listNF;
    private javax.swing.JPanel listPC;
    private javax.swing.JPanel side_pane;
    private javax.swing.JPanel tittleGerenciamentoUser;
    private javax.swing.JPanel tittleGerenciamentoUser1;
    private javax.swing.JPanel tittleGerenciamentoUser2;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
