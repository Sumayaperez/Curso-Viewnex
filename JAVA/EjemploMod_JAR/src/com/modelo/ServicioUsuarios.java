/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import static java.lang.System.out;
import java.util.ArrayList;

/**
 *
 * @author Default
 */
public class ServicioUsuarios {
    //Implementando Singleton 

    private static ServicioUsuarios instancia = null;

    //Nadie puede hacer new salgo esta misma clase
    private ServicioUsuarios() {
        // listaUsuarios = new ArrayList<>();
        this.bdUsu = new DerbyDBUsuario();
        this.listaUsuarios = bdUsu.listar();
        listaDBUsuarios = new ArrayList<>();
    }

    //Única manera de devolver un objeto en esta clase
    public static ServicioUsuarios getInstanciia() {
        if (instancia == null) {
            instancia = new ServicioUsuarios();
        }
        return instancia;
    }

    private final DerbyDBUsuario bdUsu;
    private final ArrayList<DerbyDBUsuario> listaDBUsuarios;
    private final ArrayList<Usuario> listaUsuarios;

    public boolean addUsuario(String nom, String edad, String email, String password) {
        try {
            if (nom.equals("") || email.equals("") || password.equals("")) {
                return false;

            } else {
                Usuario nuevoUsu = new Usuario(nom, edad, email, password);

                this.listaUsuarios.add(nuevoUsu);
                this.bdUsu.crear(nuevoUsu);
                return true;
            }
        } catch (Exception ex) {
            System.err.println(" >> Error: No se ha podido crear el usuario" + ex.getMessage());
            return false;
        }
    }

    public boolean validacionPasswd(String email, String passwd) {
        for (Usuario usu : listaUsuarios) {
            if (usu.getEmail().equals(email) && usu.getPassword().equals(passwd)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Usuario> listarUsuarios() {
        //Usuario nuevoUsu = new Usuario(nom, password, edad, email);
        return this.bdUsu.listar();
    }

    public int cantidadUsuarios() {
        return listaUsuarios.size();
    }

    public ArrayList<Usuario> listar() {
        return this.listaUsuarios;
    }

}
