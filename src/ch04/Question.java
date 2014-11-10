package ch04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Question
 */
public class Question extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Question() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
    	PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		pw.println("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"><title>Insert title here</title></head><body>");
		
		String page = request.getParameter("page");
		if (page == null) {
			pw.println("<form action=\"Question\" method=\"post\">");
			pw.println("Quetion1:<input type=\"text\" name=\"p1q1\"><br>");
			pw.println("Quetion2:<input type=\"text\" name=\"p1q2\">");
			pw.println("<input type=\"submit\" name=\"page\" value=\"下一頁\">");
		} else if ("下一頁".equals(page)) {
			String p1q1 = request.getParameter("p1q1");
			String p1q2 = request.getParameter("p1q2");
			pw.println("<form action=\"Question\" method=\"post\">");
			pw.println("Quetion3:<input type=\"text\" name=\"p2q1\">");
			pw.println("<input type=\"hidden\" name=\"p1q1\" value=\""+p1q1+"\">");
			pw.println("<input type=\"hidden\" name=\"p1q2\" value=\""+p1q2+"\">");
			pw.println("<input type=\"submit\" name=\"page\" value=\"結果\">");
		} else if ("結果".equals(page)) {
			pw.println(request.getParameter("p1q1"));
			pw.println(request.getParameter("p1q2"));
			pw.println(request.getParameter("p2q1"));
		}
		pw.println("</form>");
		pw.println("</body></html>");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

}
