package com.udyog.bo;

import java.io.Serializable;

public class StateBo implements Serializable {
	private static final long serialVersionUID = 9169754367601756130L;
	protected int stateNo;
	protected String stateName;

	public StateBo(int stateNo) {
		super();
		this.stateNo = stateNo;
	}

	public StateBo(int stateNo, String stateName) {
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
