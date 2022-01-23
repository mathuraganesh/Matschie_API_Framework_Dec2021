package salesForce_services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseRequest {
	
	protected RequestSpecification request;
	
	@BeforeSuite
	public void setUp() throws FileNotFoundException, IOException {
		
		Properties prop = new Properties();
		prop.load(new FileInputStream(new File("./src/test/resources/salesForce_config.properties")));
		
		RestAssured.authentication = RestAssured.oauth2(prop.getProperty("beartoken"));
		RestAssured.baseURI = "https://"+prop.getProperty("server")+"/"+prop.getProperty("resources")+"/";
		request = RestAssured.given().log().all();		
	}

	
}
