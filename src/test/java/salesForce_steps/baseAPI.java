package salesForce_steps;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class baseAPI {
	public String ID;
	public Response response;
	public ValidatableResponse json;
	public RequestSpecification request;
}
