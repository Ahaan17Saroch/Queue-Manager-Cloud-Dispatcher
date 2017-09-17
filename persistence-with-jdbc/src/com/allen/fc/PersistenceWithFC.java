package com.allen.fc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.allen.template.PersistenceWithTemplate;
import com.sap.security.core.server.csi.IXSSEncoder;
import com.sap.security.core.server.csi.XSSEncoder;

/**
 * Servlet implementation class PersistenceWithFC
 * 
 * In addition, this class includes all 4 components
 * 	= FC_EA_IC_FIM
 * 
 * @author Allen Qian
 */
public class PersistenceWithFC extends PersistenceWithTemplate {
	private static final long serialVersionUID = 1L;
	private static final String linkName = "persistencewithfc";
	private FCDAO fc; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersistenceWithFC() {
        super();
        // TODO Auto-generated constructor stub
    }

    /** {@inheritDoc} */
    @Override
    public void init() throws ServletException {
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DefaultDB");
            fc = new FCDAO(ds,"FC");
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (NamingException e) {
            throw new ServletException(e);
        }
    }
    
    @Override
    protected void displayTable(HttpServletResponse response) throws SQLException, IOException {
        // Append table that lists all persons
        List<FC> resultList = fc.selectAllEntries();
        response.getWriter().println(
                "<p><table width=70% border=\"1\"><tr><th colspan=\"1\"></th>" + "<th colspan=\"3\">" + (resultList.isEmpty() ? "" : resultList.size() + " ")
                        + "Entries in the Database</th>"
                        + "<th colspan=\"3\">" + "Smart Sorted</th></tr>");
        if (resultList.isEmpty()) {
            response.getWriter().println("<tr><td colspan=\"4\">Database is empty</td></tr>");
        } else {
            response.getWriter().println("<tr><th>#</th><th>Name</th><th>Increase</th><th>Decrease</th><th>Amount</th><th>Total</th><th>Score</th></tr>");
        }
        IXSSEncoder xssEncoder = XSSEncoder.getInstance();
        int index = 1;
        Collections.sort(resultList);
        for (FC fc : resultList) {
        	response.getWriter().println(
                    "<tr><td height=\"30\"><center>" + (index++) + "</center></td>"
                    + "<td height=\"30\"><center>" + xssEncoder.encodeHTML(fc.getName()) + "</center></td>"
					+ "<td><center><form action=\"" + linkName + "?Id="+ fc.getId() + "\"method=\"post\">" + "<input type=\"submit\" value=\"Add\" />" + "</form></center></td>" 
					+ "<td>" + "<center><input type=\"submit\" value=\"-\"></center>" + "</td>"
					+ "<td height=\"30\"><center>" + fc.getAmount() + "</center></td>" // need to change to xssEncoder for getAmount()?
					+ "<td height=\"30\"><center>" + fc.getTotal() + "</center></td>" // need to change to xssEncoder for getTotal()?
					+ "<td height=\"30\"><center>" + String.format("%.3f", (fc.getAmount()*0.8 + (fc.getTotal()-fc.getAmount())/fc.getAmount()*0.2 + 10),4) + "</center></td>"
					+ "</tr>");
        }
        response.getWriter().println("</table></p>");
    }
    
    @Override
    protected void doIncrease(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        // Extract name of person to be added from request
        String id = request.getParameter("Id");
        if (id != null && !id.trim().isEmpty()) {
        	int temp = Integer.parseInt(id);
        	int amount = fc.getAmount(temp) + 1;
        	fc.addIncidentToPerson(id, amount);
        }
    }

}
