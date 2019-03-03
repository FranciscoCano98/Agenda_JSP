<%-- 
    Document   : newjspindex
    Created on : 20-feb-2019, 13:40:01
    Author     : franc
--%>

<%@page import="java.util.Iterator"%>
<%@page import="clases.Usuario"%>
<%@page import="clases.UsuarioDB"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
            <%
                ArrayList<Usuario> usuarios;
                usuarios = UsuarioDB.leerUsuarios();
                request.setAttribute("usuarios", usuarios);               
            %>
        
        <jsp:include page="vistas/vistaUsuarios.jsp"></jsp:include>
        
        <form action="agendajsp">
            <input type="submit" name="accion" value="Entrar"/>
        </form>
    

