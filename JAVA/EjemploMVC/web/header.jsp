<%@page import="com.modelo.Usuario"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
    <h1>Pagina principal</h1>
    
</header>
<nav>
 <a href="index.jsp">Inicio</a> |
    
    <c:catch var="excepcion">
        <%--   
 <% Usuario usuario = (Usuario) session.getAttribute("usuario"); %>
    --%>
    
    <jsp:useBean id="usuario" type="com.modelo.Usuario" scope="session">
        <jsp:getProperty property="*" name="usuario"/>
       <jsp:getProperty property="id" name="usuario"/>
       <jsp:getProperty property="email" name="usuario"/>
    </jsp:useBean>
           <a href="listar.jsp">Lista de Usuarios con JSP</a>
           
</c:catch>
<c:if test="${not empty excepcion}">
     <a href="registro.jsp">Registro</a> |
     <a href="login.jsp">Login</a> |
      <br>   
</c:if>
</nav>
