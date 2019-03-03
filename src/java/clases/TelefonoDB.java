package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TelefonoDB {
    
    //subirlo a superclase conexion
    private static Connection conexion;
    private static PreparedStatement telefonos;
    
    public static void Conectar(Connection conexion) throws SQLException{
        TelefonoDB.conexion = conexion;
        String consulta = "select * from telefonos where usuario=?";
        
        telefonos= conexion.prepareStatement(consulta, 
                                             ResultSet.TYPE_SCROLL_INSENSITIVE,
                                             ResultSet.CONCUR_UPDATABLE);
    }
    
    public static ResultSet getTelefonos(String claveE) throws SQLException{
        
        ResultSet rs;
        
        telefonos.setString(1, claveE);
        rs = telefonos.executeQuery();
        
        return rs;
    }
}
