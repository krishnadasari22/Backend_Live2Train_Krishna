package com.live2train;
import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@SuppressWarnings("serial")
@WebServlet("/ViewServlet")  
public class ViewServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='index.html'>Add New Data</a>");  
        out.println("<h1>Data List</h1>");  
          
        List<Train> list=TrainDao.getAllData();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Center Name</th><th>Center Code</th><th>Address</th><th>Student Capacity</th><th>Courses Offered</th><th>Contact Email</th><th>Contact Number</th>"
        		+ "<th>Edit</th><th>Delete</th></tr>");  
        for(Train e:list){  
         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getCname()+"</td><td>"+e.getCcode()+"</td>"
         		+ "<td>"+e.getAddress()+"</td><td>"+e.getScapacity()+"<td>"+e.getCoffered()+"</td><td>"+e.getScapacity()+"</td><td>"+e.getCemail()+"</td><td>"+e.getCnumber()+"</td>"
        +"<td><a href='EditServlet?id="+e.getId()+"'>edit</a></td>"
         				+ "<td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}