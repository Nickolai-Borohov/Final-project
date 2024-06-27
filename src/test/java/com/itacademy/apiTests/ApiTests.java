package com.itacademy.apiTests;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.io.File;

import static io.restassured.RestAssured.given;

public class ApiTests {

    @Test
    public void getOpenWishlistPage(){
        given().log().all()
                .when().get("https://maps.googleapis.com/maps/api/mapsjs/gen_204?csp_test=true")
                .then().log().all().statusCode(200);
    }

    @Test
    public void putTest(){
        File file = new File("src/test/resources/json/jsonFile");
        given().log().all().contentType(ContentType.JSON)
                .body(file)
                .when().post("https://jysk.co.uk/wss/json/v2/data/customer/save")
                .then().log().all().statusCode(200);
// "https://jysk.co.uk/wss/json/v2/data/customer/save"
        //PUT
        //200
    }
    public void postTest(){}
}
