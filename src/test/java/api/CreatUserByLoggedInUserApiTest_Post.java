package api;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreatUserByLoggedInUserApiTest_Post extends TestBase {
	@Test(priority =1)
	public void UserCanLogin() throws InterruptedException {
		BaseUri();
		BasePath("/login?");
		httpRequest= RestAssured.given();
		response = httpRequest.queryParam("username",username)
				.queryParam("password", password).request(Method.GET);
		System.out.println("----------------UserLogin Testcase results----------------");
		checkStatusIs200(response);
		JsonPath jsonPathEvaluator = response.jsonPath();
		String message = jsonPathEvaluator.get("message");
		System.out.println("Message: "+message);

		String ExpireDate=response.header("X-Expires-After");
		System.out.println("Expires After: "+ExpireDate);
	}


	@Test(priority =2,dataProvider="SingleUserDataProvider")
	public void CreatUser(String username,String firstname,String lastname,String email,String password,String phone) {
		BaseUri();
		BasePathReset();
		httpRequest= RestAssured.given();
		JSONObject ReqParams=new JSONObject(); 
		ReqParams.put("id",0);
		ReqParams.put("username", username);
		ReqParams.put("firstName", firstname);
		ReqParams.put("lastName", lastname);
		ReqParams.put("email", email);
		ReqParams.put("password", password);
		ReqParams.put("phone", phone);
		ReqParams.put("userStatus",0);
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(ReqParams.toJSONString());
		response =httpRequest.request(Method.POST);
		System.out.println("------------------CreatUser Testcase results--------------");
		checkStatusIs200(response);
		GetResponseBody(response);
	}
	
	@DataProvider(name="SingleUserDataProvider")
		public static Object[][] userdata(){
			return new Object[][] {
				{"tester5","mariam","ahmed","test1@gmail.com","123","123456"},
		};
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
