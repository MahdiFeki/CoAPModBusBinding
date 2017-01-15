package com.modbusCoap.SeminarWoT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.modbusCoap.SeminarWoT.metier.ModbusMetierImpl;
import com.modbusCoap.SeminarWoT.model.ModbusForm;

@Controller
public class ModbusController {
	@Autowired
	private ModbusMetierImpl modbusMetier;
	private String ip;
	@RequestMapping(value = "/index")
	public String Index(Model model){
		model.addAttribute("ModbusForm", new ModbusForm());
		
		return "Modbus";
	}
	
	@RequestMapping(value = "/getTD")
	public String getressource(ModbusForm mf, Model model){
		String ressource = modbusMetier.getRessource(mf.getAddressIP());
		ip = mf.getAddressIP();
		mf.setRessource(ressource);
		model.addAttribute("ModbusForm", mf);
		return "Modbus";
	}
	
	@RequestMapping(value = "/getValue")
	public String getressourceValue(ModbusForm mf, Model model){
		String ressourceValue = modbusMetier.getValue(ip, mf.getRessource());
		mf.setValue(ressourceValue);
		model.addAttribute("ModbusForm", mf);	
		return "Modbus";
	}

}
