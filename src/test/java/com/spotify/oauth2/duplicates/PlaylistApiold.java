package com.spotify.oauth2.duplicates;

import com.spotify.oauth2.pojo.Playlist;
import io.restassured.response.Response;

import static com.spotify.oauth2.api.SpecBuilder.getRequestSpec;
import static com.spotify.oauth2.api.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;

public class PlaylistApiold {

    static String access_token="BQBQwH9I1mq4hTFJimVohAC1gi5Cocor8C3e1572b_PXlN42mK37_HmFk0nmi2_2ZO1fav-jb6ipMdVLX7lcjSYCVFbykGDxhTSx9ztuo8bZX8HrJjIw-NHU_JLoQed5ViZSqBBGHfJ-A90DMxOMvJbfFhl7TFWb8aXP6R-pIwxEB9JKvNfh5dxZBlGebHAjnURe7m2lI9cGfnSYiJeHbYDpb24xW66_sfVVfkVeC3GM";

    public static Response post(Playlist requestPlaylist) {
        return  given(getRequestSpec()).
                    body(requestPlaylist).
                    header("Authorization","Bearer "+access_token).
                when().
                    post("/users/zyntzzhi99iy1a6aa6a92o78s/playlists").
                then().
                    spec(getResponseSpec()).
                    extract().
                    response();

    }

    public static Response post(String token,Playlist requestPlaylist) {
        return  given(getRequestSpec()).
                    body(requestPlaylist).
                    header("Authorization","Bearer "+token).
                when().
                    post("/users/zyntzzhi99iy1a6aa6a92o78s/playlists").
                then().
                    spec(getResponseSpec()).
                    extract().
                    response();

    }

    public static Response get(String playlistId){
       return given(getRequestSpec()).
               header("Authorization","Bearer "+access_token).
              when().
                   get("/playlists/"+playlistId).
              then().
                    spec(getResponseSpec()).
                    extract().
                    response();


    }

    public static Response update(String playlistId,Playlist requestPlaylist){

        return given(getRequestSpec()).
                    body(requestPlaylist).
                    header("Authorization","Bearer "+access_token).

                when().
                    put("/playlists/"+playlistId).
                then().
                    spec(getResponseSpec()).
                    extract().
                    response();

    }



}
