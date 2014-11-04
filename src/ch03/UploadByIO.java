package ch03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestBody
 */
public class UploadByIO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadByIO() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private byte[] getBody(HttpServletRequest request) throws IOException {
    	byte[] body = new byte[request.getContentLength()];
    	InputStream is = request.getInputStream();
    	is.read(body);
    	return body;
    }
    
    private String getFileName(String textBody){
    	textBody = textBody.substring(textBody.indexOf("filename=\"")+10);
    	String fileName = textBody.substring(0,textBody.indexOf("\""));
    	return fileName;
    }
    
    private void writeTo(byte[] body, String fileName) throws IOException {
		OutputStream os = new FileOutputStream("D:\\"+fileName);
		os.write(body);
		os.close();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		byte[] body = getBody(request);
		String textBody = new String(body,"ISO-8859-1");
		String fileName = getFileName(textBody);
		writeTo(body, fileName);
	}

}
