package com.udyog.dto;

public class CityDto {
	protected int cityNo;
	protected String cityName;

	public CityDto(int cityNo) {
		super();
		this.cityNo = cityNo;
	}

	public CityDto(int cityNo, String cityName) {
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
