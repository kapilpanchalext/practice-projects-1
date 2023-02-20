package com.app05.main.service;

import com.app05.main.VO.ResponseTemplateVO;
import com.app05.main.model.MainData;

public interface MainService {

	MainData saveMainData(MainData data);

	ResponseTemplateVO getMainDataById(Long mainId);

}
