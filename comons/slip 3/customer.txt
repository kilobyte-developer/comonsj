import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Customer")
public class Customer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    Connection cn;
    public void init()
    {
       try
       {
            Class.forName("org.postgresql.Driver");
            cn=DriverManager.getConnection("jdbc:postgresql:tybcs","postgres","postgres");
            
       }
       catch(Exception ce)
       {   
           System.out.println("Error"+ce.getMessage());
       }
 
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();        
        try
        {
 
         	
        	int id=Integer.parseInt(request.getParameter("t1"));           
            
			String qry="select * from Customer1 where id="+id;
			
            
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(qry); 
            
            while(rs.next()) {
                out.print("<table border=1>");
                out.print("<tr>");
                out.print("<td>" + rs.getInt(1) + "</td>");
                out.print("<td>" + rs.getString(2) + "</td>");
                
                out.print("</tr>");
                out.print("</table>");
            
            }
        }
        catch(Exception se){
        	out.print(se);
        }
        out.close();
    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}