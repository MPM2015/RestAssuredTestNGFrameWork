package com.spotify.oauth2.duplicates;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.time.Instant;
import java.util.HashMap;

import static com.spotify.oauth2.api.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;

public class TokenManagerOld {

    private static String access_token;
    private static Instant expiry_time;

    public static String getToken(){
        try{
            if(access_token == null || Instant.now().isAfter(expiry_time)){
                System.out.println("RENEWING TOKEN.....");
                Response response = renewToken();
                access_token = response.path("access_token");
                int expiryDurationInSeconds= response.path("expires_in");
                expiry_time = Instant.now().plusSeconds(expiryDurationInSeconds - 300);

            }else{
                System.out.println("TOKEN IS GOOD TO USE");
            }


        }
        catch(Exception e){
            throw new RuntimeException("ABORT !!!!Failed to get Token");

        }
        return access_token;

    }
    private static Response renewToken(){
        HashMap<String,String> formParmas= new HashMap<String,String>();
        formParmas.put("client_id","7e7a366cdf48437cbce17b330a77874e");
        formParmas.put("client_secret","8c177ce92f4f40e38f7e67e464a6dd2f");
        formParmas.put("refresh_token","AQD-zDpiXhGOFVdeYICq3u3O2deDuyYWOIQbZO-SrJpTo1gZg8hzj62Q3-dzOPcXb_xgTg0WyTwA-ZLMd9yrsHvcyp33B341Cpsl9KUPJn4GfUGW11rXZ-aSRM2S_VxZPZk");
        formParmas.put("grant_type","refresh_token");

        Response response=given().
                baseUri("https://accounts.spotify.com").
                contentType(ContentType.URLENC).
                formParams(formParmas).
                log().all().
        when().
                post("/api/token").
        then().
                spec(getResponseSpec()).
                extract().
                response();

        if(response.statusCode() !=200) {
            throw new RuntimeException("ABORT !!! Renew Token Failed");
        }
        return response;

        }
}

