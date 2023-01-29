package API.GET;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

public class ProductList {

    @Test
    public void getProductListAPI1(){

        RestAssured.baseURI = "https://automationexercise.com";
        RestAssured.basePath = "api/productsList";

        Response response = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .when().get().then().statusCode(200).log().all().extract().response();


    }
}
