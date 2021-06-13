package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.javateam.project.domain.MemberVo;
import com.javateam.project.repository.MemberDao;
import com.javateam.project.repository.MemberDaoImpl;

public class SelectJunitTest {
	
	MemberDao dao;
	List<MemberVo> members;

	@Before
	public void setUp() throws Exception {

		dao = MemberDaoImpl.getInstance();
	}

	@Test
	public void test() {
		members = dao.getAllMembers();
//		assertNotNull(members);	// 결과 유무 점검
		
		// 결과의 개수로 점검
//		assertEquals(13, members.size());
		
		// 맨 처음 , 마지막 요소가 동일한지 점검
		// 중복 데이터 출력 여부 점검
		int lastNum = members.size() - 1;
		
		System.out.println("1 : " + members.get(0));
		System.out.println("2 : " + members.get(lastNum));
		assertFalse(members.get(0).equals(members.get(lastNum)));
	} //
}