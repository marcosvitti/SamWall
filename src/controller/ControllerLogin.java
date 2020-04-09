package controller;

import com.jtattoo.plaf.DecorationHelper;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.sql.SQLException;
import dataBase.DataBase;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        if (sanitize(new String[]{login, password})) {

            try {
                connection();
                user = con.select( "COLABORADORES", new String[] {"LOGIN","SENHA","ID_USER","LOGADO", "STATUS"}, new String[] {login, DataBase.SHA1(password)});
                if (user.isEmpty() || user.get(3).equals("1") || user.get(4).equals("0")) {
                    throw new SQLException(user.isEmpty() ? "0" : user.get(3).toString().equals("1") ? "1" : "2");
                }
                con.update("COLABORADORES", new String[]{"LOGADO"}, new String[]{"1"}, new String[]{"ID_USER"}, new String[]{user.get(2).toString()});
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, 
                        ex.getMessage().equals("0") ? 
                                "Usuário/Senha estão incorretos" : 
                                ex.getMessage().equals("1") ? "Usuário já logado no sistema!" : "Usuário inativado no sistema!" , "ERRO", JOptionPane.ERROR_MESSAGE);
                return new String[] {"Username","Password"};
            } finally {
                disconnection();
            }
            ControllerMain.main(login);
            return new String[] {"OK"};
        }
        JOptionPane.showMessageDialog(null, "Caracteres inválidos detectados!\n\tTente novamente...", "AVISO", JOptionPane.ERROR_MESSAGE);
        return new String[] {"Username","Password"};
    } // Fim do método para validar se o usuário está cadastrado no banco

    private static boolean sanitize(String[] args) {

        for (String arg : args) {

            Matcher matcher = Pattern.compile("[^\\w]").matcher(arg); // Compara o caractere digitado com a expressão regular
            if (matcher.find()) {
                return false;
            }
        }
        return true;
    }
    // '),1,0) OR 1=1 -- 
    // ' OR 1=1 -- 

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
