/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controller;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.naming.factory.TransactionFactory;

/**
 *
 * @author MY
 */
public class addNewPlayersServlet extends HttpServlet {

    TransactionFactory uTransaction ;
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
        EntityManagerFactory eManagerFactory = Persistence.createEntityManagerFactory("WebApplication4PU");
        assert eManagerFactory != null;
        EntityManager eManager = null;
        try{
            String rank = (String) request.getParameter("rank");
            String playerName = (String) request.getParameter("playerName");
            String team = (String) request.getParameter("team");
            
            Players player = new Players(rank,playerName,team);
            
           
                                                                                                                                    
            eManager = eManagerFactory.createEntityManager();
             eManager.getTransaction().begin();
            eManager.persist(player);

            eManager.getTransaction().commit();
 
            request .getRequestDispatcher("DisplayPlayers").forward(request, response);
        }catch (Exception ex){
            throw  new ServletException(ex);
        }finally{
//            if(eManagerFactory != null){
//                eManagerFactory.close();
//            }
            if(eManager.isOpen()){
                eManager.close();   
            }
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
