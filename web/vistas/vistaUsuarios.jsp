<%-- 
    Document   : vistaUsuarios
    Created on : 21-feb-2019, 11:01:55
    Author     : franc
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="clases.Usuario"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table>
    <%
        Usuario usuario;
        ArrayList<Usuario> usuarios;
        usuarios = (ArrayList<Usuario>) request.getAttribute("usuarios");
        Iterator iterador;
        iterador = usuarios.iterator();

        while (iterador.hasNext()) {
            usuario = (Usuario) iterador.next();
    %>
    <form action="agendajsp">
        <tr>
            <td><%=usuario.getNombre()%></td>
            <td><%=usuario.getApellidos()%></td>
            <td><%=usuario.getLogin()%></td>
            <td><%=usuario.getClave()%></td>   
            <td><%=usuario.isActivo()%></td>
            <td><input type="submit" name="accion" value="Ver"/></td>
            <td><input type="submit" name="accion" value="Borrar"></td>
            <td><input type="submit" name="accion" value="Editar"></td>
        <input type="hidden" name="usuario" value="<%=usuario.getLogin()%>"/>
        </tr>
    </form>
    <%}
    %>
</table>
<form action="agendajsp">
    <input type="submit" name="accion" value="Nuevo"/>
</form>