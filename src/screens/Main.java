package screens;

//==================================> Importações pertinentes á execução do frame
import controller.ControllerMain;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Image;
//==================================> Fim das importações

public class Main extends javax.swing.JFrame {

    public Main(String username) { // Método para instanciar o frame main
        initComponents(); // Inicia Componentes do frame de main
        Object[] resp = ControllerMain.buscaUserName(username);
        userName.setText(resp[0].toString()); // Definir o nome do usuário usando o método buscaUserName
        btnUsuarios.setVisible((boolean) resp[1]); // Se for o menu de Gerenciamento de Usuários (btn_3) não fica acessível
        resetPanels(new JPanel[]{jPanelPerfil, jPanelGerenciamentoUser, jPanelGerenciamentoNotasFiscais, jPanelGerenciamentoPedidoCompra}); // Chama a função para esconder os panels do menu
        side_pane.setPreferredSize(new Dimension(170, Toolkit.getDefaultToolkit().getScreenSize().height)); // Defini o tamanho da barra do menu lateral esquerdo        

    } // Fim do método de instanciação

    @Override
    public Image getIconImage() { // Método para alterar o icone da barra de tarefas
        return Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("pictures/iconLogoBar.png")); // Seta uma imagem como ícone
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
        btPerfil = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        ind_6 = new javax.swing.JPanel();
        btnUsuarios = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        ind_3 = new javax.swing.JPanel();
        jPanelGerenciamentoUser = new javax.swing.JPanel();
        addUser = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        editUser = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        listUser = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        blockUser = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        tittleGerenciamentoUser = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jPanelGerenciamentoPedidoCompra = new javax.swing.JPanel();
        addNF1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel36 = new javax.swing.JLabel();
        listNF1 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jSeparator17 = new javax.swing.JSeparator();
        jLabel40 = new javax.swing.JLabel();
        tittleGerenciamentoUser2 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jSeparator19 = new javax.swing.JSeparator();
        jPanelPerfil = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btn_exit = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        userName = new javax.swing.JLabel();
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
        jLabel2 = new javax.swing.JLabel();
        search = new javax.swing.JButton();
        listar = new javax.swing.JButton();
        numNF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconImage(getIconImage());
        setSize(new java.awt.Dimension(0, 0));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
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

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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

