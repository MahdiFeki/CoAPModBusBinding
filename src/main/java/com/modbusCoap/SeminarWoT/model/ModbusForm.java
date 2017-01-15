package com.modbusCoap.SeminarWoT.model;

public class ModbusForm {
	private String addressIP;
	private String ressource ;
	private String value;

	public String getAddressIP() {
		return addressIP;
	}

	public void setAddressIP(String addressIP) {
		this.addressIP = addressIP;
	}

	public String getRessource() {
		return ressource;
	}

	public void setRessource(String ressource) {
		this.ressource = ressource;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	

}
