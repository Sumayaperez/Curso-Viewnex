/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import com.modelo.Usuario;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Default
 */
public class DerbyDBUsuario {

    private DerbyDBUsuario bdUsu;
    private ArrayList<DerbyDBUsuario> listaDBUsuarios;

    public DerbyDBUsuario() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        } catch (Exception ex) {
            Logger.getLogger(DerbyDBUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario obtenerUno(String email){
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/UsuariosVNext", "administrador", "1234")) {
            String consultaSQL = "SELECT id, nombre, edad, email, password FROM Usuario WHERE email= '" + email +"'";
            Statement sentencia = con.createStatement();
            //sentencia.setString(1, email);
            ResultSet res = sentencia.executeQuery(consultaSQL);
            Usuario usu =null;
            if (res.next()){
                Integer id = res.getInt("id");
                String nom = res.getString("nombre");
                Integer edad = res.getInt("edad");
                String password = res.getString("password");
                
                usu = new Usuario(id, nom, edad, email, password);
                
             
            }
            return usu;
            
        } catch (SQLException ex) {
            System.err.println(" >>> " + ex.getMessage());
            return null;
        }
        
    }
    
    public ArrayList<Usuario> listar() {
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/UsuariosVNext", "administrador", "1234")) {

            ArrayList<Usuario> listaUsu = new ArrayList<>();
            String consultaSQL = "SELECT id, nombre, edad, email, password FROM Usuario";
            Statement sentencia = con.createStatement();
            ResultSet res = sentencia.executeQuery(consultaSQL);
            while (res.next()) {
                int id = res.getInt("id");
                String nombre = res.getString("nombre");
                int edad = res.getInt("edad");
                String email = res.getString("email");
                String password = res.getString("password");

                Usuario usu = new Usuario(id, nombre, edad, email, password);
                listaUsu.add(usu);
            }
            return listaUsu;
        } catch (SQLException ex) {
            System.err.println(" >>> " + ex.getMessage());
            return null;
        }

    }

    public boolean crear(Usuario persona) {
        try (Connection con = DriverManager.getConnection(Constantes.CONNEX_DB, Constantes.USUARIO_DB, Constantes.PASSWORD_DB)) {
           
            //Statement sentencia = con.createStatement();
            String querySQL = "INSERT INTO USUARIO (NOMBRE, EDAD, EMAIL, PASSWORD) VALUES (?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(querySQL);
            st.setString (1, persona.getNombre());
            st.setInt(2, persona.getEdad());
            st.setString(3, persona.getEmail());
            st.setString(4, persona.getPassword());
            st.executeUpdate();
          return true;
        } catch (SQLException ex) {
            System.err.println(" >>> " + ex.getMessage());
        }
        return false;
    }
    
    public boolean modificar(Usuario persona) {

        try (Connection con = DriverManager.getConnection(Constantes.CONNEX_DB, Constantes.USUARIO_DB, Constantes.PASSWORD_DB)) {

           String querySQL = "UPDATE SET NOMBRE=?, EDAD=?, EMAIL=?, PASSWORD=? WHERE id=?";
            PreparedStatement st = con.prepareStatement(querySQL);
            st.setString (1, persona.getNombre());
            st.setInt(2, persona.getEdad());
            st.setString(3, persona.getEmail());
            st.setString(4, persona.getPassword());
            st.setInt(5, persona.getId());

            st.executeUpdate();
          return true;      
        } catch (SQLException ex) {
            System.err.println(" >>> " + ex.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {

        try (Connection con = DriverManager.getConnection(Constantes.CONNEX_DB, Constantes.USUARIO_DB, Constantes.PASSWORD_DB)) {

           String querySQL = "DELETE FROM USUARIO WHERE id=? ";
            PreparedStatement st = con.prepareStatement(querySQL);
            st.setInt(1, id);
            st.executeUpdate();
          return true;      
        } catch (SQLException ex) {
            System.err.println(" >>> " + ex.getMessage());
            return false;
        }
    }

}
