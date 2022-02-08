package com.RestAssured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ApiTests {
	@Test
	public void canVerifyEmailAddress() {

		RestAssured.baseURI = "https://reqres.in";

		RequestSpecification httprequest = RestAssured.given();

		Response response = httprequest.request(Method.GET, "/api/users/2");

		JsonPath jsonPathEvaluator = response.jsonPath();

		String emailAdress = jsonPathEvaluator.get("data.email");

		Assert.assertEquals(emailAdress, "janet.weaver@reqres.in");
	}

	@Test
	public void canVerifyTokenValue() {

		RestAssured.baseURI = "https://reqres.in";

		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();

		requestParams.put("email", "eve.holt@reqres.in");
		requestParams.put("password", "cityslicka");
		request.header("Content-Type", "application/json");
		request.body(requestParams.toJSONString());
		Response response = request.post("/api/login");

		String token = response.jsonPath().get("token");

		System.out.println(token);

		Assert.assertEquals(token, "QpwL5tke4Pnpja7X4");
	}

	@Test
	public void canDelete() {

		/*
		 * The HTTP 204 No Content success status response code indicates that a request
		 * has succeeded, but that the client doesn't need to navigate away from its
		 * current page.
		 */

		int expectedresponsecode = 204;
		RestAssured.baseURI = "https://reqres.in";

		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");

		Response response = request.delete("/api/users/2");

		int actualResponseCode = response.getStatusCode();

		Assert.assertEquals(actualResponseCode, expectedresponsecode);

	}

	@Test
	public void canUpdatewithPatch() {
		String expectedName = "morpheus2";
		RestAssured.baseURI = "https://reqres.in";

		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();

		requestParams.put("name", "morpheus2");

		request.header("Content-Type", "application/json");
		request.body(requestParams.toJSONString());
		Response response = request.patch("/api/users/2");
		String updatedName = response.jsonPath().get("name");
		String updatedAt = response.jsonPath().get("updatedAt");

		System.out.println(updatedName);
		System.out.println(updatedAt);
		Assert.assertEquals(expectedName, updatedName);

	}

	@Test
	public void canUpdatewithPut() {
		String expectedName = "morpheus2";
		RestAssured.baseURI = "https://reqres.in";

		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();

		requestParams.put("name", "morpheus2");

		request.header("Content-Type", "application/json");
		request.body(requestParams.toJSONString());
		Response response = request.put("/api/users/2");
		String updatedName = response.jsonPath().get("name");
		String updatedAt = response.jsonPath().get("updatedAt");

		System.out.println(updatedName);
		System.out.println(updatedAt);
		Assert.assertEquals(updatedName, updatedName);

	}

	@Test
	public void canDeserializeSingleUserAsPojo() {
		
		String expectedFirstName="Janet";

		RestAssured.baseURI = "https://reqres.in";

		RequestSpecification request = RestAssured.given();

		Response response = request.get("/api/users/2");
		ResponseBody responsebody = response.getBody();

		SingleUserBase base = responsebody.as(SingleUserBase.class);

		String actualFirstName=base.getData().getFirstName();
		
		Assert.assertEquals(actualFirstName, expectedFirstName);

	}
	
	@Test
	public void canDeserializeListUserAsPojo() {
		
		String expectedFirstName="Michael";

		RestAssured.baseURI = "https://reqres.in";

		RequestSpecification request = RestAssured.given();

		Response response = request.get("/api/users?page=2");
		ResponseBody responsebody = response.getBody();

		ListUserBase base = responsebody.as(ListUserBase.class);

		String actualFirstName=base.getData().get(0).getFirstName();
		
		Assert.assertEquals(actualFirstName, expectedFirstName);

	}
}