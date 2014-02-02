package DATA;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javier Segovia @jota_Segovia
 */

public class Conectar
{

    /**METODO PARA CONECTAR A UNA BASE DE DATOS.
     Argumentos: 1.- Nombre del host.
     2.- Nombre de la base de datos.
     3.- Clave.**/
    public static void db()
    {
        //Cargar clase de controlador de base de datos
        try {
            String url = "db4free.net:3306";
            String db = "fuzzy";
            String pass = "fuzzywuzzy";
            String id = "fuzzy";
            Class.forName("com.mysql.jdbc.Driver");
        //Crear el objeto de conexion a la base de datos
            conexion = DriverManager.getConnection("jdbc:mysql://"+url+"/"+db+"",
                    id,pass);
                    
            conectado = true;
            //Crear objeto Statement para realizar queries a la base de datos
            instruccion  = conexion.createStatement();
            instruccion2 = conexion.createStatement();
            instruccion3 = conexion.createStatement();
            System.out.println("Conectado");
        } catch(ClassNotFoundException e){ System.out.println(e); }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
    }

    /**METODO PARA COMPROBAR LA EXISTENCIA DE UNA BASE DE DATOS.
     Argumentos: 1.- Nombre de la base de datos a comprobar.
     Devuelve: true, si existe, caso contrario retorna false.**/
    public static boolean db_existe(String nombre_base_de_datos)
    {
        boolean existe = false;
        {
            try {
                //comprobar existencia de db
                ResultSet table = instruccion.executeQuery("SHOW DATABASES");
                while(table.next())
                {
                    String nombre_db = table.getString(1);
                    if (nombre_db.equals(nombre_base_de_datos))
                        existe = true;
                }
            } catch (SQLException ex) {System.out.println("sql error");}
        }
        return existe;
    }
    


    /**Conectar a mySQL**/
    public static void mySQL(String clave)
    {
        
    }

    public static boolean conectado = false;
    public static Connection conexion;
    public static Statement instruccion;
    public static Statement instruccion2;
    public static Statement instruccion3;
    public static ResultSet tabla;

}