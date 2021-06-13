package test;

import java.util.Date;

import com.javateam.project.domain.MemberVo;
import com.javateam.project.repository.MemberDao;
import com.javateam.project.repository.MemberDaoImpl;

public class InsertTest {

	public static void main(String[] args) {
		
		MemberDao dao = MemberDaoImpl.getInstatnce();
		MemberVo member = new MemberVo();
		
		member.setId("java");
		member.setPw("1234");
		member.setName("홍길동");
		member.setAddress("강남");
		member.setJoindate(new Date(System.currentTimeMillis()));
		
		System.out.println("저장 성공 여부: " + dao.insertMember(member));
	}
}
