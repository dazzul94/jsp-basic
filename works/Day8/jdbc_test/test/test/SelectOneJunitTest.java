package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.javateam.project.domain.MemberVo;
import com.javateam.project.repository.MemberDao;
import com.javateam.project.repository.MemberDaoImpl;

public class SelectOneJunitTest {
	
	MemberDao dao;
	MemberVo member;

	@Before
	public void setUp() throws Exception {

		dao = MemberDaoImpl.getInstance();
	}

	@Test
	public void test() {
		member = dao.getMember("java8");
		assertEquals(true, member.getId().equals("java8"));
	} //
}