        side_pane.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 170, -1));

        btnPC.setBackground(new java.awt.Color(23, 35, 51));
        btnPC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPCMouseExited(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Pedido de Compra");

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
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
        );
        btnPCLayout.setVerticalGroup(
            btnPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ind_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(btnPCLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12))
        );

        side_pane.add(btnPC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 170, -1));

        btnNotasFiscais.setBackground(new java.awt.Color(23, 35, 51));
        btnNotasFiscais.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNotasFiscais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNotasFiscaisMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNotasFiscaisMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNotasFiscaisMouseExited(evt);
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
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnNotasFiscaisLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        side_pane.add(btnNotasFiscais, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 170, -1));

        btPerfil.setBackground(new java.awt.Color(23, 35, 51));
        btPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btPerfilMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btPerfilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btPerfilMouseExited(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout btPerfilLayout = new javax.swing.GroupLayout(btPerfil);
        btPerfil.setLayout(btPerfilLayout);
        btPerfilLayout.setHorizontalGroup(
            btPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btPerfilLayout.createSequentialGroup()
                .addComponent(ind_6, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btPerfilLayout.setVerticalGroup(
            btPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ind_6, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
            .addGroup(btPerfilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        side_pane.add(btPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 170, -1));
        btPerfil.getAccessibleContext().setAccessibleName("Perfil");

        btnUsuarios.setBackground(new java.awt.Color(23, 35, 51));
        btnUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseExited(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout btnUsuariosLayout = new javax.swing.GroupLayout(btnUsuarios);
        btnUsuarios.setLayout(btnUsuariosLayout);
        btnUsuariosLayout.setHorizontalGroup(
            btnUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnUsuariosLayout.createSequentialGroup()
                .addComponent(ind_3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnUsuariosLayout.setVerticalGroup(
            btnUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnUsuariosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
            .addComponent(ind_3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        side_pane.add(btnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 170, 50));

        getContentPane().add(side_pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanelGerenciamentoUser.setBackground(new java.awt.Color(71, 120, 197));
        jPanelGerenciamentoUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelGerenciamentoUserMouseEntered(evt);
            }
        });
        jPanelGerenciamentoUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addUser.setBackground(new java.awt.Color(84, 127, 206));
        addUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addUserMouseClicked(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swing/images/icons8_Contacts_25px.png"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Novo Usuário");

        javax.swing.GroupLayout addUserLayout = new javax.swing.GroupLayout(addUser);
        addUser.setLayout(addUserLayout);
        addUserLayout.setHorizontalGroup(
            addUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addUserLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        addUserLayout.setVerticalGroup(
            addUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelGerenciamentoUser.add(addUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 220, 160));

        editUser.setBackground(new java.awt.Color(84, 127, 206));
        editUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editUserMouseClicked(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/iconsEngrenagem.png"))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Editar Usuário");

        javax.swing.GroupLayout editUserLayout = new javax.swing.GroupLayout(editUser);
        editUser.setLayout(editUserLayout);
        editUserLayout.setHorizontalGroup(
            editUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editUserLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        editUserLayout.setVerticalGroup(
            editUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelGerenciamentoUser.add(editUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 220, 160));

        listUser.setBackground(new java.awt.Color(84, 127, 206));
        listUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listUserMouseClicked(evt);
            }
        });

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/iconsLista.png"))); // NOI18N

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Listar Usuários");

        javax.swing.GroupLayout listUserLayout = new javax.swing.GroupLayout(listUser);
        listUser.setLayout(listUserLayout);
        listUserLayout.setHorizontalGroup(
            listUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, listUserLayout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        listUserLayout.setVerticalGroup(
            listUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelGerenciamentoUser.add(listUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 220, 160));

        blockUser.setBackground(new java.awt.Color(84, 127, 206));
        blockUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        blockUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                blockUserMouseClicked(evt);
            }
        });

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/iconsLock.png"))); // NOI18N

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Bloquear Usuário");

        javax.swing.GroupLayout blockUserLayout = new javax.swing.GroupLayout(blockUser);
        blockUser.setLayout(blockUserLayout);
        blockUserLayout.setHorizontalGroup(
            blockUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, blockUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(blockUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, blockUserLayout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        blockUserLayout.setVerticalGroup(
            blockUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blockUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelGerenciamentoUser.add(blockUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 220, 160));

        tittleGerenciamentoUser.setBackground(new java.awt.Color(71, 120, 197));

        jLabel27.setBackground(new java.awt.Color(80, 120, 206));
        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Gerenciar Usuários");

        javax.swing.GroupLayout tittleGerenciamentoUserLayout = new javax.swing.GroupLayout(tittleGerenciamentoUser);
        tittleGerenciamentoUser.setLayout(tittleGerenciamentoUserLayout);
        tittleGerenciamentoUserLayout.setHorizontalGroup(
            tittleGerenciamentoUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tittleGerenciamentoUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator6)
                .addContainerGap())
        );
        tittleGerenciamentoUserLayout.setVerticalGroup(
            tittleGerenciamentoUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tittleGerenciamentoUserLayout.createSequentialGroup()
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanelGerenciamentoUser.add(tittleGerenciamentoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 13, 500, -1));

        getContentPane().add(jPanelGerenciamentoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 500, 440));

        jPanelGerenciamentoPedidoCompra.setBackground(new java.awt.Color(71, 120, 197));
        jPanelGerenciamentoPedidoCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelGerenciamentoPedidoCompraMouseEntered(evt);
            }
        });
        jPanelGerenciamentoPedidoCompra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addNF1.setBackground(new java.awt.Color(84, 127, 206));
        addNF1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addNF1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addNF1MouseClicked(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swing/images/icons8_Contacts_25px.png"))); // NOI18N

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Nova NF");

        javax.swing.GroupLayout addNF1Layout = new javax.swing.GroupLayout(addNF1);
        addNF1.setLayout(addNF1Layout);
        addNF1Layout.setHorizontalGroup(
            addNF1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addNF1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addNF1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jSeparator15, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addNF1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        addNF1Layout.setVerticalGroup(
            addNF1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addNF1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelGerenciamentoPedidoCompra.add(addNF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 220, 160));

        listNF1.setBackground(new java.awt.Color(84, 127, 206));
        listNF1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listNF1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listNF1MouseClicked(evt);
            }
        });

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/iconsLista.png"))); // NOI18N

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Listar NF's");

        javax.swing.GroupLayout listNF1Layout = new javax.swing.GroupLayout(listNF1);
        listNF1.setLayout(listNF1Layout);
        listNF1Layout.setHorizontalGroup(
            listNF1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listNF1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listNF1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jSeparator17, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, listNF1Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        listNF1Layout.setVerticalGroup(
            listNF1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listNF1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelGerenciamentoPedidoCompra.add(listNF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 220, 160));

        tittleGerenciamentoUser2.setBackground(new java.awt.Color(71, 120, 197));

        jLabel43.setBackground(new java.awt.Color(80, 120, 206));
        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Gerenciar Pedidos de Compra");

        javax.swing.GroupLayout tittleGerenciamentoUser2Layout = new javax.swing.GroupLayout(tittleGerenciamentoUser2);
        tittleGerenciamentoUser2.setLayout(tittleGerenciamentoUser2Layout);
        tittleGerenciamentoUser2Layout.setHorizontalGroup(
            tittleGerenciamentoUser2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tittleGerenciamentoUser2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator19)
                .addContainerGap())
        );
        tittleGerenciamentoUser2Layout.setVerticalGroup(
            tittleGerenciamentoUser2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tittleGerenciamentoUser2Layout.createSequentialGroup()
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelGerenciamentoPedidoCompra.add(tittleGerenciamentoUser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 13, 500, 50));

        getContentPane().add(jPanelGerenciamentoPedidoCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 500, 290));

        jPanelPerfil.setBackground(new java.awt.Color(71, 120, 197));
        jPanelPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelPerfilMouseEntered(evt);
            }
        });

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
        jPanel4.add(btn_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, 46));

        user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swing/images/imge_1.jpg"))); // NOI18N
        jPanel4.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 86, -1));

        userName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        userName.setForeground(new java.awt.Color(255, 255, 255));
        userName.setToolTipText("Usuário logado");
        jPanel4.add(userName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, 30));

        jPanel12.setBackground(new java.awt.Color(84, 127, 206));
        jPanel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/iconsEngrenagem.png"))); // NOI18N

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Configurações avançadas");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(71, 120, 197));

        jLabel28.setBackground(new java.awt.Color(80, 120, 206));
        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Perfil");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator7)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(84, 127, 206));
        jPanel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/iconsCamera.png"))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Alterar Foto");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelPerfilLayout = new javax.swing.GroupLayout(jPanelPerfil);
        jPanelPerfil.setLayout(jPanelPerfilLayout);
        jPanelPerfilLayout.setHorizontalGroup(
            jPanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPerfilLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanelPerfilLayout.setVerticalGroup(
            jPanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPerfilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, -1, 440));

        jPanelGerenciamentoNotasFiscais.setBackground(new java.awt.Color(71, 120, 197));
        jPanelGerenciamentoNotasFiscais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelGerenciamentoNotasFiscaisMouseEntered(evt);
            }
        });
        jPanelGerenciamentoNotasFiscais.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editNF.setBackground(new java.awt.Color(84, 127, 206));
        editNF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/iconsEngrenagem.png"))); // NOI18N

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Editar NF");

        javax.swing.GroupLayout editNFLayout = new javax.swing.GroupLayout(editNF);
        editNF.setLayout(editNFLayout);
        editNFLayout.setHorizontalGroup(
            editNFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editNFLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editNFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                    .addComponent(jSeparator11, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editNFLayout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        editNFLayout.setVerticalGroup(
            editNFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editNFLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelGerenciamentoNotasFiscais.add(editNF, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 220, 160));

        listNF.setBackground(new java.awt.Color(84, 127, 206));
        listNF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listNF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listNFMouseClicked(evt);
            }
        });

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novosIcones/iconsLista.png"))); // NOI18N

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Listar NF's");

        javax.swing.GroupLayout listNFLayout = new javax.swing.GroupLayout(listNF);
        listNF.setLayout(listNFLayout);
        listNFLayout.setHorizontalGroup(
            listNFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listNFLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listNFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                    .addComponent(jSeparator12, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, listNFLayout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        listNFLayout.setVerticalGroup(
            listNFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listNFLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelGerenciamentoNotasFiscais.add(listNF, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 220, 160));

        tittleGerenciamentoUser1.setBackground(new java.awt.Color(71, 120, 197));

        jLabel35.setBackground(new java.awt.Color(80, 120, 206));
        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Gerenciar Notas Fiscais");

        javax.swing.GroupLayout tittleGerenciamentoUser1Layout = new javax.swing.GroupLayout(tittleGerenciamentoUser1);
        tittleGerenciamentoUser1.setLayout(tittleGerenciamentoUser1Layout);
        tittleGerenciamentoUser1Layout.setHorizontalGroup(
            tittleGerenciamentoUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tittleGerenciamentoUser1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator14)
                .addContainerGap())
        );
        tittleGerenciamentoUser1Layout.setVerticalGroup(
            tittleGerenciamentoUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tittleGerenciamentoUser1Layout.createSequentialGroup()
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanelGerenciamentoNotasFiscais.add(tittleGerenciamentoUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 13, 500, -1));

        getContentPane().add(jPanelGerenciamentoNotasFiscais, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 500, 280));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Nº da NF :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, 90, 30));

        search.setBackground(new java.awt.Color(102, 255, 102));
        search.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("Pesquisar");
        search.setBorder(null);
        search.setBorderPainted(false);
        search.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        search.setDefaultCapable(false);
        search.setFocusPainted(false);
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchMouseExited(evt);
            }
        });
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        getContentPane().add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, 190, 40));

        listar.setBackground(new java.awt.Color(102, 255, 102));
        listar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        listar.setForeground(new java.awt.Color(255, 255, 255));
        listar.setText("Listar todas NF's");
        listar.setBorder(null);
        listar.setBorderPainted(false);
        listar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listar.setDefaultCapable(false);
        listar.setFocusPainted(false);
        listar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                listarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                listarMouseExited(evt);
            }
        });
        listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarActionPerformed(evt);
            }
        });
        getContentPane().add(listar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 180, 190, 40));

        numNF.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        numNF.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        numNF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        getContentPane().add(numNF, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 500, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseEntered
        // TODO add your handling code here:
        search.setBackground(new Color(135, 206, 250));
    }//GEN-LAST:event_searchMouseEntered

    private void searchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseExited
        // TODO add your handling code here:
        search.setBackground(new Color(102, 255, 102));
    }//GEN-LAST:event_searchMouseExited

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        /*try {
            if (numNF.getText().equals("")) {
                throw new NumberFormatException();
            }
            long valor = Long.parseLong(numNF.getText());
            con.selectNFCommandSQL("SELECT * FROM nf_a WHERE NUM_NF='" + numNF.getText() + "'");
            //AntigoSearch s = new AntigoSearch(numNF.getText(), userName.getText(), con);
            SearchNF s = new SearchNF(userName.getText(), con, numNF.getText());
            s.setVisible(true);
            dispose();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "NOTA NÃO CADASTRADA!", "AVISO", JOptionPane.INFORMATION_MESSAGE);
            //NotExistNF n = new NotExistNF(numNF.getText(), userName.getText(), con);
            //////////////////////////////////////////////////////////////////////////////////////////
            RegisterNF n = new RegisterNF(userName.getText(), con, numNF.getText());
            //////////////////////////////////////////////////////////////////////////////////////////
            n.setVisible(true);
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "FORMATO INCORRETO!!", "AVISO", JOptionPane.INFORMATION_MESSAGE);
            numNF.setText("");
        }*/
    }//GEN-LAST:event_searchActionPerformed

    private void listarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listarMouseEntered
        // TODO add your handling code here:
        listar.setBackground(new Color(135, 206, 250));
    }//GEN-LAST:event_listarMouseEntered

    private void listarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listarMouseExited
        // TODO add your handling code here:
        listar.setBackground(new Color(102, 255, 102));
    }//GEN-LAST:event_listarMouseExited

    private void listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarActionPerformed
        // TODO add your handling code here:
        //ListNF a = new ListNF(userName.getText());
        //a.setVisible(true);
        //dispose();
    }//GEN-LAST:event_listarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // Método para realizar o fechamento seguro da aplicação
        ControllerMain.disconnection(); // Método para realizar a desconexão com o banco de dados
        dispose(); // Função para fechar o frame atual
    }//GEN-LAST:event_formWindowClosing

    private void btn_exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_exitMousePressed
        // Método para fechar deslogar do sistema
        Login login = new Login(); // É intânciado o novo frame de login
        login.setVisible(true); // Defini a visibilidade do frame como visivel
        dispose(); // Fecha o frame atual, ou seja, fecha o frame Main
    }//GEN-LAST:event_btn_exitMousePressed

    private void btnNotasFiscaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNotasFiscaisMouseClicked
        // Método para abrir as opções do menu de notas fiscais
       // jPanelGerenciamentoNotasFiscais.setVisible(!jPanelGerenciamentoNotasFiscais.isVisible()); // Método para mudar a visibilidade do menu
       // resetPanels(new JPanel[]{jPanelGerenciamentoUser, jPanelPerfil}); // Método para mudar a visibilidade dos outros menus
    }//GEN-LAST:event_btnNotasFiscaisMouseClicked

    private void btnPCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPCMouseClicked
     // Método para abrir as opções do menu de notas fiscais
       // jPanelGerenciamentoPedidoCompra.setVisible(!jPanelGerenciamentoPedidoCompra.isVisible()); // Método para mudar a visibilidade do menu
       // resetPanels(new JPanel[]{jPanelGerenciamentoUser, jPanelGerenciamentoNotasFiscais,jPanelPerfil}); // Método para mudar a visibilidade dos outros menus  
    }//GEN-LAST:event_btnPCMouseClicked

    private void btnNotasFiscaisMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNotasFiscaisMouseEntered
        // Método para mudar a cor do botão quando o mouse passa por cima, dando um efeito de hover
        setColor(btnNotasFiscais); // Método para definir a cor do botão
        ind_2.setOpaque(true); // Defini o indice como opaco
        // Método para abrir as opções do menu de notas fiscais
        if(jPanelGerenciamentoNotasFiscais.isVisible()!= true)
        {
        jPanelGerenciamentoNotasFiscais.setVisible(!jPanelGerenciamentoNotasFiscais.isVisible());
        }
        resetPanels(new JPanel[]{jPanelGerenciamentoUser, jPanelPerfil,jPanelGerenciamentoPedidoCompra}); // Método para mudar a visibilidade dos outros menus
        //função para resetar a visualização de todos botões exceto do selecionado
        resetColor(new JPanel[]{btnHome}, new JPanel[]{ind_1});
        resetColor(new JPanel[]{btPerfil}, new JPanel[]{ind_6});
        resetColor(new JPanel[]{btnPC}, new JPanel[]{ind_4});
        resetColor(new JPanel[]{btnUsuarios}, new JPanel[]{ind_3});
        
    }//GEN-LAST:event_btnNotasFiscaisMouseEntered

    private void btnNotasFiscaisMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNotasFiscaisMouseExited
        // Método para redefinir as cores do botão e do indice
        resetColor(new JPanel[]{btnNotasFiscais}, new JPanel[]{ind_2}); // Método que realiza a redifinição
        //método para resetar os paineis ao sair do mouse
        resetPanels(new JPanel[]{jPanelGerenciamentoUser, jPanelPerfil,jPanelGerenciamentoPedidoCompra,jPanelGerenciamentoNotasFiscais});
    }//GEN-LAST:event_btnNotasFiscaisMouseExited

    private void btnPCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPCMouseEntered
      // Método para mudar a cor do botão quando o mouse passa por cima, dando um efeito de hover
        setColor(btnPC); // Método para definir a cor do botão
        ind_4.setOpaque(true); // Defini o indice como opaco
        // Método para abrir as opções do menu de notas fiscais
        if(jPanelGerenciamentoPedidoCompra.isVisible()!= true)
        {
        jPanelGerenciamentoPedidoCompra.setVisible(!jPanelGerenciamentoPedidoCompra.isVisible());
        }
