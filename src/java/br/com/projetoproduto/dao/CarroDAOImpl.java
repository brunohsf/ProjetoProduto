package br.com.projetoproduto.dao;

import br.com.projetoproduto.model.Carro;
import br.com.projetoproduto.model.Produto;
import br.com.projetoproduto.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDAOImpl implements GenericDAO {

    private Connection conn;

    public CarroDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {

        Carro carro = (Carro) object;
        PreparedStatement stmt = null;

        String sql = "insert into carro(anocarro, modelocarro, nrportascarro, idproduto) "
                + "values (?, ?, ?, ?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, carro.getAnoCarro());
            stmt.setInt(2, carro.getModeloCarro());
            stmt.setInt(3, carro.getNrportasCarro());
            stmt.setInt(4, new ProdutoDAOImpl().cadastrar(carro));
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar carro! Erro: "
                    + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar a conexão! Erro: "
                        + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Object> listar() {

        List<Object> produtos = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select p.*, c.* from produto p, carro c "
                + "where p.idproduto = c.idproduto;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("idproduto"));
                produto.setDescProduto(rs.getString("descproduto"));
                produto.setMarcaProduto(rs.getString("marcaproduto"));
                produto.setModeloProduto(rs.getString("modeloproduto"));
                produto.setValorProduto(rs.getDouble("valorproduto"));
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar produtos! Erro:" + ex.getMessage());
            ex.printStackTrace();

        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro" + e.getMessage());
                e.printStackTrace();
            }
        }
        return produtos;
    }

    @Override
     public Boolean excluir(int idOject) {
        PreparedStatement stmt = null;
        String sql = "delete from produto where idproduto = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idOject);
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir o produto! Erro" 
                    + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @Override
    public Object carregar(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Produto produto = null;
        
        String sql = "select * from produto where idproduto = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                produto = new Produto();
                produto.setIdProduto(rs.getInt("idproduto"));
                produto.setDescProduto(rs.getString("descproduto"));
                produto.setMarcaProduto(rs.getString("marcaproduto"));
                produto.setModeloProduto(rs.getString("modeloproduto"));
                produto.setValorProduto(rs.getDouble("valorproduto"));
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar produto! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return produto;
    }

    @Override
    public Boolean alterar(Object object) {
        Produto produto = (Produto) object;
        PreparedStatement stmt = null;
        String sql = "update produto set descproduto = ?, marcaproduto = ?, modeloproduto = ?, valorproduto = ? where idproduto = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getDescProduto());
            stmt.setString(2, produto.getMarcaProduto());
            stmt.setString(3, produto.getModeloProduto());
            stmt.setDouble(4, produto.getValorProduto());
            stmt.setInt(5, produto.getIdProduto());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao alterar automóvel! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro: "
                        + e.getMessage());
                e.printStackTrace();
            }
        }
    }

}
