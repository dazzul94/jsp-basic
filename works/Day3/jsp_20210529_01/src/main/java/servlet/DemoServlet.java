package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet(
		description = "데모 서블릿", 
		urlPatterns = { 
				"/DemoServlet", 
				"/demo.do", 
				"/demo.abc"
		}, 
		initParams = { 
				@WebInitParam(name = "jsp", value = "2.3", description = "JSP외 버전"), 
				@WebInitParam(name = "java", value = "1.8", description = "자바의 버전")
		})
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
        super();
    }

	/**
	 * 서블릿 초기화 : 초기 인자 처리
	 * @see Servlet#init(ServletConfig)
	 */
    @Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("---- init ----");
		
		System.out.println("java: " + config.getInitParameter("java"));
		System.out.println("서블릿 이름 : " + config.getServletName());
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("---- destroy ----");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---- service -----");
		
		String httpMethod = request.getMethod();
		System.out.println("httpMethod:" + httpMethod);
		
		if(httpMethod.equals("GET")) {
			doGet(request, response);
		} else if(httpMethod.equals("POST")){
			doPost(request, response);
		}
			
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		// getContextPath() : 프로젝트가 시작되는 기점 폴더(path)
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		// JSP의 out 기본(내장) 객체(JspWriter)에 해당
		// 기본 content encoding : ISO-8859-1(서유럽어)
		// content type 구성: MIME; charset
		// ex) "text/html; charset=UTF-8"
		response.setContentType("text/html; charset=UTF-8");
		// response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("out : " + "서블릿 get");
		out.println("out : " + "<br><u><b>서블릿 get</b></u>");
		out.print("<hr>");
		
		// 인자 처리/출력
		String id = request.getParameter("id");
		out.print("id: " + id + "<br>");
		
		String name = request.getParameter("name") == null ? "인자 없음"
					: request.getParameter("name").trim().equals("")?"인자 없음"
					: request.getParameter("name");
		
		out.print("name: " + name);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		
		// POST 방식 전용 인코딩 처리(변환) 
		// : ISO-8859-1 => UTF-8 
		request.setCharacterEncoding("UTF-8"); 
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("id : " + id);
		out.println("name : " + name);	
		
	}

}
