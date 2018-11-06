/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jackie
 */
public class SignupServlet extends HttpServlet {

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
        //get username and password
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int a = username.length();
        int b = password.length();
             
        User user = new User();
        
        user.setUsername(username);
        user.setPassword(password);
        if ((a!=0)&&(b!=0)&&(a<11)&&(b<21)){
            if(SignupCheck(username)){
                user.setStatus("SIGNUP SUCCESS");
                SaveUser(username,password);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                rd.forward(request, response);
            }
            else{
                user.setStatus("INVALID USERNAME");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/signup.jsp");
                rd.forward(request, response);
            }
        }
        else{
            user.setStatus("INVALID USERNAME");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/signup.jsp");
            rd.forward(request, response);
        }
    }
    
    private boolean SignupCheck(String username) {
        String url = "jdbc:derby://localhost:1527/userinfo";
        try {
            Connection conn = DriverManager.getConnection(url,"admin2560","2560");
            String sql = "select username from login";
            Statement st = conn.createStatement();
            ResultSet rs = null;
            rs = st.executeQuery(sql);
            while(rs.next()){
                String usernameInDB = rs.getString("username");
                if (usernameInDB.equals(username)){
                    return false;
                }      
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Connect failed !");
        }        
        return true;
    }
    
    private void SaveUser(String username, String password) {
        String url = "jdbc:derby://localhost:1527/userinfo";
        try {
            Connection conn = DriverManager.getConnection(url,"admin2560","2560");
            String sql = "insert into login values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Connect failed !");
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
