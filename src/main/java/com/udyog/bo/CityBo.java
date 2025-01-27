package com.udyog.bo;

import java.io.Serializable;

public class CityBo implements Serializable {
	private static final long serialVersionUID = 1082365144977874196L;
	
	protected int cityNo;
	
	protected String cityName;

	public CityBo(int cityNo) {
		super();
		this.cityNo = cityNo;
	}

	public CityBo(int cityNo, String cityName) {
		super();
		this.cityNo = cityNo;
		this.cityName = cityName;
	}

	public int getCityNo() {
		return cityNo;
	}

	public void setCityNo(int cityNo) {
		this.cityNo = cityNo;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
