/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Satwik
 */
public class calc extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet calc</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet calc at " + request.getContextPath() + "</h1>");
            
            String s1 = request.getParameter("win");
            String s2 = request.getParameter("lin");
            String s3 = request.getParameter("mac");
            String s4 = request.getParameter("oth");
            String s5 = request.getParameter("clr");
            
            if (s1 != null) 
            {
                try {
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    Connection con = (Connection) DriverManager.getConnection("jdbc:derby://localhost:1527/poll", "poll", "poll");
                    PreparedStatement stmt1 = con.prepareStatement("select * from poll");
                    ResultSet rs = stmt1.executeQuery();
                    int a1 = 0,a2 = 0,a3 = 0,a4 = 0;
                    if(rs.next()) {
                        a1 = rs.getInt(1) + 1;
                        a2 = rs.getInt(2);
                        a3 = rs.getInt(3);
                        a4 = rs.getInt(4);
                    }
                    PreparedStatement stmt2 = con.prepareStatement("delete from poll");
                    stmt2.executeUpdate();
                    
                    PreparedStatement pstmt=con.prepareStatement("insert into poll values(?,?,?,?)");
                    pstmt.setInt(1,a1);
                    pstmt.setInt(2,a2);
                    pstmt.setInt(3,a3);
                    pstmt.setInt(4,a4);
                    pstmt.executeUpdate();
                }
                catch (Exception e) {
                    System.out.println(e);
                    out.println(e);
                }
                response.sendRedirect("index.jsp");
            } 
            else if (s2 != null) 
            {
                try {
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    Connection con = (Connection) DriverManager.getConnection("jdbc:derby://localhost:1527/poll", "poll", "poll");
                    PreparedStatement stmt1 = con.prepareStatement("select * from poll");
                    ResultSet rs = stmt1.executeQuery();
                    int a1 = 0,a2 = 0,a3 = 0,a4 = 0;
                    if(rs.next()) {
                        a1 = rs.getInt(1);
                        a2 = rs.getInt(2) + 1;
                        a3 = rs.getInt(3);
                        a4 = rs.getInt(4);
                    }
                    
                    PreparedStatement stmt2 = con.prepareStatement("delete from poll");
                    stmt2.executeUpdate();
                    
                    PreparedStatement pstmt=con.prepareStatement("insert into poll values(?,?,?,?)");
                    pstmt.setInt(1,a1);
                    pstmt.setInt(2,a2);
                    pstmt.setInt(3,a3);
                    pstmt.setInt(4,a4);
                    pstmt.executeUpdate();
                }
                catch (Exception e) {
                    System.out.println(e);
                    out.println(e);
                }
                response.sendRedirect("index.jsp");
            } 
            else if (s3 != null) 
            {
                try {
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    Connection con = (Connection) DriverManager.getConnection("jdbc:derby://localhost:1527/poll", "poll", "poll");
                    PreparedStatement stmt1 = con.prepareStatement("select * from poll");
                    ResultSet rs = stmt1.executeQuery();
                    int a1 = 0,a2 = 0,a3 = 0,a4 = 0;
                    if(rs.next()) {
                        a1 = rs.getInt(1);
                        a2 = rs.getInt(2);
                        a3 = rs.getInt(3) + 1;
                        a4 = rs.getInt(4);
                    }
                    
                    PreparedStatement stmt2 = con.prepareStatement("delete from poll");
                    stmt2.executeUpdate();
                    
                    PreparedStatement pstmt=con.prepareStatement("insert into poll values(?,?,?,?)");
                    pstmt.setInt(1,a1);
                    pstmt.setInt(2,a2);
                    pstmt.setInt(3,a3);
                    pstmt.setInt(4,a4);
                    pstmt.executeUpdate();
                }
                catch (Exception e) {
                    System.out.println(e);
                    out.println(e);
                }
                response.sendRedirect("index.jsp");
            } 
            else if (s4 != null) 
            {
                try {
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    Connection con = (Connection) DriverManager.getConnection("jdbc:derby://localhost:1527/poll", "poll", "poll");
                    PreparedStatement stmt1 = con.prepareStatement("select * from poll");
                    ResultSet rs = stmt1.executeQuery();
                    int a1 = 0,a2 = 0,a3 = 0,a4 = 0;
                    if(rs.next()) {
                        a1 = rs.getInt(1);
                        a2 = rs.getInt(2);
                        a3 = rs.getInt(3);
                        a4 = rs.getInt(4) + 1;
                    }
                    
                    PreparedStatement stmt2 = con.prepareStatement("delete from poll");
                    stmt2.executeUpdate();
                    
                    PreparedStatement pstmt=con.prepareStatement("insert into poll values(?,?,?,?)");
                    pstmt.setInt(1,a1);
                    pstmt.setInt(2,a2);
                    pstmt.setInt(3,a3);
                    pstmt.setInt(4,a4);
                    pstmt.executeUpdate();
                }
                catch (Exception e) {
                    System.out.println(e);
                    out.println(e);
                }
                response.sendRedirect("index.jsp");
            }
            else if (s5 != null)
            {
                try {
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    Connection con = (Connection) DriverManager.getConnection("jdbc:derby://localhost:1527/poll", "poll", "poll");
                    int a1 = 0,a2 = 0,a3 = 0,a4 = 0;
                    
                    PreparedStatement stmt2 = con.prepareStatement("delete from poll");
                    stmt2.executeUpdate();
                    
                    PreparedStatement pstmt=con.prepareStatement("insert into poll values(?,?,?,?)");
                    pstmt.setInt(1,a1);
                    pstmt.setInt(2,a2);
                    pstmt.setInt(3,a3);
                    pstmt.setInt(4,a4);
                    pstmt.executeUpdate();
                }
                catch (Exception e) {
                    System.out.println(e);
                    out.println(e);
                }
                response.sendRedirect("index.jsp");
            }
            
            out.println("</body>");
            out.println("</html>");
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
