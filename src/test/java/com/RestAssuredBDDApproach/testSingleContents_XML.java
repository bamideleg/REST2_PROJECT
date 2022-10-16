package com.RestAssuredBDDApproach;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;



public class testSingleContents_XML {


    @Test
    void TC01_testSingleContent () {

            given().
                get("https://reqres.in/api/users/2").
            then().statusCode(200).
                    body("data.id",equalTo(2)).
                    body("data.email",equalTo("janet.weaver@reqres.in")).
                    body("data.first_name",equalTo("Janet")).
                    body("data.last_name",equalTo("Weaver")).
            log().all();

    }
    @Test
    void TC02_testSingleContent () {

        given().
                get("https://reqres.in/api/users/9").
                then().statusCode(200).
                body("data.id",equalTo(9)).
                body("data.email",equalTo("tobias.funke@reqres.in")).
                body("data.first_name",equalTo("Tobias")).
                body("data.last_name",equalTo("Funke")).
                log().all();

    }
    @Test
    void TC03_testSingleContent3 () {

        given().
                get("https://reqres.in/api/users/9").
                then().statusCode(200).
                body("data.id",equalTo(9)).
                body("data.email",equalTo("tobias.funke@reqres.in")).
                body("data.first_name",equalTo("Tobias")).
                body("data.last_name",equalTo("Funke")).
                log().all();

    }
}
