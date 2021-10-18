package api;

import org.testng.annotations.Test;

import base.TestBase;
import io.qameta.allure.Flaky;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetUserByUsernameApiTest_Get extends TestBase {
	@Flaky
	@Test
	public void getUserbyUsername() {
		String username1="user1";
		BaseUri();
		BasePath("/"+username1);
		RequestSpecification request = RestAssured.given();
		Response response = request.request(Method.GET);
		checkStatusIs200(response);
		GetResponseBody(response);

	}


}
