package api;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import data.XLfile;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class CreateListOfUsersApiTest_Post extends TestBase{
	String username,firstname,lastname,email,password,phone,newFName;
	@Test(dataProvider="UserDataProvider")
	public void createListofUsers(String username,String firstname,String lastname,String email,String password,String phone) {


		BaseUri();
		httpRequest= RestAssured.given();
		JSONObject ReqParams=new JSONObject(); 
		ReqParams.put("id",1);
		ReqParams.put("username", username);
		ReqParams.put("firstName", firstname);
		ReqParams.put("lastName", lastname);
		ReqParams.put("email", email);
		ReqParams.put("password", password);
		ReqParams.put("phone", phone);
		ReqParams.put("userStatus",1);
		JSONArray ParamsArray =new JSONArray();
		ParamsArray.add(ReqParams);
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(ParamsArray.toJSONString());
		response =httpRequest.request(Method.POST,"/createWithList");
		System.out.println("------------------CreateListOfUsers Testcase results--------------");
		GetResponseBody(response);
		checkStatusIs200(response);
	}
	@DataProvider(name="UserDataProvider")
	String[][]getUserData() throws IOException{
		String path=System.getProperty("user.dir")+"/src/test/java/data/userdata.xlsx";
		int rowNum=XLfile.getRowCount(path, "Sheet1");
		int ColNum=XLfile.getCellCount(path, "Sheet1",rowNum);
		String UserDataFromXL[][]=new String[rowNum][ColNum];
		for(int i=1 ; i <=rowNum;i++) {
			for(int j=0;j<ColNum;j++) {
				UserDataFromXL[i-1][j]=XLfile.getCellData(path, "Sheet1", i, j);
			}
		}
		return(UserDataFromXL);
	}
}
