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

public class SelectPagingJunitTest {
	
	MemberDao dao;
	List<MemberVo> members;

	@Before
	public void setUp() throws Exception {

		dao = MemberDaoImpl.getInstance();
	}

	@Test
	public void test() {
		
		// select * from member_tbl limit (page-1)*limit, limit
		members = dao.getMembersByPage(0, 5);
//		assertNotNull(members);	// 결과 유무 점검
		
		// 결과의 개수로 점검
		// assertEquals(5, members.size());
		
		// 특정 데이터 일치 여부 점검 
		// 페이지의
		assertEquals("java9", members.get(2).getId());
		
	} //
}