// Método para mudar a visibilidade do menu
        resetPanels(new JPanel[]{jPanelGerenciamentoUser, jPanelGerenciamentoNotasFiscais,jPanelPerfil}); // Método para mudar a visibilidade dos outros menus 
        //função para resetar a visualização de todos botões exceto do selecionado
        resetColor(new JPanel[]{btnHome}, new JPanel[]{ind_1});
        resetColor(new JPanel[]{btPerfil}, new JPanel[]{ind_6});
        resetColor(new JPanel[]{btnUsuarios}, new JPanel[]{ind_3});
        resetColor(new JPanel[]{btnNotasFiscais}, new JPanel[]{ind_2});
    }//GEN-LAST:event_btnPCMouseEntered

    private void btnPCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPCMouseExited
    // Método para redefinir as cores do botão e do indice
        resetColor(new JPanel[]{btnPC}, new JPanel[]{ind_4}); // Método que realiza a redifinição  
        //metodo para resetar os paineis ao sair do mouse
        resetPanels(new JPanel[]{jPanelGerenciamentoUser, jPanelGerenciamentoNotasFiscais,jPanelPerfil, jPanelGerenciamentoPedidoCompra}); 
    }//GEN-LAST:event_btnPCMouseExited

    private void btnUsuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseEntered
        // Método para mudar a cor do botão quando o mouse passa por cima, dando um efeito de hover
        setColor(btnUsuarios); // Método para definir a cor do botão
        ind_3.setOpaque(true); // Defini o indice como opaco
        
        // Método para abrir as opções do menu de usuários
        if(jPanelGerenciamentoUser.isVisible()!= true)
        {
        jPanelGerenciamentoUser.setVisible(!jPanelGerenciamentoUser.isVisible());
        }
        resetPanels(new JPanel[]{jPanelPerfil, jPanelGerenciamentoNotasFiscais,jPanelGerenciamentoPedidoCompra}); // Método para mudar a visibilidade dos outros menus
        //função para resetar a visualização de todos botões exceto do selecionado
        resetColor(new JPanel[]{btnHome}, new JPanel[]{ind_1});
        resetColor(new JPanel[]{btPerfil}, new JPanel[]{ind_6});
        resetColor(new JPanel[]{btnPC}, new JPanel[]{ind_4});
        resetColor(new JPanel[]{btnNotasFiscais}, new JPanel[]{ind_2});
    }//GEN-LAST:event_btnUsuariosMouseEntered

    private void btnUsuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseExited
        // Método para redefinir as cores do botão e do indice
        resetColor(new JPanel[]{btnUsuarios}, new JPanel[]{ind_3}); // Método que realiza a redifinição
        resetPanels(new JPanel[]{jPanelPerfil, jPanelGerenciamentoNotasFiscais,jPanelGerenciamentoUser,jPanelGerenciamentoPedidoCompra}); // Método para mudar a visibilidade dos outros menus
    }//GEN-LAST:event_btnUsuariosMouseExited

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered
        // Método para mudar a cor do botão quando o mouse passa por cima, dando um efeito de hover
        setColor(btnHome); // Método para definir a cor do botão
        ind_1.setOpaque(true); // Defini o indice como opaco
        resetPanels(new JPanel[]{jPanelPerfil, jPanelGerenciamentoNotasFiscais,jPanelGerenciamentoUser,jPanelGerenciamentoPedidoCompra}); 
        //função para resetar todos os botões exceto o selecionado
        resetColor(new JPanel[]{btPerfil}, new JPanel[]{ind_6});
        resetColor(new JPanel[]{btnPC}, new JPanel[]{ind_4});
        resetColor(new JPanel[]{btnUsuarios}, new JPanel[]{ind_3});
        resetColor(new JPanel[]{btnNotasFiscais}, new JPanel[]{ind_2});
    }//GEN-LAST:event_btnHomeMouseEntered

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited
        // Método para redefinir as cores do botão e do indice
        resetColor(new JPanel[]{btnHome}, new JPanel[]{ind_1}); // Método que realiza a redifinição
        ind_1.setOpaque(false); // Defini o indice como opaco
        resetPanels(new JPanel[]{jPanelPerfil, jPanelGerenciamentoNotasFiscais,jPanelGerenciamentoUser,jPanelGerenciamentoPedidoCompra}); 
    }//GEN-LAST:event_btnHomeMouseExited

    private void btnUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseClicked
        // Método para abrir as opções do menu de usuários
      //  jPanelGerenciamentoUser.setVisible(!jPanelGerenciamentoUser.isVisible()); // Método para mudar a visibilidade do menu
       // resetPanels(new JPanel[]{jPanelPerfil, jPanelGerenciamentoNotasFiscais}); // Método para mudar a visibilidade dos outros menus
    }//GEN-LAST:event_btnUsuariosMouseClicked

    private void addUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserMouseClicked
        // Método abrir o frame para adicionar um usuário
        AddUser addUser = new AddUser(userName.getText(), false, -1); // Instância o novo frame
        addUser.setLocationRelativeTo(null); // Defini a localização no meio da tela
        addUser.setVisible(true); // Defini o frame como visivel
        resetPanels(new JPanel[]{jPanelGerenciamentoUser}); // Método para mudar a visibilidade do menu
    }//GEN-LAST:event_addUserMouseClicked

    private void listNFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listNFMouseClicked
        // Método abrir o frame para adicionar um usuário
        /*ListNF listNF = new ListNF(userName.getText(), con); // Instância o novo frame
        listNF.setLocationRelativeTo(null); // Defini a localização no meio da tela
        listNF.setVisible(true); // Defini o frame como visivel*/
        resetPanels(new JPanel[]{jPanelGerenciamentoNotasFiscais}); // Método para mudar a visibilidade do menu
    }//GEN-LAST:event_listNFMouseClicked

    private void editUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editUserMouseClicked
        // Método abrir o frame para adicionar um usuário
        ControllerMain.userAction(userName.getText(), "Editar Usuário");
        resetPanels(new JPanel[]{jPanelGerenciamentoUser}); // Método para mudar a visibilidade do menu
    }//GEN-LAST:event_editUserMouseClicked

    private void blockUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_blockUserMouseClicked
        // Método abrir o frame para adicionar um usuário
        BlockUser user = new BlockUser(userName.getText(), "Bloquear Usuário"); // Instância o novo frame
        user.setLocationRelativeTo(null); // Defini a localização no meio da tela
        user.setVisible(true); // Defini o frame como visivel
        resetPanels(new JPanel[]{jPanelGerenciamentoUser}); // Método para mudar a visibilidade do menu
    }//GEN-LAST:event_blockUserMouseClicked

    private void listUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listUserMouseClicked
        // Método abrir o frame para adicionar um usuário
        BlockUser user = new BlockUser(userName.getText(), "Listagem de Usuários"); // Instância o novo frame
        user.setLocationRelativeTo(null); // Defini a localização no meio da tela
        user.setVisible(true); // Defini o frame como visivel
        resetPanels(new JPanel[]{jPanelGerenciamentoUser}); // Método para mudar a visibilidade do menu
    }//GEN-LAST:event_listUserMouseClicked

    private void btPerfilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPerfilMouseExited
       // Método para redefinir as cores do botão e do indice
        resetColor(new JPanel[]{btPerfil}, new JPanel[]{ind_6}); // Método que realiza a redifinição
        //metodo para redefinir todos os paineis ao sair do mouse
        resetPanels(new JPanel[]{jPanelPerfil, jPanelGerenciamentoNotasFiscais,jPanelGerenciamentoUser,jPanelGerenciamentoPedidoCompra}); 
    }//GEN-LAST:event_btPerfilMouseExited

    private void btPerfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPerfilMouseEntered
          // Método para mudar a cor do botão quando o mouse passa por cima, dando um efeito de hover
        setColor(btPerfil); // Método para definir a cor do botão
        ind_6.setOpaque(true); // Defini o indice como opaco
        // Método para abrir as opções do menu de notas fiscais
        if(jPanelPerfil.isVisible()!= true)
        {
        jPanelPerfil.setVisible(!jPanelPerfil.isVisible());
        }
        // Método para mudar a visibilidade dos outros menus
        resetPanels(new JPanel[]{jPanelGerenciamentoUser, jPanelGerenciamentoNotasFiscais,jPanelGerenciamentoPedidoCompra}); 
        //função para resetar a visualização de todos botões exceto do selecionado
        resetColor(new JPanel[]{btnHome}, new JPanel[]{ind_1});
        resetColor(new JPanel[]{btnPC}, new JPanel[]{ind_4});
        resetColor(new JPanel[]{btnUsuarios}, new JPanel[]{ind_3});
        resetColor(new JPanel[]{btnNotasFiscais}, new JPanel[]{ind_2});
    }//GEN-LAST:event_btPerfilMouseEntered

    private void btPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPerfilMouseClicked
      // Método para abrir as opções do menu de notas fiscais
        //jPanelPerfil.setVisible(!jPanelPerfil.isVisible()); // Método para mudar a visibilidade do menu
       // resetPanels(new JPanel[]{jPanelGerenciamentoUser, jPanelGerenciamentoNotasFiscais,jPanelGerenciamentoPedidoCompra}); // Método para mudar a visibilidade dos outros menus
    }//GEN-LAST:event_btPerfilMouseClicked

    private void addNF1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addNF1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_addNF1MouseClicked

    private void listNF1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listNF1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_listNF1MouseClicked

    private void jPanelGerenciamentoPedidoCompraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelGerenciamentoPedidoCompraMouseEntered
        // Método para mudar a cor do botão quando o mouse passa por cima, dando um efeito de hover
        setColor(btnPC); // Método para definir a cor do botão
        ind_4.setOpaque(true); // Defini o indice como opaco
        // Método para abrir as opções do menu de notas fiscais
        jPanelGerenciamentoPedidoCompra.setVisible(!jPanelGerenciamentoPedidoCompra.isVisible()); // Método para mudar a visibilidade do menu
        resetPanels(new JPanel[]{jPanelGerenciamentoUser, jPanelGerenciamentoNotasFiscais,jPanelPerfil}); // Método para mudar a visibilidade dos outros menus 
    }//GEN-LAST:event_jPanelGerenciamentoPedidoCompraMouseEntered

    private void jPanelPerfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelPerfilMouseEntered
          // Método para mudar a cor do botão quando o mouse passa por cima, dando um efeito de hover
        setColor(btPerfil); // Método para definir a cor do botão
        ind_6.setOpaque(true); // Defini o indice como opaco
        // Método para abrir as opções do menu de notas fiscais
        jPanelPerfil.setVisible(!jPanelPerfil.isVisible()); // Método para mudar a visibilidade do menu
        // Método para mudar a visibilidade dos outros menus
        resetPanels(new JPanel[]{jPanelGerenciamentoUser, jPanelGerenciamentoNotasFiscais,jPanelGerenciamentoPedidoCompra}); 
    }//GEN-LAST:event_jPanelPerfilMouseEntered

    private void jPanelGerenciamentoNotasFiscaisMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelGerenciamentoNotasFiscaisMouseEntered
        // Método para mudar a cor do botão quando o mouse passa por cima, dando um efeito de hover
        setColor(btnNotasFiscais); // Método para definir a cor do botão
        ind_2.setOpaque(true); // Defini o indice como opaco
        // Método para abrir as opções do menu de notas fiscais
        jPanelGerenciamentoNotasFiscais.setVisible(!jPanelGerenciamentoNotasFiscais.isVisible()); // Método para mudar a visibilidade do menu
        resetPanels(new JPanel[]{jPanelGerenciamentoUser, jPanelPerfil,jPanelGerenciamentoPedidoCompra}); // Método para mudar a visibilidade dos outros menus
    }//GEN-LAST:event_jPanelGerenciamentoNotasFiscaisMouseEntered

    private void jPanelGerenciamentoUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelGerenciamentoUserMouseEntered
       // Método para mudar a cor do botão quando o mouse passa por cima, dando um efeito de hover
        setColor(btnUsuarios); // Método para definir a cor do botão
        ind_3.setOpaque(true); // Defini o indice como opaco
        
        // Método para abrir as opções do menu de usuários
        jPanelGerenciamentoUser.setVisible(!jPanelGerenciamentoUser.isVisible()); // Método para mudar a visibilidade do menu
        resetPanels(new JPanel[]{jPanelPerfil, jPanelGerenciamentoNotasFiscais,jPanelGerenciamentoPedidoCompra}); // Método para mudar a visibilidade dos outros menus
    }//GEN-LAST:event_jPanelGerenciamentoUserMouseEntered

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        resetColor(new JPanel[]{btPerfil}, new JPanel[]{ind_6});
        resetColor(new JPanel[]{btnHome}, new JPanel[]{ind_1});
        resetColor(new JPanel[]{btnPC}, new JPanel[]{ind_4});
        resetColor(new JPanel[]{btnUsuarios}, new JPanel[]{ind_3});
        resetColor(new JPanel[]{btnNotasFiscais}, new JPanel[]{ind_2});
        resetPanels(new JPanel[]{jPanelPerfil, jPanelGerenciamentoNotasFiscais,jPanelGerenciamentoPedidoCompra,jPanelGerenciamentoUser}); // Método para mudar a visibilidade dos outros menus
    }//GEN-LAST:event_formMouseEntered

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addNF1;
    private javax.swing.JPanel addUser;
    private javax.swing.JPanel blockUser;
    private javax.swing.JPanel btPerfil;
    private javax.swing.JPanel btnHome;
    private javax.swing.JPanel btnNotasFiscais;
    private javax.swing.JPanel btnPC;
    private javax.swing.JPanel btnUsuarios;
    private javax.swing.JLabel btn_exit;
    private javax.swing.JPanel editNF;
    private javax.swing.JPanel editUser;
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
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
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
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JPanel listNF;
    private javax.swing.JPanel listNF1;
    private javax.swing.JPanel listUser;
    private javax.swing.JButton listar;
    private javax.swing.JTextField numNF;
    private javax.swing.JButton search;
    private javax.swing.JPanel side_pane;
    private javax.swing.JPanel tittleGerenciamentoUser;
    private javax.swing.JPanel tittleGerenciamentoUser1;
    private javax.swing.JPanel tittleGerenciamentoUser2;
    private javax.swing.JLabel user;
    private javax.swing.JLabel userName;
    // End of variables declaration//GEN-END:variables
}
