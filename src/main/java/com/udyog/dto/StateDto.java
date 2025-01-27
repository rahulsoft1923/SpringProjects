package com.udyog.dto;

public class StateDto {
	protected int stateNo;
	protected String stateName;

	public StateDto(int stateNo) {
		super();
		this.stateNo = stateNo;
	}

	public StateDto(int stateNo, String stateName) {
		super();
		this.stateNo = stateNo;
		this.stateName = stateName;
	}

	public int getStateNo() {
		return stateNo;
	}

	public void setStateNo(int stateNo) {
		this.stateNo = stateNo;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

}
