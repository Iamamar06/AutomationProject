package com.apiTest;

import com.utils.Roles;
import static io.restassured.RestAssured.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static com.utils.TestUtility.*;

public class CreateJobAPIRequest {

	public static void main(String[] args) {
		//System.out.println(getAuthToken(Roles.FD));
		//System.out.println(toJson(getCreateJob()));
		baseURI = "http://139.59.91.96:9000/v1";
		Header headerFirst = new Header("Content-Type", "application/json");
		Header headerSecond = new Header("Authorization", getAuthToken(Roles.FD)); 
		//Header headerThird = new Header("Content-Length", "<calculated when request is sent>");
		Headers headers = new Headers(headerFirst, headerSecond);
		Response response = 
				given()
					.headers(headers)
					.body(toJson(getCreateJob()))
				.when()
					.post("/job/create");
		System.out.println(response.asPrettyString());
		System.out.println(response.time());
		JsonPath jsonPath = new JsonPath(response.asPrettyString());
		int id = jsonPath.getInt("data.id");
		String jobId = jsonPath.getString("data.job_number");
		System.out.println(id);
		System.out.println(jobId);

	}
}
