package controller;

import com.jtattoo.plaf.DecorationHelper;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.sql.SQLException;
import dataBase.DataBase;
import java.util.ArrayList;
import screens.Login;

public class ControllerLogin {

    private static final DataBase con = DataBase.getInstance(); // Instanciação da variável interações com o banco de dados

    public static synchronized void connection(){
        con.connection();
    }

    public static synchronized void disconnection(){
        con.disconnection();
    }

    public static synchronized Object[] logar(String username, String password, Login frame){ // Método para validar se o usuário está cadastrado no banco
        ArrayList user = new ArrayList();
        try { // Tentar realizar a validação do usuário
            connection();
            //con.selectLoginCommandSQL(username, password); // Função para realizar a validação do usuário
            user = con.select( "COLABORADORES", new String[] {"LOGIN","SENHA"}, new String[] {username, DataBase.SHA1(password)}); // Função para realizar a validação do usuário
            if(user.isEmpty()){
                throw new SQLException();
            }
        } catch (SQLException ex) { // Caso a validação do usuário falhe é lançado uma exception
            JOptionPane.showMessageDialog(null, "Usuário/Senha estão incorretos", "ERRO", JOptionPane.ERROR_MESSAGE); // Cria uma tela de aviso ao usuário
            return new Object[] {"Username","Password"};
        } finally {
            disconnection();
        }
        ControllerMain.main(username);
        frame.dispose();
        return new String[] {"Username","Password"};
    } // Fim do método para validar se o usuário está cadastrado no banco

    public static void main(String args[]) {
        try { // Tentar usar o LookAndFeel da API jtattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel"); // Escolha do tema a ser usado
            DecorationHelper.decorateWindows(false); // Desativa os botões de Minimizar, Maximizar e Redimensionar do frame
        } catch (ClassNotFoundException
                | InstantiationException
                | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException ex) { // Caso ocorra alguma exception
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex); // Mostra o erro pertinente a exception 
        }

        java.awt.EventQueue.invokeLater(() -> { // Método para instânciar o frame Login
            Login frame = new Login(); // Instânciação do frame
            frame.setVisible(true); // Mudando a visibilidade como visível
            frame.requestFocus(); // Mudando o foco para o frame
        }); // Fim do método de invocação
    } // Fim do método Main
}
