package Revise_stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testData.AddPlaceTestData;
import testData.Api_urls;
import testData.Utilities;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

public class ReviseAddPlace extends Utilities{

	RequestSpecification req;
	Response response;
	static String place_id;

	AddPlaceTestData data = new AddPlaceTestData();

	@Given("Add the Payload {string} {string} {string} {string}")
	public void add_the_payload(String name, String address, String website, String language) throws IOException {
		// Write code here that turns the phrase above into concrete actions
		req = given().spec(Utilities.RequestSpecification()).body(data.AddPlaceData(name, address, website, language));
	}

	@When("Call the {string} request with the help of {string} method")
	public void call_the_request_with_the_help_of_method(String url, String method) {
		// Write code here that turns the phrase above into concrete actions

		Api_urls urls = Api_urls.valueOf(url);

		if (method.equalsIgnoreCase("POST"))
			response = req.when().post(urls.geturls());
		else if (method.equalsIgnoreCase("GET"))
			response = req.when().get(urls.geturls());
	}

	@Then("verify the status code is {int}")
	public void verify_the_status_code_is(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(), 200);
	}

	@Then("extract the place_Id for future use")
	public void extract_the_place_id_for_future_use() {
		// Write code here that turns the phrase above into concrete actions
		place_id  = JsonPath(response, "place_id");
		System.out.println(place_id);
	}

	@Given("Add the Payload for Get Place Request")
	public void add_the_payload_for_get_place_request() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		req = given().spec(Utilities.RequestSpecification()).queryParam("place_id", place_id);
	}
	

@Given("Add the Payload to delete Place")
public void add_the_payload_to_delete_place() throws IOException {
    // Write code here that turns the phrase above into concrete actions
	req = given().spec(Utilities.RequestSpecification()).body(data.deletePlace(place_id));
}

}