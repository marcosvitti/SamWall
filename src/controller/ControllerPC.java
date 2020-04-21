package controller;

import dataBase.DataBase;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import screens.AddPC;
import screens.AddProd;

public class ControllerPC {
    
    private static final DataBase con = DataBase.getInstance(); // Instanciação da variável interações com o banco de dados

    public static synchronized void connection(){
        con.connection();
    }

    public static synchronized void disconnection(){
        con.disconnection();
    }
    
    public static String nomeUser(String login) throws SQLException{
        connection();
        String nome;
        nome = con.selectUserNameCommandSQL(login);
        disconnection();
        return nome;
    }
    
    public static int idPC() throws SQLException{
        connection();
            int id = con.selectIdPc();
        disconnection();
        return id;
    }
    
    public static String nomeColab(String login) throws SQLException{
        connection();
        ArrayList nome = con.select("COLABORADORES", new String[]{"LOGIN", "NOME"}, new String[]{login});
        disconnection();
        return nome.get(1).toString();
    }
    
    public static boolean criarPC(String[] campos) {
        // Método para adicionar um novo pedido de compra
        String  fornece= campos[0];
        String contato = campos[1];
        String colab = campos[2];
        String obs = campos[3];
       
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
            ArrayList idColab = con.select("COLABORADORES",new String[]{"LOGIN","ID_USER"}, new String[]{colab});
            ArrayList forn = con.select("FORNECEDOR",new String[]{"RAZAO_SOCIAL","ID_FORNECEDOR"}, new String[]{fornece});
            
            con.insert("PEDIDO_COMPRA", new String[] { "ID_FORNECEDOR_FK", "DATA_COMPRA", "CONTATO", "ID_USER_FK", "OBS"}, 
                    new String[] { forn.get(1).toString(), "GETDATE()",contato, idColab.get(1).toString(), obs});
                       
                JOptionPane.showMessageDialog(null, "Pedido de Compra cadastrado com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);        
        } catch (SQLException ex) { // Caso a validação do usuário falhe é lançado uma exception
            JOptionPane.showMessageDialog(null, "Pedido esta incorreto", "ERRO", JOptionPane.ERROR_MESSAGE); // Cria uma tela de aviso ao usuário
        } finally {
            disconnection();
        }
        return true;
    }
    
    public static void main(String login, String action, int codigo) throws SQLException {
         // Instância o novo frame
        if (codigo == -1){
            AddPC pc = new AddPC(login, action);
            pc.setLocationRelativeTo(null); // Defini a localização no meio da tela
            pc.setVisible(true);
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
    
     public static synchronized JTable listarPd(JTable jTable, int idPC) { // Método para listar os colaboradores do sistema
        ArrayList resp = new ArrayList();
        int i = 0;
        ((DefaultTableModel) jTable.getModel()).setRowCount(0);
        
        try { // Tentar realizar a listagem dos colaboradores
            connection();
            resp = con.select("PRODUTO_PEDIDO", new String[] {"ID_PEDIDO_FK", "DESCRICAO_PROD", "QTD_PROD", "VALOR_UNIT"}, new String[]{Integer.toString(idPC)}); // Retorna o resposta da função, o nome completo do usuário
            if (resp.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Insira os produtos.", "ERRO", JOptionPane.INFORMATION_MESSAGE);
            }
            System.out.println(resp);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar os produtos!", "ERRO", JOptionPane.ERROR_MESSAGE);
            
        } finally {
            disconnection();
        }

        for(i=0; i<resp.size(); i+=4) {
            String descricao = resp.get(1).toString();
            String qtdP = resp.get(2).toString();
            String valor_unit = resp.get(3).toString();
            Double vTotal= Double.parseDouble(qtdP)*Double.parseDouble(valor_unit);

            DefaultTableCellRenderer hRenderer = new DefaultTableCellRenderer();
            hRenderer.setBackground(new Color(84, 127, 206));
            hRenderer.setForeground(new Color(255, 255, 255));

            String linha[] = {descricao, qtdP, valor_unit,Double.toString(vTotal)};
            ((DefaultTableModel) jTable.getModel()).addRow(linha);

            for (int j = 0; j < jTable.getModel().getColumnCount(); j++) {
                jTable.getColumnModel().getColumn(j).setHeaderRenderer(hRenderer);
            }
        }
        return jTable;
    }

    public static synchronized void inserirItens(String login, String action, int idPc){
        AddProd prod = new AddProd(login, action, idPc);
        prod.setVisible(true);
    }
    public static boolean criarPD(String[] campos, int IdPc) {
        // Método para adicionar um novo pedido de compra
        String produto= campos[0];
        String qtd = campos[1];
        String valorU = campos[2];
               
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
            con.insert("PRODUTO_PEDIDO", new String[] { "DESCRICAO_PROD", "QTD_PROD", "VALOR_UNIT, ID_PEDIDO_FK"}, 
                    new String[] { produto, qtd, valorU,Integer.toString(IdPc)});
                       
                JOptionPane.showMessageDialog(null, "Produto adicionado!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);        
        } catch (SQLException ex) { // Caso a validação do usuário falhe é lançado uma exception
            JOptionPane.showMessageDialog(null, "Produto esta incorreto", "ERRO", JOptionPane.ERROR_MESSAGE); // Cria uma tela de aviso ao usuário
        } finally {
            disconnection();
        }
        return true;
    }
}

