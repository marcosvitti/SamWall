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
import screens.AddNF;
import screens.ListViewNF;

public class ControllerNF {

    private static final DataBase con = DataBase.getInstance(); // Instanciação da variável interações com o banco de dados

    public static synchronized void connection() {
        con.connection();
    }

    public static synchronized void disconnection() {
        con.disconnection();
    }

    public static boolean criarNF(String[] campos) {
        // Método para adicionar um novo usuário no sistema
        String NumeroNF = campos[0];
        String valor = campos[1];
        String observacao = campos[2];
        String pedido = campos[3];
        String colaborador = campos[4];
        String fornecedor = campos[5];

        for (int i = 0; i < campos.length; i++) {
            if (campos[i].equals("")) {
                if (i != 3) {
                    JOptionPane.showMessageDialog(null, "Todos os campo precisam ser preenchidos!", "ERRO", JOptionPane.ERROR_MESSAGE); // Cria uma tela de aviso ao usuário
                    return false;
                }
            }
        }
        try {
            connection();
            ArrayList forn = con.select("FORNECEDOR", new String[]{"RAZAO_SOCIAL", "ID_FORNECEDOR"}, new String[]{fornecedor});
            //Select razao_social, id_fornecedor from fonecedor where razao_social=fornecedor

            ArrayList colab = con.select("COLABORADORES", new String[]{"NOME", "ID_USER"}, new String[]{colaborador});
            ArrayList npedido = con.select("PEDIDO_COMPRA", new String[]{"ID_PEDIDO"}, new String[]{pedido});
            con.insert("nf_a",
                    new String[]{"ID_FORNECEDOR_FK", "VALOR_NF", "NUM_NF", "ID_COLAB_FK", "OBSERVACOES", "ID_PEDIDO_FK"},
                    new String[]{forn.get(1).toString(), valor, NumeroNF, colab.get(1).toString(), observacao, npedido.get(0).toString()});
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
        if (codigo == -2) {
            ListViewNF nf = new ListViewNF(login, action);
            nf.setLocationRelativeTo(null);
            nf.setVisible(true);
        } else {
            AddNF nf = new AddNF(login, action, codigo);
            nf.setLocationRelativeTo(null);// Defini a localização no meio da tela
            nf.setVisible(true);
        }
        // Defini o frame como visivel
    }

    public static void carregarComboBox(JComboBox comboBox, String comboName) {
        String campos = null;
        String table = null;

        switch (comboName) {
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
            ArrayList dados = con.select(table, new String[]{campos}, new String[]{});
            dados.forEach((dado) -> {
                comboBox.addItem(dado.toString());
            });
        } catch (SQLException ex) { // Caso a validação do usuário falhe é lançado uma exception
            JOptionPane.showMessageDialog(null, "Erro ao listar os campos de seleções!", "ERRO", JOptionPane.ERROR_MESSAGE); // Cria uma tela de aviso ao usuário
        } finally {
            disconnection();
        }
    }

    public static synchronized JTable listarNF(JTable jTable, String[] filters, ListViewNF listNF) {
        ArrayList resp = new ArrayList();
        ArrayList IdFornecedor = new ArrayList();
        ArrayList IdColaborador = new ArrayList();
        ArrayList fornecedor = new ArrayList();
        ArrayList colaborador = new ArrayList();

        ((DefaultTableModel) jTable.getModel()).setRowCount(0);
        int i = 0;
        for (String f : filters) {
            if (f.equals("") || f.equals("Selecione...")) {
                System.out.println(f);
                filters[i] = "LIKE %";
            } else {
                filters[i] = "LIKE %" + f + "%";
            }
            i++;
        }

        try { // Tentar realizar a listagem dos colaboradores
            connection();
            resp = con.select("NF_A", new String[]{"ID_NF_A", "NUM_NF", "ID_COLAB_FK", "ID_FORNECEDOR_FK", "VALOR_NF", "STATUS_NF", "DATA_ENTRADA"}, filters); // Retorna o resposta da função, o nome completo do usuário
            if (resp.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhuma Nota Registrada!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }

            System.out.println(resp);
            System.out.println(fornecedor);
            System.out.println(colaborador);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro as notas fiscais!", "ERRO", JOptionPane.ERROR_MESSAGE);
            listNF.dispose();
        } finally {
            disconnection();
        }

        for (i = 0; i < resp.size(); i += 7) {
            try {
                connection();
                fornecedor = con.select("FORNECEDOR", new String[]{"ID_FORNECEDOR", "RAZAO_SOCIAL"}, new String[]{resp.get(i + 3).toString()});
                colaborador = con.select("COLABORADORES", new String[]{"ID_USER", "NOME"}, new String[]{resp.get(i + 2).toString()});
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro as notas fiscais!", "ERRO", JOptionPane.ERROR_MESSAGE);
                listNF.dispose();
            } finally {
                disconnection();
            }

            int id_nf = Integer.parseInt(resp.get(i).toString());
            String nf = resp.get(i + 1).toString();
            String nfcolaborador = resp.get(i + 2).toString();
            String nffornecedor = resp.get(i + 3).toString();
            String valor = resp.get(i + 4).toString();
            String status = resp.get(i + 5).toString();
            String data = resp.get(i + 6).toString();

            if (nfcolaborador.equals(colaborador.get(0).toString())) {
                nfcolaborador = colaborador.get(1).toString();
            }
            System.out.println(fornecedor);

            if (nffornecedor.equals(fornecedor.get(0).toString())) {
                nffornecedor = fornecedor.get(1).toString();
            }

            DefaultTableCellRenderer hRenderer = new DefaultTableCellRenderer();
            hRenderer.setBackground(new Color(84, 127, 206));
            hRenderer.setForeground(new Color(255, 255, 255));

            String[] linha = new String[]{String.valueOf(id_nf), nf, nfcolaborador, nffornecedor, valor, status, data.substring(8, 10) + "/" + data.substring(5, 7) + "/" + data.substring(0, 4)};
            System.out.println(
                    "ID " + String.valueOf(id_nf)
                    + "\nNF " + nf
                    + "\nID_COL " + nfcolaborador
                    + "\nID_FORN " + nffornecedor
                    + "\nVALOR " + valor
                    + "\nSTATUS " + status
                    + "\nDATA " + data.substring(8, 10) + "/" + data.substring(5, 7) + "/" + data.substring(0, 4));
            ((DefaultTableModel) jTable.getModel()).addRow(linha);

            for (int j = 0; j < jTable.getModel().getColumnCount(); j++) {
                jTable.getColumnModel().getColumn(j).setHeaderRenderer(hRenderer);
            }
        }
        return jTable;
    }

    public static ArrayList<String> GetPedidoCompra(String pedido, String login) {
        ArrayList camposPedido = new ArrayList();
        ArrayList camposFornecedor = new ArrayList();
        ArrayList campoUser = new ArrayList();
        try {
            connection();
            camposPedido = con.select("PEDIDO_COMPRA", new String[]{"ID_PEDIDO", "ID_FORNECEDOR_FK"}, new String[]{pedido});
            camposFornecedor = con.select("FORNECEDOR", new String[]{"ID_FORNECEDOR", "RAZAO_SOCIAL"}, new String[]{camposPedido.get(1).toString()});
            campoUser = con.select("COLABORADORES", new String[]{"LOGIN", "NOME"}, new String[]{login});
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro as notas fiscais!", "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            disconnection();
        }

        ArrayList<String> camposNF = new ArrayList<>();
        camposNF.add(camposFornecedor.get(1).toString());
        camposNF.add(campoUser.get(1).toString());
        return camposNF;
    }

    public static ArrayList GetNomesByIds(String[] campos) {
        ArrayList ids = new ArrayList();
        ArrayList colab = new ArrayList();
        ArrayList forn = new ArrayList();
        try {
            connection();
            if (!campos[0].equals("Selecione...")) {
                colab = con.select("COLABORADORES", new String[]{"NOME", "ID_USER"}, new String[]{campos[0]});
                ids.add(colab.get(1).toString());
            } else{
                ids.add("");
            }
            if (!campos[1].equals("Selecione...")) {
                forn = con.select("FORNECEDOR", new String[]{"RAZAO_SOCIAL", "ID_FORNECEDOR"}, new String[]{campos[1]});
                ids.add(forn.get(1).toString());
            } else {
                ids.add("");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao filtrar ComboBox!", "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            disconnection();
        }
        System.out.println("OIIIIIIIIIIIIIIIIIIIIIII");
        return ids;
    }

}
