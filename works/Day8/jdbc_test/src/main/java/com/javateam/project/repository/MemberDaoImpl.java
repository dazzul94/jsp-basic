package com.javateam.project.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.javateam.project.domain.MemberVo;
import com.javateam.project.util.DbUtil;

// final: 오버라이딩을 막기 위해
public final class MemberDaoImpl implements MemberDao {

	// Singleton pattern
	// usage) MemberDao dao = MemberDaoImpl.getInstance()
	// usage) MemberDaoImpl dao = MemberDaoImpl.getInstance()
	// usage) MemberDaoImpl dao = new MemberDaoImpl(); (X)
	
	// Spring container => 자동으로 싱글톤 객체를 생성
	// @Autowired MemberDao dao;
	
	private static MemberDaoImpl instance = null;
	
	private MemberDaoImpl() {}
	
	// 간단한 싱글톤 패턴 적용( DAO의 보안성 확보를 위해)
	public static MemberDaoImpl getInstatnce() {
		
		instance = new MemberDaoImpl();
		return instance;
	}
	
	@Override
	public boolean insertMember(MemberVo member) {

		// 저장 성공 여부 플래그
		boolean result = false;
		
		// DB 연결
		Connection con = DbUtil.connect();
		
		// SQL 구문
		// ex) MyBatis => @, XML mapper로 독립
		String sql = "INSERT INTO member_tbl VALUES (?,?,?,?,?)";
		
		// SQL 처리 객체 : ? 인자 사용 가능
		PreparedStatement pstmt = null;
		try {
			// 트랜잭션(transaction)
			con.setAutoCommit(false);	// 수동 커밋모드로 전환
			
			pstmt = con.prepareStatement(sql);
			
			// 인자 처리 
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getAddress());
//			pstmt.setDate(5, member.getJoindate());
			
			// vo는 java.util.Date 이고 pstmt의 setDate는 java.sql.Date여서 생기는 문제
			// Date date = (Date)member.getJoindate(); // (X)
//			Date date = new Date(member.getJoindate().getTime());
			pstmt.setDate(5, new Date(member.getJoindate().getTime()));
			
			
			// SQL 실행 : 메시징
			if(pstmt.executeUpdate() == 1) {
				System.out.println("회원정보 저장에 성공");
				result = true;
			} else {
				System.err.println("회원정보 저장에 실패");
				result = false;
			}
			con.commit(); // 커밋
			
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} // 롤백
			
			System.err.println(e.getStackTrace()[0].getMethodName() + ": 회원정보 저장에 실패");
			e.printStackTrace();
		} finally {
			// 자원 반납			
			DbUtil.close(con, pstmt, null);
		}
		return result;
	}

	@Override
	public void updateMember(MemberVo member) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMember(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<MemberVo> getAllMembers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberVo> getMembersByPage(int page, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVo getMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}