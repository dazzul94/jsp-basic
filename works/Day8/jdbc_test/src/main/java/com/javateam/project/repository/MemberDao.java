package com.javateam.project.repository;

import java.util.List;

import com.javateam.project.domain.MemberVo;

public interface MemberDao {
	
	/**
	 * 회원정보 생성
	 * @param member 회원 객체
	 */
	boolean insertMember(MemberVo member);
	
	/**
	 * 회원정보 수정
	 * @param member 회원 객체
	 * @return 
	 */
	boolean updateMember(MemberVo member);
	
	/**
	 * 회원정보 삭제
	 * 
	 * @param id 회원 아이디
	 */
	void deleteMember(String id);
	
	/**
	 * 전체 회원정보 조회
	 * 
	 * @return 전체 회원 리스트
	 */
	List<MemberVo> getAllMembers();
	
	/**
	 * 전체 회원정보 조회(페이징 지원)
	 * 
	 * @param page 현재 페이지
	 * @param limit 페이지당 출력 회원 수
	 * @return 회원정보 리스트
	 */
	List<MemberVo> getMembersByPage(int page, int limit);
	
	/**
	 * 개별 회원정보 조회
	 * 
	 * @param id 회원 아이디
	 * @return 회원 객체
	 */
	MemberVo getMember(String id);

}