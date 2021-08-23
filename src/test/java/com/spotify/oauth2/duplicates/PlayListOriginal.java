package com.spotify.oauth2.duplicates;

import com.spotify.oauth2.pojo.Playlist;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class PlayListOriginal {


    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    String access_token="BQBLUsUwoc8qfJZj0xMqFvqPW2oR1IdWpI6GXm1pgy4Wq2yS4XB834i_nsKkHGnp9WDbkyPmPrKDaRLJUtjglIyoguPpYowvX9w4MAqkw0pqYhoubn8aSnzuqnCYc5KHTTxwBjXQMpo9Gk9EzgHAbbm-r0P_MFDGZOHUGt104bIGy526iY2KcyB9qyJk-aFTewvKRgUQeF2QZRhjlnXc0lPRHR40VvkJGuc3UlSRA9ZW";

    @BeforeClass
    public void beforeclass() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://api.spotify.com").
                setBasePath("/v1").
                addHeader("Authorization","Bearer "+access_token).
                setContentType(ContentType.JSON).
                log(LogDetail.ALL);
        requestSpecification= requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        //responseSpecBuilder.expectContentType(ContentType.JSON).
        responseSpecBuilder.log(LogDetail.ALL);
        responseSpecification = responseSpecBuilder.build();
    }

    @Test
    public void ShouldBeAbleToCreateAPlaylist(){

        /*Playlist requestPlaylist = new Playlist();
            requestPlaylist.setName("New Playlist");
            requestPlaylist.setDescription("New playlist description");
            requestPlaylist.setPublic(false);*/


       /* String payload="{\n" +
                "  \"name\": \"New Playlist\",\n" +
                "  \"description\": \"New playlist description\",\n" +
                "  \"public\": false\n" +
                "}";*/

                /*given(requestSpecification).
                body(requestPlaylist).
                when().
                post("/users/zyntzzhi99iy1a6aa6a92o78s/playlists").
                then().
                spec(responseSpecification).
                assertThat().
                statusCode(201).
                contentType("application/json").
                body("name", is(equalTo("New Playlist")),
                        "description",is(equalTo("New playlist description")),
                        "public",is(equalTo(false)));*/

        /*Playlist responsePlaylist=given(requestSpecification).
                body(requestPlaylist).
        when().
                post("/users/zyntzzhi99iy1a6aa6a92o78s/playlists").
        then().
                spec(responseSpecification).
                assertThat().
                statusCode(201).
                contentType("application/json").
                extract().
                response().
                as(Playlist.class);

        assertThat(responsePlaylist.getName(),is(equalTo(requestPlaylist.getName())));
        assertThat(responsePlaylist.getDescription(),is(equalTo(requestPlaylist.getDescription())));
        assertThat(responsePlaylist.getPublic(),is(equalTo(requestPlaylist.getPublic())));
*/


    }

}
