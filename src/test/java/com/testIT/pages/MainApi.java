package com.testIT.pages;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

public class MainApi {

    static Response response;
    static ToDo toDo;

    public static Response sendGetRequest(String endPonit){
        response = RestAssured.given().accept(ContentType.JSON)
                .when().get(endPonit);
        return response;
    }

    public static void sendPostRequest(Object toDo, String endPoint) {
        response = RestAssured.given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(toDo)
                .when().post(endPoint);
    }

    public static void sendPutRequest(Object toDo, String endPoint){
        response = RestAssured.given().contentType(ContentType.JSON)
                .and().body(toDo)
                .when().put(endPoint);
    }

    public static Response getResponse() {
        return response;
    }

    public static void verifyStatusAndContent(int code, String content, Response response){
        Assert.assertEquals(code,response.statusCode());
        Assert.assertEquals(content,response.contentType());
    }

    public static void createToDo(int userID, String title, boolean todoComplete) {
        toDo = new ToDo(userID,title,todoComplete);
    }

    public static ToDo getToDo(){
        return toDo;
    }
}
