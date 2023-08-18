package com.api.test;

import static com.utils.TestUtility.*;
import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.pojo.LoginAPIBody;
import static org.hamcrest.Matchers.*;

import io.restassured.http.Header;

public class LoginAPITestFromExcelData {
	private String loginBody;
	
	@BeforeMethod(description = "Setting up the base URI and login POJO")
	public void setup() {
		baseURI = "http://139.59.91.96:9000/v1";
	}

	@Test(description = "Verify if login api runs successfully", groups = { "E2E", "Smoke", "Sanity" }, priority = 1, retryAnalyzer = com.utils.MyRetryAnalyzer.class, dataProviderClass = com.dataProvider.LoginDataProvider.class, dataProvider = "Login data on Excel file")
	public void test_login_api(String username, String password) {
		LoginAPIBody login = new LoginAPIBody(username, password);
		loginBody = toJson(login);
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
			.time(lessThan(1000L))
			.and()
			.body("message", equalTo("Success"));
		
	}
}
