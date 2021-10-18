package base;

import org.testng.Assert;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	public static RequestSpecification httpRequest;
	public static Response response;
	//public 	String username="tester6",firstname="mariam",lastname="ahmed",email="test5@test.com",password="123",phone="1555523",newFName="Sara";
	Faker faker = new Faker();
	public 	String username=faker.name().username();
	public String firstname=faker.name().firstName();
	public String lastname=faker.name().lastName();
	public String email=faker.internet().emailAddress();
	public String password=faker.internet().password();
	public String phone=faker.phoneNumber().toString();
	public String newFName=faker.name().firstName();




	public  void BaseUri() {
		RestAssured.baseURI="https://petstore.swagger.io/v2/user";

	}
	public void BasePath(String basePath) {
		RestAssured.basePath=basePath;

	}
	public void BasePathReset() {
		RestAssured.basePath="";

	}
	public void GetMessage(Response res) {
		JsonPath jsonPathEvaluator = res.jsonPath();
		String message = jsonPathEvaluator.get("message");
		System.out.println("Message: "+message);

	}
	public void checkStatusIs200(Response res) {
		Assert.assertEquals(res.getStatusCode(), 200,"Status check failed!");
		System.out.println("Message: "+res.getStatusCode());

	}

	public void GetResponseBody(Response res) {
		System.out.println(res.asString());
	}
}
