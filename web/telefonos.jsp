<%-- 
    Document   : telefonos
    Created on : 22-feb-2019, 12:25:18
    Author     : franc
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%            
            ResultSet rs;
            
            rs = (ResultSet) request.getAttribute("telefonos");
            
            while(rs.next()){
                out.print(rs.getString(1));
                out.print(rs.getString(2));
                out.print(rs.getString(3));
                out.print(rs.getString(4));
                out.print(rs.getString(5));
                out.print("<br/>");
            }
            
        %>
    </body>
</html>
