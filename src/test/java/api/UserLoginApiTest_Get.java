package api;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserLoginApiTest_Get extends TestBase {
	//String username="Tester",firstname="Aya",lastname="Mustafa",email="test@test.com",password="12345",phone="12345678",newFName="mariam";
	//String SingleUserData [][];
	@Test(priority=1)
	public void UserCanLogin() throws InterruptedException {
		BaseUri();
		BasePath("/login?");
		httpRequest= RestAssured.given();
		 response = httpRequest.queryParam("username",username)
				.queryParam("password", password).request(Method.GET);
		System.out.println("----------------UserLogin Testcase results----------------");
		checkStatusIs200(response);
		GetMessage(response);
		String ExpireDate=response.header("X-Expires-After");
		System.out.println("Expires After: "+ExpireDate);
	}
	


	@Test(priority=2)
	public  void UserCanLogout() {
BaseUri();
BasePathReset();
BasePath("/logout");
RequestSpecification request= RestAssured.given();
		Response response = request.request(Method.GET);
		int statusCode = response.getStatusCode();
		JsonPath jsonPathEvaluator = response.jsonPath();
		String message = jsonPathEvaluator.get("message");
		System.out.println("------------------Logout Testcase results--------------");

		System.out.println("Message: "+message);
		System.out.println(response.asString());
		Assert.assertEquals(statusCode, 200);
	}
}


