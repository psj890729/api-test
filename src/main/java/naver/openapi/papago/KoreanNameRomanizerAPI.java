package naver.openapi.papago;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class KoreanNameRomanizerAPI {

	private static final String ClientId = "";
	private static final String ClientSecret = "";

	private static String baseurl = "https://naveropenapi.apigw.ntruss.com/krdict/v1";

	public static Response romanization(String clientId, String clientSecret, String name) {
		
		return given().
					header("X-NCP-APIGW-API-KEY-ID", clientId).
					header("X-NCP-APIGW-API-KEY", clientSecret).
					param("query", name).
				when().
					get(baseurl + "/romanization").
				then().extract().response();
	}

	public static Response romanization(String name) {
		
		return romanization(ClientId, ClientSecret, name);
	}
}
