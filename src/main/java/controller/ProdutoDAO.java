package controller;

import model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProdutoDAO {
    private static Connection conn;

    public ProdutoDAO() throws SQLException {
        this.conn = ConexaoSQLite.getConexao();
    }

    public static ArrayList<Produto> listar() throws SQLException {
        ArrayList<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produto;";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Produto produto = new Produto();

            produto.setId(resultSet.getInt("id"));
            produto.setNome(resultSet.getString("nome"));
            produto.setDescricao(resultSet.getString("descricao"));
            produto.setPreco(resultSet.getDouble("preco"));
            produto.setQuantidade(resultSet.getDouble("quantidade"));
            produto.setId_fornecedor(resultSet.getInt("id_fornecedor"));
            produto.setId_categoria(resultSet.getInt("id_categoria"));
            produto.setMarca(resultSet.getString("marca"));

            LocalDate data = LocalDate.parse(resultSet.getString("data_validade"));
            produto.setData_validade(data);
            produto.setLote(resultSet.getString("lote"));

            produtos.add(produto);
        }
        return produtos;
    }

    public static Produto bucarUm(Integer id) throws SQLException {
        String sql = "SELECT * FROM produto WHERE id = ?;";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        Produto produto= new Produto() ;

        while (resultSet.next()) {
            produto.setId(resultSet.getInt("id"));
            produto.setNome(resultSet.getString("nome"));
        }
        return produto;
    }

    public static void atualizar(Produto produto) throws SQLException {
        String sql = "UPDATE produto SET nome = ? WHERE id = ?;";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setInt(1,  produto.getId());
        preparedStatement.setString(2,  produto.getNome());



        preparedStatement.executeUpdate();
    }

    public static void remover(Integer id) throws SQLException {
        String sql = "DELETE FROM Produto WHERE id = ?;";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    public static void incluir(Produto produto) throws SQLException {
        String sql = "INSERT INTO Produto VALUES(null, ?);";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(2, produto.getNome());
        preparedStatement.executeUpdate();
    }


}

