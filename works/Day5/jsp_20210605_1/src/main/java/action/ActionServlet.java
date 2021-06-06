package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberDTO;
import domain.MemberVO;

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
        super();
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
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		// 인자 -> request -> DTO/VO -> DB저장(DAO)
//		// 3개의 전화번호 필트 -> 1개의 전화번호 DB table 필드
//		Map<String,String[]> map = request.getParameterMap();
//		
//		
//		// 인자가 넘어오면 로그를 먼저 찍어보세요
//		// 인자확인 -람다?
//		map.forEach((k, v) -> System.out.println(k+"="+v[0]));
//		map.keySet().forEach(x -> System.out.println(x + "=" + map.get(x)[0]));
//		
//		// map.entrySet().forEach(x->System.out.println(x));
//		// map.entrySet().forEach(System.out::println);
//		
//		// DAO
//		// ex) dao.insertMember(memberVO);
//		// map -> VO 변환
//		// MemberVO member = new MemberVO(map);
//		MemberVO member = new MemberVO(map);
//		System.out.println("member : " + member.getPhone());
//		
//	} 
		
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		// map으로 받은 인자를 VO로 치환
//		MemberVO member = new MemberVO(request.getParameterMap());
//		System.out.println("member : " + member);
//		
//		// DAO
//		// ex) dao.insertMember(memberVO);
//	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// map -> DTO(form 1:1) -> VO(DB table 1:1)
		// 인자받아서 생성자에 집어 넣음
		MemberDTO memberDTO = new MemberDTO(request.getParameterMap());
		System.out.println("memberDTO : " + memberDTO);

		MemberVO memberVO = new MemberVO(memberDTO);
		System.out.println("memberVO : " + memberVO);
		
		
		MemberVO memberVO2 = new MemberVO(new MemberDTO(request.getParameterMap()));
		// DAO
		// ex) dao.insertMember(memberVO2);
	}

}
