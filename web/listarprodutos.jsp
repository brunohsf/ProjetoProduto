<%@page import="br.com.projetoproduto.model.Carro"%>
<%@page import="br.com.projetoproduto.model.Produto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle de Produtos</title>
    </head>
    <body>
        <h1 align="center">Controle de Produtos</h1>
        <hr>
        <table align="center" border="1">
            <tr>
                <td colspan="11" align="center">Lista de Carros</td>
            </tr>
            <tr>
                <th align="center">ID Produto</th>
                <th align="center">ID Carro</th>
                <th align="center">Descrição</th>
                <th align="center">Marca</th>
                <th align="center">Modelo</th>
                <th align="center">Valor</th>
                <th align="center">Ano Fabricação</th>
                <th align="center">Modelo Fabricação</th>
                <th align="center">Nº. Portas</th>
                <th align="center" colspan="2">Editar</th>
            </tr>
            
            <%
                List<Carro> carros = (List<Carro>) request.getAttribute("carros");
                for(Carro carro:carros){
            %>
            <tr>
                <td align="center"><%=carro.getIdProduto()%></td>
                <td align="center"><%=carro.getIdCarro()%></td>
                <td align="center"><%=carro.getDescProduto()%></td>
                <td align="center"><%=carro.getMarcaProduto()%></td>
                <td align="center"><%=carro.getModeloProduto()%></td>
                <td align="center"><%=carro.getValorProduto()%></td>
                <td align="center"><%=carro.getAnoCarro()%></td>
                <td align="center"><%=carro.getModeloCarro()%></td>
                <td align="center"><%=carro.getNrportasCarro()%></td>
                <td align="center"><a href="ExcluirProduto?idProduto=<%=carro.getIdProduto()%>">Excluir</a></td>
                <td align="center"><a href="CarregarProduto?idProduto=<%=carro.getIdProduto()%>">Alterar</a></td>
            </tr>
            <%
                }
            %>
            <tr>
                    <td align="center" colspan="11"><a href="index.jsp">Voltar</a></td>
            </tr>
        </table>
    </body>
</html>
