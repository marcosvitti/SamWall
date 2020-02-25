package dataBase;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class DataBase {

    private static DataBase INSTANCIA;
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    private final String driver = "com.mysql.jdbc.Driver";
    private final String caminho = "jdbc:mysql://127.0.0.1:3306/projeto_nf";
    private final String usuario = "root";
    private final String senha = "root";
    
    public static synchronized DataBase getInstance(){
        if (INSTANCIA == null){
            INSTANCIA = new DataBase();
        }
        return INSTANCIA;
    }

    public void connection() {
        try {
            System.setProperty("jdbc.Drivers", driver);
            con = DriverManager.getConnection(caminho, usuario, senha);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Connection unsuccessfully completed : \n "
                    + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public void disconnection() {
        try {
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Disconnection unsuccessfully completed :\n"
                    + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public String queryBuilder(String table, String[] wheres){
        String query = "";
        int controller = 0;
        for (String where : wheres) {
            if (!where.equals("")) {
                if (controller > 0) {
                    query += " and " + where;
                } else {
                    controller++;
                    query += where;
                }
            }
        }
        query = controller == 0 ? "" : " WHERE " + query;
        return "SELECT * FROM " + table + query;
    }

    public void selectLoginCommandSQL(String username, String password) throws SQLException {
        try {
            String command = "SELECT * FROM colaboradores WHERE LOGIN='" + username + "' AND SENHA=SHA1('" + password + "')";
            stm = con.createStatement();
            System.out.println(command);
            rs = stm.executeQuery(command);
            if (rs.next()) {
                rs.getString("LOGIN");
                rs.getString("SENHA");
            } else {
                throw new SQLException();
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }
    }

    public String selectUserNameCommandSQL(String username) throws SQLException {
        String command = "SELECT * FROM colaboradores WHERE LOGIN='" + username + "'";
        try {
            stm = con.createStatement();
            System.out.println(command);
            rs = stm.executeQuery(command);
            if (rs.next()) {
                return rs.getString("NOME") + " " + rs.getString("SOBRENOME");
            } else {
                throw new SQLException();
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }
    }

    public void selectNFCommandSQL(String command) throws SQLException {
        try {
            stm = con.createStatement();
            System.out.println(command);
            PreparedStatement ps = con.prepareStatement(command);
            rs = stm.executeQuery(command);
            if (rs.next()) {
                rs.getString("NUM_NF");
            } else {
                throw new SQLException();
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }
    }

    public javax.swing.JComboBox<String> selectFornecedor(String command, javax.swing.JComboBox<String> jCombobox1) throws SQLException {
        try {
            stm = con.createStatement();
            System.out.println(command);
            rs = stm.executeQuery(command);
            jCombobox1.addItem("Selecione...");
            while (rs.next()) {
                jCombobox1.addItem(rs.getString("RAZAO_SOCIAL"));
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }
        return jCombobox1;
    }

    public String buscaLogin(String username) throws SQLException {
        StringTokenizer tok = new StringTokenizer(username, " ");
        String fname = tok.nextToken();
        String lname = tok.nextToken();
        String command = "SELECT LOGIN FROM colaboradores WHERE NOME='" + fname + "' AND SOBRENOME='" + lname + "'";
        String userName = "";
        try {
            stm = con.createStatement();
            System.out.println(command);
            rs = stm.executeQuery(command);
            if (rs.next()) {
                userName = rs.getString("LOGIN");
            } else {
                throw new SQLException();
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }
        return userName;
    }

    public int obterFornecedor(String command) throws SQLException {
        int fornece;
        try {
            stm = con.createStatement();
            System.out.println(command);
            rs = stm.executeQuery(command);
            if (rs.next()) {
                fornece = rs.getInt("ID_FORNECEDOR");
            } else {
                throw new SQLException();
            }
        } catch (SQLException ex) {
            throw new SQLException("1");
        }
        return fornece;
    }

    public int obterColab(String command) throws SQLException {
        int colab;
        try {
            stm = con.createStatement();
            System.out.println(command);
            rs = stm.executeQuery(command);
            if (rs.next()) {
                colab = rs.getInt("ID_USER");
            } else {
                throw new SQLException();
            }
        } catch (SQLException ex) {
            throw new SQLException("2");
        }
        return colab;
    }

    public String buscaTipoUser(String username) throws SQLException {
        String command = "SELECT TIPO FROM colaboradores WHERE LOGIN='" + username + "'";
        try {
            stm = con.createStatement();
            System.out.println(command);
            rs = stm.executeQuery(command);
            if (rs.next()) {
                return rs.getString("TIPO");
            } else {
                throw new SQLException();
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }
    }

    public ArrayList pesquisa(String command) throws SQLException {
        ArrayList dados = new ArrayList<>();
        try {
            stm = con.createStatement();
            System.out.println(command);
            rs = stm.executeQuery(command);
            if (rs.next()) {
                dados.add(rs.getString("FORNECEDOR"));
                dados.add(rs.getString("CNPJ/CPF"));
                dados.add(rs.getString("DATA_ENTRADA"));
                dados.add(rs.getString("PRODUTO"));
                dados.add(rs.getString("QUANTIDADE"));
                dados.add(rs.getString("PRECO"));
                dados.add(rs.getString("DESCRIÇÃO"));
            } else {
                throw new SQLException();
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }
        return dados;
    }

    public String buscaImagem(String command) throws SQLException {
        String path = "";

        return path;
    }

    public JTable listaTabelaRegisterNF(String command, javax.swing.JTable jTable1) throws SQLException {
        try {
            stm = con.createStatement();
            System.out.println(command);
            rs = stm.executeQuery(command);
            while (rs.next()) {
                int id = rs.getInt("ID_PROD_NF");
                String nome = rs.getString("DESCRICAO_PROD");
                int qtde = rs.getInt("QTD_PROD");
                double preco = rs.getDouble("VALOR_UNIT");
                String linha[] = {String.valueOf(id), nome, String.valueOf(preco), String.valueOf(qtde)};
                ((DefaultTableModel) jTable1.getModel()).addRow(linha);
            }
        } catch (SQLException ex) {
            throw new SQLException("1");
        }
        return jTable1;
    }

    public JTable listaNF(String command, javax.swing.JTable jTable1) throws SQLException {
        try {
            stm = con.createStatement();
            System.out.println(command);
            rs = stm.executeQuery(command);
            while (rs.next()) {
                int id = rs.getInt("ID_NF_A");
                String num_nf = rs.getString("NUM_NF");
                String dat = rs.getString("DATA_ENTRADA");
                double valor = rs.getDouble("VALOR");
                String status = rs.getString("STATUS");
                String linha[] = {String.valueOf(id), num_nf, dat, String.valueOf(valor), status};
                ((DefaultTableModel) jTable1.getModel()).addRow(linha);
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }
        return jTable1;
    }

    public JTable listaUsers(String command, javax.swing.JTable jTable1) throws SQLException {
        ((DefaultTableModel) jTable1.getModel()).setRowCount(0); // Defini a tabela com quantidades de linhas igual a zero
        try {
            stm = con.createStatement();
            System.out.println(command);
            rs = stm.executeQuery(command);
            while (rs.next()) {
                int id = rs.getInt("ID_USER");
                String login = rs.getString("LOGIN");
                String nome = rs.getString("NOME");
                String sobrenome = rs.getString("SOBRENOME");
                String cargo = rs.getString("CARGO");
                String telefone = rs.getString("TELEFONE");
                String celular = rs.getString("CELULAR");
                String cpf = rs.getString("CPF");
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                String data = formatter.format(rs.getDate("DATA_CADASTRO"));
                System.out.println("DATA : " + data);
                int s = rs.getInt("STATUS");
                String t = rs.getString("TIPO");
                JComboBox status = new JComboBox();
                status.addActionListener((ActionEvent e) -> {
                    if(status.hasFocus()){
                        jTable1.setRowSelectionInterval(jTable1.getSelectedRow(), jTable1.getSelectedRow());
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
                
                String linha[] = {String.valueOf(id), login, nome, sobrenome, cargo, telefone, celular, cpf, data, status.getSelectedItem().toString(), tipo};
                ((DefaultTableModel) jTable1.getModel()).addRow(linha);
                
                TableColumn comboBoxStatus = jTable1.getColumnModel().getColumn(9);
                comboBoxStatus.setCellEditor(new DefaultCellEditor(status));
                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                comboBoxStatus.setCellRenderer(renderer);
                
                for (int i = 0; i < jTable1.getModel().getColumnCount(); i++) {
                    jTable1.getColumnModel().getColumn(i).setHeaderRenderer(hRenderer);
                }
            }
        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        }
        return jTable1;
    }

    public int acharIdNF(String command) throws SQLException {
        int id = -1;
        try {
            stm = con.createStatement();
            System.out.println(command);
            rs = stm.executeQuery(command);
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            throw new SQLException("1");
        }
        return id;
    }

    public int verifUser(String command) throws SQLException {
        try {
            stm = con.createStatement();
            System.out.println(command);
            rs = stm.executeQuery(command);
            if (rs.next()) {
                rs.getString("LOGIN");
            } else {
                return rs.getRow();
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }
        return rs.getRow();
    }
    
    public ArrayList<String> selectUser(String command) throws SQLException {
        try {
            stm = con.createStatement();
            System.out.println(command);
            rs = stm.executeQuery(command);
            if (rs.next()) {
                ArrayList<String> campos = new ArrayList<>();
                    campos.add(rs.getString("ID_USER"));
                    campos.add(rs.getString("LOGIN"));
                    campos.add(rs.getString("NOME"));
                    campos.add(rs.getString("SOBRENOME"));
                    campos.add(rs.getString("CARGO"));
                    campos.add(rs.getString("TELEFONE"));
                    campos.add(rs.getString("CELULAR"));
                    campos.add(rs.getString("CPF"));
                    campos.add(rs.getString("STATUS"));
                    campos.add(rs.getString("TIPO"));
                    campos.add(rs.getString("EMAIL"));
                return campos;
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }
        return null;
    }

/*******************************************************************************/
/*******************************REMOVER METODOS/********************************/
/*******************************************************************************/
    public void inserirProduto(String command) throws SQLException {
        try {
            stm = con.createStatement();
            System.out.println(command);
            stm.execute(command);
        } catch (SQLException ex) {
            throw new SQLException();
        }
    }
    public void inserirUser(String command) throws SQLException {
        try {
            stm = con.createStatement();
            System.out.println(command);
            stm.execute(command);
        } catch (SQLException ex) {
            throw new SQLException();
        }
    }
    public void alterProduto(String command) throws SQLException {
        try {
            stm = con.createStatement();
            System.out.println(command);
            stm.execute(command);
        } catch (SQLException ex) {
            throw new SQLException();
        }
    }
    public void alterUser(String command) throws SQLException {
        try {
            stm = con.createStatement();
            System.out.println(command);
            stm.execute(command);
        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        }
    }
    public void delProduto(String command) throws SQLException {
        try {
            stm = con.createStatement();
            System.out.println(command);
            stm.execute(command);
        } catch (SQLException ex) {
            throw new SQLException();
        }
    }
    public void updateNota(String command) throws SQLException {
        try {
            stm = con.createStatement();
            System.out.println(command);
            stm.execute(command);
        } catch (SQLException ex) {
            throw new SQLException();
        }
    }
    public void insereNF(String command) throws SQLException {
        try {
            stm = con.createStatement();
            System.out.println(command);
            stm.execute(command);
        } catch (SQLException ex) {
            throw new SQLException("3");
        }
    }
/*******************************************************************************/
    
    public void inserirDados(String command) throws SQLException {
        try {
            stm = con.createStatement();
            System.out.println(command);
            stm.execute(command);
        } catch (SQLException ex) {
            throw new SQLException();
        }
    }

    public ArrayList inicializacao(String command) throws SQLException {
        ArrayList campos = new ArrayList<>();
        try {
            stm = con.createStatement();
            System.out.println(command);
            rs = stm.executeQuery(command);
            if (rs.next()) {
                campos.add(rs.getString("RAZAO_SOCIAL"));
                campos.add(rs.getString("VALOR_NF"));
                campos.add(rs.getString("QTD_PARCELA"));
                campos.add(rs.getString("DATA_ENTRADA"));
                campos.add(rs.getString("STATUS_NF"));
                campos.add(rs.getString("OBSERVACOES"));
            } else {
                throw new SQLException();
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }
        return campos;
    }
}
