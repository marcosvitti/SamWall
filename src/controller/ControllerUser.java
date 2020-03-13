package controller;

import static controller.ControllerMain.connection;
import static controller.ControllerMain.disconnection;
import dataBase.DataBase;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.StringTokenizer;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import screens.BlockUser;

public class ControllerUser {

    private static final DataBase con = DataBase.getInstance(); // Instanciação da variável interações com o banco de dados

    public static synchronized void connection(){
        con.connection();
    }

    public static synchronized void disconnection(){
        con.disconnection();
    }

    public static synchronized JTable listarUsers(JTable jTable, String[] filters, BlockUser user) { // Método para listar os colaboradores do sistema
        ArrayList resp = new ArrayList();
        int i = 0;
        ((DefaultTableModel) jTable.getModel()).setRowCount(0);
        for (String f : filters) {
            if(f.equals("") || f.equals("Selecione...")){
                System.out.println(f);
                filters[i] = "LIKE %";
            }
            if(f.equals("Usuário")){
                filters[i] = "U";
            } else if(f.equals("Administrador")){
                filters[i] = "A";
            }
            if(f.equals("Ativo")){
                filters[i] = "1";
            } else if(f.equals("Inativo")){
                filters[i] = "2";
            }
            i++;
        }
        try { // Tentar realizar a listagem dos colaboradores
            connection();
            //jTable = con.listaUsers("SELECT * FROM colaboradores", jTable);
            resp = con.select("COLABORADORES", new String[] {"ID_USER", "LOGIN", "NOME", "SOBRENOME", "CARGO", "DATA_CADASTRO", "TIPO", "STATUS"}, filters); // Retorna o resposta da função, o nome completo do usuário
            System.out.println(resp);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar usuários!" + e, "ERRO", JOptionPane.ERROR_MESSAGE);
            user.dispose();
        } finally {
            disconnection();
        }

        for(i=0; i<resp.size(); i+=8) {
            int id = Integer.parseInt(resp.get(i).toString());
            String login = resp.get(i+1).toString();
            String nome = resp.get(i+2).toString();
            String sobrenome = resp.get(i+3).toString();
            String cargo = resp.get(i+4).toString();
            String data = resp.get(i+5).toString();
            String t = resp.get(i+6).toString();
            int s = Integer.parseInt(resp.get(i+7).toString());

            JComboBox status = new JComboBox();

            status.addActionListener((ActionEvent e) -> {
                if(status.hasFocus()){
                    jTable.setRowSelectionInterval(jTable.getSelectedRow(), jTable.getSelectedRow());
                }
            });

            if (s == 1) {
                status.addItem("Ativo");
                status.addItem("Inativo");
                status.setSelectedItem("Ativo");
            } else {
                status.addItem("Inativo");
                status.addItem("Ativo");
                status.setSelectedItem("Inativo");
            }
            String tipo = null;
            if (t.equals("A")) {
                tipo = "Administrador";
            } else {
                tipo = "Usuário";
            }

            DefaultTableCellRenderer hRenderer = new DefaultTableCellRenderer();
            hRenderer.setBackground(new Color(84, 127, 206));
            hRenderer.setForeground(new Color(255, 255, 255));

            String linha[] = {String.valueOf(id), login, nome, sobrenome, cargo, data, status.getSelectedItem().toString(), tipo};
            ((DefaultTableModel) jTable.getModel()).addRow(linha);

            TableColumn comboBoxStatus = jTable.getColumnModel().getColumn(6);
            comboBoxStatus.setCellEditor(new DefaultCellEditor(status));
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            comboBoxStatus.setCellRenderer(renderer);

            for (int j = 0; j < jTable.getModel().getColumnCount(); j++) {
                jTable.getColumnModel().getColumn(j).setHeaderRenderer(hRenderer);
            }
        }
        return jTable;
    }

    public static synchronized void update(JTable jTable, ArrayList<Integer> update){
        ArrayList resp = new ArrayList();
        try {
            connection();
            for (Integer row : update) {
                int status = "Inativo".equals(jTable.getValueAt(row, 6).toString()) ? 0 : 1;
                //con.alterUser("UPDATE colaboradores SET STATUS=" + status + " WHERE ID_USER=" + jTable.getValueAt(row, 0));
                resp = con.update("COLABORADORES", new String[] {"STATUS"}, new String[] {Integer.toString(status)}, new String[] {"ID_USER"}, new String[] {jTable.getValueAt(row, 0).toString()});
            }
            JOptionPane.showMessageDialog(null, "Usuário(s) alterado(s) com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE); // Mostra a mensagem de sucesso
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao efetuar a atualização => " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            disconnection();
        }
    }

    public static synchronized String buscaLogin(String username) { // Método para buscar o nome do colaborador pelo seu username 
        ArrayList nome = new ArrayList();
        try { // Tentar realizar a busca pelo usuário
            connection();
            //return con.selectUserNameCommandSQL(username); // Retorna o resposta da função, o nome completo do usuário
            nome = con.select("COLABORADORES", new String[] {"NOME","LOGIN"}, new String[] {username.split(" ")[0]}); // Retorna o resposta da função, o nome completo do usuário
        } catch (SQLException ex) { // Caso a busca do usuário falhe é lançado uma exception
            JOptionPane.showMessageDialog(null, "Usuário não encontrado", "ERROR", JOptionPane.ERROR_MESSAGE); // Mostra um aviso para o usuário
        } finally {
            disconnection();
        }
        return nome.get(0).toString();
    } // Fim do método para buscar o nome do colaborador

    public static synchronized String formatCPF(String cpf) {
        StringTokenizer tok = new StringTokenizer(cpf, ".");
        String frs = tok.nextToken();
        String sec = tok.nextToken();
        String thr = tok.nextToken();

        StringTokenizer tok2 = new StringTokenizer(thr, "-");
        String prim2 = tok2.nextToken();
        String last = tok2.nextToken();
        String iscpf = frs + sec + prim2 + last;
        return iscpf;
    }

    public static synchronized boolean isCPF(String CPF) {
        if (CPF.equals("00000000000")
                || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48);
            }
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    public static void main(String username, String action) {
        BlockUser user = new BlockUser(username, action); // Instância o novo frame
        user.setLocationRelativeTo(null); // Defini a localização no meio da tela
        user.setVisible(true); // Defini o frame como visivel
    }
}
