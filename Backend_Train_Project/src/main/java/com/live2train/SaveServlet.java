package com.live2train;
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@SuppressWarnings("serial")
@WebServlet("/SaveServlet")  
public class SaveServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String cname=request.getParameter("cname");  
        String ccode=request.getParameter("ccode");  
        String address=request.getParameter("address");  
        String scapacity=request.getParameter("scapacity"); 
        String coffered=request.getParameter("coffered");
        String cemail=request.getParameter("cemail");
        String cnumber=request.getParameter("cnumber");
          
        Train e=new Train();  
        e.setCname(cname); 
        e.setCcode(ccode);
        e.setAddress(address);
        e.setScapacity(scapacity);
        e.setCoffered(coffered);  
        e.setCemail(cemail);  
        e.setCnumber(cnumber);
          
        int status=TrainDao.save(e);  
        if(status>0){  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("index.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
    }  
  
}