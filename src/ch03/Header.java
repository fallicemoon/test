package ch03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Header
 */
public class Header extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Header() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		Enumeration<String> enumeration = request.getHeaderNames();
		while (enumeration.hasMoreElements()) {
			String header = enumeration.nextElement();
			pw.println(header + ":" + request.getHeader(header));
			pw.println();
			Enumeration<String> headers = request.getHeaders(header);
			while (headers.hasMoreElements()) {
				pw.println(header + ":" + headers.nextElement());
				
			}
		}
		pw.println("----------");
		request.setAttribute("name", "Henry");
		Enumeration<String> enumeration2 = request.getAttributeNames();
		while (enumeration2.hasMoreElements()) {
			String attributeName = enumeration2.nextElement();
			pw.println(attributeName + ":" + request.getAttribute(attributeName));
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
