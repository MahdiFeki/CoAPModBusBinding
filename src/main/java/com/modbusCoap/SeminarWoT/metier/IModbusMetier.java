package com.modbusCoap.SeminarWoT.metier;

import de.re.easymodbus.modbusclient.ModbusClient;

public interface IModbusMetier {
	
	public String getRessource (String ipAddress );
	public String getValue (String ipAddress, String res);

}