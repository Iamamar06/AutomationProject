package com.apiTest;

import static io.restassured.RestAssured.*;
import com.api.pojo.LoginAPIBody;
import static com.utils.TestUtility.*;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LoginAPIRequest {
	public static void main(String[] args) {
		baseURI = "http://139.59.91.96:9000";
		LoginAPIBody login = new LoginAPIBody("iamfd", "password");
		Response response = given()
				.header(new Header("Content-Type", "application/json"))
				.body(toJson(login))
				.post("/v1/login");
		System.out.println(response.asPrettyString());
		System.out.println(response.time());
		System.out.println(response.statusLine());
		JsonPath jsonParsing = new JsonPath(response.asPrettyString());
		String jsonObject = jsonParsing.getString("data.token");
		System.out.println(jsonObject);

	}
}
