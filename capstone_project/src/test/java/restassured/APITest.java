package restassured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import common_pages.ExtentReportsClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class APITest {
	
	ExtentReports extent;
    ExtentTest test;
	
	@BeforeTest
	public static void setup() {
		RestAssured.baseURI = "https://www.advantageonlineshopping.com/catalog/api/v1";
	}
	
	@BeforeMethod
	public void beforeMethod() {
		extent = ExtentReportsClass.getInstance(); 
	}

	@Test
	public void getRequest() {
		test = ExtentReportsClass.createTest("API testing for getting all categories"); 	
		test.assignAuthor("Naqeeb");				
		
		Response response = given().contentType(ContentType.JSON).get("/categories").then().statusCode(equalTo(200))
				.extract().response();

		assertEquals(200, response.statusCode());
		System.out.println(response.body().asPrettyString());
		test.pass("API is fetching all the categories correctly");
	}

	@Test
	public void getRequestWithQueryParam() {
		test = ExtentReportsClass.createTest("API testing for searching  a product"); 	
		test.assignAuthor("Naqeeb");
		
		Response response = given().contentType(ContentType.JSON).param("name", "tablet").get("/products").then()
				.statusCode(200).extract().response();

		assertEquals(200, response.statusCode());
		System.out.println(response.body().asPrettyString());
		test.pass("API is fetching all the search result correctly");
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException {
        extent.flush();
    }
}
