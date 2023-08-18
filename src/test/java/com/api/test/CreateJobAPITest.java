package com.api.test;

import org.testng.annotations.*;

import com.db.pojo.TR_Customer_POJO;
import com.utils.Roles;
import com.utils.TestUtility;

import dbConnection.CustomerDAO;

import static com.utils.TestUtility.*;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public final class CreateJobAPITest extends APITestBase {
	private int customerId;
	private JsonPath jsonPath;
	private CustomerDAO customerDAO;
	
	@Test(description = "Verify create job api request runs successfully and generates job number", groups = {"E2E", "Smoke","Sanity"}, priority = 1)
	public void test_create_job_api() {
		jsonPath=given()
					.header(new Header("Content-Type", "application/json"))
					.header(new Header("Authorization", getAuthToken(Roles.FD)))
					.body(toJson(getCreateJob()))
				.when()
					.log().all()
					.post("/job/create")
				.then()
					.log().all()
					.assertThat()
					.statusCode(200)
					.and()
					.body("message", equalTo("Job created successfully. "))
					.and()
					.body(matchesJsonSchema(getSchemaFile("createJobAPIresponseSchema.json")))
				.extract().jsonPath();
		TestUtility.jobId = jsonPath.getInt("data.id");
		customerId = jsonPath.getInt("data.tr_customer_id");
		customerDAO = new CustomerDAO();
		TR_Customer_POJO customerData= customerDAO.getCustomerDataFromDB(customerId);
		System.out.println(customerData);
	}
}
