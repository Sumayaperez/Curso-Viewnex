<%@include file="head.jsp" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>    

<html>
    <%= head() %>
    
    <body>    
    <%@include file="header.jsp" %>


    <body>
        <h1>Página de Login</h1>
        <form name="form1" method="post" action="./usuarios.do">
            <table border="1">
                <tr><td>Email: </td><td>
                        <input type="email" name="email" size="25" value="valido@hotmail.com" required="required"/> </td></tr>
                <tr><td>Password: </td><td>
                        <input type="password" name="pass" size="25" value="1234" required="required"/> </td></tr>
            </table>
            <input type="hidden" name="accion" value="login">
            <br><input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
