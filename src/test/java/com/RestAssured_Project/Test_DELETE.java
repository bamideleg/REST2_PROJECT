package com.RestAssured_Project;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class Test_DELETE {

    @Test
    public void test_delete() {

        when().
                delete("https://reqres.in/api/users/2").

                then().statusCode(204).log().all();

    }

}
