
<%@include file="head.jsp" %>
<html>
    <%= head() %>
    
    <body>    
    <%@include file="header.jsp" %>

    <body>
        <h2>Registro</h2>
        <form name="form1" method="post" action="./usuarios.do">
            <table border="1">
                <tr><td>Nombre: </td><td>
                        <input type="text" name="nom" id="nom" size="25" value="Sumayamvc" required="required"/> </td></tr>
                <tr><td>Edad: </td><td>
                        <input type="number" name="edad" size="25" value="40" required="required"/> </td></tr>
                <tr><td>Email: </td><td>
                        <input type="email" name="email" size="25" value="emailmvc@valido.com" required="required"/> </td></tr>
                <tr><td>Password: </td><td>
                        <input type="password" name="pass" size="25" value="1q2w3e" required="required"/> </td></tr>
            </table>
           
            <br><input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
