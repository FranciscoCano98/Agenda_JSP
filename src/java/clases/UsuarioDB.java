package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioDB {

    public static Connection conexion;
    private static PreparedStatement consultaLogin;

    public static void conectar(Connection conexion) throws SQLException {
        UsuarioDB.conexion = conexion;
        consultaLogin = UsuarioDB.conexion.prepareStatement("select * from"
                + "usuarios where login=?", ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
    }

    public static ArrayList<Usuario> leerUsuarios() throws SQLException {
        
        Usuario usuario;
        Statement sentencia;
        ResultSet rs;
        ArrayList<Usuario> usuarios = new ArrayList<>();

        sentencia = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY);

        String consulta = "select * from usuarios";
        rs = sentencia.executeQuery(consulta);

        while (rs.next()) {
            usuario = rowToUser(rs);
            usuarios.add(usuario);
        }
        sentencia.close();
        rs.close();
        return usuarios;
    }

    public static Usuario rowToUser(ResultSet rs) throws SQLException {
        String nombre, apellidos, login, clave;
        Boolean activo;

        nombre = rs.getString("nombre");
        apellidos = rs.getString("apellidos");
        login = rs.getString("clave");
        clave = rs.getString("clave");
        activo = rs.getBoolean("activo");

        Usuario usuario = new Usuario(nombre, apellidos, login, clave);
        usuario.setActivo(activo);

        return usuario;
    }

    public static Usuario getUsuario(String claveP) throws SQLException {

        String nombre, apellidos, login, clave;
        Boolean activo;
        Usuario usuario;
        //conjunto de resultados
        ResultSet rs;

        /*el 1 es por la interrogacion de la consultaLogin*/
        consultaLogin.setString(1, claveP);
        rs = consultaLogin.executeQuery();
        rs.next();//siempre hay que hacerlo
        usuario = rowToUser(rs);

        return usuario;
    }

}
