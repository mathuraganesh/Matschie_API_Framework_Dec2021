package JIRAsteps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.security.spec.ECField;
import java.util.Map;
import java.util.Map.Entry;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class JIRAManagement extends baseAPI{
	
	public static String ID;

	@Given("enable logs")
	public void setUp(){ 
		request = given().log().all();
	}
	
	@When("Issue description is added from (.*)$")
	public void add_short_description(String FileName){
		File file=new File("./data/"+FileName+".json");
		request = request.when().body(file);
	}
	

	@When("new issue is created")
	public void a_new_issue_created(){
		response = request.when().contentType(ContentType.JSON).post("issue");
		response.prettyPrint();
	}
	
	
	@Then("the status code is (\\d+)$")// ->only Digit
	public void verify_status_code(int statusCode){
		json = response.then().statusCode(statusCode);
	}

	@And("response includes the following$")
	public void response_equals(Map<String,String> responseFields){
		
		for (Entry<String, String> eachEntry : responseFields.entrySet()) {  
			
			if(StringUtils.isNumeric(eachEntry.getValue())){
				
				json.body(eachEntry.getKey(), equalTo(Integer.parseInt(eachEntry.getValue())));
			}
			else{
				json.body(eachEntry.getKey(), equalTo(eachEntry.getValue()));
			}
			
		}
	}

	@And("response includes the following in any order$")
	public void response_contains_in_any_order(Map<String,String> responseFields){
		for (Map.Entry<String, String> field : responseFields.entrySet()) {
			if(StringUtils.isNumeric(field.getValue())){
				json.body(field.getKey(), containsInAnyOrder(Integer.parseInt(field.getValue())));
			}
			else{
				json.body(field.getKey(), containsInAnyOrder(field.getValue()));
			}
		}
	}
	
	@And("Get the Id")
	public void Getid() {
		ID=response.jsonPath().get("id");
		System.out.println(ID);
	}
	
	@When("Get All issue")
	public void Getissue() {
		response = request.accept(ContentType.JSON).get("issuetype");
		response.prettyPrint();
	}
	
	@When("new issue is updated")
	public void a_new_issue_updated(){
		response = request.when().contentType(ContentType.JSON).put("issue/"+ID);
		response.prettyPrint();
	}
}


