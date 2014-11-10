package ch03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Some
 */
public class Some extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Some() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter pw = response.getWriter();
//		pw.println("安安......");
//		Enumeration<String> enumeration = request.getAttributeNames();
//		while (enumeration.hasMoreElements()) {
//			String attributeName = enumeration.nextElement();
//			pw.println(attributeName+":"+request.getAttribute(attributeName));
//		}
//		
//		request.getRequestDispatcher("Other?a=1").include(request, response);
//		pw.println(response.getHeader("a"));
//		pw.println("Some end......");
		//response.sendRedirect("/test/Other");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/test/Other");
	}

}
