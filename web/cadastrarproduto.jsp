
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

        <h3 align="center">${mensagem}</h3>

        <form name="cadastrarproduto" action="CadastrarProduto" method="POST">

            <table border="0" align="center">
                <tr>
                    <th colspan="2">Cadastrar Carros</th>
                </tr>
                <tr>
                    <td>Tipo:</td>
                    <td><select name="idTipoCarro">
                            <c:forEach var="tipocarro" item="${tipocarros}">
                                <option value="${tipocarro.idTipoCarro}">${tipocaro.nomeCarro}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Descrição:</td>
                    <td><input type="text" name="descProduto"></td>
                </tr>
                <tr>
                    <td>Marca:</td>
                    <td><input type="text" name="marcaProduto"></td>
                </tr>
                <tr>
                    <td>Modelo:</td>
                    <td><input type="text" name="modeloProduto"></td>
                </tr>
                <tr>
                    <td>Valor:</td>
                    <td><input type="text" name="valorProduto"</td>
                </tr>
                <tr>
                    <td>Ano Fabricação:</td>
                    <td><input type="text" name="anoCarro"</td>
                </tr>
                <tr>
                    <td>Modelo Fabricação:</td>
                    <td><input type="text" name="modeloCarro"</td>
                </tr>
                <tr>
                    <td>Nº Portas:</td>
                    <td><input type="text" name="nrportasCarro"</td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" 
                                                          name="cadastrar" value="Cadastrar">
                </tr>
            </table>
            <h3 align="center"><a href="index.jsp">Voltar</a></h3>
        </form>
    </body>
</html>
