package com.thumbcash.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ING JARC
 */
public class DBHelper {

    public String user = "thumbcash";
    public String pass = "thumbcash";
    Connection conn = null;

    public Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/thumbcash", user, pass);

            if (conn != null) {
                JOptionPane.showMessageDialog(null, "Conección a base de datos listo...");
            } else if (conn == null) {
                throw new SQLException();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Se produjo el siguiente error: " + e.getMessage());
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Se produjo el siguiente error: " + e.getMessage());
        } finally {
            return conn;
        }
    }

    public void desconectar() {
        conn = null;
        System.out.println("Desconexion a base de datos listo...");
    }
}
