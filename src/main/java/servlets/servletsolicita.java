/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.Articulo;
import classes.Producto;
import controllers.ControladorProducto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.ModeloFactura;
import models.ModeloPedidos;

/**
 *
 * @author marti
 */
public class servletsolicita extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        

        
        HttpSession sesion = request.getSession(true);
        ArrayList<Articulo> articulos = sesion.getAttribute("carrito") == null ? null : (ArrayList) sesion.getAttribute("carrito");
        
        int rows = Integer.parseInt(request.getParameter("rows"));
        int idped = Integer.parseInt(request.getParameter("idped"));
        
        boolean estado = false;
        
            
            
            for(Articulo a: articulos){
                
                ModeloFactura mf = new ModeloFactura();
                ModeloPedidos mp = new ModeloPedidos();
                                               
                if(mf.RegistrarSolicitar(a.getIdProducto(), a.getCantidad(), idped, rows)){
                    estado=true;
                    if(estado = true){
                        mp.UpdateStock(a.getCantidad(), a.getIdProducto());
                    }else{
                        estado = false;
                    }
                }

            }
            
            if(estado = true){
                
                response.sendRedirect("Termino.jsp");
            }else{
                response.sendRedirect("error.jsp");
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
