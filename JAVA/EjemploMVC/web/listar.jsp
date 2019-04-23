
<%@include file="head.jsp" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ArrayList<Usuario> listaUsu = ServicioUsuarios.getInstanciia().listar(); %>    


<html>
    <%= head() %>
    
    <body>    
    <%@include file="header.jsp" %>

        <table>
            <thead>
                <th>Nombre</th>
                <th>Email</th>
            </thead>
            <tbody>
                <%   for (Usuario usu : listaUsu) {                %>
                        <tr>
                        <td> <% out.println(usu.getNombre()); %> </td>
                        <td> <%= usu.getEmail() %> </td>    
                        </tr>
                <% 
                        }
                %>
            </tbody>
            
        </table>
        
    </body>
</html>
