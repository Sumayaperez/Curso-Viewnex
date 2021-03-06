/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viewnext.controladores;

import com.modelo.ServicioUsuarios;
import com.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Default
 */
@WebServlet(name = "UsuariosController", urlPatterns = {"/usuarios.do"})
public class UsuariosController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String accion = request.getParameter("accion");
            String id = request.getParameter("id");
            String nombre = request.getParameter("nombre");
            String edad = request.getParameter("edad");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            switch (accion) {
                case "login":

                    if (ServicioUsuarios.getInstanciia().validacionPasswd(email, password)) {
                        //out.println("<h3>* * * Login correcto* * * </h3>");
                        //creacion de la sesión
                        HttpSession sesion = request.getSession();
                        Usuario usu = ServicioUsuarios.getInstanciia().obtenerUno(email);
                        
                        sesion.setAttribute("usuario",usu);
                        
                    } else {
                        System.out.println("<h3>* * * Login incorrecto* * * </h3>");
                        request.getSession().setAttribute("msj_error","login incorrecto");
                    }
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                
                case "registro":
                    boolean realizado = ServicioUsuarios.getInstanciia().addUsuario(nombre, edad, email, password);
                    if (realizado) {
                        out.println("<h3>* * * Registrado correctamente* * * </h3>");
                    } else {
                        out.println("<h3>* * * No se ha registrado* * * </h3>");
                    }
                    break;
                case "PUT":
                    ServicioUsuarios.getInstanciia().modificarUsuario(id, nombre, edad, email, password);
                    request.getRequestDispatcher("listar.jsp").forward(request,response);
                    break;
            }

        } catch (Exception ex){
            System.out.println(">>>> Error Usuario.do" + ex.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
