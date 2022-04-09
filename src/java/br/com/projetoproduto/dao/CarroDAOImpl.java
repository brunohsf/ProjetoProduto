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
        String sql = "select * from produto as p inner join carro as c on p.idproduto = c.idproduto";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Carro produto = new Carro();
                produto.setIdProduto(rs.getInt("idproduto"));
                produto.setDescProduto(rs.getString("descproduto"));
                produto.setIdCarro(rs.getInt("idcarro"));
                produto.setMarcaProduto(rs.getString("marcaproduto"));
                produto.setModeloProduto(rs.getString("modeloproduto"));
                produto.setValorProduto(rs.getDouble("valorproduto"));
                produto.setAnoCarro(rs.getInt("anocarro"));
                produto.setModeloCarro(rs.getInt("anocarro"));
                produto.setNrportasCarro(rs.getInt("nrportascarro"));
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
     public Boolean excluir(int idObject) {
        PreparedStatement stmt = null;
        String sql = "delete from carro where idproduto = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
            new ProdutoDAOImpl().excluir(idObject);
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
        Carro produto = null;
        
        String sql = "select * from produto as p inner join carro as c on p.idproduto = c.idproduto where p.idproduto = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                produto = new Carro();
                produto.setIdProduto(rs.getInt("idproduto"));
                produto.setDescProduto(rs.getString("descproduto"));
                produto.setMarcaProduto(rs.getString("marcaproduto"));
                produto.setModeloProduto(rs.getString("modeloproduto"));
                produto.setValorProduto(rs.getDouble("valorproduto"));
                produto.setAnoCarro(rs.getInt("anocarro"));
                produto.setModeloCarro(rs.getInt("anocarro"));
                produto.setNrportasCarro(rs.getInt("nrportascarro"));
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
        Carro carro = (Carro) object;
        PreparedStatement stmt = null;
        String sql = "update carro set anocarro = ?, modelocarro = ?, nrportascarro = ? where idproduto = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, carro.getAnoCarro());
            stmt.setInt(2, carro.getModeloCarro());
            stmt.setInt(3, carro.getNrportasCarro());   
            stmt.setInt(4, carro.getIdProduto());
            if(!new ProdutoDAOImpl().alterar(object))
                return false;
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
