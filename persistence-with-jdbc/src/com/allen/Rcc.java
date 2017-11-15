package com.allen;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Submit
 */
public class Rcc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rcc() {
        super();
        // TODO Auto-generated constructor stub
    }
    


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().println("<html>");
		response.getWriter().println("<head><title>Edit Availability</title></head>");
		response.getWriter().println("<body>");
		
		response.getWriter().println("<h2><center> RCC Data </center></h2>");
		
		// Home button
		response.getWriter().println("<p><center><form action=\"" + "nw" + "\" method=\"get\">" + "<input type=\"submit\" value=\"Return to Home\" />" + "</form></center></p>");
		        
		
		response.getWriter().println("<center><form action=\"\" method=\"post\">" + "Name:<input type=\"text\" name=\"name\">"
                + "&nbsp;Value:<input type=\"text\" name=\"value\">"
                + "&nbsp;<input type=\"submit\" value=\"Update\">" + "</form></center>");

		
		
		response.getWriter().println(
                "<p><center><table width=50% border=\"1\">");
        	
        response.getWriter().println("<tr><th>Name</th><th>Current Queue Days</th><th>%usage</th></tr>");	
	
        
		displayTable(response);
		
		response.getWriter().println("</tr></table></center></p>");
		
		response.getWriter().println("");
		response.getWriter().println("<h2><center> Reset Records </center></h2>");
		// Add reset button
        response.getWriter().println("<p><center>The first day of the month? If yes, click <form action=\"" + "nw" + "?operation=reset\" method=\"post\">" + "<input type=\"submit\" onclick=\"return window.confirm('Are you sure to RESET all values?')\" value=\"RESET\" />" + "</form></center></p>");
        
		
		
        
        response.getWriter().println("</body>");
		response.getWriter().println("</html>");
	}
	
	private void displayTable(HttpServletResponse response) throws IOException {
		Integer index = 1;
		writeRow(index, response, "Ahaan", "1.00");
		writeRow(index, response, "Alex", "1.00");
		writeRow(index, response, "Allen", "1.00");
		writeRow(index, response, "April", "1.00");
		writeRow(index, response, "Graham", "1.00");
		writeRow(index, response, "Hitomi", "1.00");
		writeRow(index, response, "John H", "1.00");
		writeRow(index, response, "John L", "0.5");
		writeRow(index, response, "Julie", "1.00");
		writeRow(index, response, "Leila", "1.00");
		writeRow(index, response, "Marc", "1.00");
		writeRow(index, response, "Pedro", "1.00");
		writeRow(index, response, "Stefan", "1.00");
		writeRow(index, response, "Yvonne", "0.75");
	}

	private void writeRow(Integer index, HttpServletResponse response, String name, String usage) throws IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().println("<tr><td height=\"30\"><center>" + name + "</center></td>");
		response.getWriter().println("<td height=\"30\"><center>" + QueueDays.getValue(name) + "</center></td>");
		response.getWriter().println("<td height=\"30\"><center>" + usage + "</center></td></tr>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name").trim();
        String value = request.getParameter("value").trim();
        if (name != null && value != null) {
        	if (!name.equals("Ahaan") || !name.equals("Alex") || !name.equals("Allen")
        			|| !name.equals("April") || !name.equals("Graham")
        			|| !name.equals("Hitomi") || !name.equals("John H")
        			|| !name.equals("John L") || !name.equals("Julie")
        			|| !name.equals("Leila") || !name.equals("Marc")
        			|| !name.equals("Pedro") || !name.equals("Stefan")
        			|| !name.equals("Yvonne")) {
	        	double v = Double.parseDouble(value);
	        	QueueDays.changeValue(name, v);
        	}
        } 

        doGet(request, response);
	}

}
