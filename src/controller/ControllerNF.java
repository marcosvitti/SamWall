package controller;

import dataBase.DataBase;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.control.ComboBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import screens.AddNF;

public class ControllerNF {
    
    private static final DataBase con = DataBase.getInstance(); // Instanciação da variável interações com o banco de dados

    public static synchronized void connection(){
        con.connection();
    }

    public static synchronized void disconnection(){
        con.disconnection();
    }
    
    public static boolean criarNF(String[] campos) {
        // Método para adicionar um novo usuário no sistema
        String NumeroNF = campos[0];
        String qtdParcela = campos[1];
        String valor = campos[2];
        String observacao = campos[3];
        String pedido = campos[4];
        String colaborador = campos[5];
        String fornecedor = campos[6];

        for (int i=0 ; i < campos.length; i++) {
            if (campos[i].equals("")) {
                if(i != 3) {
                    JOptionPane.showMessageDialog(null, "Todos os campo precisam ser preenchidos!", "ERRO", JOptionPane.ERROR_MESSAGE); // Cria uma tela de aviso ao usuário
                    return false;
                }
            }
        }
        try {
            connection();
            ArrayList forn = con.select("FORNECEDOR", new String[] {"RAZAO_SOCIAL", "ID_FORNECEDOR"}, new String[]{fornecedor});
            //Select razao_social, id_fornecedor from fonecedor where razao_social=fornecedor
            
            ArrayList colab = con.select("COLABORADORES", new String[] {"NOME", "ID_USER"}, new String[] {colaborador});
            ArrayList npedido = con.select("PEDIDO_COMPRA", new String[] {"ID_PEDIDO"}, new String[] {pedido});
            con.insert("nf_a",
                        new String[] {"ID_FORNECEDOR_FK", "VALOR_NF", "NUM_NF", "QTD_PARCELA", "ID_COLAB_FK", "OBSERVACOES", "ID_PEDIDO_FK"},
                        new String[] {forn.get(1).toString(), valor, NumeroNF, qtdParcela, colab.get(1).toString(), observacao, npedido.get(0).toString()});
                JOptionPane.showMessageDialog(null, "Nota Fiscal cadastrado com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);        
        } catch (SQLException ex) { // Caso a validação do usuário falhe é lançado uma exception
            JOptionPane.showMessageDialog(null, "Nota fiscal esta incorreto", "ERRO", JOptionPane.ERROR_MESSAGE); // Cria uma tela de aviso ao usuário
        } finally {
            disconnection();
        }
        return true;
    }
    
    public static void main(String login, String action, int codigo) {
         // Instância o novo frame
        if (codigo == -1){
            AddNF nf = new AddNF(login, action);
            nf.setLocationRelativeTo(null); // Defini a localização no meio da tela
            nf.setVisible(true);
        } else {
            System.out.println("Abriu outra Tela");
        }
         // Defini o frame como visivel
    }

    public static void carregarComboBox(JComboBox comboBox, String comboName) {
        String campos = null;
        String table = null;

        switch(comboName) {
            case "FORNECEDOR":
                table = "FORNECEDOR";
                campos = "RAZAO_SOCIAL";
                break;
            case "COLABORADOR":
                campos = "NOME";
                table = "COLABORADORES";
                break;
            case "PEDIDO":
                table = "PEDIDO_COMPRA";
                campos = "ID_PEDIDO";
                break;
        }
        try {
            connection();
            ArrayList dados = con.select(table, new String[] {campos}, new String[] {});
            comboBox.addItem("Selecione...");
            dados.forEach((dado) -> {
                comboBox.addItem(dado.toString());
            });
        } catch (SQLException ex) { // Caso a validação do usuário falhe é lançado uma exception
            JOptionPane.showMessageDialog(null, "Erro ao listar os campos de seleções!", "ERRO", JOptionPane.ERROR_MESSAGE); // Cria uma tela de aviso ao usuário
        } finally {
            disconnection();
        }
    }
}