package com.testIT.pages;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

public class MainApi {

    static Response response;
    static ToDo toDo;

    /**
     * Sends a GET request with the given end point
     *
     * @param endPoint
     */
    public static void sendGetRequest(String endPoint){
        response = RestAssured.given().accept(ContentType.JSON)
                .when().get(endPoint);
    }

    /**
     * Sends a POST request with the given POJO object and end point
     *
     * @param toDo
     * @param endPoint
     */
    public static void sendPostRequest(Object toDo, String endPoint) {
        response = RestAssured.given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(toDo)
                .when().post(endPoint);
    }

    /**
     * Sends a PUT request using the POJO object with modified data and end point
     *
     * @param toDo
     * @param endPoint
     */
    public static void sendPutRequest(Object toDo, String endPoint){
        response = RestAssured.given().contentType(ContentType.JSON)
                .and().body(toDo)
                .when().put(endPoint);
    }

    /**
     * Sends a PATCH request using the patch String with modified data and end point
     *
     * @param patch
     * @param endPoint
     */
    public static void sendPatchRequest(String patch, String endPoint){
        response =  RestAssured.given().contentType(ContentType.JSON)
                .and().body(patch)
                .when().patch(endPoint);
    }

    /**
     * Sends a DELETE request using the end point
     *
     * @param endPoint
     */
    public static void sendDeleteRequest(String endPoint){
        response = RestAssured.given().accept(ContentType.JSON)
                .when().delete(endPoint);
    }

    /**
     * Returns the response object
     *
     * @return response
     */
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

    /**
     * Returns the toDo object
     *
     * @return toDo
     */
    public static ToDo getToDo(){
        return toDo;
    }
}
