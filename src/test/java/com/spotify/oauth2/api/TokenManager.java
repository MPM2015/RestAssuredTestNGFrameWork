package com.spotify.oauth2.api;

import com.spotify.oauth2.utils.ConfigLoader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.time.Instant;
import java.util.HashMap;

import static com.spotify.oauth2.api.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;

public class TokenManager {

    private static String access_token;
    private static Instant expiry_time;

    public synchronized static String getToken(){
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
            e.printStackTrace();
            throw new RuntimeException("ABORT !!!!Failed to get Token");

        }
        return access_token;

    }
    private static Response renewToken(){
        HashMap<String,String> formParmas= new HashMap<String,String>();
        formParmas.put("client_id", ConfigLoader.getInstance().getClientId());
        formParmas.put("client_secret",ConfigLoader.getInstance().getClientSecret());
        formParmas.put("refresh_token",ConfigLoader.getInstance().getRefreshToken());
        formParmas.put("grant_type",ConfigLoader.getInstance().getGrantType());

        Response response=RestResource.postAccount(formParmas);

        if(response.statusCode() !=200) {
            throw new RuntimeException("ABORT !!! Renew Token Failed");
        }
        return response;

        }
}

