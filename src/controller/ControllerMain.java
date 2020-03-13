package controller;

import dataBase.DataBase;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import screens.Main;

public class ControllerMain {

    private static final DataBase con = DataBase.getInstance(); // Instanciação da variável interações com o banco de dados

    public static synchronized void connection(){
        con.connection();
    }

    public static synchronized void disconnection(){
        con.disconnection();
    }

    public static synchronized Object[] buscaUserName(String username) { // Método para buscar o nome do colaborador pelo seu username 
        ArrayList nome = new ArrayList();
        try { // Tentar realizar a busca pelo usuário
            connection();
            //return con.selectUserNameCommandSQL(username); // Retorna o resposta da função, o nome completo do usuário
            nome = con.select("COLABORADORES", new String[] {"LOGIN","NOME","SOBRENOME", "TIPO"}, new String[] {username}); // Retorna o resposta da função, o nome completo do usuário
        } catch (SQLException ex) { // Caso a busca do usuário falhe é lançado uma exception
            JOptionPane.showMessageDialog(null, "Usuário não encontrado", "ERROR", JOptionPane.ERROR_MESSAGE); // Mostra um aviso para o usuário
        } finally {
            disconnection();
        }
        return  new Object[] {nome.get(1) + " " + nome.get(2), nome.get(3).equals("A")};
    } // Fim do método para buscar o nome do colaborador

    public static synchronized void userAction(String username, String action){
        ControllerUser.main(username, action); // Instância o novo frame
    }

    public static void main(String username) {
        Main main = new Main(username);
        //main.setExtendedState(JFrame.MAXIMIZED_BOTH); // Inicializa o frame main com full screen
        main.setExtendedState(6); // Inicializa o frame main com full screen
        main.setLocationRelativeTo(null); // Inicializa o frame main centralizado na tela
        main.setVisible(true); // Muda a visibilidade do novo frame instânciado para visível
    }
}