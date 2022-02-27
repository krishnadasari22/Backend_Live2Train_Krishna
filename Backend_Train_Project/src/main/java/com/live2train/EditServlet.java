package com.live2train;
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@SuppressWarnings("serial")
@WebServlet("/EditServlet")  
public class EditServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Employee</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        Train e=TrainDao.getEmployeeById(id);  
          
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
        out.print("<tr><td>Center Name:</td><td><input type='text' name='cname' value='"+e.getCname()+"'/></td></tr>");  
        out.print("<tr><td>Center Code:</td><td><input type='text' name='code' value='"+e.getCcode()+"'/>"
        		+ "</td></tr>"); 
        out.print("<tr><td>Address:</td><td><input type='text' name='address' value='"+e.getAddress()+"'/></td></tr>");
        out.print("<tr><td>Student Capacity:</td><td><input type='text' name='scapacity' value='"+e.getScapacity()+"'/></td></tr>");
        out.print("<tr><td>Courses Offered:</td><td><input type='text' name='coffered' value='"+e.getCoffered()+"'/></td></tr>");
        out.print("<tr><td>Contact Email:</td><td><input type='email' name='cemail' value='"+e.getCemail()+"'/></td></tr>"); 
        out.print("<tr><td>Contact Number:</td><td><input type='text' name='cnumber' value='"+e.getCnumber()+"'/></td></tr>");  
        out.print("</select>");  
        out.print("</td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
}
