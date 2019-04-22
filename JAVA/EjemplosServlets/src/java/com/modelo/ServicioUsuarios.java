/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import java.util.ArrayList;

/**
 *
 * @author Default
 */
public class ServicioUsuarios {
    //Implementando Singleton 
    
    private static ServicioUsuarios instancia =null;
    //Nadie puede hacer new salgo esta misma clase
    private ServicioUsuarios(){
        listaUsuarios =new ArrayList<>();
    }
    //Única manera de devolver un objeto en esta clase
    public static ServicioUsuarios getInstanciia() {
        if (instancia == null)
            instancia = new ServicioUsuarios();
        return instancia;
    }
    
    
    private final ArrayList<Usuario> listaUsuarios;
    
   
    public boolean addUsuario(String nom, int edad, String email,String password){
        Usuario nuevoUsu = new Usuario(nom, password, edad, email);
        this.listaUsuarios.add(nuevoUsu);
        return true;
    }
    public boolean validacionPasswd(String email, String passwd){
        if (listaUsuarios.stream().anyMatch((usu) -> (usu.getEmail().equals(email) && usu.getPassword().equals(passwd)))) {
            return true;
        }
        return false;
    }
    public int cantidadUsuarios(){
        return listaUsuarios.size();
    }
}
