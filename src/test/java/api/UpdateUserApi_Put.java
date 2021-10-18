package api;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateUserApi_Put extends TestBase {
	@Test(priority=1)
	public void UserCanLogin() throws InterruptedException {
		BaseUri();
		BasePath("/login?");
		httpRequest= RestAssured.given();
		response = httpRequest.queryParam("username","tester1")
				.queryParam("password", "123").request(Method.GET);
		System.out.println("----------------UserLogin Testcase results----------------");
		checkStatusIs200(response);
		GetMessage(response);
		String ExpireDate=response.header("X-Expires-After");
		System.out.println("Expires After: "+ExpireDate);
	}
	@Test(priority=2)
	public void UpdateUser() {
		BaseUri();
		BasePathReset();
		BasePath("/"+username);
		httpRequest= RestAssured.given();
		httpRequest.header("Content-Type","application/json");
		JSONObject ReqParams = new JSONObject();
		ReqParams.put("id",0);
		ReqParams.put("username", username);
		ReqParams.put("firstName", newFName);
		ReqParams.put("lastName", lastname);
		ReqParams.put("email", email);
		ReqParams.put("password", password);
		ReqParams.put("phone", phone);
		ReqParams.put("userStatus",0);		
		httpRequest.body(ReqParams.toJSONString());
		response = httpRequest.request(Method.PUT);
		System.out.println("----------------UpdateUser Testcase results----------------");

		checkStatusIs200(response);
		GetResponseBody(response);
		GetMessage(response);
	}
	@Test(priority=3)
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
		GetMessage(response);
		checkStatusIs200(response);
	}
}
