package com.utils;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Iterator;
import com.api.pojo.CreateJobAPIbody;
import com.api.pojo.Customer;
import com.api.pojo.CustomerAddress;
import com.api.pojo.CustomerProduct;
import com.api.pojo.LoginAPIBody;
import com.api.pojo.Problems;
import com.filters.JobIdFilter;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.ui.pojo.CreateJobInputDetailsPojo;
import com.ui.pojo.GlobalDetailsPojo;

import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestUtility {
	public static int jobId;

	public static String toJson(Object src) {
		Gson gson = new Gson();
		String jsonObject = gson.toJson(src);
		return jsonObject;
	}

	public static Object toPojo(String src, Type type) {
		Gson gson = new Gson();
		Object pojoObject = gson.fromJson(src, type);
		return pojoObject;
	}

	public static CreateJobAPIbody getCreateJob() {
		Faker faker = new Faker(new Locale("en-IND"));
		Customer customer = new Customer(faker.name().firstName(), faker.name().lastName(),
				faker.phoneNumber().phoneNumber(), null, faker.internet().emailAddress(), null);
		CustomerAddress customer_address = new CustomerAddress(faker.address().buildingNumber(),
				faker.address().streetName(), faker.address().streetName(), "near " + faker.address().streetName(),
				faker.address().streetName(), faker.address().zipCode(), "India", "Karnataka");
		String imei = faker.numerify("##############");
		CustomerProduct customer_product = new CustomerProduct("2022-11-30T18:30:00.000Z", imei, imei, imei,
				"2022-11-30T18:30:00.000Z", 3, 3);
		ArrayList<Problems> problems = new ArrayList<>();
		problems.add(new Problems(6, "Phone heats a lot and battery is draining fast"));
		CreateJobAPIbody createJob = new CreateJobAPIbody(0, 2, 1, 2, customer, customer_address, customer_product,
				problems);
		return createJob;
	}

	public static CreateJobInputDetailsPojo enterCreateJobinputfiels() {
		Faker faker = new Faker(new Locale("en-IND"));
		CreateJobInputDetailsPojo createjobdetails = new CreateJobInputDetailsPojo("Google","Nexus 2","Nexus 2 blue",faker.numerify("##############"),
				"12/23/2022", "In Warrenty","Poor battery life" ,"Test remarks", faker.name().firstName(), faker.name().lastName(),
				faker.numerify("9#########"), faker.internet().emailAddress(), faker.address().buildingNumber(),
				faker.address().streetName(), "near " + faker.address().streetName(), faker.address().streetName(),
				faker.address().streetName(), "Karnataka",faker.address().zipCode());
		return createjobdetails;
	}

	public static String getAuthToken(Roles role) {
		LoginAPIBody login = null;
		if (role == Roles.FD) {
			login = new LoginAPIBody("iamfd", "password");
		} else if (role == Roles.SUP) {
			login = new LoginAPIBody("iamsup", "password");
		} else if (role == Roles.ENG) {
			login = new LoginAPIBody("iameng", "password");
		} else if (role == Roles.QC) {
			login = new LoginAPIBody("iamqc", "password");
		}
		baseURI = "http://139.59.91.96:9000/v1";
		Response response = given().header(new Header("Content-Type", "application/json")).body(toJson(login))
				.post("/login");
		JsonPath jsonParsing = new JsonPath(response.asPrettyString());
		String token = jsonParsing.getString("data.token");
		return token;
	}

	public static Iterator<String[]> readCSVfile(String filename) {
		File file = new File(System.getProperty("user.dir") + "//testdata//" + filename);
		FileReader filereader = null;
		CSVReader csvReader;
		List<String[]> dataList = null;
		try {
			filereader = new FileReader(file);
			csvReader = new CSVReader(filereader);
			dataList = csvReader.readAll();
			csvReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvException e) {
			e.printStackTrace();
		}
		Iterator<String[]> dataIterator = dataList.iterator();
		dataIterator.next(); // starts from the next line on csv file
		return dataIterator;
	}

	/**
	 * Used to read the full excel file with provided file name and sheet name on
	 * excelsheet
	 */
	public static String[][] readExcelSheet(String fileName, String sheetName) {
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(System.getProperty("user.dir") + "\\testData\\" + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet(sheetName);
		XSSFRow rowHeader = sheet.getRow(0);
		int lastRowIndex = sheet.getLastRowNum();
		int totalColumns = rowHeader.getLastCellNum();
		XSSFRow row;
		XSSFCell cell;
		String[][] excelArray = new String[lastRowIndex][totalColumns];
		for (int rowIndex = 1; rowIndex <= lastRowIndex; rowIndex++) {
			row = sheet.getRow(rowIndex);
			for (int cellIndex = 0; cellIndex < totalColumns; cellIndex++) {
				cell = row.getCell(cellIndex);
				excelArray[rowIndex - 1][cellIndex] = cell.toString();
			}
		}
		return excelArray;
	}

	public static String getPropertyFrom(String propertyFileName, String key) {
		File file = new File(System.getProperty("user.dir") + "\\config\\" + propertyFileName);
		FileReader fileReader = null;
		Properties properties = null;
		try {
			fileReader = new FileReader(file);
			properties = new Properties();
			properties.load(fileReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String value = properties.getProperty(key);
		return value;
	}

	public static File getSchemaFile(String fileName) {
		File schema = new File(System.getProperty("user.dir") + "\\testData\\" + fileName);
		return schema;
	}

	public static List<GlobalDetailsPojo> searchDataInList(List<GlobalDetailsPojo> dataList, String key) {
		List<GlobalDetailsPojo> resultsList = dataList.stream().filter(new JobIdFilter(key))
				.collect(Collectors.toList());
		return resultsList;
	}
	

    public static String extractJobNumber(String inputText) {
        String jobNumber = null;
        Pattern pattern = Pattern.compile("(JOB_\\d+)");
        Matcher matcher = pattern.matcher(inputText);

        if (matcher.find()) {
            jobNumber = matcher.group(1);
        }

        return jobNumber;
    }

}
