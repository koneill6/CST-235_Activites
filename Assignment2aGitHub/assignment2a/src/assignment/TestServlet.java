package assignment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();

    }



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		
		if(firstName == null || firstName == "") {
			request.setAttribute("error", "First name cannot be empty");
			request.getRequestDispatcher("TestError.jsp").forward(request, response);
			
		}else if(lastName == null || lastName == ""){
			request.setAttribute("error", "Last name cannot be empty");
			request.getRequestDispatcher("TestError.jsp").forward(request, response);
			
		}else {
			request.setAttribute("firstname", firstName);
			request.setAttribute("lastname", lastName);
			request.getRequestDispatcher("TestResponse.jsp").forward(request, response);
		
		}
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
