package naver.openapi.papago.test;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import io.restassured.response.Response;
import naver.openapi.papago.KoreanNameRomanizerAPI;

public class RomanizationTest {
	
	@Test
	public void testFirstName() throws Exception {
		String koreanName = "박수지";
		String firstName = "박";
		
		Response response = KoreanNameRomanizerAPI.romanization(koreanName);
		assertThat(response.body().path("aResult.sFirstName"), hasItem(firstName));
	}
	
	@Test
	public void testName() throws Exception {
		String koreanName = "박수지";
		String englishName = "Park Suji";
		
		KoreanNameRomanizerAPI.romanization(koreanName)
			.then().body("aResult.aItems*.find {it.score == '78'}.name", hasItem(englishName));
	}
	
	@Test
	public void testName_Fail() throws Exception {
		String koreanName = "박수지";
		String englishName = "Park Sooji";

		KoreanNameRomanizerAPI.romanization(koreanName)
			.then().body("aResult.aItems*.find {it.score == '78'}.name", hasItem(englishName));
	}

}
