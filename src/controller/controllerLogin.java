package controller;

import com.jtattoo.plaf.DecorationHelper;
import dataBase.DataBase;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import screens.Login;
import screens.Main;

public class ControllerLogin {

    private static final DataBase con = DataBase.getInstance(); // Instanciação da variável interações com o banco de dados

    public static synchronized void connection(Login frame){
        con.connection();
    }

    public static synchronized void disconnection(Login frame){
        con.disconnection();
    }

    public static synchronized String[] logar(String username, String password, Login frame){ // Método para validar se o usuário está cadastrado no banco
        try { // Tentar realizar a validação do usuário
            //con.selectLoginCommandSQL(username, password); // Função para realizar a validação do usuário
            con.select( "COLABORADORES", new String[] {"LOGIN","SENHA"}, new String[] {username, DataBase.SHA1(password)}); // Função para realizar a validação do usuário
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
        frame.dispose();
        return new String[] {"SUCCESS"};
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
