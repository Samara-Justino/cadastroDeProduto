/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telacadastroproduto;

/**
 *
 * @author Samara Justino
 */
public class Produto {

    private int id;
    private String descricao;
    private double preco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void cadastrar() throws SQLException {
        Connection con = getConexao();

        PreparedStatement comando = con.prepareStatement("insert into produto (descricao, preco) values(?,?)");
        comando.setString(1, descricao);
        comando.setDouble(2, preco);
        comando.execute();

        con.close();
    }

    public void deletar() throws SQLException {
        Connection con = getConexao();

        PreparedStatement comando = con.prepareStatement("delete from produto where id=?");
        comando.setInt(1, id);
        comando.execute();
        con.close();
    }

    public void atualizar() throws SQLException {
        Connection con = getConexao();

        PreparedStatement comando = con.prepareStatement("update produto set descricao = ? where id = ?");
        comando.setString(1, descricao);
        comando.setDouble(2, preco);
        comando.setInt(1, id);
        comando.execute();

    }

    public Connection getConexao() {
        try {
            //O método forName carrega e inicia o driver passado por parâmetro
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/aula_ioo";
            String USER = "root";
            String PASSWORD = "";
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {//Tratamento de exceções
            System.out.println(ex);
            return null;

        }
    }

}
