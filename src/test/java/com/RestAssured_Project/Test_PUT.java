package com.RestAssured_Project;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Test_PUT {


    @Test
    public void test_POST1(){

        JSONObject request = new JSONObject();

        request.put("name", "Lord Nelson");
        request.put("Job", "Teacher");

        // Different way fo printing values
        System.out.println(request);
        System.out.println(request.toJSONString());


        given().
                header("content-type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).

                when().
                         put("https://reqres.in/api/users/2").
                then().statusCode(200).log().all();
    }

}
