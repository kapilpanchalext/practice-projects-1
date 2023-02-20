package com.app05.main.service;

import com.app05.main.model.MainData;

public interface MainService {

	MainData saveMainData(MainData data);

	MainData getMainDataById(Long mainId);

}
