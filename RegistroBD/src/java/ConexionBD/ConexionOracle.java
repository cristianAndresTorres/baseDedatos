/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author 57301
 */
public class ConexionOracle {
    //Atributos
    protected Connection miConexion;
    protected PreparedStatement consultaRegristro;
    protected ResultSet r;
            
    protected boolean estado;
    protected Connection conexionBD = null;
	
    public ConexionOracle() {}
    
    //Realiza conexion a la BD de oracle
    public Connection realizarConexionBD() {
            String url = "jdbc:oracle:thin:@localhost:1521:orcl";
            String usuario = "criss";
            String contrasegna = "123";

            try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    conexionBD = DriverManager.getConnection(url, usuario, contrasegna);
                    System.out.println("ConexionExitosa");
            } catch (Exception e) {
                    System.out.println("ConexionOracle - ERROR");
            }

            return conexionBD;
    }
    
}
