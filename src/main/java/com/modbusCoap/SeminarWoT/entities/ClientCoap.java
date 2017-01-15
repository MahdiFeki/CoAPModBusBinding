package com.modbusCoap.SeminarWoT.entities;

import java.io.Serializable;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ClientCoap implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String ipAdress;
	
	public ClientCoap(String ipAdress) {
		super();
		this.ipAdress = ipAdress;
	}

	public String getUri(String ipAdress){
		 String uri = "coap://"+ ipAdress +":5683/";
		 return uri;
	}
	
	public CoapResponse getTd(){
		CoapClient client = new CoapClient(getUri(ipAdress) +"td");
		CoapResponse response = client.get();
		return response;	
	}

	public  String tdParser() throws ParseException{
		String ressource = null ;
		JSONParser parser = new JSONParser();
		JSONObject td = (JSONObject) parser.parse(getTd().getResponseText());
		JSONArray properties = (JSONArray) td.get("properties");
		JSONObject prop1 = (JSONObject) properties.get(0);
		JSONArray href = (JSONArray) prop1.get("hrefs");
		ressource = (String ) href.get(0);
		return ressource;
	}
	
	public String getValue(String res){
		CoapClient client = new CoapClient(getUri(ipAdress) +res);
		String response = client.get().getResponseText();
		
		return response;
	}
}