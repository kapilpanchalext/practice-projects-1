package com.app05.main.VO;

import com.app05.main.model.MainData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.app05.userserviceredis.model.UserDetails;
import com.app05.departmentserviceredis.model.DepartmentDetails;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
	
	private MainData mainData;
	private UserDetails userDetails;
	private DepartmentDetails departmentDetails;	
}