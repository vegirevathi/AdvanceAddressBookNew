package com;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class AddressBookTest {


    @Before
    public void setUp() {
        RestAssured.baseURI = "http://localhost:4000";
    }

    public Response getPersonList() {
        return RestAssured.get("/addressBook/list");
    }

    @Test
    public void givenPerson_WhenPresent_ShouldReturnDetails() {
        Response response = getPersonList();
        System.out.println(response.asString());
        response.then().body("id", Matchers.hasItems(1));
        response.then().body("firstName", Matchers.hasItems("Vegi"));
    }

    @Test
    public void givenPerson_OnPost_ShouldReturnAddedPerson() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body("{\"firstName\": \"Vaibhav\", \"lastName\": \"Singh\"," +
                        "\"city\": \"korba\", \"state\": \"cg\", \"zipCode\": \"456737\"," +
                        "\"phone\": \"8967654398\"}")
                .when()
                .post("/addressBook/create");
        response.then().body("firstName", Matchers.is("Vaibhav"));
    }

    @Test
    public void givenPersonId_OnDelete_ShouldReturnSuccessStatus() {
        Response response = RestAssured.delete("/addressBook/delete/3");
        response.then().body("id", Matchers.not(2));
    }
}

