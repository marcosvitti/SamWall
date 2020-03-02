package controller;

import dataBase.DataBase;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import screens.Main;

public class controllerLogin {

    private static final DataBase con = DataBase.getInstance(); // Instanciação da variável interações com o banco de dados

    public static synchronized void connection(){
        con.connection();
    }

    public static synchronized void disconnection(){
        con.disconnection();
    }

    public static synchronized String[] logar(String username, String password){ // Método para validar se o usuário está cadastrado no banco
        try { // Tentar realizar a validação do usuário
            con.selectLoginCommandSQL(username, password); // Função para realizar a validação do usuário
            //con.select( "COLABORADORES", new String[] {"LOGIN","SENHA"}, new String[] {username, DataBase.SHA1(password)}); // Função para realizar a validação do usuário
            Main main = new Main(username); // Se o usuário existir no banco é instânciado o novo frame =>
            //=> passando como parâmetro o nome do usuário, para printar mensagens personalizadas, e =>
            //=> a própria conexão para não ficar instânciando novas conexões nos outros frames
            //main.setExtendedState(JFrame.MAXIMIZED_BOTH); // Inicializa o frame main com full screen
            main.setExtendedState(6); // Inicializa o frame main com full screen
            main.setLocationRelativeTo(null); // Inicializa o frame main centralizado na tela
            main.setVisible(true); // Muda a visibilidade do novo frame instânciado para visível
        } catch (SQLException ex) { // Caso a validação do usuário falhe é lançado uma exception
            JOptionPane.showMessageDialog(null, "Usuário/Senha estão incorretos", "ERRO", JOptionPane.ERROR_MESSAGE); // Cria uma tela de aviso ao usuário
            return new String[] {"ERROR"};
        }
        return new String[] {"SUCCESS"};
    } // Fim do método para validar se o usuário está cadastrado no banco

}
