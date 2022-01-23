package salesForce_steps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;

public class SalesForceManagement extends baseAPI{
	
	public String LeadID="00Q5j000006CVDPEA4";

	@Given("enable logs")
	public void setUp(){ 
		request = given().log().all();
	}
	
	@When("First Name is added with (.*)$")
	public void add_firstname(String first_name){
		request = request.when().body("{\"FirstName\" : \""+first_name+"\"}");
	}
	
	@When("Last Name is added with (.*)$")
	public void add_lastname(String last_name){
		request = request.when().body("{\"LastName\" : \""+last_name+"\"}");
	}
	
	@When("Company is added with (.*)$")
	public void add_company(String company){
		request = request.when().body("{\"Company\" : \""+company+"\"}");
	}
	
		
	@When("Other Street is added with (.*)$")
	public void add_otherstreet(String other_street){
		request = request.when().body("{\"OtherStreet\" : \""+other_street+"\"}");
	}
	
	@When("Other City is added with (.*)$")
	public void add_othercity(String other_city){
		request = request.when().body("{\"OtherCity\" : \""+other_city+"\"}");
	}
	
	@When("Other State is added with (.*)$")
	public void add_otherstate(String other_state){
		request = request.when().body("{\"OtherState\" : \""+other_state+"\"}");
	}
	
	@When("Other PostalCode is added with (.*)$")
	public void add_otherpostalcode(String other_postalcode){
		request = request.when().body("{\"OtherPostalCode\" : \""+other_postalcode+"\"}");
	}
	
	@When("Other Country is added with (.*)$")
	public void add_othercountry(String other_country){
		request = request.when().body("{\"OtherCountry\" : \""+other_country+"\"}");
	}

	@When("new contact is created")
	public void a_new_contact_created(){
		response = request.when().contentType(ContentType.JSON).post("Contact");
		ID=response.jsonPath().get("id");
		System.out.println(ID);
		response.prettyPrint();
	}
	
	@When("Contact is Updated")
	public void a_contact_updated(){
		response = request.when().contentType(ContentType.JSON).patch("Contact/0035j00000IukyRAAR");
		response.prettyPrint();
	}
	
	@When("Get the Contact")
	public void a_Get_contact(){
		response = request.when().contentType(ContentType.JSON).get("Contact/0035j00000IukyRAAR");
		response.prettyPrint();
	}
	
	@When("get all contact")
	public void get_all_contact(){
		response = request.when().contentType(ContentType.JSON).get("Contact");
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
	
	
	@When("new lead is created")
	public void a_new_lead_created(){
		response = request.when().contentType(ContentType.JSON).post("Lead");
		//LeadID=response.jsonPath().get("id");
		//System.out.println("Lead ID-"+LeadID);
		response.prettyPrint();
	}
	
	@When("Lead is Updated")
	public void a_lead_updated(){
		response = request.when().contentType(ContentType.JSON).patch("Lead/"+LeadID);
		response.prettyPrint();
	}
	
	@When("Get the Lead")
	public void a_Get_Lead(){
		response = request.when().contentType(ContentType.JSON).get("Lead/"+LeadID);
		response.prettyPrint();
	}
	
	@When("get all lead")
	public void get_all_lead(){
		response = request.when().contentType(ContentType.JSON).get("Lead");
		response.prettyPrint();
	}
	
	@When("Lead is Deleted")
	public void a_lead_deleted(){
		response = request.when().contentType(ContentType.JSON).delete("Lead/"+LeadID);
		
	}
}


