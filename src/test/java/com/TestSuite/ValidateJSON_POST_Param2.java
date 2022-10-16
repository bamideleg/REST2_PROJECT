// How to get data from API response and pass into another API request
// https://www.youtube.com/watch?v=Ls48Yi8-2Ew

// RestAssured | How to upload file using API
//https://www.youtube.com/watch?v=z2m-YX4gKlo

package com.TestSuite;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class ValidateJSON_POST_Param2 {

    long acctid;


    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test
    public void testAPI_GET_All_Users () {


        Response response = given().header("accept"," application/json").
                when().get("/api/users?page=2");

        System.out.println(response.asString());
//                            or,
        System.out.println(response.prettyPrint());
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");

    }


    @Test
    public void postCreateNewUserDataValidation(){

              long acctid; //Variable is declared at class level in other to access it in the project
 //             String json = "\"name\": \"morpheus\"," +
 //                     "    \"job\": \"Manager\"";
//              System.out.println(json);

              String json = " \"name\": \"morpheus\",\n" +
                  "    \"job\": \"leader\"";



           Response response = given().header("accept"," application/json").header("Content-Type", "text/html; charset=utf-8").body("json").
                      when().post("/api/users?page=2");
           System.out.println(json);


           System.out.println(response.asString());
            System.out.println(response.prettyPrint());
            Assert.assertEquals(response.statusCode(), 201);
            Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");

        response.then().body("id", equalTo(606))
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("leader"));

// We are going to get the user ID created by POST method using GET statement by passing the id generated
//         long acctid = response.path("id");
           acctid = response.path("id");
           System.out.println("acctid");
    }

//    @Test(dependsOnMethods = "postCreateNewUserDataValidation")
    @Test
    public void putUpdateUser() {
 //   We can pass the (acctid) in this class as variable to update the data ( +acctid+)
//    However, it doesn't exist in the payload

        String json = "\"name\": \"morpheus\"," +
                "    \"job\": \"Manager2\"";

//        System.out.println(json);

        Response response = given().header("accept", "application/json").header("Content-Type", "text/html; charset=utf-8").body("json").
                when().put("/api/users");

        System.out.println(response.asString());
        System.out.println(response.prettyPrint());
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.contentType(), "text/html; charset=utf-8");

    }

//    @Test (dependsOnMethods = "putUpdateUser")
    @Test
    public void deleteUser() {
        Response response = given().header("accept","application/json")
                .when().delete("/api/users/10");

        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(), 204);
 //       Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");

    }

//    @Test (dependsOnMethods = "deleteUser")
    @Test
    public void postUpdate(){
        Response response = given().header("accept","application/json").header("Content-Type", "application/json; charset=utf-8")
                .formParam("name","").formParam("job", "Line")
                .when().post("/api/users/2");

        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(response.contentType(), "text/html; charset=utf-8");

    }

//    @Test (dependsOnMethods = "postUpdate")
    @Test
    public void testAPI_GET_verifyUserDetails () {

        Response response = given().header("accept"," application/json").
                when().get("/api/users/3");

//        System.out.println(response.asString());
//                            or,
        System.out.println(response.prettyPrint());
        Assert.assertEquals(response.statusCode(), 200);


        response.then().body("data.id", equalTo(3))
                .body("email", equalTo("emma.wong@reqres.in"))
                .body("first_name", equalTo("Emma"))
                .body("last_name", equalTo("Wong"));

        acctid = response.path("id");
        System.out.println("acctid");

    }


}
