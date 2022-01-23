package salesForce_services;

import static org.hamcrest.Matchers.containsString;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ContactTests extends BaseRequest{
	
	
	@Test
	public void getIncidents(){
		request
			.contentType(ContentType.JSON)
			.get("Lead")
			.then()
			.assertThat()
			.statusCode(200)
			.body(containsString("number"),containsString("Id"));		
	}
}
