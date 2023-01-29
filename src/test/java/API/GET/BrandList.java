package API.GET;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

public class BrandList {

    @Test
    public void BrandList(){

        RestAssured.baseURI = "https://automationexercise.com";
        RestAssured.basePath = "api/brandsList";

        RestAssured.given().contentType(ContentType.HTML).accept(ContentType.JSON).when()
                .get().then().statusCode(200).log().body().extract().response();





    }
}
