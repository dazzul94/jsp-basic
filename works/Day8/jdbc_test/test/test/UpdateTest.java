package test;

import com.javateam.project.domain.MemberVo;
import com.javateam.project.repository.MemberDao;
import com.javateam.project.repository.MemberDaoImpl;

public class UpdateTest {

	public static void main(String[] args) {
		
		MemberDao dao = MemberDaoImpl.getInstance();
		
		MemberVo member = new MemberVo();
		member.setId("spring");
		member.setPw("1111");
		member.setAddress("강서구 까치산");
		
		System.out.println("저장 성공 여부: " + dao.updateMember(member));
	}
}
