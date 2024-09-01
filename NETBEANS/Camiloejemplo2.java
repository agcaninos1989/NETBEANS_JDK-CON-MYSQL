
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package camiloejemplo2;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;




public class Camiloejemplo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String usuario = "root";
        String password = "Camilo1989";
        String url = "jdbc:mysql://localhost:3306/agcaninos?serverTimezone=UTC";
        Connection  conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            conexion = java.sql.DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("select * from agcaninos_proyecto");
            while(rs.next()){
                System.out.println(rs.getString("raza"));
            }
            statement.execute("INSERT INTO agcaninos_proyecto (nombre, apellido, nombre_perro, raza, sexo, edad)\n" +
"VALUES \n" +
"('Emilia', 'Bustos', 'Kiara_biyi', 'Golden Retriever', 'F', 10)");
            rs = statement.executeQuery("select * from agcaninos_proyecto");
            while(rs.next()){
                System.out.println(rs.getString("nombre_perro"));
            }
            statement.execute("UPDATE `agcaninos_proyecto` SET `nombre` = 'Mario', `apellido` = 'Arevalo', `nombre_perro` = 'Tammy', `raza` = 'beagle' WHERE `agcaninos_proyecto`.`id` = 5;");
            rs = statement.executeQuery("select * from agcaninos_proyecto");
            while(rs.next()){
                System.out.println(rs.getString("nombre_perro"));
            }
            statement.execute("DELETE FROM agcaninos_proyecto WHERE `agcaninos_proyecto`.`id` = 22");
            rs = statement.executeQuery("select * from agcaninos_proyecto");
            while(rs.next()){
                System.out.println(rs.getString("nombre_perro"));
            }
        }
            
        catch (SQLException ex){
            Logger.getLogger(Camiloejemplo2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
