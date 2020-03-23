package controller;

import dataBase.DataBase;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import screens.Main;

public class ControllerMain {

    private static final DataBase con = DataBase.getInstance();

    public static synchronized void connection(){
        con.connection();
    }

    public static synchronized void disconnection(){
        con.disconnection();
    }

    public static synchronized String[] buscaUserName(String login) { // Método para buscar o nome do colaborador pelo seu username 
        ArrayList nome = new ArrayList();
        try {
            connection();
            nome = con.select("COLABORADORES", new String[] {"LOGIN","NOME","SOBRENOME", "TIPO"}, new String[] {login});
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Usuário não encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            disconnection();
        }
        return  new String[] {nome.get(1) + " " + nome.get(2), Boolean.toString(nome.get(3).equals("A"))};
    } // Fim do método para buscar o nome do colaborador

    public static synchronized void userAction(String login, String action){
        ControllerUser.main(login, action, 0);
    }

    public static synchronized void logout(){
        disconnection();
        ControllerLogin.main(null);
    }

    public static void main(String login) {
        Main main = new Main(login);
        main.setExtendedState(6);
        main.setLocationRelativeTo(null);
        main.setVisible(true);
    }
}