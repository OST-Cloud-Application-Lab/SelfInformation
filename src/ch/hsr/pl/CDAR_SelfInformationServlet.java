package ch.hsr.pl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.hsr.bll.CDAR_EnvironmentVariables;
import ch.hsr.bll.CDAR_HardwareInformation;
import ch.hsr.bll.CDAR_NetworkInformation;
import ch.hsr.bll.CDAR_SystemInformation;

/**
 * Servlet implementation class SelfInformation
 */
/**
 * @author dzigerli@hsr.ch (Daniel Zigerlig)
 * 
 */
public class CDAR_SelfInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CDAR_OutputHelper outputHelper;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CDAR_SelfInformationServlet() {
		super();
		initOutputHelper();
	}

	private void initOutputHelper() {
		this.outputHelper = new CDAR_OutputHelper();
		try {
			this.outputHelper.addInformation(new CDAR_HardwareInformation());
			this.outputHelper.addInformation(new CDAR_HardwareInformation());
			this.outputHelper.addInformation(new CDAR_NetworkInformation());
			this.outputHelper.addInformation(new CDAR_SystemInformation());
			this.outputHelper.addInformation(new CDAR_EnvironmentVariables());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("xml") != null) {
			printXML(response, request);
		} else {
			printHTMLHeader(response, request);
			printHTMLForm(response, request);
			printHTMLFooter(response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void printXML(HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		response.setContentType("application/xml");
		PrintWriter out = response.getWriter();
		try {
			out.print(this.outputHelper.getXML());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected void printHTMLHeader(HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 5//EN\" \"http://www.w3.org/TR/html5/html5.dtd\">");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("<title>SelfInformation</title>");
		out.println("<LINK href=\"" + request.getContextPath()
				+ "/css/selfInformation.css"
				+ "\" rel=\"stylesheet\" type=\"text/css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div id=\"content\">");
		out.println("<h1>Self Information</h1>");
	}

	protected void printHTMLFooter(HttpServletResponse response)
			throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void printHTMLForm(HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(this.outputHelper.getHTML());
	}

	protected String removeQueryString(String aURI) {
		int i = aURI.indexOf('?');
		if (i != -1) {
			aURI = aURI.substring(0, i);
		}
		return aURI;
	}
}
