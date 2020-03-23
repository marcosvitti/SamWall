package controller;

import com.jtattoo.plaf.DecorationHelper;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.sql.SQLException;
import dataBase.DataBase;
import java.util.ArrayList;
import screens.Login;

public class ControllerLogin {

    private static final DataBase con = DataBase.getInstance();

    public static synchronized void connection() {
        con.connection();
    }

    public static synchronized void disconnection() {
        con.disconnection();
    }

    public static synchronized String[] logar(String login, String password) { // Método para validar se o usuário está cadastrado no banco
        ArrayList user;
        try {
            connection();
            user = con.select( "COLABORADORES", new String[] {"LOGIN","SENHA"}, new String[] {login, DataBase.SHA1(password)});
            if(user.isEmpty()){
                throw new SQLException();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Usuário/Senha estão incorretos", "ERRO", JOptionPane.ERROR_MESSAGE);
            return new String[] {"Username","Password"};
        } finally {
            disconnection();
        }
        ControllerMain.main(login);
        return null;
    } // Fim do método para validar se o usuário está cadastrado no banco

    public static void main(String args[]) {
        try { 
            UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel"); // Escolha do tema a ser usado
            DecorationHelper.decorateWindows(false); // Desativa os botões de Minimizar, Maximizar e Redimensionar do frame
        } catch (ClassNotFoundException
                | InstantiationException
                | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException ex) { // Caso ocorra alguma exception
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex); // Mostra o erro pertinente a exception 
        }

        java.awt.EventQueue.invokeLater(() -> {
            Login frame = new Login();
            frame.setVisible(true);
            frame.requestFocus();
        });
    }
}
