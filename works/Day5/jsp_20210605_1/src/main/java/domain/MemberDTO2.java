package domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// DTO(Data Transfer Object)
// form field 1:1 대응(mapping)
@Getter
@Setter
@ToString
//@Data
public class MemberDTO2 {

	private String phone1;
	private String phone2;
	private String phone3;
	
	
	
}
