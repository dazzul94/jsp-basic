package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.VO;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("/action.do")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String txt = request.getParameter("txt");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		System.out.println("txt : " + txt);
		out.println("txt : " + txt);
		
		// 인자 => result.jsp 이동(forward)
		request.setAttribute("txt2", txt);
		
		
		// 인자 => VO => forward
		VO vo = new VO();
		vo.setTxt(txt);
		
		request.setAttribute("vo", vo);
		
		// jsp : <jsp:forward page="result.jsp" />
		// jsp : pageContext.forward("result.jsp");
		// spring : return "result"; // result.jsp
		RequestDispatcher rd 
			= request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}

}
