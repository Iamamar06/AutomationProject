package com.api.test;

import static com.utils.TestUtility.*;
import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.pojo.LoginAPIBody;
import static org.hamcrest.Matchers.*;
import io.restassured.http.Header;

public class LoginAPITest {
	private String loginBody;
	
	@BeforeMethod(description = "Setting up the base URI and login POJO")
	public void setup() {
		baseURI = getPropertyFrom("qa.properties", "BASE_URL");
		LoginAPIBody login = new LoginAPIBody("iamfd", "password");
		loginBody = toJson(login);
	}

	@Test(description = "Verify if login api runs successfully", groups = { "E2E", "Smoke", "Sanity" }, priority = 1, retryAnalyzer = com.utils.MyRetryAnalyzer.class)
	public void test_login_api() {
		
		given()
			.header(new Header("Content-Type", "application/json"))
			.body(loginBody)
		.when()
			.log().all()
			.post("/login")
		.then()
			.log().all()
			.assertThat()
			.statusCode(200)
			.and()
			.body("message", equalTo("Success"));
		
	}
}
