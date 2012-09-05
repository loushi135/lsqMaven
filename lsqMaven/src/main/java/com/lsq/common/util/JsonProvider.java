package com.lsq.common.util;

import java.io.IOException;

import javassist.bytecode.stackmap.TypeData;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonProvider {
	public static String writeToString(Object object){
		String result ="";
		try {
	    	ObjectMapper m = new ObjectMapper();
			result =m.writeValueAsString(object);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result ;
	}
	

	public static TypeData fromJSON(String json, TypeData clazz) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			clazz=  mapper.readValue(json, TypeData.class);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clazz;
	}
	 public static void main(String[] args) {
		 //resolveJson();
		// String json="{\"name\":\"张三\",\"年龄\":\"15\"}";
		// fromJSON(json,new TypeData());
	}
}