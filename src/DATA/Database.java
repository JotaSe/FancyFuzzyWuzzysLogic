/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Javier Segovia @jota_Segovia
 */
public class Database {
    public static ResultSet getTipos() throws SQLException
            
    {
        return DATA.Conectar.instruccion.executeQuery("Select * from tipo_variable where entrada = true");
    }
    
    public static void setVariables(String nombre , int tipo, Double ini, Double fin ) throws SQLException
    {
         DATA.Conectar.instruccion.execute("insert into variables (nombre,tipo,ini,fin, entrada) values('"+nombre+"'"
                + ", "+tipo+","+ini+","+fin+")");
    }
    public static ResultSet getVariables() throws SQLException
    {
        return DATA.Conectar.instruccion.executeQuery("select variables.nombre, tipo_variable.nombre,tipo_variable.unidad "
                + "from variables,tipo_variable "
                + "where variables.tipo = tipo_variable.id_TipoVariable "
                + "order by tipo_variable.nombre ");
    }
    public static void setTipos(String nombre, String unidad, boolean in)throws SQLException
    {
            DATA.Conectar.instruccion.execute("insert into tipo_variable (Nombre,Unidad, entrada) Values ('"+nombre+"','"+unidad+"',"+in+")");
    }
    public static String getUnidad (String nombre) throws SQLException
    {
        ResultSet rs = DATA.Conectar.instruccion2.executeQuery("select unidad from tipo_variable where nombre = '"+nombre+"'");
        String asd = null;
        while(rs.next())
        {
             asd = rs.getString("unidad");
        }
       
        return asd;
    }
    public static void setCategoria(String nombre) throws SQLException
    {
        DATA.Conectar.instruccion.execute("insert into categoria_salida (nombre) values ('"+nombre+"')");
    }
    public static ResultSet getCategoria() throws SQLException
    {
        return DATA.Conectar.instruccion.executeQuery("Select nombre from tipo_Variable where entrada = false");
    }
    public static ResultSet getSalida() throws  SQLException
    {
        return DATA.Conectar.instruccion.executeQuery("select salida.nombre, categoria_salida.nombre "
                + "from salida,categoria "
                + "where salida.categoria = categoria_salida.idCategoria "
                + "order by categoria_salida.nombre");
                
    }
    
    public static int getCategoria (String nombre) throws SQLException
    {
        ResultSet rs = DATA.Conectar.instruccion2.executeQuery("select idCategoria from categoria_salida where nombre = '"+nombre+"'");
        int asd = 0;
        while(rs.next())
        {
             asd = rs.getInt("idCategoria");
        }
       
        return asd;
    }    
    public static void setSalida(String nombre, int cat) throws SQLException
    {
        DATA.Conectar.instruccion.execute("insert into Salida (nombre,categoria) values ('"+nombre+"', "+cat+")");
    }
    
    
    
}
