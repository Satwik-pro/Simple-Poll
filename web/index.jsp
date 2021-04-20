<%-- 
    Document   : index
    Created on : 8 Apr, 2021, 6:26:49 PM
    Author     : Satwik
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            * {box-sizing: border-box}
            .container {
                width: 100%;
                background-color: #ddd;
            }
            .skills {
                text-align: right;
                padding-top: 10px;
                padding-bottom: 10px;
                color: white;
            }
        </style>
    </head>
    <body>
    <center>
        <form action="calc" method="post"> 
            <input name="win" type="submit" value="Windows" />
            <input name="lin" type="submit" value="Linux" />
            <input name="mac" type="submit" value="MAC" />
            <input name="oth" type="submit" value="Other" />
            <input name="clr" type="submit" value="Clear Poll" />
        </form>
    </center>
    <%
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:derby://localhost:1527/poll", "poll", "poll");
            PreparedStatement stmt1 = con.prepareStatement("select * from poll");
            ResultSet rs = stmt1.executeQuery();
            if (rs.next()) {
                int a1 = rs.getInt(1);
                int a2 = rs.getInt(2);
                int a3 = rs.getInt(3);
                int a4 = rs.getInt(4);
                
                int total = a1+a2+a3+a4;
                double d1=0.0,d2=0.0,d3=0.0,d4=0.0;
                
                if(total != 0)
                {
                    d1 = (a1/(double)total)*100;
                    d2 = (a2/(double)total)*100;
                    d3 = (a3/(double)total)*100;
                    d4 = (a4/(double)total)*100;
                }
    %>
    <style>
        .html {width: <%out.print(d1);%>%; background-color: #4CAF50;}
        .css {width: <%out.print(d2);%>%; background-color: #2196F3;}
        .js {width: <%out.print(d3);%>%; background-color: #f44336;}
        .php {width: <%out.print(d4);%>%; background-color: #808080;}
    </style>
    <h1>POLL</h1>
    <p>Windows</p>
    <div class="container">
        <div class="skills html"><%out.print(d1);%>%</div>
    </div>

    <p>Linux</p>
    <div class="container">
        <div class="skills css"><%out.print(d2);%>%</div>
    </div>

    <p>MAC</p>
    <div class="container">
        <div class="skills js"><%out.print(d3);%>%</div>
    </div>

    <p>Other</p>
    <div class="container">
        <div class="skills php"><%out.print(d4);%>%</div>
    </div>
    <%             }
        } catch (Exception e) {
            System.out.println(e);
            out.println(e);
        }
    %>
</body>
</html>
