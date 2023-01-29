package API.PUT;

import API.Pojo.Brand;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class BrandList {

    @Test
    public void brandList(){

//        RestAssured.baseURI = "https://automationexercise.com";
//        RestAssured.basePath ="api/brandsList";

        Response response = RestAssured.given().contentType(ContentType.JSON)
                .when().put("https://automationexercise.com/api/brandsList").then()
                .statusCode(200).log().all().extract().response();






    }
}
