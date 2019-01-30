package com.journaldev.spring;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.json.JSONObject;
import org.json.XML;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class PersonController {
	
	@RequestMapping("/")
	public String healthCheck() {
		javaToJson();
		javaToJsonPrettyPrint();
		jsonStringToJsonObject();
		return "Converted Successfully...";
	}
	
	public void javaToJson() {
	
		Person person = new Person();
		person.setName("Peter");
		person.setSal("20000");
		person.setAge("25");
		person.setAddress("Hyderabad");
		person.setPhoneNumber("9000080000");
		
		JSONObject jsonObject = new JSONObject(person);
		System.out.println("jsonObject1 : " + jsonObject);
		System.out.println("jsonObject2 : " + jsonObject.toString());
	}
	
	public void javaToJsonPrettyPrint() {
		int PRETTY_PRINT_INDENT_FACTOR = 4;
		
		Person person = new Person();
		person.setName("Peter");
		person.setSal("20000");
		person.setAge("25");
		person.setAddress("Hyderabad");
		person.setPhoneNumber("9000080000");
		
		JSONObject jsonObject = new JSONObject(person);
		System.out.println("jsonObject3 : " + jsonObject.toString(PRETTY_PRINT_INDENT_FACTOR));
	}
	
	public void jsonStringToJsonObject() {
		String jsonStr = "{\n" + 
				"    \"address\": \"Hyderabad\",\n" + 
				"    \"phoneNumber\": \"9000080000\",\n" + 
				"    \"name\": \"Peter\",\n" + 
				"    \"age\": \"25\",\n" + 
				"    \"sal\": \"20000\"\n" + 
				"}";
		
		JSONObject json = new JSONObject(jsonStr);
		System.out.println("jsonObject4 : " + json);
		System.out.println("jsonObject5 : " + json.toString());
	}
}
