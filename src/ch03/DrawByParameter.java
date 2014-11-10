package ch03;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DrawByParameter
 */
public class DrawByParameter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DrawByParameter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InputStream is;
		OutputStream os = response.getOutputStream();
		String picture = request.getParameter("picture");
		if (picture.equals("jbpm1")) 
			is = getServletContext().getResourceAsStream("/WEB-INF/picture/fixedAssets.disposal.png");
		else if (picture.equals("jbpm2")) 
			is = getServletContext().getResourceAsStream("/WEB-INF/picture/jBPM-taskLifeCycle.png");
		else 
			return;
		
		byte[] b = new byte[1024];
		while (is.read(b)!=-1)
			os.write(b, 0, b.length);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
