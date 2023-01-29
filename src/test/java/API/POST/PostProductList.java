package API.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

public class PostProductList {

    @Test
    public void postProductList(){
        RestAssured.baseURI = "https://automationexercise.com";
        RestAssured.basePath = "api/productsList";

        Response response = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .when().post().then().statusCode(200).log().all().extract().response();
    }
}
