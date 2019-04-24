
<%@include file="head.jsp" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ArrayList<Usuario> listaUsu = ServicioUsuarios.getInstanciia().listar();%>    

<html>
    <%= head()%>

    <body>    
        <%@include file="header.jsp" %>
        
        
            <%   for (Usuario usu : listaUsu) {     %>
                <form action="usuarios.do" method="post" name="form_<%= usu.getId() %>">
                    <input id="id" name="id" type="text" size="4" readonly="true" value="<%= usu.getId() %>" />
                    
                    <input id="id" name="nombre" type="text" size="20" value="<%= usu.getNombre() %>" />
                    <input id="edad" name="edad" type="number" size="4"  value="<%= usu.getEdad() %>" />
                    <input id="email" name="email" type="text" size="20"  value="<%= usu.getEmail() %>" />
                    <input id="password" name="password" type="text" size="10"  value="<%= usu.getPassword() %>" />
                    
                    <input class="metodo" id="accion" name="accion" readonly="true" value="***"/>
                    <input type="submit" value="EDIT" onclick="Array.from(document.getElementsByClassName('metodo')).forEach((thisInput)=> { thisInput.value='PUT';})"/>               
                </form>
            <%
                }
            %>
        

</html>
