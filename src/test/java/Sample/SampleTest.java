package Sample;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import common.BaseTestClass;

public class SampleTest extends BaseTestClass {
	
	@Test
	public void sampleTest() throws Exception {
		when()
			.get(baseUrl + "/greeting").
		then()
			.body("content", is("Hello, World!"));
	}
	
	@Test
	public void sampleTest_Fail() throws Exception {
		when()
			.get(baseUrl + "/greeting").
		then()
			.body("content", is("Hello, World! fail"));
	}
}
