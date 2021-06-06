package domain;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MemberVO {
	
	private String phone;
	
	
	
	public MemberVO() {}
	
	public MemberVO(Map<String, String[]> map) {
		
		Set<String> keys = map.keySet();
		Iterator<String> it = keys.iterator();
		this.phone = "";
		
		// 전화번호 폼(form) 필드값 + "-" 추가 => DB table 필드 변경
		while (it.hasNext()) {
			this.phone += map.get(it.next())[0] + "-";
		}
		
		// 마지막에 들어간 -을 빼기 위해 총 길이에서 -1
		this.phone = phone.substring(0, phone.length()-1);
		
	
	}
	
	
	public MemberVO(MemberDTO memberDTO) {
		this.phone = memberDTO.getPhone1() + "-"
				   + memberDTO.getPhone2() + "-"
				   + memberDTO.getPhone3();
	}
	
	

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return String.format("MemberVO [phone=%s]", phone);
	}
	
	
	

}
