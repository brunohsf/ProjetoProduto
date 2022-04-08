package br.com.projetoproduto.dao;

import br.com.projetoproduto.model.Produto;
import br.com.projetoproduto.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProdutoDAOImpl implements GenericDAO{
    
    private Connection conn;

    public ProdutoDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public Integer cadastrar(Produto produto) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer idProduto = null;

        String sql = "insert into produto(descproduto, marcaproduto, "
                + "modeloproduto, valorproduto) "
                + "values (?, ?, ?, ?) returning idproduto;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getDescProduto());
            stmt.setString(2, produto.getMarcaProduto());
            stmt.setString(3, produto.getModeloProduto());
            stmt.setDouble(4, produto.getValorProduto());
            rs = stmt.executeQuery();
            if (rs.next()) {
                idProduto = rs.getInt("idproduto");
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar Produto! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return idProduto;
    }

    @Override
    public List<Object> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean excluir(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object carregar(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean alterar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean cadastrar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
