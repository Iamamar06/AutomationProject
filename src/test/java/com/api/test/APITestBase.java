package com.api.test;

import static io.restassured.RestAssured.baseURI;

import org.testng.annotations.BeforeClass;

import static com.utils.TestUtility.*;

public abstract class APITestBase {
	@BeforeClass(description = "Setting up the base URI for the API using config file")
	public void setup() {
		baseURI = getPropertyFrom("qa.properties", "BASE_URL");
		
	}
}
